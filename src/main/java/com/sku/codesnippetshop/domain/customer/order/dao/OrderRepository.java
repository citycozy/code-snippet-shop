package com.sku.codesnippetshop.domain.customer.order.dao;

import com.sku.codesnippetshop.domain.customer.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
