package com.luminahi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    void subtraction() {
        assertEquals(0, calculator.sub(1, 1));
    }

    @Test
    void multiplication() {
        assertEquals(4, calculator.mult(2, 2));
    }
}