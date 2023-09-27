package dat;

import jakarta.xml.bind.ValidationException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static dat.WeatherAPIReader.gson;
import static org.junit.jupiter.api.Assertions.*;

class WeatherAPIReaderTest {

    @Test
    void testValidCity() {
        String city = "København";
        List<WeatherDataConnectorToDTO> validTest = WebScraping.tv2Weather(city);
        WeatherDataDTO obj = new WeatherDataDTO("15.00", LocalDate.now(), 18.0, 3.0, 0.0, 140, 69, 12.5655, 55.6759, "Clouds", "overcast clouds", 10000);
        WeatherDataDTO wdto = WeatherAPIReader.getWeatherFromCity(validTest, city);
        assertEquals(obj, wdto);


}

    @Test
    void testInvalidCity(){
        String city = "London";

        assertThrows(IndexOutOfBoundsException.class, () -> {
            List<WeatherDataConnectorToDTO> invalidTest = WebScraping.tv2Weather(city);
            WeatherDataDTO obj = new WeatherDataDTO("15.00", LocalDate.now(), 15.0, 3.0, 0.0, 140, 69, 12.5655, 55.6759, "Clouds", "overcast clouds", 10000);
            WeatherDataDTO wdto = WeatherAPIReader.getWeatherFromCity(invalidTest, city);
        });

    }
    @Test
    void testNullCity(){
        String city = null;

        assertThrows(NullPointerException.class, () -> {
            List<WeatherDataConnectorToDTO> invalidTest = WebScraping.tv2Weather(city);
            WeatherDataDTO obj = new WeatherDataDTO("15.00", LocalDate.now(), 15.0, 3.0, 0.0, 140, 69, 12.5655, 55.6759, "Clouds", "overcast clouds", 10000);
            WeatherDataDTO wdto = WeatherAPIReader.getWeatherFromCity(invalidTest, city);
        });

    }
}