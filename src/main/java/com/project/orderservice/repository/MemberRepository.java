package com.project.orderservice.repository;

import com.project.orderservice.domain.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * @implSpec  회원 객체 저장
     * @param member
     * @param <S>
     * @return <S extends Member> : 저장한 멤버 객체 반환
     */
    @Override
    <S extends Member> S save(S member);

    /**
     * @implSpec 회원 객체 ID로 조회
     * @param memberId
     * @return Optional<Member> : 해당 ID의 멤버 객체 반환
     */
    @Override
    Optional<Member> findById(Long memberId);

    /**
     * @implSpec 회원 전체 멤버 객체 반환
     * @param members
     * @param <S>
     * @return <S extends Member> List<S>: 전체 멤버 객체 반환
     */
    @Override
    <S extends Member> List<S> findAll(Example<S> members);
}