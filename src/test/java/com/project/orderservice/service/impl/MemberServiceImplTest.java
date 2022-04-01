package com.project.orderservice.service.impl;

import com.project.orderservice.domain.Address;
import com.project.orderservice.domain.Member;
import com.project.orderservice.repository.MemberRepository;
import com.project.orderservice.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("회원 등록 -> 성공")
    void saveMember_O() {
        //given
        Address address1 = new Address("city1", "street1", 1111);
        Address address2 = new Address("city2", "street2", 2222);

        //when
        Long memberId1 = memberService.saveMember(address1, "member1");
        Long memberId2 = memberService.saveMember(address2, "member2");

        //then
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(2);

        Member savedMember1 = memberRepository.findById(memberId1).get();
        Member savedMember2 = memberRepository.findById(memberId2).get();
        assertThat(members).contains(savedMember1, savedMember2);


    }

    @Test
    @DisplayName("회원 등록 -> member.getId(), savedMember.getId()")
    void saveMember_returnId() {

        //given
        Address address1 = new Address("city1", "street1", 1111);

        //when
        Long memberId1 = memberService.saveMember(address1, "member1");//getId()
        Member member = memberRepository.findAll().get(0);// savedId()

        //then
        assertThat(memberId1).isEqualTo(member.getId());
    }

    @Test
    @DisplayName("회원 조회 -> 예외 발생")
    void saveMember_X() {

        //given

        //when

        //then
        assertThrows(NoSuchElementException.class, ()-> memberService.findMember(1L));

    }



    @Test
    @DisplayName("아이디로 멤버 조회")
    void findMember() {

        //given
        Address address = new Address("city1", "street1", 1111);
        Long memberId = memberService.saveMember(address, "member1");

        Address address2 = new Address("city2", "street2", 1112);
        Long memberId2 = memberService.saveMember(address2, "member2");


        //when
        Member member = memberService.findMember(memberId);
        Member member2 = memberService.findMember(memberId2);

        //then
        assertThat(memberId).isEqualTo(member.getId());
        assertThat(memberId2).isEqualTo(member2.getId());

    }

    @Test
    @DisplayName("모든 멤버 조회")
    void findAllMember() {

        //given
        Address address = new Address("city1", "street1", 1111);
        Long memberId = memberService.saveMember(address, "member1");

        Address address2 = new Address("city2", "street2", 1112);
        Long memberId2 = memberService.saveMember(address2, "member2");


        //when
        List<Member> allMembers = memberService.findAllMembers();

        //then
        Member member1 = memberRepository.findById(memberId).get();
        Member member2 = memberRepository.findById(memberId2).get();
        assertThat(allMembers).contains(member1, member2);

    }
}