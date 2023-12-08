package com.sku.codesnippetshop.domain.admin.codeTable.dao;

import com.sku.codesnippetshop.domain.admin.codeTable.domain.CodeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeTableRepository extends JpaRepository<CodeTable, Long> {

    List<CodeTable> findByKey_KeyId(Long keyId);
}
