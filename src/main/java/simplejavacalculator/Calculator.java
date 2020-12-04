/**
 * @name        Simple Java Calculator
 * @file        Calculator.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;

import static java.lang.Double.NaN;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    public enum BiOperatorModes {
        /**
         * Operations that requires two operands.
         * normal return num2
         * add return the product of num1 and num2
         * minus return the difference of num1 and num2
         * multiply return the product of num1 and num2
         * divide return the quotient of num1 and num2
         * xpowerofy return num1 to the power of num2
         */
        normal, add, minus, multiply, divide, xpowerofy
    }

    public enum MonoOperatorModes {
        /**
         * Operations that requires one operand.
         * square return the square of num
         * squareRoot return the square root of num
         * oneDevidedBy return the quotient of 1 and num
         * cos return the cosine of num (in degree)
         * sin return the sine of num (in degree)
         * tan return the tangent of num (in degree)
         * log return the logarithm of num to base 10
         * rate return the quotient of num and 100
         * abs return the absolute value of num
         */
        square, squareRoot, oneDevidedBy, cos, sin, tan, log, rate, abs
    }

    /**
     * num1 is the first operand of a two-operand operation.
     */
    private Double num1;
    /**
     * num2 is the second operand of a two-operand operation.
     */
    private Double num2;
    /**
     * BiOperatorModes is the operation to be used.
     */
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }
        if (mode == BiOperatorModes.add) {
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;
        }
        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        }
        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.divide) {
            return num1 / num2;
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1, num2);
        }

        // never reach
        throw new Error();
    }

    /**
     * calculateBi return the result of a operation that requires two operands.
     * @return result of newMode operation
     * @param newMode type of operation
     * @param num second operand
     */

    public Double calculateBi(final BiOperatorModes newMode, final Double num) {
        if (mode == BiOperatorModes.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return NaN;
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.square) {
            return num * num;
        }
        if (newMode == MonoOperatorModes.squareRoot) {
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.oneDevidedBy) {
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.cos) {
            return Math.cos(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.sin) {
            return Math.sin(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.tan) {
            if (num == 0 || num % 180 == 0) {
                return 0.0;
            }
            if (num % 90 == 0 && num % 180 != 0) {
                return NaN;
            }

            return Math.tan(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.log) {
            return log10(num);
        }
        if (newMode == MonoOperatorModes.rate) {
           return num / 100;
        }
        if (newMode == MonoOperatorModes.abs){
            return Math.abs(num);
        }

        // never reach
        throw new Error();
    }

}
