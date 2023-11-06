package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class InOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inout_id")
    @NotNull
    private Long inOutId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemId;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @NotNull
    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp createDate;

}
