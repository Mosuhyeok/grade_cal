package com.tistory.suhyeokeee.grade_cal.service.post;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import com.tistory.suhyeokeee.grade_cal.domain.post.PostsRepository;
import com.tistory.suhyeokeee.grade_cal.dto.posts.PostsResponseDto;
import com.tistory.suhyeokeee.grade_cal.dto.posts.PostsSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;


    @Transactional
    public Posts save(PostsSaveDto dto){
        return postsRepository.save(dto.toEntity());
    }

    @Transactional
    public List<Posts> findAll(){
        List<Posts> list = postsRepository.findAllByOrderByIdDesc();
        return list;
    }

    public PostsResponseDto findById(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()
                ->new IllegalArgumentException("해당 게시물이 없다 id = "+id));
        return new PostsResponseDto(posts);
    }
}
