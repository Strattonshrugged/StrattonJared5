/**
 This is only a tool to implement functionality of the Function class
 */

import java.util.*;

public class FunctionTown extends Function{
    public static Scanner console = new Scanner(System.in);


    public static void main(String args[]) {
        Function A = new Function(3);
        Function B = new Function(3,6);
        Function C = new Function(6,9,12);
        Function D = new Function(-4,-1);
        D.addTerm(4,-4);
        D.addTerm(2,"cos",12);
        Function E = new Function(-1,"sin",2);
        Function F = new Function(3,"cos",4);
        Function G = new Function(5,"tan",6);
        Function Z = A.add(B);
        Z = Z.add(C);
        Z = Z.add(D);
        Z = Z.add(E);
        Z = Z.add(F);
        Z = Z.add(G);
        System.out.println(Z.toString());
        //System.out.println(Z.slope(0.0000000001));
        //System.out.println(Z.integral(-0.00000000005,0.00000000005));

        Function R = new Function(2,1);
        System.out.println(R.toString());
        //R.slope(2);
        /*

        System.out.println("Function nada");
        Function nada = new Function();
        double evaluateNada = nada.evaluate(4);
        System.out.println(evaluateNada);
        System.out.println(nada.toString());
        System.out.println();

        System.out.println("Function uno");
        Function uno = new Function(7.0);
        double evaluateUno = uno.evaluate(4);
        System.out.println(evaluateUno);
        System.out.println(uno.toString());
        System.out.println();

        System.out.println("Function dos");
        Function dos = new Function(5.0, 7.0);
        double evaluateDos = dos.evaluate(4);
        System.out.println(evaluateDos);
        System.out.println(dos.toString());
        System.out.println();

        System.out.println("Function tres");
        Function tres = new Function(3.0,5.0,7.0);
        double evaluateTres = tres.evaluate(4);
        System.out.println(evaluateTres);
        System.out.println(tres.toString());
        System.out.println();
*/
        //System.out.println(A.slope(1));


    }   // end of main



}   // end of Sandbox class

