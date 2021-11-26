package pl.abrams.quiz.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.abrams.quiz.dto.CategoriesDto;

@Service
@Log
public class QuizDataService {

    public void getQuizCategories(){
        RestTemplate restTemplate = new RestTemplate();
        CategoriesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
        log.info("Quiz - Kategorie: " + result.getCategories());
    }
}
