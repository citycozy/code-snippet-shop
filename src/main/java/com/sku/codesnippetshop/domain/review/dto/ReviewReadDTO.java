package com.sku.codesnippetshop.domain.review.dto;

import com.sku.codesnippetshop.domain.member.domain.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
