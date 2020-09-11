package com.tistory.suhyeokeee.grade_cal.dto.member;

import com.tistory.suhyeokeee.grade_cal.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberSaveDto {

    private String name;
    private String userId;
    private String password;


    public Member toEntity(){
        return Member.builder()
                .name(name)
                .password(password)
                .userId(userId)
                .build();
    }
}
