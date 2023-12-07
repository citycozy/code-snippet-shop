package com.sku.codesnippetshop.domain.admin.codeTable.api;

import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableCreateDTO;
import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableReadDTO;
import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableUpdateDTO;
import com.sku.codesnippetshop.domain.admin.codeTable.service.CodeTableService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/code-tables")
@RequiredArgsConstructor
public class CodeTableController {

    private final CodeTableService codeTableService;


    /*코드 테이블 생성 컨트롤러
    param : 생성 코드 테이블 info */
    @PostMapping
    public ResponseFormat<Void> createBoard(@RequestBody List<CodeTableCreateDTO> createList) {
        try {
            for(CodeTableCreateDTO create : createList) {
                codeTableService.createCodeTable(create);
            }
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*특정 키의 코드 테이블 전부 읽기 컨트롤러
    param : X */
    @GetMapping("/{keyId}")
    public ResponseFormat<List<CodeTableReadDTO>> getAllCodeTables(@PathVariable(value = "keyId") Long keyId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, codeTableService.getCodeTablesByKeyId(keyId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*코드 테이블 수정 컨트롤러
    param : 수정 코드 테이블 info */
    @PutMapping("/{codeTableId}")
    public ResponseFormat<Void> updateBoardByBoardId(@PathVariable(value = "codeTableId")Long codeTableId, @RequestBody CodeTableUpdateDTO update) {
        try {
            codeTableService.updateCodeTable(update, codeTableId);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*코드 테이블 삭제 컨트롤러
    param : 삭제 코드 테이블 CodeTableId*/
    @DeleteMapping("/{codeTableId}")
    public ResponseFormat<Void> deleteBoardByBoardId(@PathVariable(name = "codeTableId") Long codeTableId) {
        try {
            codeTableService.deleteCodeTableByCodeTableId(codeTableId);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
