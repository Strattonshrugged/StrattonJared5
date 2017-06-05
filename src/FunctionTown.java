/**
 This is only a tool to implement functionality of the Function class
 */

import java.util.*;

public class FunctionTown extends Function{
    public static Scanner console = new Scanner(System.in);


    public static void main(String args[]) {
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

        System.out.println("Function combo");
        Function partA = new Function(2.0,2.0,2.0);
        double evaluatePartA = partA.evaluate(2);
        System.out.println(evaluatePartA);

        Function partB = new Function (2.0,2.0,2.0);
        double evaluatePartB = partB.evaluate(2);
        System.out.println(evaluatePartB);

        System.out.println("partAtoString: " + partA.toString());
        System.out.println("partBtoString: " + partB.toString());
        partA.add(partB);


    }   // end of main
}   // end of Sandbox class