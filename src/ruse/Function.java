/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruse;

import java.util.*;

/**
 *
 * @author phil
 */
public class Function extends Object{
    
    private final String name;
    private final ArrayList<String> parlist;
    private final int arity;
    private final Boolean variadic;
    final ruseParser.ExprContext body;
    private SymbolTable localSymTab;
    
    public Function(String n, ArrayList<String> p, ruseParser.ExprContext b,
                    Boolean var) {
        name = n;
        parlist = p;
        arity = p.size();
        body = b;
        localSymTab = null;
        variadic = var;
    }
    
    public String getName() { return name; }
    public int getArity() { return arity; }
    public ruseParser.ExprContext getBody() { return body; }
    public SymbolTable getLocalSymTab() { return localSymTab; }
    
    @Override
    public String toString() {
        if (name == null)
            return("#<procedure>");
        else
            return("#<procedure:"+name+">");
    }
    
    public void createLocalSymTab(ArrayList<Object> actualParams,
            SymbolTable pred) {
        if (localSymTab == null) localSymTab = new SymbolTable(pred);
        if (!variadic) {
        for (int i=0; i < arity; i++)
            localSymTab.enter(parlist.get(i),actualParams.get(i)); }
        else {
            for (int i=0; i < arity - 1; i++)
                localSymTab.enter(parlist.get(i),actualParams.get(i));
            Object rest = EmptyList.getInstance();
            for (int i = actualParams.size()-1; i >= arity -1 ; i--) {
                rest = new Pair(actualParams.get(i),rest);
            }
            localSymTab.enter(parlist.get(arity-1), rest);
        }
    }
    
    public void setLocalSymTab(SymbolTable symTab)
    { localSymTab = symTab; }
}
