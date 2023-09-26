package dat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WebScraping {

    public static List<WeatherDataConnectorToDTO> tv2Weather() {
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

        return weatherData;

    }
}
