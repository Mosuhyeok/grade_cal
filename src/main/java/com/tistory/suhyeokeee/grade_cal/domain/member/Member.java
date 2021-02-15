package com.tistory.suhyeokeee.grade_cal.domain.member;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import com.tistory.suhyeokeee.grade_cal.dto.member.MemberDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;


    //DB는 RoleType이라는 내가 만든 자바 오브젝트가 없으니 알아먹게 어노테이션을 붙여줘야함
    @Enumerated(EnumType.STRING)
    private Role role;


    @Builder
    public Member(String name, String username, String password, Role role){
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Posts> posts;

    public MemberDto toDto(MemberDto dto){
       return  dto.builder()
                .name(this.name)
                .password(this.password)
                .role(this.role)
                .userId(this.username)
                .build();
    }
}
