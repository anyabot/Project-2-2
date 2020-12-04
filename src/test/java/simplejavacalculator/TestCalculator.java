package simplejavacalculator;

import static java.lang.Double.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.lang.Math;

public class TestCalculator{
    Calculator calculator = new Calculator();
    Double result = 0.0;

    @Test
    public void testUI(){
        try {
            UI uiCal = new UI();
            uiCal.init();
            uiCal.writer(69.69);
            assertEquals(uiCal.reader(), 69.69, 1e-9);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testBasicMethodCalculator(){
        result = calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.0);
        assertEquals(NaN, result);
        result = calculator.calculateBi(Calculator.BiOperatorModes.normal, 3.0);
        assertEquals(NaN, result);
        result = calculator.reset();
        assertEquals(NaN, result);
    }
    @Test
    public void testAdditionSubstraction(){
        calculator.calculateBi(Calculator.BiOperatorModes.add, 127938.489);
        result = calculator.calculateBi(Calculator.BiOperatorModes.add, 12739.125);
        assertEquals(140677.614, result, 1e-9);

        result = calculator.calculateBi(Calculator.BiOperatorModes.minus, 0.0);
        assertEquals(140677.614, result, 1e-9);

        result = calculator.calculateEqual(175349.85);
        assertEquals(-34672.236, result, 1e-9);
    }
    @Test
    public void testMultiplicationDivision(){
        calculator.calculateBi(Calculator.BiOperatorModes.multiply, 358.0);
        result = calculator.calculateBi(Calculator.BiOperatorModes.divide, 423.0);
        assertEquals(151434.0, result, 1e-9);

        result = calculator.calculateEqual(25239.0);
        assertEquals(6.0, result, 1e-9);
    }
    @Test
    public void testPower(){
        calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 2.0);
        result = calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 4.0);
        assertEquals(16.0, result, 1e-9);

        result = calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 0.5);
        assertEquals(4.0, result, 1e-9);

        result = calculator.calculateEqual(-0.5);
        assertEquals(0.5, result, 1e-9);
    }

    @Test
    public void testDivisionByZero(){
        calculator.calculateBi(Calculator.BiOperatorModes.divide, 1.0);
        assertEquals(POSITIVE_INFINITY, calculator.calculateEqual(0.0));
        assertEquals(POSITIVE_INFINITY, calculator.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, 0.0));
        assertEquals(0.0, calculator.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, POSITIVE_INFINITY));
        assertEquals(NEGATIVE_INFINITY, calculator.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, -0.0));
        assertEquals(-0.0, calculator.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, NEGATIVE_INFINITY));
    }

    @Test
    public void testOneDividedBy(){
        assertEquals(1.0, calculator.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, 1.0), 1e-9);
        assertEquals(-1.0, calculator.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, -1.0), 1e-9);
    }

    @Test
    public void testPowerBaseNegative(){
        calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, -1.0);
        assertEquals(NaN, calculator.calculateEqual(-0.5));
    }

    @Test
    public void testSquare(){
        assertEquals(4844.16, calculator.calculateMono(Calculator.MonoOperatorModes.square, 69.6), 1e-9);
        assertEquals(4844.16, calculator.calculateMono(Calculator.MonoOperatorModes.square, -69.6), 1e-9);
    }

    @Test
    public void testSquareRoot(){
        assertEquals(69.6, calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, 4844.16), 1e-9);
        assertEquals(0.0, calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, 0.0), 1e-9);
    }

    @Test
    public void testSquareRootOfNegativeNumber(){
        assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, -1.0));
    }

    @Test
    public void testCosine(){
        assertEquals(0.5, calculator.calculateMono(Calculator.MonoOperatorModes.cos, Math.PI / 3), 1e-9);
        assertEquals(0.0, calculator.calculateMono(Calculator.MonoOperatorModes.cos, Math.PI / 2), 1e-9);
    }

    @Test
    public void testSin(){
        assertEquals(0.5, calculator.calculateMono(Calculator.MonoOperatorModes.sin, Math.PI / 6), 1e-9);
        assertEquals(1.0, calculator.calculateMono(Calculator.MonoOperatorModes.cos, Math.PI / 2), 1e-9);
    }

    @Test
    public void testTan(){
        assertEquals(1.0, calculator.calculateMono(Calculator.MonoOperatorModes.tan, Math.PI / 4), 1e-9);
    }

    @Test
    public void testTanOfRightAngle(){
        assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.tan, Math.PI / 2));
    }

    @Test
    public void testLog(){
        assertEquals(2.0, calculator.calculateMono(Calculator.MonoOperatorModes.log, 100.0), 1e-9);
        assertEquals(0.0, calculator.calculateMono(Calculator.MonoOperatorModes.log, 1.0), 1e-9);
    }

    @Test
    public void testLogNegativeNumber(){
        assertEquals(NaN, calculator.calculateMono(Calculator.MonoOperatorModes.log, -1.0));
    }

    @Test
    public void testLogZero(){
        assertEquals(NEGATIVE_INFINITY, calculator.calculateMono(Calculator.MonoOperatorModes.log, 0.0));
    }

    @Test
    public void testRate(){
        assertEquals(1.0, calculator.calculateMono(Calculator.MonoOperatorModes.rate, 100.0), 1e-9);
    }

    @Test
    public void testAbs(){
        assertEquals(0.0, calculator.calculateMono(Calculator.MonoOperatorModes.abs, 0.0) );
        assertEquals(69.0, calculator.calculateMono(Calculator.MonoOperatorModes.abs, -69.0));
        assertEquals(69.0, calculator.calculateMono(Calculator.MonoOperatorModes.abs, 69.0));
    }
}