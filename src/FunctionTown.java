/**
 This is only a tool to implement functionality of the Function class
 */

import java.util.*;

public class FunctionTown extends Function{
    public static Scanner console = new Scanner(System.in);


    public static void main(String args[]) {
        Function zip = new Function();
        System.out.printf(zip.toString());
        Function uno = new Function(2.0);
        System.out.printf(uno.toString());
        Function dos = new Function(2.0,4.0);
        System.out.printf(dos.toString());
        Function tres = new Function(2.0,4.0,6.0);
        System.out.printf(tres.toString());
    }   // end of main
}   // end of Sandbox class