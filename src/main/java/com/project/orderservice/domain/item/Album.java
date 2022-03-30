package com.project.orderservice.domain.item;

import com.project.orderservice.domain.item.Item;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Album extends Item {
    private String artist;
}
