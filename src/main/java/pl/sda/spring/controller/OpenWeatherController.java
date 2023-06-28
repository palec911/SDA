package pl.sda.spring.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.service.WeatherService;

@RestController
@RequestMapping("/api")
public class OpenWeatherController {

    WeatherService weatherService;

    public OpenWeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{cityName}")
    public ResponseEntity<String> getWeatherByCityName(@PathVariable String cityName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String responseBody = weatherService.getWeatherDetailsByCityName(cityName).getBody();
        return ResponseEntity.ok().headers(headers).body(responseBody);
    }

    @GetMapping("/weather/code")
    public ResponseEntity<String> getWeatherByCityCode(@RequestParam String cityCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String responseBody = weatherService.getWeatherDetailsByCityCode(cityCode);
        return ResponseEntity.ok().headers(headers).body(responseBody);
    }
}
