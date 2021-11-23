package pl.abrams.quiz.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.abrams.quiz.dto.HealthCheckDto;

@RestController
@RequestMapping("/api/health")
public class HealthCheckRestController {

    @GetMapping
    public HealthCheckDto healthCheck() {
        HealthCheckDto dto = new HealthCheckDto(true, "Działa!!!");
        return dto;
    }
}
