package de.exxcellent.challenge.service.processors;


import de.exxcellent.challenge.bo.WeatherDataBO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WeatherSpreadProcessorTest {

    @InjectMocks
    WeatherSpreadProcessor weatherSpreadProcessor;

    @BeforeAll
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void processCSVDataTest() throws IOException {
        List<WeatherDataBO> weatherDataBOS = new ArrayList<>();
        WeatherDataBO weatherDataBO1 = new WeatherDataBO("1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5");
        WeatherDataBO weatherDataBO2 = new WeatherDataBO("2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5");
        weatherDataBOS.add(weatherDataBO1);
        weatherDataBOS.add(weatherDataBO2);
        WeatherDataBO weather = weatherSpreadProcessor.calculateSpread(weatherDataBOS);
        assertNotNull(weather);
        assertEquals(weather.getDay(), 2);
    }
}
