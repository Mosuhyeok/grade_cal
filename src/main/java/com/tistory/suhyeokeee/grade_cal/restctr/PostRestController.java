package com.tistory.suhyeokeee.grade_cal.restctr;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import com.tistory.suhyeokeee.grade_cal.dto.posts.PostsSaveDto;
import com.tistory.suhyeokeee.grade_cal.service.post.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostRestController {

    private final PostsService postsService;

    @PostMapping("/postSave")
    public Posts save(@RequestBody PostsSaveDto dto){
        return postsService.save(dto);
    }

    //나중에 update delete 등 추가할때 SecurityConfig도 설정추가하기
}
