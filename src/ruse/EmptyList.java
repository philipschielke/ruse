/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruse;

/**
 *
 * @author phil
 */
public final class EmptyList {
   private static EmptyList instance = null;
   private EmptyList() {
      // Exists only to defeat instantiation.
   }
   public static EmptyList getInstance() {
      if(instance == null) {
         instance = new EmptyList();
      }
      return instance;
   }
   
   @Override
   public String toString() {
       return "'()";
   }
   
   @Override
   public boolean equals(Object o2)
   {
       return o2 instanceof EmptyList;
   }
}
