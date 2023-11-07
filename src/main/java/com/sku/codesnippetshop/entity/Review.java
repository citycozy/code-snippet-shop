package com.sku.codesnippetshop.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    @NotNull
    private Long reviewId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
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
    @CreatedDate
    private LocalDateTime createDate;

    @NotNull
    @Column(name = "modify_date")
    @LastModifiedDate
    private LocalDateTime modifyDate;
}
