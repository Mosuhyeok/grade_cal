package com.tistory.suhyeokeee.grade_cal.dto.posts;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // Application Runner 쓸 때 사용 할 것 배포시 삭제
public class PostsSaveDto {

    private String author;
    private String title;
    private String content;

    public Posts toEntity(){
        return Posts.builder()
                .author(author)
                .title(title)
                .content(content)
                .build();
    }
}
