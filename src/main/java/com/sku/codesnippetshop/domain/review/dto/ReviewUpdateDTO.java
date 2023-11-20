package com.sku.codesnippetshop.domain.review.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewUpdateDTO {

    private int rating;
    private String content;
}
