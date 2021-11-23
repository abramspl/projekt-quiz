package pl.abrams.quiz;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.abrams.quiz.database.entities.PlayerEntity;

@Component
@Log
public class StartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("Wykonywanie startowych akcji...");

        PlayerEntity player = new PlayerEntity("Lukas");
        log.info("Utworzenie gracza: " + player);
    }
}
