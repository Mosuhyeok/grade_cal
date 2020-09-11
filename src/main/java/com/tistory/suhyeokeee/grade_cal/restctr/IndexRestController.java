package com.tistory.suhyeokeee.grade_cal.restctr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tistory.suhyeokeee.grade_cal.dto.FormData;
import com.tistory.suhyeokeee.grade_cal.dto.ResultData;
import com.tistory.suhyeokeee.grade_cal.dto.SecondData;
import com.tistory.suhyeokeee.grade_cal.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IndexRestController {

    private final  IndexService indexService;


    @PostMapping("/result")
    public String result (@RequestBody List<FormData> list) throws JsonProcessingException {
        ResultData resultData = indexService.save(list);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(resultData);
        return json;
    }

    @PostMapping("/secondResult")
    public String secondResult(@RequestBody SecondData secondData){
        String str = indexService.secondCal(secondData);
        return str;
    }


}
