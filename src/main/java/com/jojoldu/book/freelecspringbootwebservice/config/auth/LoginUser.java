package com.jojoldu.book.freelecspringbootwebservice.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
    1. 이 어노테이션이 생성될 수 있는 위치를 지정. 현재는 메서드의 파라미터로 선언된 객체에만 생성이 가능
    2. 이 파일을 어노테이션으로 지정. `@LoginUser`라는 이름의 어노테이션이 새로 만들어진 것임.
 */
@Target(ElementType.PARAMETER)          // 1
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {           // 2
}
