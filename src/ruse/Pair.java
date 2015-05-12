/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruse;

import java.util.ArrayList;

public class Pair extends Object{

  private final Object left;
  private final Object right;

  public Pair(Object left, Object right) {
    this.left = left;
    this.right = right;
  }

  public Object getLeft() { return left; }
  public Object getRight() { return right; }

  @Override
  public int hashCode() { return left.hashCode() ^ right.hashCode(); }

  public boolean isList() {
      if (!(this.right instanceof Pair) && this.right != EmptyList.getInstance())
          return false;
      if (this.right == EmptyList.getInstance())
          return true;
      else
          return ((Pair)this.right).isList();
  }
  
  // This function returns an ArrayList of all the items in the
  // list.  This function assumes that the pair is in fact a RUSE list.
  public ArrayList<Object> toList() {
      ArrayList<Object> result = new ArrayList<>();
      Object current = this;
      while(!(current instanceof EmptyList))
      {
          result.add(((Pair)current).getLeft());
          current = ((Pair)current).getRight();
      }
      return result;
  }
  
  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof Pair)) return false;
    Pair pairo = (Pair) o;
    return this.left.equals(pairo.getLeft()) &&
           this.right.equals(pairo.getRight());
      }

  private String HelpertoString() {
      if (getRight() == EmptyList.getInstance()) return getLeft().toString();
      return "" + getLeft() + " " + ((Pair)getRight()).HelpertoString();
  }
  
  @Override
  public String toString() {
      if (getRight() == EmptyList.getInstance())
          return "("+getLeft()+")";
      if (isList())
          return "(" + this.HelpertoString() + ")";
      else
        return "(" + getLeft() + " . " + getRight() + ")";
  }

}