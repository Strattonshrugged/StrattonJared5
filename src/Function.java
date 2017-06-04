/**
 * Created by jared stratton on 5/31/17.
 */

// PLEASE leave your class name as Function
public class Function {
    // CLASS VARIABLES
    public static final int MAX_TERM_CAPACITY = 10;
    Term[] contents = new Term[MAX_TERM_CAPACITY];
    int nextIndex = 0;

    public class Term   {
        Double numberOne;
        String flag;
        Double numberTwo;

        // Term constructor
        public Term(double numberOne, String flag, double numberTwo)    {
        this.numberOne = numberOne;
        this.flag = flag;
        this.numberTwo = numberTwo;
        }
    }


    // CONSTRUCTORS
    // Initialize Function to f(x)=0
    // this is already done by virtue of having no terms in it
    public Function() {
    }


    // Set Function to f(x)=c
    public Function(double c) {
        Term powZero = new Term(1,"exp",0);
        contents[0] = powZero;
        nextIndex = 1;
    }


    // Set Function to f(x)=bx+c
    public Function(double b, double c) {
        Term powOne = new Term(b,"exp",1);
        Term powZero = new Term(c,"exp",0);
        contents[0] = powOne;
        contents[1] = powZero;
        nextIndex = 2;
    }


    // Set Function to f(x)=ax^2+bx+c
    public Function(double a, double b, double c) {
        Term powTwo = new Term(a,"exp",2);
        Term powOne = new Term(b,"exp",1);
        Term powZero = new Term(c,"exp",0);
        contents[0] = powTwo;
        contents[1] = powOne;
        contents[2] = powZero;
        nextIndex = 3;
    }


    // Set Function to f(x)=coeff*trigFunction(px)
    public Function(double coeff, String trigFunction, double p) {
        if (trigFunction.equals("sin")) {
            Term temp = new Term(coeff,"sin",p);
            contents[0] = temp;
            nextIndex = 1;
        }   else if (trigFunction.equals("cos"))    {
            Term temp = new Term(coeff,"cos",p);
            contents[0] = temp;
            nextIndex = 1;
        }   else if (trigFunction.equals("tan"))    {
            Term temp = new Term(coeff,"tan",p);
            contents[0] = temp;
            nextIndex = 1;
        }   else    {
            System.out.println("Invalid Function input, please check Trig Function desired");
        }
    }


    // Add a polynomial term of the form: Cx^P. to the Function
    public void addTerm(double C, double P) {
        Term spawn = new Term(C,"exp",P);
        contents[nextIndex] = spawn;
        nextIndex = nextIndex + 1;
    }


    // Add a trigonometric term of the form c*trigFunction(px)
    public boolean addTerm(double c, String trigFunction, double p) {
        if (trigFunction.equals("sin") || trigFunction.equals("cos") || trigFunction.equals("tan")) {
            Term spawn = new Term(c,trigFunction,p);
            contents[nextIndex] = spawn;
            nextIndex = nextIndex + 1;
            return true;
        }   else    {
            System.out.println("Invalid Function input, please check Trig Function desired");
            return false;
        }
    }


    // set Function to f(x)=0
    public void clear() {
        for (int i = 0; i < (MAX_TERM_CAPACITY); i++) {
            contents[i] = null;
        }
        nextIndex = 0;
    }


    // return the Function value at x
    public double evaluate(double x) {
        // if the nextIndex is zero
            // return zero
        // for each term in contents
            // if the flag is an exponent
                // raise x to power of numberTwo
                // multiply x by numberOne
            // else
                // x equals x times numberTwo
                // if the flag is cos
                    // x is cosine x
                // if the flag is sin
                    // x is sin x
                // if the flag is tan
                    // x is tan x
                // multiply x by numberOne
        return x;
    }


    // returns a Function that is the addition of this Function with f
    // (combine similar terms when possible)
    public Function add(Function f) {
        // for each item in contents of f
            // look for like terms
            // or just add to contents and increase next index
        // if next index equals max_final
            // reject the other terms and toString the remaining terms

        return f;
    }


    // returns a Function that is the subtraction of this Function with f
    // (combine similar terms when possible)
    public Function subtract(Function f) {
        return f;
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
    //     4.00cos(x)-tan(3.00x)+7.00x^8.00-x^2.00+6.00+9.00x^(-1.00)
    //     -4.50sin(x)+sin(2.5x)+3.25sin(2.0x)
        if (nextIndex == 0) {
            return "This Function contains no terms and will return zero\n";
        }
        String stuff = "";
        // optional nextIndex printing
        // stuff = stuff + "nextIndex is " + nextIndex + "\n";
        for (int i = 0; i < nextIndex; i++) {
            // add plus sign between terms for positive terms to show addition
            if (contents[i].numberOne > 0 && i > 0) {
                stuff = stuff + "+";
            }
            // print actual term
            stuff = stuff + toString(contents[i]);
        }
        stuff = stuff + "\n";
        return stuff;
    }
    public String toString(Term termIn)    {
        String termString = "";
        termString = termString + Double.toString(termIn.numberOne);
        if (termIn.flag.equals("exp")) {
            termString = termString + "x^" + Double.toString(termIn.numberTwo);
        }   else    {
            termString = termString + termIn.flag + "(" + Double.toString(termIn.numberTwo) + "x)";
        }
        return termString;
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
