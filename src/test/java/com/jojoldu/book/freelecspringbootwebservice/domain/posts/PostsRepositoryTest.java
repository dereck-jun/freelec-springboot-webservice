package com.jojoldu.book.freelecspringbootwebservice.domain.posts;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class PostsRepositoryTest {
    
    /*
        1. 단위 테스트가 끝날 때마다 수행되는 메서드를 지정하는 어노테이션. 테스트 간 데이터 침범을 막기 위해 사용
        2. 테이블 posts에 insert/update 쿼리를 실행. id 값이 있으면 update, 없으면 insert 쿼리가 실행됨
        3. 테이블 posts에 있는 모든 데이터를 조회하는 메서드
     */

    @Autowired
    PostsRepository postsRepository;

    @AfterEach      // 1
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    void 게시글_저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(
                Posts.builder()
                        .title(title)
                        .content(content)
                        .author("tester@gmail.com")
                        .build()
        );      // 2

        // when
        List<Posts> postsList = postsRepository.findAll();      // 3

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(
                Posts.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                        .build()
        );

        //when
        List<Posts> posts = postsRepository.findAll();

        //then
        Posts findpost = posts.get(0);

        log.info(">>>>>>>>> createDate={}, modifiedDate={}", findpost.getCreatedDate(), findpost.getModifiedDate());

        assertThat(findpost.getCreatedDate()).isAfter(now);
        assertThat(findpost.getModifiedDate()).isAfter(now);
    }

}