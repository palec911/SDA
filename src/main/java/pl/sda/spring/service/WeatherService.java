package pl.sda.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WeatherService {

    @Value("${weatherapi.urlbase}")
    private String urlBase;

    private final String api_code = "50cf755d9c3ab32654cf0445de7b3602";

    public String getWeatherDetailsByCityName(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = urlBase + "q=" + cityName + "&appid=" + api_code;
        log.info("URL is + " + url);
        return restTemplate.getForEntity(url, String.class).getBody();
    }

    public String getWeatherDetailsByCityCode(String cityCode){
        String url = urlBase + "id=" + cityCode + "&appid=" + api_code;
        WebClient.ResponseSpec val = WebClient.create(url).get().retrieve();
        return val.bodyToMono(String.class).block();
    }

}
