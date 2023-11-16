package com.sku.codesnippetshop.domain.Brand.dao;

import com.sku.codesnippetshop.domain.Brand.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
