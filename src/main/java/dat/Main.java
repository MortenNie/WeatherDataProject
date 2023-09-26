package dat;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static dat.WeatherAPIReader.gson;

public class Main {
    public static void main(String[] args) {
        String input = WeatherInputManager.cityInput();

        if (input.equalsIgnoreCase("København") || input.equalsIgnoreCase("Odense") || input.equalsIgnoreCase("Gladsaxe")) {
            List<WeatherDataConnectorToDTO> weatherData = WebScraping.tv2Weather(input);
            WeatherDataDTO obj = WeatherAPIReader.getWeatherFromCity(weatherData, input);
            System.out.println(obj);
        } else {
            System.out.println("try again");
        }



    }
}
