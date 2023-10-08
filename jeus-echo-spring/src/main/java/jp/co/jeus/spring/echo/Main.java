package jp.co.jeus.spring.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Main {

    @RequestMapping("/")
    public String echo(@RequestParam("text") String text) {
        return text;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}