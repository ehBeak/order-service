package com.project.orderservice.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Embedded
    private Address address;

    private String name;

    //==생성 메서드==//
    public static Member createMember(Address address, String name) {

        Member createMember = new Member();
        createMember.address = address;
        createMember.name = name;

        return createMember;
    }
}
