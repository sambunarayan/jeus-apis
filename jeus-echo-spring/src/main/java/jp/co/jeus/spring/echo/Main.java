package jp.co.jeus.spring.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class Main {

    @GetMapping("/")
    public String echo(@RequestParam("text") String text) {
        return text;
    }

    @PostMapping("/post")
    public String postEcho(@RequestBody String text) {
        return text;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}