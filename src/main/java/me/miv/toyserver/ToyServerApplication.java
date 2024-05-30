package me.miv.toyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ToyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyServerApplication.class, args);
    }

}
