package com.sku.codesnippetshop.domain.order.service;


import com.sku.codesnippetshop.domain.member.dao.MemberRepository;
import com.sku.codesnippetshop.domain.member.domain.Member;
import com.sku.codesnippetshop.domain.order.dao.OrderRepository;
import com.sku.codesnippetshop.domain.order.domain.Order;
import com.sku.codesnippetshop.domain.order.dto.OrderCreateDTO;
import com.sku.codesnippetshop.domain.order.dto.OrderReadDTO;
import com.sku.codesnippetshop.domain.order.dto.OrderUpdateDTO;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    /* 주문 생성 서비스
    param : 생성 주문 info  */
    @Transactional
    public void createOrder(OrderCreateDTO create) {
        System.out.println(create.getMemberId());
        final Member member = memberRepository.findById(create.getMemberId()).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final Order order = Order.dtoToEntity(create, member);
        orderRepository.save(order);
    }

    /* 주문 읽기 서비스
    param : 읽을 주문 아이디  */
    public OrderReadDTO getOrderByOrderId(Long orderId) {
        final Order order = orderRepository
                .findById(orderId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        return Order.entityToDTO(order);
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
