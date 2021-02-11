package com.tistory.suhyeokeee.grade_cal.service.member;

import com.tistory.suhyeokeee.grade_cal.domain.member.Member;
import com.tistory.suhyeokeee.grade_cal.domain.member.MemberRepository;
import com.tistory.suhyeokeee.grade_cal.domain.member.Role;
import com.tistory.suhyeokeee.grade_cal.dto.member.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private final MemberRepository memberRepository;


    @Transactional
    public Member save(MemberSaveDto dto){
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        dto.setRole(Role.MEMBER);
        return memberRepository.save(dto.toEntity());
    }
}
