package com.tistory.suhyeokeee.grade_cal;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import com.tistory.suhyeokeee.grade_cal.domain.post.PostsRepository;
import com.tistory.suhyeokeee.grade_cal.dto.posts.PostsResponseDto;
import com.tistory.suhyeokeee.grade_cal.dto.posts.PostsSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    PostsRepository postsRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        PostsSaveDto dto = new PostsSaveDto();
        dto.setAuthor("모수혁");
        dto.setTitle("제목 1번");
        dto.setContent("본문입니다 나앙ㄴ란ㅇ랑ㄴ");
        postsRepository.save(dto.toEntity());
    }
}
