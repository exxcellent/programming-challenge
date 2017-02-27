package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    private String successLabel = "not successful";

    @Before
    public void setUp() throws Exception {
        successLabel = "successful";
    }

    @Test
    public void aPointlessTest() {
        Assert.assertEquals("Expectations met", "successful", successLabel);
    }

}