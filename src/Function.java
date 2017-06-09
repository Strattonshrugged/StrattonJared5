/**
 * Created by jared stratton on 5/31/17.
 */

import java.text.DecimalFormat;

// PLEASE leave your class name as Function
public class Function {
    // CLASS VARIABLES
    private static final int MAX_TERM_CAPACITY = 10;
    private DecimalFormat tw0 = new DecimalFormat("#0.00");
    private Term[] contents = new Term[MAX_TERM_CAPACITY];
    private int nextIndex = 0;


    private boolean isEqual(double a, double b) {
        return Math.abs(a - b) < 0.0001;
    }


    private class Term   {
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
        String flag = trigFunction.toLowerCase();
        if (flag.equals("sin")) {
            Term temp = new Term(coeff,"sin",p);
            contents[0] = temp;
            nextIndex = 1;
        }   else if (flag.equals("cos"))    {
            Term temp = new Term(coeff,"cos",p);
            contents[0] = temp;
            nextIndex = 1;
        }   else if (flag.equals("tan"))    {
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
        String flag = trigFunction.toLowerCase();
        if (flag.equals("exp")) {
            addTerm(c,p);
            return true;
        }   else if (flag.equals("sin") || flag.equals("cos") || flag.equals("tan")) {
            Term spawn = new Term(c,trigFunction,p);
            // find like bases
            for (int i = 0; i < nextIndex; i++) {
                if (isEqual(contents[i].numberTwo, spawn.numberTwo)
                        && (contents[i].flag.equals(spawn.flag)))   {
                    contents[i].numberOne = contents[i].numberOne + spawn.numberOne;
                    return true;
                }
            }
            contents[nextIndex] = spawn;
            nextIndex = nextIndex + 1;
            return true;
        }   else    {
            System.out.println("Invalid Function input, please check Trig Function desired");
            return false;
        }
    }



    // Create identical clone of a Function
    // usage: "Function blah = Bee.doppel()" ... would create a clone of Function Bee
    public Function doppel()  {
        Function spawn = new Function();
        for (int i = 0; i < this.nextIndex; i++)    {
            Term eggplant = new Term(this.contents[i].numberOne,this.contents[i].flag,this.contents[i].numberTwo);
            spawn.contents[i] = eggplant;
        }
        spawn.nextIndex = this.nextIndex;
        return spawn;
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

    private double evaluateTerm(Term termIn, double x)   {
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


    // returns a Function that is the addition of this Function with f
    // (combine similar terms when possible)
    public Function add(Function f) {
        Boolean placed;
        Function m = this.doppel();
        f = f.doppel();
        // check every term in f
        for (int i = 0; i < f.nextIndex; i++) {
            placed = false;
            // check against every term in m for identical base
            for (int j = 0; j < m.nextIndex; j++) {
                // if they have the same flag and numberTwo, combine numberOne
                if (isEqual(f.contents[i].numberTwo, m.contents[j].numberTwo) && (f.contents[i].flag.equals(m.contents[j].flag))) {
                    m.contents[i].numberOne = m.contents[i].numberOne + f.contents[i].numberOne;
                    placed = true;
                }
            }
            // if there are no identical bases and there is room, toss it in
            if (!placed && m.nextIndex < MAX_TERM_CAPACITY) {
                Term temp = new Term(f.contents[i].numberOne, f.contents[i].flag,f.contents[i].numberTwo);
                m.contents[nextIndex] = temp;
                m.nextIndex = nextIndex + 1;
            } else if (!placed) {
                System.out.println("Unable to complete process for term: " + f.contents[i].toString());
            }
        }   // end of for loop
         return m;
    }   // end of add Function


    // returns a Function that is the subtraction of this Function with f
    // (combine similar terms when possible)
    public Function subtract(Function f) {
        f = f.doppel();
        Function m = this.doppel();
        for (int i = 0; i < f.nextIndex; i++)   {
            f.contents[i].numberOne = -f.contents[i].numberOne;
        }
        Function p = m.add(f);
        return p;
    }


    public String toString() {
        if (nextIndex == 0) {
            return "Function contains no terms and will return zero";
        }
        String stuff = "";
        for (int i = 0; i < nextIndex; i++) {
            // add plus sign between terms for positive terms to show addition
            if ((contents[i].numberOne > 0) && (i > 0)) {
                stuff = stuff + "+";
            }   else    {
                stuff = stuff + "";
            }
            // print actual term
            stuff = stuff + termToString(contents[i]);
        }
        return stuff;
    }


    private String termToString(Term termIn)    {
        String termString = "";
        // add first number, either coefficient of trig or coefficient of x
        if (isEqual(termIn.numberOne,1))    {
        }   else if (isEqual(termIn.numberOne,-1))  {
            termString = termString + "-";
        }   else    {
            termString = termString + tw0.format(termIn.numberOne);
        }
        if (termIn.flag.equals("exp")) {
            // add x unless it's to the power of zero
            if (isEqual(termIn.numberTwo,0))    {
            }   else {
                termString = termString + "x";
            }

            // add power, wrap in parenthesis
            if (isEqual(termIn.numberTwo,1) || isEqual(termIn.numberTwo,0)) {
            }   else if(termIn.numberTwo < 0 && !isEqual(termIn.numberTwo,0))   {
                termString = termString + "^(" + tw0.format(termIn.numberTwo) + ")";
            }   else    {
                termString = termString + "^" + tw0.format(termIn.numberTwo);
            }
        }   else    {
            // add trigFunction, and x coefficient and x-character
            termString = termString + termIn.flag + "(";
            if (isEqual(termIn.numberTwo,1)) {
            }   else    {
                termString = termString + tw0.format(termIn.numberTwo);
            }
            termString = termString + "x)";
        }
        return termString;
    }


    public double slope(double X) {
        // slope = y1 - y2 / x1 - x2
        // x1 and y1 are left of X, x2 and y2 are right of x
        double x1 = (X - 0.00000000005);
        double y1 = evaluate(x1);
        double x2 = (X + 0.00000000005);
        double y2 = evaluate(x2);
        return Math.round(((y1 - y2) / (x1 - x2))*100.0)/100.0;
    }


    public double integral(double start, double end) {
        // take start and end, divide difference by one million, that's a "step"
        double stepsDesired = 10000000;
        double stepSize = (end - start)/stepsDesired;
        double A = 0.0;
        double B,Area;
        double tally = 0.0;
        boolean jumpstart = true;

        // Rather than evaluate twice iteration--passes right step to left, calculates right
        for (double cursor = start; cursor+stepSize < end; cursor += stepSize)  {
            if (jumpstart == true)  {
                A = evaluate(cursor);
                jumpstart = false;
            }
            B = evaluate(cursor + stepSize);
            Area = ((A + B) / 2) * stepSize;
            tally = tally + Area;
            A = B;
        }
        return Math.round(tally*100.0)/100.0;
    }   // end of integral
}   // End of Function Class
