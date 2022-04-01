package com.project.orderservice.service.impl;

import com.project.orderservice.domain.item.Item;
import com.project.orderservice.repository.ItemRepository;
import com.project.orderservice.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ItemServiceImplTest {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemService itemService;

    @Test
    @DisplayName("상품 등록 성공")
    void saveItemBook() {
        //given


        //when
        Long bookId1 = itemService.saveItemBook("hello", 10000, 100, "author", 1111);
        Long bookId2 = itemService.saveItemBook("hello2", 10000, 100, "author", 2222);

        //then
        List<Item> items = itemRepository.findAll();
        assertThat(items.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("아이디로 상품 조회 성공")
    void findItem_O() {
        //given
        Long bookId1 = itemService.saveItemBook("hello", 10000, 100, "author", 1111);
        Long bookId2 = itemService.saveItemBook("hello2", 10000, 100, "author", 2222);

        //when
        Item item1 = itemService.findItem(bookId1);
        Item item2 = itemService.findItem(bookId2);

        //then
        assertThat(item1.getId()).isEqualTo(bookId1);
        assertThat(item2.getId()).isEqualTo(bookId2);
    }

    @Test
    @DisplayName("아이디로 상품 조회 싪패_예외 발생")
    void findItem_X() {
        //given

        //when

        //then
        assertThrows(NoSuchElementException.class, () -> itemService.findItem(1L));
    }

    @Test
    @DisplayName("모든 상품 조회")
    void findAllItems() {
        //given
        Long bookId1 = itemService.saveItemBook("hello", 10000, 100, "author", 1111);
        Long bookId2 = itemService.saveItemBook("hello2", 10000, 100, "author", 2222);

        //when
        Item item1 = itemService.findItem(bookId1);
        Item item2 = itemService.findItem(bookId2);

        //then
        List<Item> allItems = itemService.findAllItems();
        assertThat(allItems.size()).isEqualTo(2);

        Item findItem1 = itemRepository.findById(bookId1).get();
        Item findItem2 = itemRepository.findById(bookId2).get();
        assertThat(allItems).contains(findItem1, findItem2);
    }
}