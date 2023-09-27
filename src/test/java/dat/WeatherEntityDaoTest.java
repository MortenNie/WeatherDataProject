package dat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class WeatherEntityDaoTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static WeatherEntityDao weatherEntityDao;

    private static WeatherEntity weatherEntity;


    @BeforeAll
    static void setUpALl() {
        emf = HibernateConfigTest.getEntityManagerFactoryConfig("WeatherDataTest");
        em = emf.createEntityManager();
        weatherEntityDao = new WeatherEntityDao();
        weatherEntity = new WeatherEntity();

    }

    @AfterEach
    void tearDownAll() {
        em.close();

    }

    @Test
    void getAll() {

        WeatherEntity testWeatherEnt = new WeatherEntity("14.00", LocalDate.now(),
                21,2.0,0.0,221,65,
                12.5655,55.6759,"Clouds","broken clouds",10000);
        List<WeatherEntity> weatherEntityList= new ArrayList<>();
        weatherEntityList.add(testWeatherEnt);
        saveWeather(testWeatherEnt);
        List<WeatherEntity> kage = weatherEntityDao.getAll();

        assertEquals(weatherEntityList,kage);


    }

    @Test
    void getYesterday() {


        LocalDate yesterday = LocalDate.now().minusDays(1);
        WeatherEntity testWeatherEnt = new WeatherEntity("14.00", yesterday,
                21, 2.0, 0.0, 221, 65,
                    12.5655, 55.6759, "Clouds", "broken clouds", 10000);
            saveWeather(testWeatherEnt);


            WeatherEntity retrievedWeather = weatherEntityDao.getYesterday(LocalDate.now());
            assertEquals(yesterday, retrievedWeather.getTime());



    }

    @Test
    void saveWeather() {


            WeatherEntity testWeatherEnt = new WeatherEntity("14.00", LocalDate.now(),
                    21, 2.0, 0.0, 221, 65,
                    12.5655, 55.6759, "Clouds", "broken clouds", 10000);

            WeatherEntity savedWeather = saveWeather(testWeatherEnt);
            WeatherEntity retrievedWeather = em.find(WeatherEntity.class, savedWeather.getId());
            assertEquals(testWeatherEnt, retrievedWeather);


    }

    @Test
    void updateWeather() {
    }

    @Test
    void deleteWeather() {
    }

    @Test
    void findWeatherById() {
    }



    public static WeatherEntity saveWeather (WeatherEntity weather)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(weather);
        em.getTransaction().commit();
        em.close();
        return weather;
    }
}