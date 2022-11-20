package com.org.accountbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AccountbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountbookApplication.class, args);
    }

}
