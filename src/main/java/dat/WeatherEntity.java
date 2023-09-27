package dat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "time")
    private String time;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "tempratur")
    private double temperatur;

    @Column(name = "wind")
    private double wind;

    @Column(name = "precipitation")
    private double precipitation;

    @Column(name = "deg")
    private int deg;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "lon")
    private double lon;

    @Column(name = "lat")
    private double lat;

    @Column(name = "main")
    private String main;

    @Column(name = "description")
    private String description;

    @Column(name = "visibility")
    private int visibility;



    public WeatherEntity(String time, LocalDate date, double temperatur, double wind, double precipitation, int deg, int humidity, double lon, double lat, String main, String description, int visibility) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherEntity that = (WeatherEntity) o;
        return Double.compare(temperatur, that.temperatur) == 0 && Double.compare(wind, that.wind) == 0 && Double.compare(precipitation, that.precipitation) == 0 && deg == that.deg && humidity == that.humidity && Double.compare(lon, that.lon) == 0 && Double.compare(lat, that.lat) == 0 && visibility == that.visibility && Objects.equals(time, that.time) && Objects.equals(date, that.date) && Objects.equals(main, that.main) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, date, temperatur, wind, precipitation, deg, humidity, lon, lat, main, description, visibility);
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
}
