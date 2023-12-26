package com.sku.codesnippetshop.domain.admin.filter.api;

import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableReadDTO;
import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableUpdateDTO;
import com.sku.codesnippetshop.domain.admin.filter.dto.FilterCreateDto;
import com.sku.codesnippetshop.domain.admin.filter.dto.FilterReadDto;
import com.sku.codesnippetshop.domain.admin.filter.dto.FilterUpdateDTO;
import com.sku.codesnippetshop.domain.admin.filter.service.FilterService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filters")
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    /* 필터 테이블 생성 컨트롤러
    param : 생성 필터 테이블 info */
    @PostMapping
    public ResponseFormat<Long> createFilter(@RequestBody List<FilterCreateDto> createDtoList) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_CREATE,filterService.createFilter(createDtoList));
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /* 필터 전부 읽기 컨트롤러
    param : X */
    @GetMapping
    public ResponseFormat<List<FilterReadDto>> getAllFilters() {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, filterService.getFilters());
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

//    /* 필터 수정 컨트롤러
//   param : 수정 필터 테이블 info */
//    @PutMapping("/{filterId}")
//    public ResponseFormat<Void> updateFilterByFilterId(@PathVariable(value = "filterId")Long filterId, @RequestBody FilterUpdateDTO update) {
//        try {
//            filterService.updateFilter(update, filterId);
//            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
//        } catch (NotFoundException e) {
//            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
//        } catch (RuntimeException e) {
//            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
//        }
//    }

    /* 필터 삭제 컨트롤러
    param : 삭제 필터 filterId*/
    @DeleteMapping("/{filterId}")
    public ResponseFormat<Void> deleteFilterByFilterId(@PathVariable(name = "filterId") Long filterId) {
        try {
            filterService.deleteFilterByFilterId(filterId);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
