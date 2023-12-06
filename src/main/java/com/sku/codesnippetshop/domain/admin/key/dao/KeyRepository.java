package com.sku.codesnippetshop.domain.admin.key.dao;

import com.sku.codesnippetshop.domain.admin.key.domain.Key;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KeyRepository extends JpaRepository<Key, Long> {
}
