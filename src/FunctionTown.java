/**
 This is only a tool to implement functionality of the Function class
 */

import java.util.*;

public class FunctionTown extends Function{
    public static Scanner console = new Scanner(System.in);


    public static void main(String args[]) {
        Function A = new Function(4,9,-1600);
        Function B = new Function(1,0);
        Function E = new Function(14,"cos",0.76);
        Function F = new Function(1000,"tan",14);
        F.addTerm(100,2);
        Function C = A.add(B);
        //C.addTerm(14,"cos",14);
        System.out.println(C.toString());
        Function X = F.add(E);
        System.out.println(X.toString());
        System.out.println(X.evaluate(12));
        //System.out.println(B.toString());
        //System.out.println(B.slope(4));
        //System.out.println(B.integral(0,6));
    }   // end of main



}   // end of Sandbox class

