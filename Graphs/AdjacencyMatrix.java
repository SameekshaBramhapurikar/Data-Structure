// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) {
       int n=3,m=3;
       ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
       
       for(int i=0;i<=n;i++)
       {
           adj.add(new ArrayList<Integer>());
       }
       //edge 1-2
       adj.get(1).add(2);
       adj.get(2).add(1);
       
       //edge 2-4
      adj.get(2).add(3);
       adj.get(3).add(2);
       
       //edge 3-4,4-5
       adj.get(3).add(1);
       adj.get(1).add(3);
       
       System.out.println("Adjacency List");

       for(int i=1;i<=n;i++)
       {    System.out.print("Vertex "+i+":");
           for(int j=0;j<adj.get(i).size();j++)
           {
                System.out.print(" "+adj.get(i).get(j)+" ");  
           
           if(j<adj.get(i).size()-1)
           {
               System.out.print("->");
           }
           }
            System.out.println();
       }
       
    }
}
