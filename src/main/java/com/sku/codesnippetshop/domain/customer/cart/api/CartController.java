package com.sku.codesnippetshop.domain.customer.cart.api;

import com.sku.codesnippetshop.domain.customer.cart.dto.CartCreateDto;
import com.sku.codesnippetshop.domain.customer.cart.dto.CartReadDto;
import com.sku.codesnippetshop.domain.customer.cart.dto.CartUpdateDTO;
import com.sku.codesnippetshop.domain.customer.cart.service.CartService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    /* 장바구니 정보 등록 컨트롤러
    param : 등록 장바구니 정보 info */
    @PostMapping
    public ResponseFormat<Void> regCart(@RequestBody CartCreateDto create) {
        try {
            cartService.createCart(create);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_CREATE);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /* 장바구니 정보 전체 조회 컨트롤러
    param : 조회 장바구니 cartId*/
    @GetMapping
    public ResponseFormat<List<CartReadDto>> GetAllCart() {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, cartService.getAllCart());
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /* 장바구니 정보 수정 컨트롤러
   param : 수정 장바구니 cartId, 수정 장바구니 정보 info */
    @PutMapping("/{cartId}")
    public ResponseFormat<Void> updateCartByCartId(@PathVariable(name = "cartId") Long cartId,
                                                   @RequestBody CartUpdateDTO update) {
        try {
            cartService.updateCart(cartId, update);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    @DeleteMapping("/{cartId}")
    public ResponseFormat<Void> deleteCartByCartId(@PathVariable(name = "cartId") Long cartId) {
        try {
            cartService.deleteCartByCartId(cartId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}