package stratpoint.samuelnieva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * The Calculator class. This class contains methods to perform basic
 * arithmetic operations. The methods are:
 * <ul>
 *     <li>Add</li>
 *     <li>Subtract</li>
 *     <li>Multiply</li>
 *     <li>Divide</li>
 * </ul>
 *
 * The class also contains a method for parsing and calculating an expression
 * in the form of a string. The methods used for this are:
 * <ul>
 *     <li>validateString</li>
 *     <li>calculateString</li>
 * </ul>
 */
public class Calculator {
    Logger logger = LoggerFactory.getLogger(Calculator.class);

    /**
     * This method adds two numbers and returns the result as a double.
     *
     * @param x The first number
     * @param y The second number
     * @return The sum of the two numbers
     */
    public double addNum(double x, double y) {
        logger.debug("Adding numbers: {} and {}. Result: {}", x, y, x + y);
        return x + y;
    }

    /**
     * This method subtracts two numbers and returns the result as a double.
     *
     * @param x The first number
     * @param y The second number
     * @return The difference of the two numbers
     */
    public double subNum(double x, double y) {
        logger.debug("Subtracting numbers: {} and {}. Result: {}", x, y, x - y);
        return x - y;
    }

    /**
     * This method divides two numbers and returns the result as a double.
     *
     * @param x The dividend
     * @param y The divisor
     * @return The quotient of the two numbers
     */
    public double divNum(double x, double y) {
        logger.debug("Dividing numbers: {} and {}. Result: {}", x, y, x / y);
        return x / y;
    }

    /**
     * This method multiplies two numbers and returns the result as a double.
     *
     * @param x The first number
     * @param y The second number
     * @return The product of the two numbers
     */
    public double mulNum(double x, double y) {
        logger.debug("Multiplying numbers: {} and {}. Result: {}", x, y, x * y);
        return x * y;
    }

    /**
     * Validates the expression String by checking if the number of
     * opening and closing parentheses are equal.
     *
     * @param e The expression
     * @return True if the expression is valid, false otherwise
     */
    public boolean validateString(String e) {
        char[] c = e.toCharArray();
        boolean firstPar = true;
        int parCount1 = 0;
        int parCount2 = 0;

        for(int i = 0;i < c.length;i++) {
            if(firstPar) {
                if(c[i] == ')')
                    return false;
                else if(c[i] == '(') {
                    parCount1++;
                    firstPar = false;
                }
            }
            else {
                if(c[i] == ')')
                    parCount2++;
                else if(c[i] == '(')
                    parCount1++;
            }
        }

        if(parCount1 == parCount2)
            return true;
        else
            return false;
    }

    /**
     * This method parses and calculates an expression in the form of a
     * string.
     *
     * @param e The expression
     * @return The result of the expression
     */
    public double calculateString(String e) {
        double total = 0;

        Stack<Double> nums = new Stack<>();
        Stack<Character> symbols = new Stack<>();
        //If parenthesis
        boolean parFlag = false;
        Stack<Character> par = new Stack<>();
        String parString = new String("");

        char[] chars = e.toCharArray();
        boolean calc = false;


        try {
            if(!this.validateString(e))
                throw new Exception("Invalid Input: Invalid Parenthesis");

            for (int i = 0;i < chars.length;i++) {
                boolean numFlag = chars[i] == '-' || Character.getNumericValue(chars[i]) != -1;
                boolean negFlag = i == 0 || (chars[i-1] == '+' || chars[i-1] == '-' || chars[i-1] == '*' || chars[i-1] == '/');
                boolean symFlag1 = chars[i] == '+' || chars[i] == '-';
                boolean symFlag2 = chars[i] == '*' || chars[i] == '/';

                if(chars[i] == '(' && !parFlag) {
                    parFlag = true;
                    parString = "";
                }

                if(parFlag) {
                    if(chars[i] == '(')
                        par.push(chars[i]);
                    else if(chars[i] == ')')
                        par.pop();

                    parString += chars[i];

                    if(par.isEmpty()) {
                        parFlag = false;
                        parString = parString.substring(1, parString.length()-1);

                        if(calc) {
                            char op = symbols.pop();
                            double temp = nums.pop();
                            double temp2 = this.calculateString(parString);

                            if(op == '*') {
                                nums.push(this.mulNum(temp, temp2));
                            }
                            else {
                                nums.push(this.divNum(temp, temp2));
                            }
                        }
                        else
                            nums.push(this.calculateString(parString));
                    }
                }
                else if(calc) {
                    Double temp = nums.pop();
                    Double temp2;

                    String temp3 = "";

                    if(chars[i] == '-') {
                        if(negFlag) {
                            temp3 += chars[i];
                            i++;
                        }
                        else {
                            symbols.push(chars[i]);
                            i++;
                        }
                    }

                    //Parse number
                    if(i != chars.length - 1 && (chars[i+1] == '.' || Character.getNumericValue(chars[i+1]) != -1)) {
                        temp3 += chars[i];
                        while(i != chars.length - 1 && (chars[i+1] == '.' || Character.getNumericValue(chars[i+1]) != -1)) {
                            i++;

                            if(chars[i] == '.' && temp3.contains("."))
                                throw new Exception("Invalid input: Multiple decimal points found");

                            temp3 += chars[i];
                        }

                        temp2 = Double.parseDouble(temp3);
                    }
                    else {
                        if(!temp3.isEmpty())
                            temp2 = Double.parseDouble(temp3 + chars[i]);
                        else
                            temp2 = (double) Character.getNumericValue(chars[i]);
                    }

                    Character op = symbols.pop();

                    if(op == '*') {
                        nums.push(this.mulNum(temp, temp2));
                    }
                    else {
                        nums.push(this.divNum(temp, temp2));
                    }

                    calc = false;
                }
                else {
                    String temp = "";

                    if(numFlag) {

                        //Case on if negative sign was found
                        if(chars[i] == '-') {
                            if(negFlag) {
                                temp += chars[i];
                                i++;
                            }
                            else {
                                symbols.push(chars[i]);
                                i++;
                            }
                        }

                        if(i != chars.length - 1  && ((Character.getNumericValue(chars[i+1]) != -1) || chars[i+1] == '.')) {
                            temp += chars[i];

                            while(i != chars.length - 1 && ((Character.getNumericValue(chars[i+1]) != -1) || chars[i+1] == '.')) {
                                i++;
                                if(chars[i] == '.' && temp.contains("."))
                                    throw new Exception("Invalid input: Multiple decimal points found");

                                temp += chars[i];
                            }

                            nums.push(Double.parseDouble(temp));
                        }
                        else {
                            if(!temp.isEmpty())
                                nums.push(Double.parseDouble(temp + chars[i]));
                            else
                                nums.push((double) Character.getNumericValue(chars[i]));
                        }
                    }

                    else if(symFlag1 || symFlag2) {
                        symbols.push(chars[i]);
                    }

                    if(symFlag2)
                        calc = true;
                }
            }



            if(nums.size() != symbols.size() + 1) {
                total = 0;
                throw new Exception(("Invalid input: Wrong formatting"));
            }

            //Last pass
            total = nums.pop();

            //Operations done from right to left (Stack)
            while(!nums.isEmpty() && !symbols.isEmpty()) {
                switch(symbols.pop()) {
                    case '+':
                        total = this.addNum(total, nums.pop());
                        break;
                    case '-':
                        total = this.subNum(nums.pop(), total);
                        break;
                }
            }
        }
        catch(Exception ex) {
            System.out.println();
            System.out.println(ex.getMessage());
        }

        return total;
    }
}
