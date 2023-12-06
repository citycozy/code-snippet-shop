package com.sku.codesnippetshop.domain.customer.item.dao;

import com.sku.codesnippetshop.domain.customer.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
