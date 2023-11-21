package com.sku.codesnippetshop.domain.orderdetail.dao;

import com.sku.codesnippetshop.domain.orderdetail.domain.OrderDetail;
import com.sku.codesnippetshop.domain.orderdetail.dto.OrderDetailReadDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrder_OrderId(Long orderId);
}
