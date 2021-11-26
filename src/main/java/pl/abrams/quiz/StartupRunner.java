package pl.abrams.quiz;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.abrams.quiz.database.entities.PlayerEntity;
import pl.abrams.quiz.database.repositories.PlayerRepository;
import pl.abrams.quiz.services.QuizDataService;

import java.util.List;

@Component //klasa która sama również jest beanem Springowym
@Log
public class StartupRunner implements CommandLineRunner {

    @Autowired //Spring automatycznie w tym polu umieści referencję do odpowiedniego beana (wstrzyknięcie (ang. inject)).
    private PlayerRepository playerRepository;

    @Autowired
    private QuizDataService quizDataService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Wykonywanie startowych akcji...");
        playerRepository.save(new PlayerEntity("Lukasz"));
        playerRepository.save(new PlayerEntity("Tomek"));
        playerRepository.save(new PlayerEntity("Kasia"));
        quizDataService.getQuizCategories();

        log.info("Lista graczy z bazy danych:");
        List<PlayerEntity> playersFromDb = playerRepository.findAll();
        for (PlayerEntity player : playersFromDb){
            log.info("Odzyskany gracz: " + player);
        }
    }
}
