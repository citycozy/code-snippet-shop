package com.sku.codesnippetshop.domain.admin.filter.dao;

import com.sku.codesnippetshop.domain.admin.filter.domain.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Long> {
}
