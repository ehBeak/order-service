package com.project.orderservice.service.impl;

import com.project.orderservice.domain.Address;
import com.project.orderservice.domain.Member;
import com.project.orderservice.repository.MemberRepository;
import com.project.orderservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    public final MemberRepository memberRepository;

    // TODO: 서비스에서 받는 파라미터 고민
    @Override
    @Transactional
    public Long saveMember(Address address, String memberName) {
        Member member = Member.createMember(address, memberName);
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new NoSuchElementException(memberId + "를 가진 멤버가 존재하지 않습니다."));
    }

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
}
