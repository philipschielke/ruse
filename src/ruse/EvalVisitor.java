/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruse;

import java.util.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author phil
 */
public class EvalVisitor extends ruseBaseVisitor<Object>{
    
    final SymbolTable globSymTab = new SymbolTable();
    final Stack callStack = new Stack<>();
    
    private Object FunctionCall(Function func,
            List<ruseParser.ExprContext> actualExprs) {
        ArrayList<Object> actuals = new ArrayList<>();
        for ( ruseParser.ExprContext actual : actualExprs)
            actuals.add(visit(actual));
        
        // Create a new local symbol table for this function invocation
        func.createLocalSymTab(actuals, globSymTab);
        
        // Push the current function onto the call stack.
        callStack.push(func);
        Object result = visit(func.body);
        callStack.pop();
        return result;
    }
    
    // Racket treats any value other than #f as true
    // The function takes in an object and if that object
    // is a Boolean it simply returns it.  Otherwise
    // it returns Boolean true
    private Boolean evalRacketBoolean(Object conditional)
    {
        if (conditional instanceof Boolean) return (Boolean) conditional;
        else return (Boolean) true;
    }
    @Override
    public Object visitJustID(ruseParser.JustIDContext ctx) {
        String id = ctx.ID().getText();
        
        // If the call stack is empty this is a global identifier
        if (callStack.empty())
            return globSymTab.lookup(id);
        
        // Otherwise, look in the current active function's symbol table.
        Function currentInvocation = (Function) callStack.peek();
        return currentInvocation.getLocalSymTab().lookup(id);        
    }
    
    @Override 
    public Object visitFuncCall(ruseParser.FuncCallContext ctx) {
        // The first matched expr, f,  must evaluate to a function
        // whether it be a lambda, a defined ID, or a function that
        // returns another function
        Function func = (Function) visit(ctx.f);
        
        return FunctionCall(func, ctx.expr().subList(1,ctx.expr().size()));
    }
  /*  
    @Override 
    public Object visitFuncInvL(ruseParser.FuncInvLContext ctx) {
        // Lambda is a function, so grab it.
        Function func = (Function) visit(ctx.lambda());
        
        return FunctionCall(func, ctx.expr());
    }
    
    @Override
    public Object visitFuncInvID(ruseParser.FuncInvIDContext ctx) {
        Function func;
        if (callStack.empty())
             func = (Function) globSymTab.lookup(ctx.ID().getText());
        else
             func = (Function) ((Function)callStack.peek()).getLocalSymTab().lookup(ctx.ID().getText());
                
        return FunctionCall(func, ctx.expr());
    }
    */
    @Override
    public Object visitLambda(ruseParser.LambdaContext ctx) {
        ArrayList<String> formals = new ArrayList<>();
        for ( TerminalNode t : ctx.ID()) {
            formals.add(t.getText());
        }
        Function result = new Function(null, formals, ctx.expr(), false);
        // if this lambda is being returned from a function or other
        // local context, bind that contexts symbol table to the lambda
        // to capture any bound variables.
        if (!callStack.empty()) {
           Function currentInvocation = (Function) callStack.peek();
           result.setLocalSymTab(currentInvocation.getLocalSymTab());
        }
        return result;
    }
    
    @Override
    public Object visitDefFunc(ruseParser.DefFuncContext ctx) {
        ArrayList<String> formals = new ArrayList<>();
        String name = ctx.ID().get(0).getText();
        for ( TerminalNode t : ctx.ID().subList(1, ctx.ID().size())) {
            formals.add(t.getText());
        }
        Function result = new Function(name, formals, ctx.expr(), false);
        globSymTab.enter(name, result);
        return result;
    }
    
    @Override
    public Object visitDefFuncRest(ruseParser.DefFuncRestContext ctx) {
        ArrayList<String> formals = new ArrayList<>();
        String name = ctx.ID().get(0).getText();
        for ( TerminalNode t : ctx.ID().subList(1, ctx.ID().size())) {
            formals.add(t.getText());
        }
        Function result = new Function(name, formals, ctx.expr(), true);
        globSymTab.enter(name, result);
        return result;
    }
    
    @Override
    public Object visitDefSimple(ruseParser.DefSimpleContext ctx) {
    globSymTab.enter(ctx.ID().getText(), visit(ctx.expr()));
        return null;
    }
    
    @Override
    public Object visitSimplePlus(ruseParser.SimplePlusContext ctx) {
        Integer v1 = (Integer) visit(ctx.expr(0));
        Integer v2 = (Integer) visit(ctx.expr(1));
        return v1 + v2;
    }
    
// Arhitmetic operators  
    @Override
    public Object visitSimpleMinus(ruseParser.SimpleMinusContext ctx) {
        Integer v1 = (Integer) visit(ctx.expr(0));
        Integer v2 = (Integer) visit(ctx.expr(1));
        return v1 - v2;
    }
    
    @Override
    public Object visitSimpleDivide(ruseParser.SimpleDivideContext ctx) {
        Integer v1 = (Integer) visit(ctx.expr(0));
        Integer v2 = (Integer) visit(ctx.expr(1));
        return v1 / v2;
    }
    
    @Override
    public Object visitSimpleTimes(ruseParser.SimpleTimesContext ctx) {
        Integer v1 = (Integer) visit(ctx.expr(0));
        Integer v2 = (Integer) visit(ctx.expr(1));
        return v1 * v2;
    }
    
 // Relational operators   
    @Override
    public Object visitEquals(ruseParser.EqualsContext ctx) {
        Integer v1 = (Integer) visit(ctx.expr(0));
        Integer v2 = (Integer) visit(ctx.expr(1));
        return (Boolean) (v1 == v2);
    }
    
    @Override
    public Object visitGreaterThan(ruseParser.GreaterThanContext ctx) {
        Integer v1 = (Integer) visit(ctx.expr(0));
        Integer v2 = (Integer) visit(ctx.expr(1));
        return (Boolean) (v1 > v2);
    }
    
    @Override
    public Object visitLessThan(ruseParser.LessThanContext ctx) {
        Integer v1 = (Integer) visit(ctx.expr(0));
        Integer v2 = (Integer) visit(ctx.expr(1));
        return (Boolean) (v1 < v2);
    }

 // Logical operators
    @Override
    public Object visitAnd(ruseParser.AndContext ctx) {
        Boolean v1 = evalRacketBoolean(visit(ctx.expr(0)));
        Boolean v2 = evalRacketBoolean(visit(ctx.expr(1)));
        return (Boolean) (v1 && v2);
    }
    
    @Override
    public Object visitOr(ruseParser.OrContext ctx) {
        Boolean v1 = evalRacketBoolean(visit(ctx.expr(0)));
        Boolean v2 = evalRacketBoolean(visit(ctx.expr(1)));
        return (Boolean) (v1 || v2);
    }
    
    @Override
    public Object visitNot(ruseParser.NotContext ctx) {
        Boolean v1 = evalRacketBoolean(visit(ctx.expr()));
        return !v1;
    }

 // Pair and list related operators
    @Override
    public Object visitList(ruseParser.ListContext ctx) {
        Object result = EmptyList.getInstance();
        for (int i = ctx.expr().size() - 1; i >= 0; i--) {
            Object l = visit(ctx.expr(i));
            result = new Pair(l,result);
        }
        return result;
    }
    
    @Override
    public Object visitEList(ruseParser.EListContext ctx) {
        return EmptyList.getInstance();
    }
    
    @Override
    public Object visitCons(ruseParser.ConsContext ctx) {
        Object l = visit(ctx.expr(0));
        Object r = visit(ctx.expr(1));
        return new Pair(l, r);
    }
    @Override
    public Object visitCar(ruseParser.CarContext ctx) {
        Pair p = (Pair) visit(ctx.expr());
        return p.getLeft();
    }
    @Override
    public Object visitCdr(ruseParser.CdrContext ctx) {
        Pair p = (Pair) visit(ctx.expr());
        return p.getRight();
    }
    
    @Override
    public Object visitIfThenElse(ruseParser.IfThenElseContext ctx) {
        Boolean condition = evalRacketBoolean(visit(ctx.cond));
        Object  thenResult = visit(ctx.thenpart);
        Object  elseResult = visit(ctx.elsepart);
        
        if (condition) return thenResult;
        else return elseResult;
    }
    
    @Override
    public Object visitInt(ruseParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }
        
    @Override
    public Object visitString(ruseParser.StringContext ctx) {
        return (String) (ctx.STRING().getText());
    }    
    
    @Override
    public Object visitSExpr(ruseParser.SExprContext ctx) {
        Object result = visit(ctx.expr());
        if (result == null) System.out.println("undefined");
        else if (result instanceof RUSESymbol) 
            System.out.println("'" + result);
        else if (result instanceof Pair)
            System.out.println("'" + result);
        else if (result instanceof Boolean)
            if ((Boolean)result == true) System.out.println("#t");
            else System.out.println("#f");
        else if (result instanceof RUSEvoid)
            System.out.println("");
        else
            System.out.println(result);
        return 0;
    }
    
    @Override
    public Object visitCond(ruseParser.CondContext ctx) {
      
        for ( int i = 0; i < ctx.expr().size(); i+=2) {
            Boolean t = evalRacketBoolean(visit(ctx.expr(i)));
            //Object v = visit(ctx.expr(i+1));
            if (t == true) return visit(ctx.expr(i+1));
        }
        return null;
    }
        
    @Override
    public Object visitLet(ruseParser.LetContext ctx) {
         ArrayList<String> formals = new ArrayList<>();
         ArrayList<Object> actuals = new ArrayList<>();

        for (ruseParser.LetbindingContext binding : ctx.letbinding() ) {
            formals.add(binding.ID().getText());
            actuals.add(visit(binding.expr()));
        }
        
        Function temp = new Function(null, formals, ctx.expr(), false);
        
        // Create a new local symbol table for this pseudo-function invocation
        if (callStack.empty()) temp.createLocalSymTab(actuals, globSymTab);
        else {
            Function currentInvocation = (Function) callStack.peek();
            temp.createLocalSymTab(actuals, currentInvocation.getLocalSymTab());
        }
        //temp.createLocalSymTab(actuals, globSymTab);
        
        // Push the current function onto the call stack.
        callStack.push(temp);
        Object result = visit(temp.body);
        callStack.pop();
        return result;
    }
    
    @Override
    public Object visitEmptyQ(ruseParser.EmptyQContext ctx) {
        Object test = visit(ctx.expr());
        if (test instanceof EmptyList)
            return true;
        else
            return false;
    }
    
    @Override
    public Object visitZeroQ(ruseParser.ZeroQContext ctx) {
        Object test = visit(ctx.expr());
        if ((test instanceof Integer) && ((Integer)test == 0))
            return true;
        else
            return false;
    }
    
    @Override
    public Object visitListQ(ruseParser.ListQContext ctx) {
        Object test = visit(ctx.expr());
        if (test instanceof EmptyList) return true;
        if ((test instanceof Pair) && (((Pair)test).isList()))
            return true;
        else
            return false;
    }
    
    @Override
    public Object visitEvaluate(ruseParser.EvaluateContext ctx) {
        //Pair code = (Pair) visit(ctx.expr());
        Object code = visit(ctx.expr());
        String codes = code.toString();
        ANTLRInputStream input = new ANTLRInputStream(codes+"\n");
        ruseLexer lexer = new ruseLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ruseParser parser = new ruseParser(null);
        parser.setInputStream(tokens); // notify parser of new token stream
        ParseTree tree = parser.expr();                 // start the parser
            
       return visit(tree);
    }
    
    @Override
    public Object visitApply(ruseParser.ApplyContext ctx) {
        Function func = (Function) visit(ctx.f);
        Pair args = (Pair) visit(ctx.l);
        
        func.createLocalSymTab(args.toList(), globSymTab);
        
        // Push the current function onto the call stack.
        callStack.push(func);
        Object result = visit(func.body);
        callStack.pop();
        return result;
    }
    
    @Override
    public Object visitSetBang(ruseParser.SetBangContext ctx) {
      globSymTab.enter(ctx.ID().getText(), visit(ctx.expr()));
      return RUSEvoid.getInstance();
    }
    
    @Override
    public Object visitEqualQ(ruseParser.EqualQContext ctx) {
        Object rhs = visit(ctx.e1);
        Object lhs = visit(ctx.e2);
        return rhs.equals(lhs);
    }
/*    
    public Object quoteHelper(ParseTree p)
    {
        if (p.getChild(0) == ruseParser.LPAREN) return null;
        if (p.getChild(0) == ruseParser.INT) return visit(p);
        if (p.getChild(0) == ruserParser.STRING) return visit(p);
        if p.
            ctx.e.getRuleContext() instanceof ruseParser.StringContext)
            return visit(ctx.e);
        if (ctx.e.getRuleContext() instanceof ruseParser.JustIDContext)
            return (RUSESymbol) new RUSESymbol(ctx.e.getText()); 
    }
  */  
    @Override
    public Object visitQuote(ruseParser.QuoteContext ctx) {
        return visit(ctx.e);
    }
    
    @Override
    public Object visitQuoteInt(ruseParser.QuoteIntContext ctx)
    {
        return Integer.valueOf(ctx.INT().getText());
    }
    @Override
    public Object visitQuoteString(ruseParser.QuoteStringContext ctx)
    {
        return ctx.STRING().getText();
    }
    @Override
    public Object visitQuoteID(ruseParser.QuoteIDContext ctx)
    {
        return (RUSESymbol) new RUSESymbol(ctx.ID().getText()); 
    }
    @Override
    public Object visitQuoteList(ruseParser.QuoteListContext ctx)
    {
        Object result = EmptyList.getInstance();
        for (int i = ctx.quoteexpr().size() - 1; i >= 0; i--) {
            Object l = visit(ctx.quoteexpr(i));
            result = new Pair(l,result);
        }
        return result;
    }
    @Override
    public Object visitDisplayln(ruseParser.DisplaylnContext ctx) {
        Object todisplay = visit(ctx.expr());
        System.out.println(todisplay.toString());
        return RUSEvoid.getInstance();
    }
    
    @Override
    public Object visitDisplay(ruseParser.DisplayContext ctx) {
        Object todisplay = visit(ctx.expr());
        System.out.print(todisplay.toString());
        return RUSEvoid.getInstance();
    }
    
    @Override
    public Object visitLoad(ruseParser.LoadContext ctx) {
        String file = ctx.STRING().getText();
        BufferedReader inputStream;
        try {
            inputStream = new BufferedReader(new FileReader(file.substring(1, file.length()-1))); 
            String l;
            while ((l = inputStream.readLine()) != null) {
                ANTLRInputStream input = new ANTLRInputStream(l+"\n");
                ruseLexer lexer = new ruseLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                if (tokens.getNumberOfOnChannelTokens() > 1)
                {
                    ruseParser parser = new ruseParser(null);
                    parser.setInputStream(tokens); // notify parser of new token stream
                    ParseTree tree = parser.eval();                 // start the parser
                    visit(tree);
                }
            }
            inputStream.close();
            
        }
        catch (IOException ioe) {
            System.out.print("Trouble reading from the file: " + ioe.getMessage());
        } 
        
        return RUSEvoid.getInstance();
    }
}