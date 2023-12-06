package com.sku.codesnippetshop.domain.customer.review.domain;


import com.sku.codesnippetshop.domain.customer.member.domain.Member;
import com.sku.codesnippetshop.domain.customer.review.dto.ReviewCreateDTO;
import com.sku.codesnippetshop.domain.customer.review.dto.ReviewReadDTO;
import com.sku.codesnippetshop.domain.customer.review.dto.ReviewUpdateDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    @Column(name = "rating")
    private int rating;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    @CreatedDate
    private LocalDateTime regDt;

    @Column(name = "modify_date")
    @LastModifiedDate
    private LocalDateTime modDt;

    @Builder
    private Review(Member member, int rating, String content){
        this.member = member;
        this.rating = rating;
        this.content = content;
    }

    public void updateReview(ReviewUpdateDTO update) {
        this.rating = update.getRating();
        this.content = update.getContent();
    }

    public static ReviewReadDTO entityToDTO(Review review){
        return ReviewReadDTO.builder()
                .reviewId(review.getReviewId())
                .memberId(review.getMember().getMemberId())
                .rating(review.getRating())
                .content(review.getContent())
                .regDt(review.getRegDt())
                .modDt(review.getModDt())
                .build();
    }

    public static Review dtoToEntity(ReviewCreateDTO create, Member member){
        return Review.builder()
                .member(member)
                .rating(create.getRating())
                .content(create.getContent())
                .build();
    }

}
