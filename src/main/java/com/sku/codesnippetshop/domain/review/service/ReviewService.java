package com.sku.codesnippetshop.domain.review.service;

import com.sku.codesnippetshop.domain.member.dao.MemberRepository;
import com.sku.codesnippetshop.domain.member.domain.Member;
import com.sku.codesnippetshop.domain.review.domain.Review;
import com.sku.codesnippetshop.domain.review.dto.ReviewCreateDTO;
import com.sku.codesnippetshop.domain.review.dto.ReviewReadDTO;
import com.sku.codesnippetshop.domain.review.dto.ReviewUpdateDTO;
import com.sku.codesnippetshop.domain.review.dao.ReviewRepository;
import com.sku.codesnippetshop.domain.review.dto.ReviewCreateDTO;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;


    /* 리뷰 생성 서비스
    param : 생성 리뷰 info  */
    @Transactional
    public Review createReview(ReviewCreateDTO create) {
        final Member member = memberRepository.findById(create.getMemberId()).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final Review review = Review.dtoToEntity(create, member);
        reviewRepository.save(review);

        return review;
    }

    /* 리뷰 읽기 서비스
    param : 읽을 리뷰 아이디  */
    public ReviewReadDTO getReviewByReviewId(Long reviewId) {
        final Review review = reviewRepository
                .findById(reviewId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        return Review.entityToDTO(review);
    }

    /* 리뷰 정보 수정 서비스
    param : 수정 리뷰 아이디(pk), 수정 리뷰 정보 info */
    @Transactional
    public void updateReview(Long reviewId, ReviewUpdateDTO update){
        Review review = reviewRepository
                .findById(reviewId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        review.updateReview(update);
    }


    /* 리뷰 정보 삭제 서비스
    param : 삭제 리뷰 아이디(pk) */
    @Transactional
    public void deleteReviewByReviewId(Long reviewId) {
        final Review review = reviewRepository
                .findById(reviewId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        reviewRepository.deleteById(reviewId);
    }



}
