package dat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
         




    }

    @Test
    void getYesterday() {
    }

    @Test
    void saveWeather() {

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