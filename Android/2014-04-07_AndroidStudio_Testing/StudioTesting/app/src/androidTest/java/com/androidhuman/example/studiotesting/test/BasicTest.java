package com.androidhuman.example.studiotesting.test;

import com.androidhuman.example.studiotesting.Adder;

import junit.framework.TestCase;

/**
 * Created by kunny on 4/7/14.
 */
public class BasicTest extends TestCase{

    public void testSimple(){
        Adder adder = new Adder();
        assertEquals(5, adder.add(2, 3));
    }
}
