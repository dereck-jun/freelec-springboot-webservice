package com.jojoldu.book.freelecspringbootwebservice.web;

import com.jojoldu.book.freelecspringbootwebservice.config.auth.LoginUser;
import com.jojoldu.book.freelecspringbootwebservice.config.auth.dto.SessionUser;
import com.jojoldu.book.freelecspringbootwebservice.service.posts.PostsService;
import com.jojoldu.book.freelecspringbootwebservice.web.dto.PostsResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {      // 1   // 4
        model.addAttribute("posts", postsService.findAllDesc());

//        SessionUser user = (SessionUser) httpSession.getAttribute("user");  // 2

        if (user != null) {     // 3
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

    /*
        1. 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음. `postsService.findAllDesc()`의 결과를 `posts`라는 이름으로 `index.mustache`에 전달함
        2. `CustomOAuth2UserService`에서 로그인 성공 시 세션에 `SessionUser`를 저장하도록 구성. 로그인 성공 시 세션 안에 있는 `user`에서 값을 가져올 수 있음.
        3. 세션에 저장된 값이 있을 때만 `model`에 `userName`으로 등록. 저장된 값이 없으면 로그인 버튼이 보이게 됨.
        4. @LoginUser SessionUser user: 기존에 `(SessionUser) httpSession.getAttribute("user")`로 가져오던 세션 정보 값을 `@LoginUser`를 통해 가져올 수 있게 됨.
     */
}
