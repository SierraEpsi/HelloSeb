package copycat;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class CopyCatService {
    private final static String GREETER_SVC = "greeter-svc";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultAnswer")
    public String copyGreeter(String name) {
        String url = "http://" + GREETER_SVC + "/greeter";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/vnd.spencr.v1+json");

        HttpEntity entity = new HttpEntity(headers);

        restTemplate.exchange(url + "?name=" + name , HttpMethod.PUT, entity, String.class);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    private String defaultAnswer(String name) {
        return "01@ W&r&1d!";
    }
}
