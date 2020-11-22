package de.exxcellent.challenge.factory;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.bo.FootballDataBO;
import de.exxcellent.challenge.bo.FootballDataListBO;
import de.exxcellent.challenge.bo.WeatherDataBO;
import de.exxcellent.challenge.constants.Domain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseBOFactoryTest {

    @Test
    public void getBaseBOTest_HappyPath() throws IOException {
        BaseBO footballListBO = BaseBOFactory.getBaseObject(null, Domain.FOOTBALL);
        assertNotNull((FootballDataListBO) footballListBO);

        String weatherDataCsv = "2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5";
        BaseBO weatherBO = BaseBOFactory.getBaseObject(weatherDataCsv, Domain.WEATHER);
        assertNotNull((WeatherDataBO) weatherBO);
    }

    @Test
    public void getBaseBOTest_NegativeTest() throws IOException {
        try {
            BaseBO baseBO = BaseBOFactory.getBaseObject(null, Domain.WEATHER);
            FootballDataBO footballDataBO = (FootballDataBO) baseBO;
            fail("Exception expected but did not happen");
        } catch (ClassCastException cce) {
            assertNotNull(cce);
        }
    }
}
