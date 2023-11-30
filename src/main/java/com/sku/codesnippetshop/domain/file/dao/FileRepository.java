package com.sku.codesnippetshop.domain.file.dao;


import com.sku.codesnippetshop.domain.file.domain.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileData, Long> {
    Optional<FileData> findByFileName(String fileName);
    Optional<FileData> findByFilePath(String filePath);
}
