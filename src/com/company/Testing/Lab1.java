package com.company.Testing;

import java.util.Set;

public class Lab1 {

//    private Set set1;
//    private Set set2;
//
//    public Lab1(Set set1, Set set2) {
//        this.set1 = set1;
//        this.set2 = set2;
//    }
//
//    public Lab1() {
//    }



    public Set SetDifferance(Set set1, Set set2){
       if(set1==null||set2==null){
           throw new NullPointerException("Prazni se i dvata seta");
       }
       else {
           for (Object e : set2){

               if(set1.contains(e)){
                   set1.remove(e);
               }
           }
           if(!set1.isEmpty()){
              return set1;
           }
           else
               return null;
       }
    }
}
