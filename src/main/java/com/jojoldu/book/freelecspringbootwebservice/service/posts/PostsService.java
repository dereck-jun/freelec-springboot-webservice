package com.jojoldu.book.freelecspringbootwebservice.service.posts;

import com.jojoldu.book.freelecspringbootwebservice.domain.posts.Posts;
import com.jojoldu.book.freelecspringbootwebservice.domain.posts.PostsRepository;
import com.jojoldu.book.freelecspringbootwebservice.web.dto.PostsListResponseDto;
import com.jojoldu.book.freelecspringbootwebservice.web.dto.PostsResponseDto;
import com.jojoldu.book.freelecspringbootwebservice.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.freelecspringbootwebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .stream()
                .map(PostsListResponseDto::new)
                .toList();
    }

    @Transactional
    public void delete(Long id) {
        Posts findPost = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(findPost);
    }
}
