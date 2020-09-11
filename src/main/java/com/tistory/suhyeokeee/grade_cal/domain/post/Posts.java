package com.tistory.suhyeokeee.grade_cal.domain.post;

import com.tistory.suhyeokeee.grade_cal.jpaconfig.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Builder
    public Posts(String author, String title, String content){
        this.author=author;
        this.title = title;
        this.content = content;
    }

}
