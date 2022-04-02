package com.project.orderservice.service.impl;

import com.project.orderservice.domain.Member;
import com.project.orderservice.domain.Order;
import com.project.orderservice.domain.item.Item;
import com.project.orderservice.repository.OrderRepository;
import com.project.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Long saveOrder(Member member, Item item, int quantity) {
        if (item.checkQuantity(quantity)) {
            item.subQuantity(quantity);
            Order order = orderRepository.save(Order.createOrder(member, item, quantity));
            return order.getId();
        }else {
            throw new IllegalArgumentException("재고 수량이 부족합니다.");
        }
    }

    @Override
    public Order findOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new NoSuchElementException(orderId + "의 아이디를 가진 주문이 존재하지 않습니다."));
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}
