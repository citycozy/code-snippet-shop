package com.sku.codesnippetshop.domain.customer.review.dao;

import com.sku.codesnippetshop.domain.customer.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
