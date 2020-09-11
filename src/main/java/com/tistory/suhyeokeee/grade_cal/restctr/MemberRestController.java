package com.tistory.suhyeokeee.grade_cal.restctr;

import com.tistory.suhyeokeee.grade_cal.domain.member.Member;
import com.tistory.suhyeokeee.grade_cal.dto.member.MemberSaveDto;
import com.tistory.suhyeokeee.grade_cal.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("/member/signup")
    public Member signUp(@RequestBody MemberSaveDto dto){
        return memberService.save(dto);
    }
}
