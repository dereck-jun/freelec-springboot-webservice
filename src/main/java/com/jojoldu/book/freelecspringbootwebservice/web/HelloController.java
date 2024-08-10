package com.jojoldu.book.freelecspringbootwebservice.web;

import com.jojoldu.book.freelecspringbootwebservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어 준다. ResponseBody를 한번에 사용할 수 있게 해준다고 생각
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * @RequestParam
     * 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션.
     * ?name=`name`&amount=`amount`
     */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam String name, @RequestParam int amount) {
        return new HelloResponseDto(name, amount);
    }
}
