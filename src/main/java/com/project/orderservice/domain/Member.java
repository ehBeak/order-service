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

    //TODO: Member 생성자 고민
    private Member(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    protected Member() {
    }

    //==생성 메서드==//
    public static Member createMember(Address address, String name) {
        return new Member(address, name);
    }
}
