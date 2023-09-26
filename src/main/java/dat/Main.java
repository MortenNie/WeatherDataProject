package dat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {
    public static void main(String[] args) {
        String url = "https://vejr.tv2.dk/vejr/koebenhavn-2618425";

        try {
            Document document = Jsoup.connect(url).get();
            /* for (Element row : document.select("table.tc_datatable_main td")) {

                 String weather = row.select("tc_weather_forecast_list_temperature").text();
                 System.out.println(weather);
             } */

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

                    System.out.println(time + " " + temp + "°  " + precipitationFinal + " " + windFinal + " m/s");
                }
            }




        } catch(Exception ex) {
            ex.printStackTrace();

        }
    }
}
