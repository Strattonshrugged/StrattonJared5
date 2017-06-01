/**
 * Created by jared stratton on 5/31/17.
 */

// PLEASE leave your class name as Function
public class Function {


    // CLASS VARIABLES
    // use any collection of variables as you see fit.
    // CONSTRUCTORS
    // Initialize Function to f(x)=0
    public Function() {

    }


    // Set Function to f(x)=c
    public Function(double c) {

    }


    // Set Function to f(x)=bx+c
    public Function(double b, double c) {

    }


    // Set Function to f(x)=ax^2+bx+c
    public Function(double a, double b, double c) {

    }


    // Set Function to f(x)=coeff*trigFunction(px)
    public Function(double coeff, String trigFunction, double p) {

    }

    
    // Add a polynomial term of the form: Cx^P. to the Function
    public void addTerm(double C, double P) {

    }


    // Add a trigonometric term of the form c*trigFunction(px)
    public boolean addTerm(double c, String trigFunction, double p) {

    }


    // set Function to f(x)=0
    public void clear() {

    }


    // return the Function value at x
    public double evaluate(double x) {
        return x;
    }


    // returns a Function that is the addition of this Function with f
    // (combine similar terms when possible)
    public Function add(Function f) {

        return f;
    }


    // returns a Function that is the subtraction of this Function with f
    // (combine similar terms when possible)
    public Function subtract(Function f) {
    }


    // returns a String to represent the function
    // - combine similar terms
    // - show all coefficients to two places after decimal
    // - omit coefficients of 1.0000 except for negative exponents.
    // [There are NO specifications as to the order terms are displayed].
    // // Good Examples:
    //     4.00cos(x)-tan(3.00x)+7.00x^8.00-x^2.00+6.00+9.00x^(-1.00)
    //     -4.50sin(x)+sin(2.5x)+3.25sin(2.0x)
    // // Bad Examples:
    //     7.00x^8.00-1.00x^2.00+6.00+9.00x^-1.00
    //     -4.50sin(x)+sin(x)+3.25sin(x)
    //     7.00x^4.00-x^4.00
    // // NOTE: String.format method will be useful/similar to System.out.printf method.
public String toString() {

    }


    /* UNDER DEVELOPMENT
// return function slope=rise/run using a deltaX of 0.0000000001
        symmetrically about X
// (i.e. let run be defined by: X-0.00000000005 to X+0.00000000005) public double slope(double X) {

        } // return the integral value of the function between x value interval,
        start to end
// Use 10 million vertical, trapezoidal slices to determine integral
        value.
// If start is greater than end, return the negative value of the
        integration end to start.
public double integral(double start, double end) {

        } // Use any additional methods as you see fit.
*/

} //End Class
