package com.sku.codesnippetshop.domain.admin.key.api;

import com.sku.codesnippetshop.domain.admin.key.dto.KeyCreateDTO;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyReadDTO;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyUpdateDTO;
import com.sku.codesnippetshop.domain.admin.key.service.KeyService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/keys")
@RequiredArgsConstructor
public class KeyController {

    private final KeyService keyService;


    /*키 생성 컨트롤러
  param : 생성 키 info */
    @PostMapping
    public ResponseFormat<Void> createBoard(@RequestBody KeyCreateDTO create) {
        try {
            keyService.createKey(create);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*키 전부 읽기 컨트롤러
    param : X */
    @GetMapping
    public ResponseFormat<List<KeyReadDTO>> getAllKeys() {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, keyService.getKeys());
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*키 수정 컨트롤러
    param : 수정 키 info */
    @PutMapping("/{keyId}")
    public ResponseFormat<Void> updateBoardByBoardId(@PathVariable(value = "keyId")Long keyId, @RequestBody KeyUpdateDTO update) {
        try {
            keyService.updateKey(update, keyId);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*키 삭제 컨트롤러
    param : 삭제 키 KeyId*/
    @DeleteMapping("/{keyId}")
    public ResponseFormat<Void> deleteBoardByBoardId(@PathVariable(name = "keyId") Long keyId) {
        try {
            keyService.deleteKeyByKeyId(keyId);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
