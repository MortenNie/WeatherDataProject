package dat;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class WeatherDataConnectorToDTO {

    private String time;

    private LocalDate date;

    private double temperatur;

    private double wind;

    private double precipitation;

    public WeatherDataConnectorToDTO(String time, LocalDate date, double temperatur, double wind, double precipitation) {
        this.time = time;
        this.date = date;
        this.temperatur = temperatur;
        this.wind = wind;
        this.precipitation = precipitation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        this.temperatur = temperatur;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }
}
