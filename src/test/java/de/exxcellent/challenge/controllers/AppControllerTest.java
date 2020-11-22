package de.exxcellent.challenge.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static de.exxcellent.challenge.constants.Domain.FOOTBALL;
import static de.exxcellent.challenge.constants.Domain.WEATHER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppControllerTest {

    @InjectMocks
    AppController appController;

    @BeforeAll
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void processCSVDataTest() throws IOException {
        String spread = appController.processCSVData("de/exxcellent/challenge/football.csv", FOOTBALL);
        assertNotNull(spread);
        assertEquals(spread, "Team with smallest goal spread from CSV: Aston_Villa");
    }

    @Test
    public void processJSONDataTest() throws IOException {
        String spread = appController.processJSONData("de/exxcellent/challenge/weather.json", WEATHER);
        assertNotNull(spread);
        assertEquals(spread, "Day with smallest temperature spread from JSON: Day 14");
    }
}
