package com.sku.codesnippetshop.domain.cart.service;

import com.sku.codesnippetshop.domain.cart.dao.CartRepository;
import com.sku.codesnippetshop.domain.cart.domain.Cart;
import com.sku.codesnippetshop.domain.cart.dto.CartCreateDto;
import com.sku.codesnippetshop.domain.cart.dto.CartReadDto;
import com.sku.codesnippetshop.domain.cart.dto.CartUpdateDTO;
import com.sku.codesnippetshop.domain.customer.item.dao.ItemRepository;
import com.sku.codesnippetshop.domain.customer.item.domain.Item;
import com.sku.codesnippetshop.domain.customer.member.dao.MemberRepository;
import com.sku.codesnippetshop.domain.customer.member.domain.Member;
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
public class CartService {

    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /* 장바구니 생성 서비스
    param : 생성 장바구니 info */
    @Transactional
    public void createCart(CartCreateDto create) {
        final Member member = memberRepository.findById(create.getMemberId())
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final Item item = itemRepository.findById(create.getItemId())
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final Cart cart = Cart.dtoToEntity(create, member, item);

        cartRepository.save(cart);
        System.out.println(cart.getCartId());
    }

    /* 장바구니 읽기 서비스
    param : 조회 장바구니 info */
    @Transactional
    public List<CartReadDto> getAllCart() {
        final List<Cart> cartList = cartRepository.findAll();
        List<CartReadDto> cartReadDtoList = new ArrayList<>();
        for (Cart cart : cartList) {
            cartReadDtoList.add(Cart.entityToDTO(cart));
        }
        return cartReadDtoList;
    }

    @Transactional
    public void updateCart(Long cartId, CartUpdateDTO update) {
        Cart cart = cartRepository
                .findById(cartId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        cart.updateCart(update);
    }

    @Transactional
    public void deleteCartByCartId(Long cartId) {
        final Cart cart = cartRepository
                .findById(cartId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        cartRepository.delete(cart);
    }
}
