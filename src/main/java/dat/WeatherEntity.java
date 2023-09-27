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
@ToString
public class WeatherEntity extends WeatherDataDTO{

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

    @ManyToOne
    public User user;

    public WeatherEntity(String time, LocalDate date, double temperatur, double wind,
                         double precipitation, int deg, int humidity,
                         double lon, double lat, String main, String description, int visibility) {
        super(time, date, temperatur, wind, precipitation,
                deg, humidity, lon, lat, main, description, visibility);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherEntity that = (WeatherEntity) o;
        return id == that.id && deg == that.deg && humidity == that.humidity && visibility == that.visibility && Objects.equals(time, that.time) && Objects.equals(date, that.date) && Objects.equals(temperatur, that.temperatur) && Objects.equals(wind, that.wind) && Objects.equals(precipitation, that.precipitation) && Objects.equals(lon, that.lon) && Objects.equals(lat, that.lat) && Objects.equals(main, that.main) && Objects.equals(description, that.description) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, date, temperatur, wind, precipitation, deg, humidity, lon, lat, main, description, visibility, user);
    }
}
