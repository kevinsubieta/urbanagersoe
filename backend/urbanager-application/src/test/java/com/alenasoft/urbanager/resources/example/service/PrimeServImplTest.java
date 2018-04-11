package com.alenasoft.urbanager.resources.example.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PrimeServImplTest {
    private PrimeServImpl primeServ;

    @Before
    public void setUp() {
        primeServ = new PrimeServImpl();
    }

    @After
    public void tearDown() throws Exception {
        primeServ = null;
    }


    @Test
    public void testIfIntegerNumberIsPrimeReturnTrue() throws Exception{
        int primeNumber = 7;
        assertTrue(primeServ.numberIntegerIsPrime(primeNumber));
    }

}
