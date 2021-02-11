package com.tistory.suhyeokeee.grade_cal.domain.post;

import com.tistory.suhyeokeee.grade_cal.domain.member.Member;
import com.tistory.suhyeokeee.grade_cal.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@DynamicInsert  // 조회수의 경우 null인 값은 insert하게 하지 않게
@NoArgsConstructor
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    @ColumnDefault("0")
    private int cnt;    // 조회수


    @Builder
    public Posts(String author, String title, String content){
        this.author=author;
        this.title = title;
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "MemberId")
    private Member member;

}
