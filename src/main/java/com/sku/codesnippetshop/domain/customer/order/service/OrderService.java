package com.sku.codesnippetshop.domain.customer.order.service;


import com.sku.codesnippetshop.domain.customer.member.dao.MemberRepository;
import com.sku.codesnippetshop.domain.customer.member.domain.Member;
import com.sku.codesnippetshop.domain.customer.order.dao.OrderRepository;
import com.sku.codesnippetshop.domain.customer.order.domain.Order;
import com.sku.codesnippetshop.domain.customer.order.dto.OrderCreateDTO;
import com.sku.codesnippetshop.domain.customer.order.dto.OrderReadDTO;
import com.sku.codesnippetshop.domain.customer.order.dto.OrderUpdateDTO;
import com.sku.codesnippetshop.domain.customer.orderDetail.dao.OrderDetailRepository;
import com.sku.codesnippetshop.domain.customer.orderDetail.domain.OrderDetail;
import com.sku.codesnippetshop.domain.customer.orderDetail.dto.OrderDetailReadDTO;
import com.sku.codesnippetshop.domain.customer.orderDetail.service.OrderDetailService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderDetailService orderDetailService;


    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final MemberRepository memberRepository;

    /* 주문 생성 서비스
    param : 생성 주문 info  */
    @Transactional
    public Long createOrder(OrderCreateDTO create) {

        final Member member = memberRepository.findById(create.getMemberId()).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final Order order = Order.dtoToEntity(create, member);
        orderRepository.save(order);
        System.out.println(order.getOrderId());
        return order.getOrderId();
    }

    /* 주문 + 주문 상세 읽기 서비스
    param : 읽을 주문 아이디  */
    public OrderReadDTO getOrderAndOrderDetailsByOrderId(Long orderId) {
        final Order order = orderRepository
                .findById(orderId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        final List<OrderDetail> orderDetails = orderDetailRepository.findByOrder_OrderId(orderId);

        List<OrderDetailReadDTO> orderDetailDTOs = orderDetails.stream()
                .map(OrderDetail::entityToDTO)
                .toList();

        return Order.entityToDTO(order, orderDetailDTOs);
    }


    /* 전체 주문 읽기 서비스
    param : 읽을 주문 아이디  */
    public List<OrderReadDTO> getAllOrder( ) {
        final List<Order> orderList = orderRepository
                .findAll();
        List<OrderReadDTO> orderReadDTOList = new ArrayList<>();
        for(Order order : orderList) {
            orderReadDTOList.add(Order.entityToDTO(order));
        }
        return orderReadDTOList;
    }


    /* 주문 정보 수정 서비스
    param : 수정 주문 아이디(pk), 수정 주문 정보 info */
    @Transactional
    public void updateOrder(Long orderId, OrderUpdateDTO update){
        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        order.updateOrder(update);
    }


    /* 주문 정보 삭제 서비스
    param : 삭제 주문 아이디(pk) */
    @Transactional
    public void deleteOrderByOrderId(Long orderId) {
        final Order order = orderRepository
                .findById(orderId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        orderRepository.deleteById(orderId);
    }

}
