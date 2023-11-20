package com.sku.codesnippetshop.domain.orderdetail.service;

import com.sku.codesnippetshop.domain.item.dao.ItemRepository;
import com.sku.codesnippetshop.domain.item.domain.Item;
import com.sku.codesnippetshop.domain.order.dao.OrderRepository;
import com.sku.codesnippetshop.domain.order.domain.Order;
import com.sku.codesnippetshop.domain.orderdetail.dao.OrderDetailRepository;
import com.sku.codesnippetshop.domain.orderdetail.domain.OrderDetail;
import com.sku.codesnippetshop.domain.orderdetail.dto.OrderDetailCreateDTO;
import com.sku.codesnippetshop.domain.orderdetail.dto.OrderDetailReadDTO;
import com.sku.codesnippetshop.entity.Review;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderDetailService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final ReviewRepository reviewRepository;
    private final OrderDetailRepository orderDetailRepository;

    /* 주문 상세 생성 서비스
    param : 생성 주문 상세 info  */
    @Transactional
    public void createOrderDetail(OrderDetailCreateDTO create) {
        final Order order = orderRepository.findById(create.getOrderId()).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final Item item = itemRepository.findById(create.getItemId()).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final Review review = reviewRepository.findById(create.getReviewId()).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final OrderDetail orderDetail = OrderDetail.dtoToEntity(create, order, item, review);
        orderDetailRepository.save(orderDetail);
    }

    /* 주문 상세 읽기 서비스
    param : 읽을 주문 상세 아이디  */
    public OrderDetailReadDTO getOrderDetailByOrderDetailId(Long orderDetialId) {

        final OrderDetail orderDetail = orderDetailRepository
                .findById(orderDetialId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        return OrderDetail.entityToDTO(orderDetail);
    }

    /* 주문 정보 삭제 서비스
    param : 삭제 주문 아이디(pk) */
    @Transactional
    public void deleteOrderDetailByOrderDetailId(Long orderDetailId) {
        final OrderDetail orderDetail = orderDetailRepository
                .findById(orderDetailId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        orderDetailRepository.deleteById(orderDetailId);
    }


}
