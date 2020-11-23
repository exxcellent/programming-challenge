package de.exxcellent.challenge.service.processors;

import de.exxcellent.challenge.bo.FootballDataBO;
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
public class FootballSpreadProcessorTest {

    @InjectMocks
    FootballSpreadProcessor footballSpreadProcessor;

    @BeforeAll
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void processCSVDataTest() throws IOException {
        List<FootballDataBO> footballDataBOS = new ArrayList<>();
        FootballDataBO footballDataBO1 = new FootballDataBO("Arsenal,38,26,9,3,79,36,87");
        FootballDataBO footballDataBO2 = new FootballDataBO("Liverpool,38,24,8,6,67,30,80");
        footballDataBOS.add(footballDataBO1);
        footballDataBOS.add(footballDataBO2);
        FootballDataBO footballData = footballSpreadProcessor.calculateSpread(footballDataBOS);
        assertNotNull(footballData);
        assertEquals(footballData.getTeam(), "Liverpool");
    }
}
