package com.project.orderservice.service.impl;

import com.project.orderservice.domain.item.Book;
import com.project.orderservice.domain.item.Item;
import com.project.orderservice.repository.ItemRepository;
import com.project.orderservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Long saveItemBook(String name, int price, int quantity, String author, int isbn) {
        Book newBook = new Book(name, price, quantity, author, isbn);
        itemRepository.save(newBook);
        return newBook.getId();
    }

    @Override
    public Item findItem(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow(() -> new NoSuchElementException(itemId + "라는 아이디를 가진 아이템이 존재하지않습니다."));
    }

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }
}
