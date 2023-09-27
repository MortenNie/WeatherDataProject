package dat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WeatherEntityDao {

    //getAll, getYesterday, update(LocalDate date)
    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("WeatherData");

    public List<WeatherEntity> getAll(){

        try (var em = emf.createEntityManager()) {

            TypedQuery<WeatherEntity> query = em.createQuery("SELECT w FROM WeatherEntity w ", WeatherEntity.class);

            List<WeatherEntity> results = query.getResultList();


            return results;

        }

    }

    public WeatherEntity getYesterday(LocalDate date){
        try (var em = emf.createEntityManager()) {


            LocalDate yesterday = (date.minusDays(1));

            TypedQuery<WeatherEntity> query = em.createQuery("SELECT h FROM WeatherEntity h WHERE h.time = :parameter", WeatherEntity.class);
            query.setParameter("parameter", yesterday);
            WeatherEntity result = query.getSingleResult();

            return result;

        }
    }

    public WeatherEntity saveWeather (WeatherEntity weather)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(weather);
        em.getTransaction().commit();
        em.close();
        return weather;
    }
    public WeatherEntity updateWeather (WeatherEntity weather){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        WeatherEntity updatedWeather = em.merge(weather);
        em.getTransaction().commit();
        em.close();
        return updatedWeather;
    }

    public void deleteWeather (int id)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        WeatherEntity weatherEntity = findWeatherById(id);
        if (weatherEntity != null)
        {
            em.remove(weatherEntity);
        }
        em.getTransaction().commit();
        em.close();
    }

    public WeatherEntity findWeatherById (int id)
    {
        EntityManager em = emf.createEntityManager();
        WeatherEntity foundWeather = em.find(WeatherEntity.class, id);
        em.close();
        return foundWeather;
    }

}