package com.jojoldu.book.freelecspringbootwebservice.config.auth;

import com.jojoldu.book.freelecspringbootwebservice.config.auth.dto.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {   // 3

    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {   // 1
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
        return isLoginUserAnnotation && isUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {    // 2
        return httpSession.getAttribute("user");
    }
    
    /* 
        1. supportsParameter(): 컨트롤러 메서드의 특정 파라미터를 지원하는지 판단.
        2. resolveArgument(): 파라미터에 전달할 객체를 생성. 여기서는 세션에서 객체를 가져옴
        3. HandlerMethodArgumentResolver: `HandlerMethodArgumentResolver`는 항상 `WebMvcConfigurer`의 `addArgumentResolvers()`를 재정의해서 추가해야 한다.
           다른 `HandlerMethodArgumentResolver`가 필요하다면 같은 방식으로 추가하면 됨. (`config/WebConfig.class` 참고)
     */
}
