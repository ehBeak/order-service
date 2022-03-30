package com.project.orderservice.domain.item;

import com.project.orderservice.domain.item.Item;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {
    private String director;
    private String actor;
}
