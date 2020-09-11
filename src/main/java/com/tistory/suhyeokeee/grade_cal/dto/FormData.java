package com.tistory.suhyeokeee.grade_cal.dto;

import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FormData {
    private String grade;
    private String score;

    List<FormData>list = new ArrayList<>();

}
