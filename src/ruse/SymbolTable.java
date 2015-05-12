/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruse;
import java.util.HashMap;

/**
 *
 * @author phil
 */
public class SymbolTable {
    HashMap<String,Object> table;
    
    private final SymbolTable pred;
    
    public SymbolTable() { 
        table = new HashMap<>();
        pred = null;
    }
    
    public SymbolTable(SymbolTable p) {
        table = new HashMap<>();
        pred = p;
    }
    
    public SymbolTable getPred() { return pred; }
    
    public boolean enter(String s, Object entry) {
        Object value = lookup(s);
        table.put(s, entry);
        return(value==null);
    }
    
    public Object lookup(String s) {
        Object value = table.get(s);
        if (value == null && pred!=null)
            value = pred.lookup(s);
        return value;
    }
}

