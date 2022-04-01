package com.project.orderservice.repository;

import com.project.orderservice.domain.item.Item;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * @implSpec 아이템 객체 조회
     * @param item
     * @param <S>
     * @return <S extends Item> S
     */
    @Override
    <S extends Item> S save(S item);


    /**
     * @implSpec 아이디로 아이템 조회
     * @param itemId
     * @return Optional<Item>
     */
    @Override
    Optional<Item> findById(Long itemId);

    /**
     * @implSpec 아이템 전체 조회
     * @return List<Item>
     */
    @Override
    List<Item> findAll();
}
