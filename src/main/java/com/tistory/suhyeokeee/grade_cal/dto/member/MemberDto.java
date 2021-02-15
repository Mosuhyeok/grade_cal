package com.tistory.suhyeokeee.grade_cal.dto.member;

import com.tistory.suhyeokeee.grade_cal.domain.member.Member;
import com.tistory.suhyeokeee.grade_cal.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDto {

    // 궁금한게 어차피 view 페이지에서 필요한 Member는 userId만 필요한데 굳이 name,userId,
    // password, role 다 필요할까? 그냥 userId만 있는 클래스 dto 파일은 별로인가...?


    private String name;
    private String userId;
    private String password;
    private Role role;

    @Builder
    public MemberDto(String name, String userId, String password, Role role){
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

}
