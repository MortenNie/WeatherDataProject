package dat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.beans.Visibility;
import java.io.IOException;
import java.util.List;

public class WeatherAPIReader {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String API_KEY = "&appid=1ac9bb5e0ff283159aded1e97f75b12a"; //Final fordi det er en endelig værdi.


    public static void main(String[] args) {

    }

    public static WeatherDataDTO getWeatherFromCity(List<WeatherDataConnectorToDTO> weatherData, String city) {

        String url = API_URL + city + API_KEY;
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String res = response.body().string();
            WeatherDTO weatherDTO = gson.fromJson(res, WeatherDTO.class);

            WeatherDataDTO weatherDataFinal = new WeatherDataDTO(weatherData.get(0).getTime(),
                    weatherData.get(0).getDate(),
                    weatherData.get(0).getTemperatur(),
                    weatherData.get(0).getWind(),
                    weatherData.get(0).getPrecipitation(),
                    weatherDTO.getWind().getDeg(),
                    weatherDTO.getWeatherMain().getHumidity(),
                    weatherDTO.getCoord().getLon(),
                    weatherDTO.getCoord().getLat(),
                    weatherDTO.getWeather()[0].getMain(),
                    weatherDTO.getWeather()[0].getDescription(),
                    weatherDTO.getVisibility());

            return weatherDataFinal;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @ToString
    @NoArgsConstructor
    @Getter
    public class WeatherDTO {
        private Coord coord;
        private Weather[] weather;
        @SerializedName("main")
        private WeatherMain weatherMain;
        private int visibility;
        private Wind wind;

    }

    class Coord {
        private double lon;
        private double lat;

        public double getLon() {
            return lon;
        }

        public double getLat() {
            return lat;
        }
    }


    class Weather {
        private String main;
        private String description;

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }
    }

    class WeatherMain {
        private int humidity;

        public int getHumidity() {
            return humidity;
        }
    }


    class Wind {
        private int deg;

        public int getDeg() {
            return deg;
        }


    }

}