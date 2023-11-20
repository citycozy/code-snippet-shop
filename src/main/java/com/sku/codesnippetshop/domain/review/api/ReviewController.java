package com.sku.codesnippetshop.domain.review.api;

import com.sku.codesnippetshop.domain.review.dto.ReviewCreateDTO;
import com.sku.codesnippetshop.domain.review.dto.ReviewReadDTO;
import com.sku.codesnippetshop.domain.review.dto.ReviewUpdateDTO;
import com.sku.codesnippetshop.domain.review.service.ReviewService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    /* 리뷰 정보 등록 컨트롤러
    param : 등록 리뷰 정보 info */
    @PostMapping
    public ResponseFormat<Void> regItem(@RequestBody ReviewCreateDTO create) {
        try {
            reviewService.createReview(create);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /* 리뷰 정보 조회 컨트롤러
    param : 조회 리뷰 reviewId*/
    @GetMapping("/{reviewId}")
    public ResponseFormat<ReviewReadDTO> getReviewByReviewId(@PathVariable(name = "reviewId") Long reviewId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, reviewService.getReviewByReviewId(reviewId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }


    /* 리뷰 정보 수정 컨트롤러
    param : 수정 리뷰 reviewId, 수정 리뷰 정보 info */
    @PutMapping("/{reviewId}")
    public ResponseFormat<Void> updateReviewByReviewId(@PathVariable(name = "reviewId") Long reviewId,
                                                     @RequestBody ReviewUpdateDTO update) {
        try {
            reviewService.updateReview(reviewId, update);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /* 리뷰 삭제 컨트롤러
    param : 삭제 리뷰 reviewId */
    @DeleteMapping("/{reviewId}")
    public ResponseFormat<Void> deleteReviewByReviewId(@PathVariable(name = "reviewId") Long reviewId) {
        try {
            reviewService.deleteReviewByReviewId(reviewId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
