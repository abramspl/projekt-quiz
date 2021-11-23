package pl.abrams.quiz;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.abrams.quiz.database.entities.PlayerEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component //klasa która sama również jest beanem Springowym
@Log
public class StartupRunner implements CommandLineRunner {

    @Autowired //Spring automatycznie w tym polu umieści referencję do odpowiedniego beana (wstrzyknięcie (ang. inject)).
    private EntityManager entityManager;

    @Override
    @Transactional //oznacza, że kod danej metody będzie wykonywany w transakcji bazodanowej.
    public void run(String... args) throws Exception {
        log.info("Wykonywanie startowych akcji...");
        PlayerEntity player = new PlayerEntity("Lukas");
        log.info("Utworzenie gracza: " + player);

        //powoduje skorzystanie z EntityManagera do zapisania obiektu player do bazy danych.
        // Od tego momentu nasz obiekt jest zarządzany przez JPA - i jego modyfikacje będą odzwierciedlone w bazie danych.
        entityManager.persist(player);
        log.info("Ten sam gracz po zapisaniu: " + player);

        log.info("Lista graczy z bazy danych:");
        Query q = entityManager.createQuery("SELECT p FROM PLAYERS p");
        List<PlayerEntity> playersFromDb = (List<PlayerEntity>)q.getResultList();

        for (PlayerEntity playerFromDb : playersFromDb){
            log.info("Gracze z DB: " + playerFromDb);
        }
    }
}
