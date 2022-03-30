package com.project.orderservice.domain;

import javax.persistence.Entity;

@Entity
public class Book extends Item {
    private String author;
    private int isbn;
}
