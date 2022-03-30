package com.project.orderservice.domain.item;

import com.project.orderservice.domain.item.Item;

import javax.persistence.Entity;

@Entity
public class Book extends Item {
    private String author;
    private int isbn;
}
