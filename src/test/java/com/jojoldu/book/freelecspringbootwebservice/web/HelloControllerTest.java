package com.jojoldu.book.freelecspringbootwebservice.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = HelloController.class)    // 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있음. 단, @Repository, @Service, @Component 등은 안됨
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;    // 웹 API를 테스트할 때 사용. Spring Mvc 테스트의 시작점. 해당 클래스로 GET,POST 등에 대한 API 테스트를 할 수 있음

    @Test
    void hello가_리턴된다() throws Exception {
        String hello = "hello";

        /*
            1. MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함 (메서드 체이닝 지원)
            2. mvc.perform의 결과를 검증. HTTP Header의 status(상태코드)를 검증
            3. mvc.perform의 결과를 검증. 응답 본문의 내용을 검증.
         */
        mvc.perform(get("/hello"))                // 1
                .andExpect(status().isOk())                 // 2
                .andExpect(content().string(hello));        // 3
    }

    @Test
    void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
            get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value(name))
        .andExpect(jsonPath("$.amount").value(amount));
    }


}