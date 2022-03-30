package com.project.orderservice.domain.item;

import com.project.orderservice.domain.item.Item;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Movie extends Item {
    private String director;
    private String actor;
}
