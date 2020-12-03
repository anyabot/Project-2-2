package simplejavacalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import static java.lang.Double.NaN;
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
        assertEquals(result, NaN);
        result = calculator.calculateBi(Calculator.BiOperatorModes.normal, 3.0);
        assertEquals(result, NaN);
        result = calculator.reset();
        assertEquals(result, NaN);
    }
    @Test
    public void testAdditionSubstraction(){
        calculator.calculateBi(Calculator.BiOperatorModes.add, 127938.489);
        result = calculator.calculateBi(Calculator.BiOperatorModes.add, 12739.125);
        assertEquals(result, 140677.614, 1e-9);

        result = calculator.calculateBi(Calculator.BiOperatorModes.minus, 0.0);
        assertEquals(result, 140677.614, 1e-9);

        result = calculator.calculateEqual(175349.85);
        assertEquals(result, -34672.236, 1e-9);
    }
    @Test
    public void testMultiplicationDivision(){
        calculator.calculateBi(Calculator.BiOperatorModes.multiply, 358.0);
        result = calculator.calculateBi(Calculator.BiOperatorModes.divide, 423.0);
        assertEquals(result, 151434.0, 1e-9);

        result = calculator.calculateEqual(25239.0);
        assertEquals(result, 6.0, 1e-9);
    }

    @Test
    public void testPower(){
        calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 2.0);
        result = calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 4.0);
        assertEquals(result, 16.0, 1e-9);

        result = calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 0.5);
        assertEquals(result, 4.0, 1e-9);

        result = calculator.calculateEqual(-0.5);
        assertEquals(result, 0.5, 1e-9);
    }

    @Test
    public void testDivisionByZero(){
        calculator.calculateBi(Calculator.BiOperatorModes.divide, 1.0);
        assertEquals(calculator.calculateEqual(0.0), NaN);
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, 0.0), NaN);
    }

    @Test
    public void testPowerBaseNegative(){
        calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, -1.0);
        assertEquals(calculator.calculateEqual(-0.5), NaN);
    }

    @Test
    public void testSquare(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.square, 69.6), 4844.16, 1e-9);
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.square, -69.6), 4844.16, 1e-9);
    }

    @Test
    public void testSquareRoot(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, 4844.16), 69.6, 1e-9);
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, 0.0), 0.0, 1e-9);
    }

    @Test
    public void testSquareRootOfNegativeNumber(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, -1.0), NaN);
    }

    @Test
    public void testCosine(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.cos, Math.PI/3), 0.5, 1e-9);
    }

    @Test
    public void testSin(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.sin, Math.PI / 6), 0.5, 1e-9);
    }

    @Test
    public void testTan(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.tan, Math.PI / 4), 1.0, 1e-9);
    }

    @Test
    public void testTanOfRightAngle(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.tan, Math.PI / 2), NaN);
    }

    @Test
    public void testLog(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.log, 100.0), 2.0, 1e-9);
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.log, 1.0), 0.0, 1e-9);
    }

    @Test
    public void testLogNegativeNumber(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.log, -1.0), NaN);
    }

    @Test
    public void testRate(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.rate, 100.0), 1.0, 1e-9);
    }

    @Test
    public void testAbs(){
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.abs, 0.0), 0.0);
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.abs, -69.0), 69.0);
        assertEquals(calculator.calculateMono(Calculator.MonoOperatorModes.abs, 69.0), 69.0);
    }
}