package com.tistory.suhyeokeee.grade_cal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GradeCalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradeCalApplication.class, args);
    }

}
