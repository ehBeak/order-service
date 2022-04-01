package com.project.orderservice.domain.item;

import com.project.orderservice.domain.item.Item;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Book extends Item {
    private String author;
    private int isbn;

    protected Book() {
    }

    //TODO: 상속관계의 경우 생성자, 정적 메소드
    //TODO: 상속관계에서 생성자 구현 방법(이펙티브 자바)
    public Book (String name, int price, int quantity, String author, int isbn) {
        super(name, price, quantity);
        this.author = author;
        this.isbn = isbn;
    }
}
