package com.alenasoft.urbanager.resources.example.service;

import com.alenasoft.urbanager.UrbanagerApp;
import com.alenasoft.urbanager.UrbanagerConf;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.*;

import javax.ws.rs.client.Client;
import java.util.ArrayList;
import java.util.Random;


public class PrimeSeriesResourceTest {

    @ClassRule
    public static final DropwizardAppRule<UrbanagerConf> RULE = new
            DropwizardAppRule<UrbanagerConf>(UrbanagerApp.class,
            ResourceHelpers.resourceFilePath("config-test.yml"));

    public final Random random = new Random();
    private Client client;

    @Before
    public void setUp() {
        this.client = new JerseyClientBuilder(RULE.getEnvironment())
                .build(String.format("tester-%d", this.random.nextInt()));
    }

    @After
    public void tearDown() {
        this.client.close();
        this.client = null;
    }

    @Test
    public void testGetNFirstNumberPrimeSeriesGivenThreeReturnArrayWithTwoThreeFive() {
        int primerNumber = 3;
        int[] expectedPrimeArray = {2,3,5};

        String pathUrl = String.
                format("http://localhost:%s/api/primo?",
                        RULE.getLocalPort(), primerNumber);

        String response = this.client.
                target(pathUrl).request().get().
                readEntity(String.class);

        int[] responseArray = new Gson().fromJson(response,new TypeToken<Iterators.Array<Integer>>() {}.getType());
        Assert.assertEquals(responseArray, expectedPrimeArray);
    }

}
