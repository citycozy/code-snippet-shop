package com.sku.codesnippetshop.domain.customer.file.api;

import com.sku.codesnippetshop.domain.customer.file.service.FileService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("{itemId}")
    public ResponseEntity<String> getFilePath(@PathVariable(name = "itemId") Long itemId) {
        try {
            // 파일 경로 가져오기
            String filePath = fileService.getFilePathByItemId(itemId);

            // 파일 경로를 클라이언트에 반환
            return ResponseEntity.ok(filePath);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseFormat<Void> deleteFileByItemId(@PathVariable(name = "itemId") Long itemId) {
        try {
            fileService.deleteItemByItemId(itemId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
