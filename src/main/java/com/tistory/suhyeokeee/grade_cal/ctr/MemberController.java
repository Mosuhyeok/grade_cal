package com.tistory.suhyeokeee.grade_cal.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//회원가입/로그인 관련된 로직에 관련된 컨트롤러

@Controller
public class MemberController {

    @GetMapping("/member/signup")
    public String signUp(){
        return "member/signUp";
    }
}
