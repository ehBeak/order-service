package com.project.orderservice.domain;

import com.project.orderservice.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "ORDERS")
@Getter
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Enumerated(EnumType.STRING)
    private Delivery deliveryStatus;

    private String name;
    private int quantity;
    private LocalDateTime orderDate;

    protected Order() {
    }

    private Order(Member member, Item item, Delivery deliveryStatus, String name, int quantity, LocalDateTime orderDate) {
        this.member = member;
        this.item = item;
        this.deliveryStatus = deliveryStatus;
        this.name = name;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    //==생성 메소드==//
    //TODO: 재고 체크나 변경로직 -> Order? OrderService?
    public static Order createOrder(Member member, Item item, int quantity) {
        return new Order(member, item, Delivery.ORDER, item.getName(), quantity, LocalDateTime.now());
    }


}
