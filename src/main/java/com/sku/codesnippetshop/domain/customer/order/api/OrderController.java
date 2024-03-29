package com.sku.codesnippetshop.domain.customer.order.api;

import com.sku.codesnippetshop.domain.customer.order.service.OrderService;
import com.sku.codesnippetshop.domain.customer.order.dto.OrderCreateDTO;
import com.sku.codesnippetshop.domain.customer.order.dto.OrderReadDTO;
import com.sku.codesnippetshop.domain.customer.order.dto.OrderUpdateDTO;
import com.sku.codesnippetshop.domain.customer.orderDetail.dto.OrderDetailCreateDTO;
import com.sku.codesnippetshop.domain.customer.orderDetail.service.OrderDetailService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    /* 주문 정보 등록 컨트롤러
    param : 등록 주문 정보 info */
    @PostMapping
    public ResponseFormat<Void> regItem(@RequestBody OrderCreateDTO create) {
        try {
            Long orderId = orderService.createOrder(create);
            for(OrderDetailCreateDTO orderDetail : create.getOrderDetails()) {
                orderDetailService.createOrderDetail(orderDetail, orderId);
            }
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /* 주문 + 주문 상세 정보 조회 컨트롤러
    param : 조회 주문 orderId*/
    @GetMapping("/{orderId}")
    public ResponseFormat<OrderReadDTO> getOrderByOrderId(@PathVariable(name = "orderId") Long orderId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, orderService.getOrderAndOrderDetailsByOrderId(orderId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }



    /* 주문 정보 전체 조회 컨트롤러
    param : 조회 주문 orderId*/
    @GetMapping("")
    public ResponseFormat<List<OrderReadDTO>> getAllOrder() {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, orderService.getAllOrder());
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }


    /* 주문 정보 수정 컨트롤러
    param : 수정 주문 orderId, 수정 주문 정보 info */
    @PutMapping("/{orderId}")
    public ResponseFormat<Void> updateOrderByOrderId(@PathVariable(name = "orderId") Long orderId,
                                                   @RequestBody OrderUpdateDTO update) {
        try {
            orderService.updateOrder(orderId, update);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /* 주문 삭제 컨트롤러
    param : 삭제 주문 orderId */
    @DeleteMapping("/{orderId}")
    public ResponseFormat<Void> deleteOrderByOrderId(@PathVariable(name = "orderId") Long orderId) {
        try {
            orderService.deleteOrderByOrderId(orderId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

}
