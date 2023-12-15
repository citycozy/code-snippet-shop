package com.sku.codesnippetshop.domain.admin.logFormat.dao;

import com.sku.codesnippetshop.domain.admin.logFormat.domain.LogFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogFormatRepository extends JpaRepository<LogFormat, Long> {
}
