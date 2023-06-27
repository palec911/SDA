package pl.sda.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class WeatherService {

    @Value("${weatherapi.urlbase}")
    private String urlBase;

    private final String api_code = "50cf755d9c3ab32654cf0445de7b3602";

    public ResponseEntity<String> getWeatherDetailsByCityName(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = urlBase + "q=" + cityName + "&appid=" + api_code;
        log.info("URL is + " + url);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.getForEntity(url, String.class);
        } catch (HttpStatusCodeException e) {
            log.error(e.getResponseBodyAsString());
            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
                .body(e.getResponseBodyAsString());
        }
        if (response.getStatusCode().is2xxSuccessful()) {
            return response;
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public String getWeatherDetailsByCityCode(String cityCode){
        String url = urlBase + "id=" + cityCode + "&appid=" + api_code;
        Mono<String> response = WebClient.create(url).get().exchangeToMono(r -> {
            if (r.statusCode().equals(HttpStatus.OK)) {
                return r.bodyToMono(String.class);
            } else if (r.statusCode().is4xxClientError()) {
                return Mono.just("Error response");
            } else {
                return r.createException()
                        .flatMap(Mono::error);
            }
        });
        return response.block();
    }

}
