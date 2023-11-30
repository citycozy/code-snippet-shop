package com.sku.codesnippetshop.domain.item.api;

import com.sku.codesnippetshop.domain.file.domain.FileData;
import com.sku.codesnippetshop.domain.file.service.FileService;
import com.sku.codesnippetshop.domain.item.domain.Item;
import com.sku.codesnippetshop.domain.item.dto.ItemReadDto;
import com.sku.codesnippetshop.domain.item.dto.ItemCreateDto;
import com.sku.codesnippetshop.domain.item.dto.ItemUpdateDto;
import com.sku.codesnippetshop.domain.item.service.ItemService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final FileService fileService;
    /* 제품 등록 컨트롤러
    param : 등록 제품 info */
    @PostMapping
    public ResponseFormat<Void> regItem(@RequestPart(value = "create") ItemCreateDto create , @RequestPart(value = "file") MultipartFile file) {
        try {
            Item item = itemService.regItem(create);
            fileService.uploadFileToFileSystem(file, null , item);


//            Long fileId = fileService.uploadFileToFileSystem(file);
//            Long enrolledGameId = gameService.createGame(create, fileId);
//            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_CREATE, enrolledGameId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* 제품 정보 조회 컨트롤러
    param : 조회 제품 itemId*/
    @GetMapping("/{itemId}")
    public ResponseFormat<ItemReadDto> getItemByItemId(@PathVariable(name = "itemId") Long itemId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, itemService.getItemByItemId(itemId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /* 제품 정보 수정 컨트롤러
    param : 수정 제품 itemId, 수정 제품 info */
    @PutMapping("/{itemId}")
    public ResponseFormat<Void> updateItemByItemId(@PathVariable(name = "itemId") Long itemId,
                                                   @RequestBody @Validated ItemUpdateDto update) {
        try {
            itemService.updateItem(itemId, update);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /* 제품 삭제 컨트롤러
    param : 삭제 제품 itemId */
    @DeleteMapping("/{itemId}")
    public ResponseFormat<Void> deleteItemByItemId(@PathVariable(name = "itemId") Long itemId) {
        try {
            itemService.deleteItemByItemId(itemId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
