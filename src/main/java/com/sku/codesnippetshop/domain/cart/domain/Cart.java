package com.sku.codesnippetshop.domain.cart.domain;

import com.sku.codesnippetshop.domain.cart.dto.CartCreateDto;
import com.sku.codesnippetshop.domain.cart.dto.CartReadDto;
import com.sku.codesnippetshop.domain.cart.dto.CartUpdateDTO;
import com.sku.codesnippetshop.domain.member.domain.Member;
import com.sku.codesnippetshop.domain.item.domain.Item;
import com.sku.codesnippetshop.domain.order.dto.OrderUpdateDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    private Cart(Member member, Item item, int quantity) {
        this.member = member;
        this.item = item;
        this.quantity = 1;
    }

    public static Cart dtoToEntity(CartCreateDto create, Member member, Item item) {
        return Cart.builder()
                .member(member)
                .item(item)
                .quantity(create.getQuantity())
                .build();
    }

    public static CartReadDto entityToDTO(Cart cart) {
        return CartReadDto.builder()
                .memberId(cart.getMember().getMemberId())
                .itemId(cart.getItem().getItemId())
                .quantity(cart.getQuantity())
                .regDt(cart.getCreatedDate())
                .modDt(cart.getModifiedDate())
                .build();
    }

    public void updateCart(CartUpdateDTO update) {
        this.quantity = update.getQuantity();
    }
}
