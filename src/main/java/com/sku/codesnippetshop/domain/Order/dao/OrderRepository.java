package com.sku.codesnippetshop.domain.Order.dao;

import com.sku.codesnippetshop.domain.Order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
