package com.sku.codesnippetshop.domain.customer.orderDetail.dao;

import com.sku.codesnippetshop.domain.customer.orderDetail.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrder_OrderId(Long orderId);
}
