package com.androidhuman.example.jacocounittest;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testSum() {
        assertEquals(5, Calculator.sum(2, 3));
    }

}
