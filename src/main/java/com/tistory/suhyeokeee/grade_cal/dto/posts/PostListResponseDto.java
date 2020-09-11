package com.tistory.suhyeokeee.grade_cal.dto.posts;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {

    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdDate;

    public PostListResponseDto(Posts entity){
        this.id = entity.getId();
        this.author = entity.getAuthor();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
    }

}
