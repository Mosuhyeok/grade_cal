package com.tistory.suhyeokeee.grade_cal.ctr;

import com.tistory.suhyeokeee.grade_cal.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {



    // 주로 단순한 페이지 이동만을 다루는 controller


    private final  IndexService indexService;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/firstFunc")
    public String grade_cal(){
        return "firstFunc";
    }

    @GetMapping("/secondFunc")
    public String secondFunc(){
        return "secondFunc";
    }

    @GetMapping("/gradeExplain")
    public String gradeExplain(){
        return "gradeExplain";
    }




}
