package com.sku.codesnippetshop.domain.orderdetail.dao;

import com.sku.codesnippetshop.domain.orderdetail.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
