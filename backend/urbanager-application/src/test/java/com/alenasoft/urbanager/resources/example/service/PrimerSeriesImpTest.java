package com.alenasoft.urbanager.resources.example.service;

import com.google.common.reflect.TypeToken;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.debugger.cdbg.BaseClass;

import java.util.ArrayList;

import static org.hamcrest.core.IsInstanceOf.instanceOf;

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
    public void testGeneratePrimeSeriesByQuantityRequiredIfReturnAListOfIntegers(){
        int quantityOfDigitsToSee = 5;
        Assert.assertThat(primeSeriesServImpl.generatePrimeSeriesByQuantityRequired(quantityOfDigitsToSee)
        , instanceOf(new TypeToken<ArrayList<Integer>>() {}.getClass()));
    }
}
