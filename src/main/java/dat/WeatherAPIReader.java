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

public class WeatherAPIReader {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {

        String url = "https://api.openweathermap.org/data/2.5/weather?q=Barcelona&appid=1ac9bb5e0ff283159aded1e97f75b12a";
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
            System.out.println(weatherDTO);
            System.out.println(gson.toJson(weatherDTO));

            //System.out.println(weatherDTO.weatherMain.getHumidity());
            System.out.println(weatherDTO.getVisibility());
            System.out.println(weatherDTO.coord.getLat());
            System.out.println(weatherDTO.wind.getDeg());

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
        @Getter
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