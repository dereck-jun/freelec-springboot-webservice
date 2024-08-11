package com.jojoldu.book.freelecspringbootwebservice.web;

import com.jojoldu.book.freelecspringbootwebservice.service.posts.PostsService;
import com.jojoldu.book.freelecspringbootwebservice.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;


    @GetMapping("/")
    public String index(Model model) {      // 1
        model.addAttribute("posts", postsService.findAllDesc());
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
     */
}
