package pl.abrams.quiz.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.abrams.quiz.database.entities.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
