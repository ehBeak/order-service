package com.project.orderservice.repository;

import com.project.orderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * @param entity
     * @param <S>
     * @return <S extends Order> S
     * @implSpec 주문 등록
     */
    @Override
    <S extends Order> S save(S entity);

    /**
     * @param aLong
     * @return Optional<Order>
     * @implSpec 아이디로 주문 조회
     */
    @Override
    Optional<Order> findById(Long aLong);

    /**
     * @return List<Order>
     * @implSpec 전체 주문 상품 조회
     */
    @Override
    List<Order> findAll();
}
