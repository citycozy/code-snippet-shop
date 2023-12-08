package com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.dao;

import com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.domain.SCMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SCMapRepository extends JpaRepository<SCMap, Long> {
}
