// Generated from /Users/phil/NetBeansProjects/ruse/ruse.g4 by ANTLR 4.4

package ruse;
import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ruseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, INT=3, DOT=4, FLOAT=5, NEWLINE=6, TIMES=7, DIVIDE=8, 
		PLUS=9, MINUS=10, MODULO=11, LPAREN=12, RPAREN=13, CAR=14, CDR=15, CONS=16, 
		LESSTHAN=17, GREATERTHAN=18, EQUALS=19, IF=20, OR=21, AND=22, NOT=23, 
		DEFINE=24, LAMBDA=25, TRUE=26, FALSE=27, LIST=28, COND=29, LET=30, EMPTY=31, 
		ZERO=32, LISTQ=33, EVAL=34, APPLY=35, STRING=36, ELIST=37, SETBANG=38, 
		EQQ=39, EQUALQ=40, DSPLYLN=41, LOAD=42, ID=43, SYMBOL=44, LEADING=45;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "COMMENT", "INT", "'.'", "FLOAT", "NEWLINE", "'*'", 
		"'/'", "'+'", "'-'", "'%'", "'('", "')'", "'car'", "'cdr'", "'cons'", 
		"'<'", "'>'", "'='", "'if'", "'or'", "'and'", "'not'", "'define'", "'lambda'", 
		"'#t'", "'#f'", "'list'", "'cond'", "'let'", "'empty?'", "'zero?'", "'list?'", 
		"'eval'", "'apply'", "STRING", "''()'", "'set!'", "'eq?'", "'equal?'", 
		"'displayln'", "'load'", "ID", "SYMBOL", "LEADING"
	};
	public static final int
		RULE_eval = 0, RULE_expr = 1, RULE_define = 2, RULE_lambda = 3, RULE_letbinding = 4;
	public static final String[] ruleNames = {
		"eval", "expr", "define", "lambda", "letbinding"
	};

	@Override
	public String getGrammarFileName() { return "ruse.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ruseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvalContext extends ParserRuleContext {
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
	 
		public EvalContext() { }
		public void copyFrom(EvalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SExprContext extends EvalContext {
		public TerminalNode NEWLINE() { return getToken(ruseParser.NEWLINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SExprContext(EvalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefContext extends EvalContext {
		public DefineContext define() {
			return getRuleContext(DefineContext.class,0);
		}
		public DefContext(EvalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		try {
			setState(14);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new SExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(10); expr();
				setState(11); match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new DefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(13); define();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DisplaylnContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode DSPLYLN() { return getToken(ruseParser.DSPLYLN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public DisplaylnContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitDisplayln(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadContext extends ExprContext {
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LOAD() { return getToken(ruseParser.LOAD, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(ruseParser.STRING, 0); }
		public LoadContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLoad(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode LESSTHAN() { return getToken(ruseParser.LESSTHAN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public LessThanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConsContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode CONS() { return getToken(ruseParser.CONS, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public ConsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitCons(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ZeroContext extends ExprContext {
		public TerminalNode ZERO() { return getToken(ruseParser.ZERO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public ZeroContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitZero(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusIntContext extends ExprContext {
		public TerminalNode INT() { return getToken(ruseParser.INT, 0); }
		public TerminalNode MINUS() { return getToken(ruseParser.MINUS, 0); }
		public MinusIntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitMinusInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyContext extends ExprContext {
		public TerminalNode EMPTY() { return getToken(ruseParser.EMPTY, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public EmptyContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CdrContext extends ExprContext {
		public TerminalNode CDR() { return getToken(ruseParser.CDR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public CdrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitCdr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CarContext extends ExprContext {
		public TerminalNode CAR() { return getToken(ruseParser.CAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public CarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitCar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleMinusContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(ruseParser.MINUS, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public SimpleMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSimpleMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JustIDContext extends ExprContext {
		public TerminalNode ID() { return getToken(ruseParser.ID, 0); }
		public JustIDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitJustID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondContext extends ExprContext {
		public ExprContext t;
		public ExprContext v;
		public TerminalNode LPAREN(int i) {
			return getToken(ruseParser.LPAREN, i);
		}
		public TerminalNode COND() { return getToken(ruseParser.COND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(ruseParser.RPAREN, i);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ruseParser.RPAREN); }
		public List<TerminalNode> LPAREN() { return getTokens(ruseParser.LPAREN); }
		public CondContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode GREATERTHAN() { return getToken(ruseParser.GREATERTHAN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public GreaterThanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApplyContext extends ExprContext {
		public ExprContext f;
		public ExprContext l;
		public TerminalNode APPLY() { return getToken(ruseParser.APPLY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public ApplyContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public TerminalNode LIST() { return getToken(ruseParser.LIST, 0); }
		public ListContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(ruseParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaMatchContext extends ExprContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public LambdaMatchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLambdaMatch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualQContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode EQUALQ() { return getToken(ruseParser.EQUALQ, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public EqualQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitEqualQ(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetContext extends ExprContext {
		public TerminalNode LPAREN(int i) {
			return getToken(ruseParser.LPAREN, i);
		}
		public TerminalNode LET() { return getToken(ruseParser.LET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(ruseParser.RPAREN, i);
		}
		public LetbindingContext letbinding(int i) {
			return getRuleContext(LetbindingContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ruseParser.RPAREN); }
		public List<TerminalNode> LPAREN() { return getTokens(ruseParser.LPAREN); }
		public List<LetbindingContext> letbinding() {
			return getRuleContexts(LetbindingContext.class);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleTimesContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode TIMES() { return getToken(ruseParser.TIMES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public SimpleTimesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSimpleTimes(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EvaluateContext extends ExprContext {
		public TerminalNode EVAL() { return getToken(ruseParser.EVAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public EvaluateContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitEvaluate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListQContext extends ExprContext {
		public TerminalNode LISTQ() { return getToken(ruseParser.LISTQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public ListQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitListQ(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallContext extends ExprContext {
		public ExprContext f;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public FuncCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EListContext extends ExprContext {
		public TerminalNode ELIST() { return getToken(ruseParser.ELIST, 0); }
		public EListContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitEList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleDivideContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public TerminalNode DIVIDE() { return getToken(ruseParser.DIVIDE, 0); }
		public SimpleDivideContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSimpleDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(ruseParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimplePlusContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode PLUS() { return getToken(ruseParser.PLUS, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public SimplePlusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSimplePlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenElseContext extends ExprContext {
		public ExprContext cond;
		public ExprContext thenpart;
		public ExprContext elsepart;
		public TerminalNode IF() { return getToken(ruseParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public IfThenElseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitIfThenElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(ruseParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SymbolContext extends ExprContext {
		public TerminalNode SYMBOL() { return getToken(ruseParser.SYMBOL, 0); }
		public SymbolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(ruseParser.OR, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualsContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode EQUALS() { return getToken(ruseParser.EQUALS, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public EqualsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetBangContext extends ExprContext {
		public TerminalNode SETBANG() { return getToken(ruseParser.SETBANG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ruseParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public SetBangContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSetBang(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode AND() { return getToken(ruseParser.AND, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		int _la;
		try {
			setState(198);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new SimplePlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(16); match(LPAREN);
				setState(17); match(PLUS);
				setState(18); ((SimplePlusContext)_localctx).e1 = expr();
				setState(19); ((SimplePlusContext)_localctx).e2 = expr();
				setState(20); match(RPAREN);
				}
				break;
			case 2:
				_localctx = new SimpleMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(22); match(LPAREN);
				setState(23); match(MINUS);
				setState(24); ((SimpleMinusContext)_localctx).e1 = expr();
				setState(25); ((SimpleMinusContext)_localctx).e2 = expr();
				setState(26); match(RPAREN);
				}
				break;
			case 3:
				_localctx = new SimpleTimesContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(28); match(LPAREN);
				setState(29); match(TIMES);
				setState(30); ((SimpleTimesContext)_localctx).e1 = expr();
				setState(31); ((SimpleTimesContext)_localctx).e2 = expr();
				setState(32); match(RPAREN);
				}
				break;
			case 4:
				_localctx = new SimpleDivideContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(34); match(LPAREN);
				setState(35); match(DIVIDE);
				setState(36); ((SimpleDivideContext)_localctx).e1 = expr();
				setState(37); ((SimpleDivideContext)_localctx).e2 = expr();
				setState(38); match(RPAREN);
				}
				break;
			case 5:
				_localctx = new CarContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(40); match(LPAREN);
				setState(41); match(CAR);
				setState(42); expr();
				setState(43); match(RPAREN);
				}
				break;
			case 6:
				_localctx = new CdrContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(45); match(LPAREN);
				setState(46); match(CDR);
				setState(47); expr();
				setState(48); match(RPAREN);
				}
				break;
			case 7:
				_localctx = new ConsContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(50); match(LPAREN);
				setState(51); match(CONS);
				setState(52); ((ConsContext)_localctx).e1 = expr();
				setState(53); ((ConsContext)_localctx).e2 = expr();
				setState(54); match(RPAREN);
				}
				break;
			case 8:
				_localctx = new ListContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(56); match(LPAREN);
				setState(57); match(LIST);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << MINUS) | (1L << LPAREN) | (1L << STRING) | (1L << ELIST) | (1L << ID) | (1L << SYMBOL))) != 0)) {
					{
					{
					setState(58); expr();
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(64); match(RPAREN);
				}
				break;
			case 9:
				_localctx = new LessThanContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(65); match(LPAREN);
				setState(66); match(LESSTHAN);
				setState(67); ((LessThanContext)_localctx).e1 = expr();
				setState(68); ((LessThanContext)_localctx).e2 = expr();
				setState(69); match(RPAREN);
				}
				break;
			case 10:
				_localctx = new GreaterThanContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(71); match(LPAREN);
				setState(72); match(GREATERTHAN);
				setState(73); ((GreaterThanContext)_localctx).e1 = expr();
				setState(74); ((GreaterThanContext)_localctx).e2 = expr();
				setState(75); match(RPAREN);
				}
				break;
			case 11:
				_localctx = new EqualsContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(77); match(LPAREN);
				setState(78); match(EQUALS);
				setState(79); ((EqualsContext)_localctx).e1 = expr();
				setState(80); ((EqualsContext)_localctx).e2 = expr();
				setState(81); match(RPAREN);
				}
				break;
			case 12:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(83); match(LPAREN);
				setState(84); match(IF);
				setState(85); ((IfThenElseContext)_localctx).cond = expr();
				setState(86); ((IfThenElseContext)_localctx).thenpart = expr();
				setState(87); ((IfThenElseContext)_localctx).elsepart = expr();
				setState(88); match(RPAREN);
				}
				break;
			case 13:
				_localctx = new AndContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(90); match(LPAREN);
				setState(91); match(AND);
				setState(92); ((AndContext)_localctx).e1 = expr();
				setState(93); ((AndContext)_localctx).e2 = expr();
				setState(94); match(RPAREN);
				}
				break;
			case 14:
				_localctx = new OrContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(96); match(LPAREN);
				setState(97); match(OR);
				setState(98); ((OrContext)_localctx).e1 = expr();
				setState(99); ((OrContext)_localctx).e2 = expr();
				setState(100); match(RPAREN);
				}
				break;
			case 15:
				_localctx = new NotContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(102); match(LPAREN);
				setState(103); match(NOT);
				setState(104); expr();
				setState(105); match(RPAREN);
				}
				break;
			case 16:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(107); match(INT);
				}
				break;
			case 17:
				_localctx = new MinusIntContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(108); match(MINUS);
				setState(109); match(INT);
				}
				break;
			case 18:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(110); match(STRING);
				}
				break;
			case 19:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(111); match(LPAREN);
				setState(112); ((FuncCallContext)_localctx).f = expr();
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << MINUS) | (1L << LPAREN) | (1L << STRING) | (1L << ELIST) | (1L << ID) | (1L << SYMBOL))) != 0)) {
					{
					{
					setState(113); expr();
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119); match(RPAREN);
				}
				break;
			case 20:
				_localctx = new JustIDContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(121); match(ID);
				}
				break;
			case 21:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(122); match(LPAREN);
				setState(123); match(LET);
				setState(124); match(LPAREN);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LPAREN) {
					{
					{
					setState(125); letbinding();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131); match(RPAREN);
				setState(132); expr();
				setState(133); match(RPAREN);
				}
				break;
			case 22:
				_localctx = new LambdaMatchContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(135); lambda();
				}
				break;
			case 23:
				_localctx = new CondContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(136); match(LPAREN);
				setState(137); match(COND);
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(138); match(LPAREN);
					setState(139); ((CondContext)_localctx).t = expr();
					setState(140); ((CondContext)_localctx).v = expr();
					setState(141); match(RPAREN);
					}
					}
					setState(145); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LPAREN );
				setState(147); match(RPAREN);
				}
				break;
			case 24:
				_localctx = new SymbolContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(149); match(SYMBOL);
				}
				break;
			case 25:
				_localctx = new EListContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(150); match(ELIST);
				}
				break;
			case 26:
				_localctx = new ZeroContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(151); match(LPAREN);
				setState(152); match(ZERO);
				setState(153); expr();
				setState(154); match(RPAREN);
				}
				break;
			case 27:
				_localctx = new EmptyContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(156); match(LPAREN);
				setState(157); match(EMPTY);
				setState(158); expr();
				setState(159); match(RPAREN);
				}
				break;
			case 28:
				_localctx = new ListQContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(161); match(LPAREN);
				setState(162); match(LISTQ);
				setState(163); expr();
				setState(164); match(RPAREN);
				}
				break;
			case 29:
				_localctx = new EvaluateContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(166); match(LPAREN);
				setState(167); match(EVAL);
				setState(168); expr();
				setState(169); match(RPAREN);
				}
				break;
			case 30:
				_localctx = new ApplyContext(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(171); match(LPAREN);
				setState(172); match(APPLY);
				setState(173); ((ApplyContext)_localctx).f = expr();
				setState(174); ((ApplyContext)_localctx).l = expr();
				setState(175); match(RPAREN);
				}
				break;
			case 31:
				_localctx = new EqualQContext(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(177); match(LPAREN);
				setState(178); match(EQUALQ);
				setState(179); ((EqualQContext)_localctx).e1 = expr();
				setState(180); ((EqualQContext)_localctx).e2 = expr();
				setState(181); match(RPAREN);
				}
				break;
			case 32:
				_localctx = new SetBangContext(_localctx);
				enterOuterAlt(_localctx, 32);
				{
				setState(183); match(LPAREN);
				setState(184); match(SETBANG);
				setState(185); match(ID);
				setState(186); expr();
				setState(187); match(RPAREN);
				}
				break;
			case 33:
				_localctx = new DisplaylnContext(_localctx);
				enterOuterAlt(_localctx, 33);
				{
				setState(189); match(LPAREN);
				setState(190); match(DSPLYLN);
				setState(191); expr();
				setState(192); match(RPAREN);
				}
				break;
			case 34:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 34);
				{
				setState(194); match(LPAREN);
				setState(195); match(LOAD);
				setState(196); match(STRING);
				setState(197); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineContext extends ParserRuleContext {
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
	 
		public DefineContext() { }
		public void copyFrom(DefineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefFuncRestContext extends DefineContext {
		public TerminalNode LPAREN(int i) {
			return getToken(ruseParser.LPAREN, i);
		}
		public TerminalNode DEFINE() { return getToken(ruseParser.DEFINE, 0); }
		public TerminalNode DOT() { return getToken(ruseParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(ruseParser.RPAREN, i);
		}
		public List<TerminalNode> ID() { return getTokens(ruseParser.ID); }
		public List<TerminalNode> RPAREN() { return getTokens(ruseParser.RPAREN); }
		public List<TerminalNode> LPAREN() { return getTokens(ruseParser.LPAREN); }
		public TerminalNode ID(int i) {
			return getToken(ruseParser.ID, i);
		}
		public DefFuncRestContext(DefineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitDefFuncRest(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefSimpleContext extends DefineContext {
		public TerminalNode DEFINE() { return getToken(ruseParser.DEFINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ruseParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public DefSimpleContext(DefineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitDefSimple(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefFuncContext extends DefineContext {
		public TerminalNode LPAREN(int i) {
			return getToken(ruseParser.LPAREN, i);
		}
		public TerminalNode DEFINE() { return getToken(ruseParser.DEFINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(ruseParser.RPAREN, i);
		}
		public List<TerminalNode> ID() { return getTokens(ruseParser.ID); }
		public List<TerminalNode> RPAREN() { return getTokens(ruseParser.RPAREN); }
		public List<TerminalNode> LPAREN() { return getTokens(ruseParser.LPAREN); }
		public TerminalNode ID(int i) {
			return getToken(ruseParser.ID, i);
		}
		public DefFuncContext(DefineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitDefFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_define);
		int _la;
		try {
			setState(232);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new DefSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(200); match(LPAREN);
				setState(201); match(DEFINE);
				setState(202); match(ID);
				setState(203); expr();
				setState(204); match(RPAREN);
				}
				break;
			case 2:
				_localctx = new DefFuncContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(206); match(LPAREN);
				setState(207); match(DEFINE);
				setState(208); match(LPAREN);
				setState(210); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(209); match(ID);
					}
					}
					setState(212); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(214); match(RPAREN);
				setState(215); expr();
				setState(216); match(RPAREN);
				}
				break;
			case 3:
				_localctx = new DefFuncRestContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(218); match(LPAREN);
				setState(219); match(DEFINE);
				setState(220); match(LPAREN);
				setState(222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(221); match(ID);
					}
					}
					setState(224); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(226); match(DOT);
				setState(227); match(ID);
				setState(228); match(RPAREN);
				setState(229); expr();
				setState(230); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode LPAREN(int i) {
			return getToken(ruseParser.LPAREN, i);
		}
		public TerminalNode DOT() { return getToken(ruseParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(ruseParser.RPAREN, i);
		}
		public List<TerminalNode> ID() { return getTokens(ruseParser.ID); }
		public List<TerminalNode> RPAREN() { return getTokens(ruseParser.RPAREN); }
		public TerminalNode LAMBDA() { return getToken(ruseParser.LAMBDA, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(ruseParser.LPAREN); }
		public TerminalNode ID(int i) {
			return getToken(ruseParser.ID, i);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lambda);
		int _la;
		try {
			setState(262);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234); match(LPAREN);
				setState(235); match(LAMBDA);
				setState(236); match(LPAREN);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(237); match(ID);
					}
					}
					setState(242);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(243); match(RPAREN);
				setState(244); expr();
				setState(245); match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247); match(LPAREN);
				setState(248); match(LAMBDA);
				setState(249); match(LPAREN);
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(250); match(ID);
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(256); match(DOT);
				setState(257); match(ID);
				setState(258); match(RPAREN);
				setState(259); expr();
				setState(260); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetbindingContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ruseParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public LetbindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letbinding; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLetbinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetbindingContext letbinding() throws RecognitionException {
		LetbindingContext _localctx = new LetbindingContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_letbinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264); match(LPAREN);
			setState(265); match(ID);
			setState(266); expr();
			setState(267); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u0110\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\5\2\21\n\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\7\3>\n\3\f\3\16\3A\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3u\n\3\f\3\16\3x\13\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\7\3\u0081\n\3\f\3\16\3\u0084\13\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\u0092\n\3\r\3\16\3\u0093\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00c9\n\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\u00d5\n\4\r\4\16\4\u00d6\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\u00e1\n\4\r\4\16\4\u00e2\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4\u00eb\n\4\3\5\3\5\3\5\3\5\7\5\u00f1\n\5\f\5\16\5\u00f4"+
		"\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00fe\n\5\f\5\16\5\u0101\13"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0109\n\5\3\6\3\6\3\6\3\6\3\6\3\6\2\2\7"+
		"\2\4\6\b\n\2\2\u0137\2\20\3\2\2\2\4\u00c8\3\2\2\2\6\u00ea\3\2\2\2\b\u0108"+
		"\3\2\2\2\n\u010a\3\2\2\2\f\r\5\4\3\2\r\16\7\b\2\2\16\21\3\2\2\2\17\21"+
		"\5\6\4\2\20\f\3\2\2\2\20\17\3\2\2\2\21\3\3\2\2\2\22\23\7\16\2\2\23\24"+
		"\7\13\2\2\24\25\5\4\3\2\25\26\5\4\3\2\26\27\7\17\2\2\27\u00c9\3\2\2\2"+
		"\30\31\7\16\2\2\31\32\7\f\2\2\32\33\5\4\3\2\33\34\5\4\3\2\34\35\7\17\2"+
		"\2\35\u00c9\3\2\2\2\36\37\7\16\2\2\37 \7\t\2\2 !\5\4\3\2!\"\5\4\3\2\""+
		"#\7\17\2\2#\u00c9\3\2\2\2$%\7\16\2\2%&\7\n\2\2&\'\5\4\3\2\'(\5\4\3\2("+
		")\7\17\2\2)\u00c9\3\2\2\2*+\7\16\2\2+,\7\20\2\2,-\5\4\3\2-.\7\17\2\2."+
		"\u00c9\3\2\2\2/\60\7\16\2\2\60\61\7\21\2\2\61\62\5\4\3\2\62\63\7\17\2"+
		"\2\63\u00c9\3\2\2\2\64\65\7\16\2\2\65\66\7\22\2\2\66\67\5\4\3\2\678\5"+
		"\4\3\289\7\17\2\29\u00c9\3\2\2\2:;\7\16\2\2;?\7\36\2\2<>\5\4\3\2=<\3\2"+
		"\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2B\u00c9\7\17\2\2"+
		"CD\7\16\2\2DE\7\23\2\2EF\5\4\3\2FG\5\4\3\2GH\7\17\2\2H\u00c9\3\2\2\2I"+
		"J\7\16\2\2JK\7\24\2\2KL\5\4\3\2LM\5\4\3\2MN\7\17\2\2N\u00c9\3\2\2\2OP"+
		"\7\16\2\2PQ\7\25\2\2QR\5\4\3\2RS\5\4\3\2ST\7\17\2\2T\u00c9\3\2\2\2UV\7"+
		"\16\2\2VW\7\26\2\2WX\5\4\3\2XY\5\4\3\2YZ\5\4\3\2Z[\7\17\2\2[\u00c9\3\2"+
		"\2\2\\]\7\16\2\2]^\7\30\2\2^_\5\4\3\2_`\5\4\3\2`a\7\17\2\2a\u00c9\3\2"+
		"\2\2bc\7\16\2\2cd\7\27\2\2de\5\4\3\2ef\5\4\3\2fg\7\17\2\2g\u00c9\3\2\2"+
		"\2hi\7\16\2\2ij\7\31\2\2jk\5\4\3\2kl\7\17\2\2l\u00c9\3\2\2\2m\u00c9\7"+
		"\5\2\2no\7\f\2\2o\u00c9\7\5\2\2p\u00c9\7&\2\2qr\7\16\2\2rv\5\4\3\2su\5"+
		"\4\3\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7"+
		"\17\2\2z\u00c9\3\2\2\2{\u00c9\7-\2\2|}\7\16\2\2}~\7 \2\2~\u0082\7\16\2"+
		"\2\177\u0081\5\n\6\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0086\7\17\2\2\u0086\u0087\5\4\3\2\u0087\u0088\7\17\2\2\u0088\u00c9\3"+
		"\2\2\2\u0089\u00c9\5\b\5\2\u008a\u008b\7\16\2\2\u008b\u0091\7\37\2\2\u008c"+
		"\u008d\7\16\2\2\u008d\u008e\5\4\3\2\u008e\u008f\5\4\3\2\u008f\u0090\7"+
		"\17\2\2\u0090\u0092\3\2\2\2\u0091\u008c\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7\17"+
		"\2\2\u0096\u00c9\3\2\2\2\u0097\u00c9\7.\2\2\u0098\u00c9\7\'\2\2\u0099"+
		"\u009a\7\16\2\2\u009a\u009b\7\"\2\2\u009b\u009c\5\4\3\2\u009c\u009d\7"+
		"\17\2\2\u009d\u00c9\3\2\2\2\u009e\u009f\7\16\2\2\u009f\u00a0\7!\2\2\u00a0"+
		"\u00a1\5\4\3\2\u00a1\u00a2\7\17\2\2\u00a2\u00c9\3\2\2\2\u00a3\u00a4\7"+
		"\16\2\2\u00a4\u00a5\7#\2\2\u00a5\u00a6\5\4\3\2\u00a6\u00a7\7\17\2\2\u00a7"+
		"\u00c9\3\2\2\2\u00a8\u00a9\7\16\2\2\u00a9\u00aa\7$\2\2\u00aa\u00ab\5\4"+
		"\3\2\u00ab\u00ac\7\17\2\2\u00ac\u00c9\3\2\2\2\u00ad\u00ae\7\16\2\2\u00ae"+
		"\u00af\7%\2\2\u00af\u00b0\5\4\3\2\u00b0\u00b1\5\4\3\2\u00b1\u00b2\7\17"+
		"\2\2\u00b2\u00c9\3\2\2\2\u00b3\u00b4\7\16\2\2\u00b4\u00b5\7*\2\2\u00b5"+
		"\u00b6\5\4\3\2\u00b6\u00b7\5\4\3\2\u00b7\u00b8\7\17\2\2\u00b8\u00c9\3"+
		"\2\2\2\u00b9\u00ba\7\16\2\2\u00ba\u00bb\7(\2\2\u00bb\u00bc\7-\2\2\u00bc"+
		"\u00bd\5\4\3\2\u00bd\u00be\7\17\2\2\u00be\u00c9\3\2\2\2\u00bf\u00c0\7"+
		"\16\2\2\u00c0\u00c1\7+\2\2\u00c1\u00c2\5\4\3\2\u00c2\u00c3\7\17\2\2\u00c3"+
		"\u00c9\3\2\2\2\u00c4\u00c5\7\16\2\2\u00c5\u00c6\7,\2\2\u00c6\u00c7\7&"+
		"\2\2\u00c7\u00c9\7\17\2\2\u00c8\22\3\2\2\2\u00c8\30\3\2\2\2\u00c8\36\3"+
		"\2\2\2\u00c8$\3\2\2\2\u00c8*\3\2\2\2\u00c8/\3\2\2\2\u00c8\64\3\2\2\2\u00c8"+
		":\3\2\2\2\u00c8C\3\2\2\2\u00c8I\3\2\2\2\u00c8O\3\2\2\2\u00c8U\3\2\2\2"+
		"\u00c8\\\3\2\2\2\u00c8b\3\2\2\2\u00c8h\3\2\2\2\u00c8m\3\2\2\2\u00c8n\3"+
		"\2\2\2\u00c8p\3\2\2\2\u00c8q\3\2\2\2\u00c8{\3\2\2\2\u00c8|\3\2\2\2\u00c8"+
		"\u0089\3\2\2\2\u00c8\u008a\3\2\2\2\u00c8\u0097\3\2\2\2\u00c8\u0098\3\2"+
		"\2\2\u00c8\u0099\3\2\2\2\u00c8\u009e\3\2\2\2\u00c8\u00a3\3\2\2\2\u00c8"+
		"\u00a8\3\2\2\2\u00c8\u00ad\3\2\2\2\u00c8\u00b3\3\2\2\2\u00c8\u00b9\3\2"+
		"\2\2\u00c8\u00bf\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9\5\3\2\2\2\u00ca\u00cb"+
		"\7\16\2\2\u00cb\u00cc\7\32\2\2\u00cc\u00cd\7-\2\2\u00cd\u00ce\5\4\3\2"+
		"\u00ce\u00cf\7\17\2\2\u00cf\u00eb\3\2\2\2\u00d0\u00d1\7\16\2\2\u00d1\u00d2"+
		"\7\32\2\2\u00d2\u00d4\7\16\2\2\u00d3\u00d5\7-\2\2\u00d4\u00d3\3\2\2\2"+
		"\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8\u00d9\7\17\2\2\u00d9\u00da\5\4\3\2\u00da\u00db\7\17\2\2"+
		"\u00db\u00eb\3\2\2\2\u00dc\u00dd\7\16\2\2\u00dd\u00de\7\32\2\2\u00de\u00e0"+
		"\7\16\2\2\u00df\u00e1\7-\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7\6"+
		"\2\2\u00e5\u00e6\7-\2\2\u00e6\u00e7\7\17\2\2\u00e7\u00e8\5\4\3\2\u00e8"+
		"\u00e9\7\17\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00ca\3\2\2\2\u00ea\u00d0\3"+
		"\2\2\2\u00ea\u00dc\3\2\2\2\u00eb\7\3\2\2\2\u00ec\u00ed\7\16\2\2\u00ed"+
		"\u00ee\7\33\2\2\u00ee\u00f2\7\16\2\2\u00ef\u00f1\7-\2\2\u00f0\u00ef\3"+
		"\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7\17\2\2\u00f6\u00f7\5"+
		"\4\3\2\u00f7\u00f8\7\17\2\2\u00f8\u0109\3\2\2\2\u00f9\u00fa\7\16\2\2\u00fa"+
		"\u00fb\7\33\2\2\u00fb\u00ff\7\16\2\2\u00fc\u00fe\7-\2\2\u00fd\u00fc\3"+
		"\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\7\6\2\2\u0103\u0104\7-"+
		"\2\2\u0104\u0105\7\17\2\2\u0105\u0106\5\4\3\2\u0106\u0107\7\17\2\2\u0107"+
		"\u0109\3\2\2\2\u0108\u00ec\3\2\2\2\u0108\u00f9\3\2\2\2\u0109\t\3\2\2\2"+
		"\u010a\u010b\7\16\2\2\u010b\u010c\7-\2\2\u010c\u010d\5\4\3\2\u010d\u010e"+
		"\7\17\2\2\u010e\13\3\2\2\2\16\20?v\u0082\u0093\u00c8\u00d6\u00e2\u00ea"+
		"\u00f2\u00ff\u0108";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}