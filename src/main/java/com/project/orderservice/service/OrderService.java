package com.project.orderservice.service;

import com.project.orderservice.domain.Member;
import com.project.orderservice.domain.Order;
import com.project.orderservice.domain.item.Item;

import java.util.List;

public interface OrderService {

    /**
     * @param member
     * @param item
     * @return Long: OrderId
     * @implSpec 주문 저장
     */
    Long saveOrder(Member member, Item item, int quantity);

    /**
     * @param orderId
     * @return Item
     * @implSpec 주문 아이디로 주문 조회
     */
    Order findOrder(Long orderId);

    /**
     * @return List<Order>
     * @implSpec 모든 주문 조회
     */
    List<Order> findAllOrders();
}
