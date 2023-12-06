package com.sku.codesnippetshop.domain.customer.brand.dao;

import com.sku.codesnippetshop.domain.customer.brand.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
