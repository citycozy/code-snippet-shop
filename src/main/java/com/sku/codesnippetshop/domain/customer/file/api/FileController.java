package com.sku.codesnippetshop.domain.customer.file.api;

import com.sku.codesnippetshop.domain.customer.file.service.FileService;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/files")
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
