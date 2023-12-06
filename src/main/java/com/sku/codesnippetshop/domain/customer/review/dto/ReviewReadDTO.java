package com.sku.codesnippetshop.domain.customer.review.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewReadDTO {
    private Long reviewId;
    private Long memberId;
    private int rating;
    private String content;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
