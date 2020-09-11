package com.tistory.suhyeokeee.grade_cal.service;

import com.tistory.suhyeokeee.grade_cal.dto.FormData;
import com.tistory.suhyeokeee.grade_cal.dto.ResultData;
import com.tistory.suhyeokeee.grade_cal.dto.SecondData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService {


    public ResultData save(List<FormData>list){
        ResultData resultData = new ResultData();
        float totalGrade=0;
        int totalScore=0;

        List<Float>calGrade = new ArrayList<>();
        List<Integer>calScore = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            calGrade.add(Float.parseFloat(list.get(i).getGrade()));
            calScore.add(Integer.parseInt(list.get(i).getScore()));
        }
        for(int i=0; i<calScore.size();i++){
            totalScore+=calScore.get(i);
        }

        for(int i=0; i<calGrade.size(); i++){
            totalGrade+= calGrade.get(i) * calScore.get(i);
        }

        totalGrade/=totalScore;
        resultData.setTotalGrade(String.format("%.2f",totalGrade));
        resultData.setTotalScore(totalScore);

        return resultData;
    }

    public String secondCal(SecondData secondData){
        // grade = 학점평균 score 수강학점
        float allGrade = Float.parseFloat(secondData.getAllGrade());
        float nowGrade = Float.parseFloat(secondData.getNowGrade());
        int allScore = Integer.parseInt(secondData.getAllScore());
        int nowScore = Integer.parseInt(secondData.getNowScore());
        int totalScore = allScore+nowScore; //최종 수강학점
        float totalSum = allGrade*allScore; // 여태까지 들은 학점+평균 점수
        float tmp = 0.0f;
        String ans ="";

        while(true){
            float tmpNowScore = nowScore*tmp;
            if((totalSum+tmpNowScore)/ totalScore >= nowGrade){
                if(tmp>=4.52f){
                    ans="불가능";
                }
                else{
                    if(tmp>=4.51f){
                        tmp=4.5f;
                    }
                    ans=String.format("%.2f",tmp);
                }
                break;
            }
            tmp+=0.01;
        }
        return ans;
    }

}
