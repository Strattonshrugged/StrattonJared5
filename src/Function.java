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
        Term powZero = new Term(c,"exp",0);
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
        // no terms, no result
        if (nextIndex == 0)  {
            return 0.0;
        }
        double t = 0;
        // loop through each value
        for (int i = 0; i < nextIndex; i++) {
            if (i == 0)  {
                t = evaluateTerm(contents[i],x);
            }   else    {
                t = t + evaluateTerm(contents[i],x);
            }
        }   // end for loop
        // set x back to the value being returned
        x = t;
        //System.out.println(contents.toString());
        return x;
    }

    public double evaluateTerm(Term termIn, double x)   {
        double temp;
        if (termIn.flag.equals("exp"))   {
            // raise x to exponent
            temp = Math.pow(x,termIn.numberTwo);
            // multiply by coefficient
            temp = temp * termIn.numberOne;
        }   else    {
            // multiply by coefficient of x
            temp = x * termIn.numberTwo;
            // take trigonometric value of x
            if (termIn.flag.equals("sin")) {
                temp = Math.sin(temp);
            }   else if (termIn.flag.equals("cos"))  {
                temp = Math.cos(temp);
            }   else if (termIn.flag.equals("tan"))   {
                temp = Math.tan(temp);
            }
            // multiply by coefficient of trig function
            temp = temp * termIn.numberOne;
        }
        // termReport
        System.out.printf("\tx=" + x + " numOne=" + termIn.numberOne + " flag=" + termIn.flag
        + " numTwo=" + termIn.numberTwo + " temp=" + temp + "\n");
        return temp;
    }

    boolean isEqual(double a, double b) {
        return Math.abs(a - b) < 0.0001;
    }

    // returns a Function that is the addition of this Function with f
    // (combine similar terms when possible)
    public Function add(Function f) {
        // the final index of f as "add" starts moving
        int FINAL_INDEX = f.nextIndex;
        boolean placed;
        // for every term in THIS contents
        for (int i = 0; i < nextIndex; i++)   {
            placed = false;
            // check against every term in function f's contents
            for (int j = 0; j < FINAL_INDEX; j++) {
                // if they have the same base and flag ...
                System.out.println("Comparison ...");
                System.out.println(contents[i].numberTwo);
                System.out.println(f.contents[j].numberTwo);
                System.out.println(contents[i].flag);
                System.out.println(f.contents[j].flag);
                System.out.println(isEqual(contents[i].numberTwo, f.contents[j].numberTwo));

                if (isEqual(contents[i].numberTwo, f.contents[j].numberTwo) && (contents[i].flag.equals(f.contents[j].flag))) {
                    System.out.println("Boom, inside the combination machine");
                    // add the numberOnes
                    f.contents[j].numberOne = f.contents[j].numberOne + contents[i].numberOne;
                    placed = true;
                }
            }
            // if there were no like bases and there IS room for a new term ...
            if ((placed == false) && (f.nextIndex < MAX_TERM_CAPACITY))  {
                f.contents[f.nextIndex] = contents[i];
                f.nextIndex = f.nextIndex + 1;
            }   else if (placed == false)    {
                // else there is no room and the term must be rejected
                System.out.println("Unable to complete process for term: " + f.contents[i].toString());
            }
        }
        System.out.println("f");
        System.out.println(f.toString());
        return f;
    }

    // returns a Function that is the subtraction of this Function with f
    // (combine similar terms when possible)
    public Function subtract(Function f) {
        // flip the positive/negative of every numberOne in every term
        // add
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
        if (nextIndex == 0) {
            return "Function contains no terms and will return zero";
        }
        String stuff = "";
        for (int i = 0; i < nextIndex; i++) {
            // add plus sign between terms for positive terms to show addition
            if ((contents[i].numberOne > 0) && (i > 0)) {
                stuff = stuff + " + ";
            }
            // print actual term
            stuff = stuff + termToString(contents[i]);
        }
        // stuff = stuff;
        return stuff;
    }
    public String termToString(Term termIn)    {
        String termString = "";
        // add first number, either coefficient of trig or coefficient of x
        termString = termString + Double.toString(termIn.numberOne);
        if (termIn.flag.equals("exp")) {
            // add x and exponent
            termString = termString + "x^" + Double.toString(termIn.numberTwo);
        }   else    {
            // add trigFunction, and quantity coefficient and x
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
