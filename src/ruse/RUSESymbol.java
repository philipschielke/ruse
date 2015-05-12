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
public class RUSESymbol extends Object{
    
    private final String text;
    
    public RUSESymbol(String t) {
        text = t.substring(1, t.length());
    }
    
    public String getText() { return text; }
    
    @Override
    public String toString() {
        return text;
    }
    
    @Override
    public boolean equals(Object o2)
    {
        if (!(o2 instanceof RUSESymbol)) return false;
        return this.text.equals(((RUSESymbol)o2).text);
    }
}
