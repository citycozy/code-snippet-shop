package com.sku.codesnippetshop.domain.customer.orderDetail.service;

import com.sku.codesnippetshop.domain.customer.item.dao.ItemRepository;
import com.sku.codesnippetshop.domain.customer.item.domain.Item;
import com.sku.codesnippetshop.domain.customer.order.dao.OrderRepository;
import com.sku.codesnippetshop.domain.customer.order.domain.Order;
import com.sku.codesnippetshop.domain.customer.orderDetail.dao.OrderDetailRepository;
import com.sku.codesnippetshop.domain.customer.orderDetail.domain.OrderDetail;
import com.sku.codesnippetshop.domain.customer.orderDetail.dto.OrderDetailReadDTO;
import com.sku.codesnippetshop.domain.customer.orderDetail.dto.OrderDetailCreateDTO;
import com.sku.codesnippetshop.domain.customer.review.dao.ReviewRepository;
import com.sku.codesnippetshop.domain.customer.review.domain.Review;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public void createOrderDetail(OrderDetailCreateDTO create, Long orderId) {
        final Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final Item item = itemRepository.findById(create.getItemId()).orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final OrderDetail orderDetail = OrderDetail.dtoToEntity(create, order, item);
        orderDetailRepository.save(orderDetail);
    }

    /* 주문 상세 읽기 서비스
    param : 읽을 주문 상세 아이디  */
    public List<OrderDetailReadDTO> getOrderDetailListByOrderId(Long orderId) {
        return orderDetailRepository.findByOrder_OrderId(orderId)
                .stream()
                .map(OrderDetail::entityToDTO)
                .collect(Collectors.toList());
    }


    /* 주문한 제품의 작성 리뷰 저장 서비스
    param : 생성된 리뷰 Id */
    @Transactional
    public void updateOrderDetailByReview(Review review, Long orderDetailId) {
        final OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        orderDetail.updateReview(review);
        orderDetailRepository.save(orderDetail);
    }


//    /* 주문 정보 삭제 서비스
//    param : 삭제 주문 아이디(pk) */
//    @Transactional
//    public void deleteOrderDetailByOrderDetailId(Long orderDetailId) {
//        final OrderDetail orderDetail = orderDetailRepository
//                .findById(orderDetailId)
//                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
//        orderDetailRepository.deleteById(orderDetailId);
//    }


}
