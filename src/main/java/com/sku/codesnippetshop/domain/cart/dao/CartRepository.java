package com.sku.codesnippetshop.domain.cart.dao;

import com.sku.codesnippetshop.domain.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
