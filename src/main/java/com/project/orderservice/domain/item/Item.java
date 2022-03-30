package com.project.orderservice.domain.item;

import com.project.orderservice.domain.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    @OneToMany(mappedBy = "item")
    private List<Order> orders = new ArrayList<>();

    private String name;
    private int quantity;
    private String author;
    private int isbn;

}
