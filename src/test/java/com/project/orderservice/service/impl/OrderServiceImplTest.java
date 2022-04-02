package com.project.orderservice.service.impl;

import com.project.orderservice.domain.Address;
import com.project.orderservice.domain.Member;
import com.project.orderservice.domain.Order;
import com.project.orderservice.domain.item.Book;
import com.project.orderservice.domain.item.Item;
import com.project.orderservice.repository.ItemRepository;
import com.project.orderservice.repository.MemberRepository;
import com.project.orderservice.repository.OrderRepository;
import com.project.orderservice.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class OrderServiceImplTest {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("주문 등록 성공")
    void saveOrder_O() {
        //given
        Member member = Member.createMember(new Address("city", "street", 1111), "member1");
        Book book = new Book("book", 1000, 10, "kim", 1234);

        Member savedMember = memberRepository.save(member);
        Book savedBook = itemRepository.save(book);

        //when
        Long orderId = orderService.saveOrder(savedMember, savedBook, 2);

        //then
        Order findOrder = orderRepository.findById(orderId).get();

        assertThat(orderId).isEqualTo(findOrder.getId());
        assertThat(savedBook).isEqualTo(findOrder.getItem());
        assertThat(savedMember).isEqualTo(findOrder.getMember());
        assertThat(savedBook.getQuantity()).isEqualTo(8);
    }

    @Test
    @DisplayName("주문 등록 재고 수량 부족_예외 발생")
    void saveOrder_X() {
        //given
        Member member = Member.createMember(new Address("city", "street", 1111), "member1");
        Book book = new Book("book", 1000, 10, "kim", 1234);

        Member savedMember = memberRepository.save(member);
        Book savedBook = itemRepository.save(book);
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> orderService.saveOrder(savedMember, savedBook, 100));
    }


    @Test
    void findOrder() {
    }

    @Test
    void findAllOrders() {
    }
}