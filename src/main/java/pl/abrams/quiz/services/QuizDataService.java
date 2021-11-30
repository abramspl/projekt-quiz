package pl.abrams.quiz.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.abrams.quiz.QuestionsDto;
import pl.abrams.quiz.dto.CategoriesDto;
import pl.abrams.quiz.frontend.GameOptions;

import java.net.URI;
import java.util.List;

@Service
@Log
public class QuizDataService {

    public List<CategoriesDto.CategoryDto> getQuizCategories(){
        RestTemplate restTemplate = new RestTemplate();
        CategoriesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
        log.info("Quiz - Kategorie: " + result.getCategories());
        return result.getCategories();
    }

    public List<QuestionsDto.QuestionDto> getQuizQuestions(GameOptions gameOptions) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://opentdb.com/api.php")
                .queryParam("amount", gameOptions.getNumberOfQuestions())
                .queryParam("category", gameOptions.getCategoryId())
                .queryParam("difficulty", gameOptions.getDifficulty().name().toLowerCase())
                .build().toUri();
        log.info("Pytanie quizu — pobierz URL: " + uri);

        QuestionsDto result = restTemplate.getForObject(uri, QuestionsDto.class);
        log.info("Pytania quizowe: " + result.getResults());
        return result.getResults();
    }
}
