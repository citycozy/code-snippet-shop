package com.sku.codesnippetshop.domain.admin.logFormat.dao;

import com.sku.codesnippetshop.domain.admin.logFormat.domain.LogFormat;
import com.sku.codesnippetshop.domain.admin.logFormat.domain.LogFormatKeyMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogFormatKeyMapRepository extends JpaRepository<LogFormatKeyMap, Long> {
    public void deleteByLogFormat_Id(Long logFormatId);
    public List<LogFormatKeyMap> findByLogFormat_Id (Long logFormatId);
}
