package com.project.orderservice.domain.item;

import com.project.orderservice.domain.Order;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Getter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    @OneToMany(mappedBy = "item")
    private List<Order> orders = new ArrayList<>();

    private String name;
    private int quantity;
    private int price;

    public Item() {
    }

    protected Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //==비지니스 로직==//
    // 재고 확인
    public boolean checkQuantity(int quantity) {
        int surplus = this.getQuantity() - quantity;
        if (surplus < 0) return false;
        else return true;
    }

    // 재고 빼기
    public void subQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
