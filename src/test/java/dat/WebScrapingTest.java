package dat;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WebScrapingTest {


    /**
     * This test works in the specific time frame that we have give
     */
    @Test
    void tv2WeatherTest() {

        String input = "københavn";
        List<WeatherDataConnectorToDTO> wdcTest= new ArrayList<>();
        WeatherDataConnectorToDTO obg= new WeatherDataConnectorToDTO("14.00", LocalDate.now(),18.0,3.0,0.0);
        wdcTest.add(obg);

        List<WeatherDataConnectorToDTO> wdc2= WebScraping.tv2Weather(input);
        assertEquals(wdcTest.get(0),wdc2.get(0));



    }
}