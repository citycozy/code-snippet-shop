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
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    @NotNull
    private Long reviewId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;

    @NotNull
    @Column(name = "rating")
    private int rating;

    @NotNull
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp createDate;

    @NotNull
    @Column(name = "modify_date")
    @UpdateTimestamp
    private Timestamp modifyDate;
}
