package com.sku.codesnippetshop.domain.Order.service;


import com.sku.codesnippetshop.domain.Order.dao.OrderRepository;
import com.sku.codesnippetshop.domain.Order.domain.Order;
import com.sku.codesnippetshop.domain.Order.dto.OrderCreateDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    /* 주문 생성 서비스
    param : 생성 주문 info  */
    @Transactional
    public void createOrder(OrderCreateDto create) {

    }


}
