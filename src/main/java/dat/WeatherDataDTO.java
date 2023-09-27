package dat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@Setter
public class WeatherDataDTO {
    private String time;

    private LocalDate date;

    private double temperatur;

    private double wind;

    private double precipitation;

    private int deg;

    private int humidity;

    private double lon;

    private double lat;

    private String main;

    private String description;

    private int visibility;

    public WeatherDataDTO(String time, LocalDate date, double temperatur, double wind, double precipitation, int deg, int humidity, double lon, double lat, String main, String description, int visibility) {
        this.time = time;
        this.date = date;
        this.temperatur = temperatur;
        this.wind = wind;
        this.precipitation = precipitation;
        this.deg = deg;
        this.humidity = humidity;
        this.lon = lon;
        this.lat = lat;
        this.main = main;
        this.description = description;
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "Weather Data" + "\n" +
                "{" + "\n" +
                "time: " + time + "\n" +
                "date: " + date + "\n" +
                "temperatur: " + temperatur + "°c" + "\n" +
                "wind: " + wind + " m/s" + "\n" +
                "precipitation: " + precipitation + "mm" + "\n" +
                "deg: " + deg + "\n" +
                "humidity: " + humidity + "%" + "\n" +
                "lon: " + lon + "\n" +
                "lat: " + lat + "\n" +
                "main: " + main + "\n" +
                "description: " + description + "\n" +
                "visibility: " + visibility + "\n" +
                '}';
    }

    public static WeatherEntity runWeatherEntity() {
        String input = WeatherInputManager.cityInput();
        WeatherEntity weatherEntity = new WeatherEntity();
        if (input.equalsIgnoreCase("København") || input.equalsIgnoreCase("Odense") || input.equalsIgnoreCase("Gladsaxe")) {
            List<WeatherDataConnectorToDTO> weatherData = WebScraping.tv2Weather(input);
            WeatherDataDTO obj = WeatherAPIReader.getWeatherFromCity(weatherData, input);

            weatherEntity = new WeatherEntity(obj.getTime(), obj.getDate(),
                    obj.getTemperatur(), obj.getWind(), obj.getPrecipitation(),
                    obj.getDeg(), obj.getHumidity(), obj.getLon(), obj.getLat(),
                    obj.getMain(), obj.getDescription(), obj.getVisibility());


            System.out.println(weatherEntity);
        } else {
            System.out.println("try again");
        }
        return weatherEntity;
    }

}




