package com.sku.codesnippetshop.domain.file.api;

import com.sku.codesnippetshop.domain.brand.service.BrandService;
import com.sku.codesnippetshop.domain.file.service.FileService;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseFormat<Long> createFile(@RequestPart("file") List<MultipartFile> fileList) {

        System.out.println("hello");
//
//        try{
//
//            fileService.uploadFileToFileSystem(file);
//            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
//        }catch(RuntimeException e){
//            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        return null;
    }


}
