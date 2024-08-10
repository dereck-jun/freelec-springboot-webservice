package com.jojoldu.book.freelecspringbootwebservice.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloResponseDtoTest {

    @Test
    void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        /*
            1. assertj라는 테스트 검증 라이브러리의 검증 메서드. 검증하고 싶은 대상을 메서드 인자로 받는다. (메서드 체이닝 지원)
            2. assertj의 동등 비교 메서드. 검증 대상과의 값을 비교해서 같으면 성공
         */
        assertThat(dto.getName()).isEqualTo(name);      // 1, 2
        assertThat(dto.getAmount()).isEqualTo(amount);  
    }

}