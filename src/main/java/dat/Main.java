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
        String url = "https://vejr.tv2.dk/vejr/koebenhavn-2618425";
        List<WeatherDataConnectorToDTO> weatherData = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();


            var table = document.select("table").get(0);
            var rows = table.select("tr");


            for (Element s: rows) {

                var temperaturAndWind =  s.select("td").text();
                var temporaryWind = s.select("span.tc_weather__forecast__list__wind__speed").text();
                var temporaryTemperatur = s.select("td.tc_weather__forecast__list__temperature").text();
                var time = s.select ("th").text();
                var precipitation = s.select("td.tc__weather__forecast__list__precipitation").text();
                if (precipitation.isEmpty()) {
                    precipitation = "0";
                    
                }
                double precipitationFinal = Double.parseDouble(precipitation);

                if (!temporaryWind.isEmpty()) {
                     var temporaryWind2 = temporaryWind.replace("m/s","");
                     double windFinal = Double.parseDouble(temporaryWind2);
                     var temporaryTemperatur2 =  temporaryTemperatur.replace("°", "");
                     double temp = Double.parseDouble(temporaryTemperatur2);
                     WeatherDataConnectorToDTO connector = new WeatherDataConnectorToDTO(time, LocalDate.now(),temp,windFinal,precipitationFinal);
                     weatherData.add(connector);

                }
            }





        } catch(Exception ex) {
            ex.printStackTrace();

        }

        String url2 = "https://api.openweathermap.org/data/2.5/weather?q=Barcelona&appid=1ac9bb5e0ff283159aded1e97f75b12a";
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(url2)
                .method("GET", null)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String res = response.body().string();
            WeatherAPIReader.WeatherDTO weatherDTO = gson.fromJson(res, WeatherAPIReader.WeatherDTO.class);

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

            System.out.println(weatherDataFinal);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
