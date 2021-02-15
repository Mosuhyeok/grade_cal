package com.tistory.suhyeokeee.grade_cal.dto.posts;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostsSaveDto {

    private String title;
    private String content;

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .build();
    }
}
