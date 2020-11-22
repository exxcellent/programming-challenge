package de.exxcellent.challenge.service.readers;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.bo.FootballDataBO;
import de.exxcellent.challenge.bo.WeatherDataBO;
import de.exxcellent.challenge.constants.Domain;
import de.exxcellent.challenge.service.processors.WeatherSpreadProcessor;
import de.exxcellent.challenge.utils.FileReaderUtil;
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
public class CsvReaderTest {

    @InjectMocks
    CsvReader csvReader;

    @BeforeAll
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void readTest() throws IOException {
        String csvData =  FileReaderUtil.readFile("de/exxcellent/challenge/football.csv");
        List<BaseBO> baseBOS = csvReader.read(csvData, Domain.FOOTBALL);
        assertNotNull(baseBOS);
        assertEquals(baseBOS.size(), 20);
        assertEquals(((FootballDataBO) baseBOS.get(0)).getTeam(), "Arsenal");
    }
}
