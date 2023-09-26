package dat;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherDataConnectorToDTO that = (WeatherDataConnectorToDTO) o;
        return Double.compare(temperatur, that.temperatur) == 0 && Double.compare(wind, that.wind) == 0 && Double.compare(precipitation, that.precipitation) == 0 && Objects.equals(time, that.time) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, date, temperatur, wind, precipitation);
    }
}
