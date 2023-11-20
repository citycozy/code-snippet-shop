package com.sku.codesnippetshop.domain.brand.dao;

import com.sku.codesnippetshop.domain.brand.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
