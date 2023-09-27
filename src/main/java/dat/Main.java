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

            WeatherEntity weatherEntity= new WeatherEntity(obj.getTime(),obj.getDate(),
                    obj.getTemperatur(), obj.getWind(), obj.getPrecipitation(),
                    obj.getDeg(), obj.getHumidity(), obj.getLon(), obj.getLat(),
                    obj.getMain(), obj.getDescription(), obj.getVisibility());


            System.out.println(weatherEntity);
        } else {
            System.out.println("try again");
        }



    }
}
