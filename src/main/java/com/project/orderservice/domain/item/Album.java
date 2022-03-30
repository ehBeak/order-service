package com.project.orderservice.domain.item;

import com.project.orderservice.domain.item.Item;

import javax.persistence.Entity;

@Entity
public class Album extends Item {
    private String artist;
}
