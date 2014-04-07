package com.androidhuman.example.studiotesting.test;

import junit.framework.TestCase;

/**
 * Created by kunny on 4/7/14.
 */
public class BasicTest extends TestCase{

    public void testSimple(){
        int a = 1;
        int b = 3;
        int result = a+b;

        assertEquals(4, result);
    }
}
