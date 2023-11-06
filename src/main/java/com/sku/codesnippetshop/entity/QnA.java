package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QnA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_id")
    @NotNull
    private long qndId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;

    @NotNull
    @Column(name = "category",length = 20, columnDefinition = "default 'Q'")
    private String category;

    @NotNull
    @Column(name = "status", columnDefinition = "default '답변을 기다리는 중'")
    private String status;


}
