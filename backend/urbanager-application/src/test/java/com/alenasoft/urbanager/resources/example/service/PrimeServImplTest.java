package com.alenasoft.urbanager.resources.example.service;

import com.alenasoft.urbanager.resources.example.service.Implementation.PrimeServImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    public void testNumberIntegerIsPrimeIfIntegerNumberIsPrimeReturnTrue() throws Exception{
        int primeNumber = 7;
        assertTrue(primeServ.numberIntegerIsPrime(primeNumber));
    }

    @Test
    public void testNumberIntegerIsPrimeIfIntegerNumberIsNotPrimeReturnFalse() {
        int notPrimeNumber = 4;
        assertFalse(primeServ.numberIntegerIsPrime(notPrimeNumber));
    }

    @Test
    public void testNumberIntegerIsPrimeIfIntegerIsNegativeReturnFalse(){
        int negativeNumber = -7;
        assertFalse(primeServ.numberIntegerIsPrime(negativeNumber));
    }

    @Test
    public void testNumberIntegerIsPrimeIfIntegerIsOneReturnFalse(){
        assertFalse(primeServ.numberIntegerIsPrime(1));
    }
}
