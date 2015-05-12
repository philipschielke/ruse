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
    final ruseParser.ExprContext body;
    private SymbolTable localSymTab;
    
    public Function(String n, ArrayList<String> p, ruseParser.ExprContext b) {
        name = n;
        parlist = p;
        arity = p.size();
        body = b;
        localSymTab = null;
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
        for (int i=0; i < arity; i++)
            localSymTab.enter(parlist.get(i),actualParams.get(i));
    }
    
    public void setLocalSymTab(SymbolTable symTab)
    { localSymTab = symTab; }
}
