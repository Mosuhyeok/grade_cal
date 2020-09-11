package com.tistory.suhyeokeee.grade_cal.dto.posts;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter // 20.09.10 dto 엔 getter가 꼭 있어야 한다. 아니면 model에 넘겨줬을때 값을 못읽어오는듯!!
public class PostsResponseDto {

    private String title;
    private String author;
    private String content;
    private LocalDateTime date;

    public PostsResponseDto(Posts entity){
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.date = entity.getModifiedDate();
    }

}
