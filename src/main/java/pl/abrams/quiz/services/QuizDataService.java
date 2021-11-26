package pl.abrams.quiz.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.abrams.quiz.QuestionsDto;
import pl.abrams.quiz.dto.CategoriesDto;

import java.net.URI;

@Service
@Log
public class QuizDataService {

    public void getQuizCategories(){
        RestTemplate restTemplate = new RestTemplate();
        CategoriesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
        log.info("Quiz - Kategorie: " + result.getCategories());
    }

    public void getQuizQuestions() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://opentdb.com/api.php")
                .queryParam("amount", 2)
                .queryParam("category", 25)
                .queryParam("difficulty", "medium")
                .build().toUri();
        log.info("Pytanie quizu — pobierz URL: " + uri);

        QuestionsDto result = restTemplate.getForObject(uri, QuestionsDto.class);
        log.info("Pytania quizowe: " + result.getResults());
    }
}
