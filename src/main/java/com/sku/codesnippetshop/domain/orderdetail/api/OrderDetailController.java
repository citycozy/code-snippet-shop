package com.sku.codesnippetshop.domain.orderdetail.api;

import com.sku.codesnippetshop.domain.orderdetail.dto.OrderDetailReadDTO;
import com.sku.codesnippetshop.domain.orderdetail.service.OrderDetailService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
@RequiredArgsConstructor
public class OrderDetailController {
    private OrderDetailService orderDetailService;

    /* 주문 상세 조회 컨트롤러
    param : 조회 주문 상세 orderId*/
    @GetMapping("/{orderId}")
    public ResponseFormat<List<OrderDetailReadDTO>> getOrderByOrderId(@PathVariable(name = "orderId") Long orderId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, orderDetailService.getOrderDetailListByOrderId(orderId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
