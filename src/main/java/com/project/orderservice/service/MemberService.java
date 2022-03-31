package com.project.orderservice.service;

import com.project.orderservice.domain.Address;
import com.project.orderservice.domain.Member;

public interface MemberService {

    /**
     * 멤버 객체 저장
     * @param address
     * @param memberName
     * @return Long: memberId
     */
    //TODO: parameter
    Long saveMember(Address address, String memberName);

    /**
     * id로 멤버 객체 찾기
     * @param memberId
     * @return Member: member
     */
    Member findMember(Long memberId);

}
