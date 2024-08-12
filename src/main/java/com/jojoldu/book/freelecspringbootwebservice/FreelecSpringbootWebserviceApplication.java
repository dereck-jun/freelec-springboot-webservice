package com.jojoldu.book.freelecspringbootwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing 삭제됨 <- 테스트 코드에서 `IllegalArgumentException: At least one JPA metamodel must be present!` 발생
@SpringBootApplication
public class FreelecSpringbootWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelecSpringbootWebserviceApplication.class, args);
    }

}
