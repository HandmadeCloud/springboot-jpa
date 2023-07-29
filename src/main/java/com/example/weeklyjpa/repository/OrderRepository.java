package com.example.weeklyjpa.repository;

import com.example.weeklyjpa.domain.order.Order;
import com.example.weeklyjpa.domain.order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);

    @Query("SELECT o FROM Order AS o WHERE o.memo LIKE  %?1%")
    Optional<Order> findByMemo(String memo);
}