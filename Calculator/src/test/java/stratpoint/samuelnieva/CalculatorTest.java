package stratpoint.samuelnieva;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void addNum() {
        assertEquals(5, calc.addNum(3, 2));
    }

    @Test
    void subNum() {
        assertEquals(1, calc.subNum(5, 4));
    }

    @Test
    void divNum() {
        assertEquals(2, calc.divNum(10, 5));
    }

    @Test
    void mulNum() {
        assertEquals(6, calc.mulNum(3, 2));
    }

    @Test
    void validateString() {
        assertFalse(calc.validateString("(1+2))"));
        assertTrue(calc.validateString("(1+2)"));
    }

    @Test
    void calculateString() {
        assertEquals(3, calc.calculateString("(1+2)"));
        assertEquals(3.5, calc.calculateString("(1+(5/2))"));
    }
}