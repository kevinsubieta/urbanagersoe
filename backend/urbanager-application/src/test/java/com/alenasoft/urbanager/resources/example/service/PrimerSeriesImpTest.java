package com.alenasoft.urbanager.resources.example.service;

import com.alenasoft.urbanager.resources.example.service.Implementation.PrimeSeriesServImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrimerSeriesImpTest {
    private PrimeSeriesServImpl primeSeriesServImpl;

    @Before
    public void setUp() {
        primeSeriesServImpl = new PrimeSeriesServImpl();
    }

    @After
    public void tearDown() throws Exception {
        primeSeriesServImpl = null;
    }


    @Test
    public void testGetNFirstNumberPrimeSeriesGivenThreeReturnArrayWithTwoThreeFive(){
        int primeNumberToGenerate = 3;
        int[] expectedPrimeArray = {2,3,5};
        Assert.assertArrayEquals(primeSeriesServImpl.getNFirstNumberPrimeSeries(primeNumberToGenerate), expectedPrimeArray);
    }

    @Test
    public void testGetNFirstNumberPrimeSeriesGivenNegativeNumberReturnEmptyList(){
        int primeNumberToGenerate = -1;
        int[] expectedPrimeArray = {};
        Assert.assertArrayEquals(primeSeriesServImpl.getNFirstNumberPrimeSeries(primeNumberToGenerate), expectedPrimeArray);
    }

}
