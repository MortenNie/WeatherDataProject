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
                var tempWind =  s.select("td").text();
                var time = s.select ("th").text();
                var precipitation = s.select("td.tc_weather_forecast_list_precipitation").text();
                if (precipitation.equals("")) {
                    precipitation = "0";
                    
                }
                double precipitationFinal = Double.parseDouble(precipitation);

                System.out.println(time + " - " + tempWind + " - " + precipitationFinal + "mm");
            }




        } catch(Exception ex) {
            ex.printStackTrace();

        }
    }
}
