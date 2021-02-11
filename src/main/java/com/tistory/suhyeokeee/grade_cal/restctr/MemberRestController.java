package com.tistory.suhyeokeee.grade_cal.restctr;

import com.tistory.suhyeokeee.grade_cal.domain.member.Member;
import com.tistory.suhyeokeee.grade_cal.dto.member.MemberSaveDto;
import com.tistory.suhyeokeee.grade_cal.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("/member/signup")
    public Member signUp(@RequestBody MemberSaveDto dto){
        System.out.println(dto.getName());
        System.out.println(dto.getUserId());
        System.out.println(dto.getPassword());
        return memberService.save(dto);
    }
}
