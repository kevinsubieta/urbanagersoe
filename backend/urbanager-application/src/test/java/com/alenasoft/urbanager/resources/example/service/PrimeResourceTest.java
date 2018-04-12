package com.alenasoft.urbanager.resources.example.service;

import com.alenasoft.urbanager.UrbanagerApp;
import com.alenasoft.urbanager.UrbanagerConf;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.util.Random;


public class PrimeResourceTest {

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
    public void testIsPrimeIntegerNumberReturnOk() {
        String expectedResponse = "OK";
        int primerNumber = 7;

        String pathUrl = String.
                format("http://localhost:%s/api/primo/%s",
                        RULE.getLocalPort(), primerNumber);

        String response = this.client.
                target(pathUrl).request().get().
                readEntity(String.class);
        Assert.assertEquals(response, expectedResponse);
    }

    @Test
    public void testPrimoUrlIfIntegerIsNotPrimeReturnFail() {
        String expectedResponse = "FAIL";
        int primerNumber = 4;

        String pathUrl = String.
                format("http://localhost:%s/api/primo/%s",
                        RULE.getLocalPort(), primerNumber);

        String response = this.client.
                target(pathUrl).request().get().
                readEntity(String.class);
        Assert.assertEquals(response, expectedResponse);
    }

}
