package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    @NotNull
    private Long cartId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemId;

    @NotNull
    @Column(name = "quantity", columnDefinition = "default 1")
    private int quantity;

    @NotNull
    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdDate;

    @NotNull
    @Column(name = "modified_date")
    @UpdateTimestamp
    private Timestamp modifiedDate;

}
