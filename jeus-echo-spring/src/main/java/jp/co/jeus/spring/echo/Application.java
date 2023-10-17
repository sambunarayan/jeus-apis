package jp.co.jeus.spring.echo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class Application {

    private Logger logger = LogManager.getLogger(Application.class);

    @GetMapping("/")
    public String echo(@RequestParam("text") String text) {
        return text;
    }

    @PostMapping("/post")
    public String postEcho(@RequestBody String text) {
        logger.info("[echo] :" + text);
        return text;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}