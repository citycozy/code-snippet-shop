package com.sku.codesnippetshop.domain.customer.file.service;

import com.sku.codesnippetshop.domain.customer.brand.domain.Brand;
import com.sku.codesnippetshop.domain.customer.file.dao.FileRepository;
import com.sku.codesnippetshop.domain.customer.file.domain.FileData;
import com.sku.codesnippetshop.domain.customer.item.domain.Item;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@AllArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

//    public void uploadFileToFileSystem(MultipartFile file, Brand brand, Item item) throws IOException {
//
//
//        String FOLDER_PATH = System.getProperty("user.dir"); // System.getProperty("user.dir") 를 통해 현재 디렉토리 접근
//        FOLDER_PATH = FOLDER_PATH.concat("\\src\\main\\resources\\static\\images\\products\\");
//        String filePath = FOLDER_PATH + file.getOriginalFilename();
//        FileData fileData = fileRepository.save(
//                FileData.builder()
//                        .fileName(file.getOriginalFilename())
//                        .filePath(filePath)
//                        .item(item)
//                        .brand(brand)
//                        .build()
//        );
//        // 파일 경로
//        file.transferTo(new File(filePath));
//
//    }

    public void uploadFileToFileSystem(MultipartFile file, Brand brand, Item item) throws IOException {
        String FOLDER_PATH = "static/images/products/"; // 클래스패스 상의 경로를 사용합니다.
        String fileName = file.getOriginalFilename();
        String filePath = FOLDER_PATH + fileName;

        Resource resource = new ClassPathResource(filePath);

        FileData fileData = fileRepository.save(
                FileData.builder()
                        .fileName(file.getOriginalFilename())
                        .filePath(filePath)
                        .item(item)
                        .brand(brand)
                        .build()
        );
        // 파일 경로
        file.transferTo(new File(resource.getURI()));

    }
    public String getFilePathByItemId(Long itemId) {
        FileData fileData = fileRepository.findByItem_ItemId(itemId);

        return fileData != null ? fileData.getFilePath() : null;
    }

    @Transactional
    public void deleteItemByItemId(Long itemId) {
        final FileData file = fileRepository
                .findByItem_ItemId(itemId);

        fileRepository.delete(file);
    }
}
