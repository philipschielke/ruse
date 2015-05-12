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
public class RUSEvoid {
   private static RUSEvoid instance = null;
   private RUSEvoid() {
      // Exists only to defeat instantiation.
   }
   public static RUSEvoid getInstance() {
      if(instance == null) {
         instance = new RUSEvoid();
      }
      return instance;
   }
   
   @Override
   public String toString() {
       return "#<void>";
   }
   
   @Override
   public boolean equals(Object o2)
   {
       return o2 instanceof RUSEvoid;
   }
}
