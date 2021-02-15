package com.tistory.suhyeokeee.grade_cal.dto.posts;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import com.tistory.suhyeokeee.grade_cal.dto.member.MemberDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter // 20.09.10 dto 엔 getter가 꼭 있어야 한다. 아니면 model에 넘겨줬을때 값을 못읽어오는듯!!
public class PostsResponseDto {

    private String title;
    private String content;
    private int cnt;
    private LocalDateTime date;
    private MemberDto member;
    public PostsResponseDto(Posts entity){
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.date = entity.getModifiedDate();
        this.cnt = entity.getCnt();
        member = entity.getMember().toDto(member);

    }
}
