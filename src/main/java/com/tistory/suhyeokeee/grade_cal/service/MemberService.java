package com.tistory.suhyeokeee.grade_cal.service;

import com.tistory.suhyeokeee.grade_cal.domain.member.Member;
import com.tistory.suhyeokeee.grade_cal.domain.member.MemberRepository;
import com.tistory.suhyeokeee.grade_cal.dto.member.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(MemberSaveDto dto){
        return memberRepository.save(dto.toEntity());
    }
}
