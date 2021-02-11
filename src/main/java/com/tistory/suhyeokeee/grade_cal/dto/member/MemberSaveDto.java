package com.tistory.suhyeokeee.grade_cal.dto.member;

import com.tistory.suhyeokeee.grade_cal.domain.member.Member;
import com.tistory.suhyeokeee.grade_cal.domain.member.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSaveDto {

    private String name;
    private String userId;
    private String password;
    private Role role;

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .password(password)
                .username(userId)
                .role(role)
                .build();
    }
}
