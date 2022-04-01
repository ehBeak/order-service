package com.project.orderservice.service;

import com.project.orderservice.domain.item.Item;

import java.util.List;

public interface ItemService {

    /**
     * @implSpec 상품 등록
     * @param name
     * @param price
     * @param quantity
     * @param author
     * @param isbn
     * @return Long
     */
    //TODO: 파라미터 고민
    Long saveItemBook(String name, int price, int quantity, String author, int isbn);

    /**
     * @implSpec 아이디로 상품 조회
     * @param itemId
     * @return Item
     */
    Item findItem(Long itemId);


    /**
     * @implSpec 모든 등록된 상품 조회
     * @return List<Item>
     */
    List<Item> findAllItems();

}
