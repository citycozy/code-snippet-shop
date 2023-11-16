package com.sku.codesnippetshop.domain.Brand.api;

import com.sku.codesnippetshop.domain.Brand.dto.BrandCreateDTO;
import com.sku.codesnippetshop.domain.Brand.dto.BrandReadDTO;
import com.sku.codesnippetshop.domain.Brand.dto.BrandUpdateDTO;
import com.sku.codesnippetshop.domain.Brand.service.BrandService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;



    /*브랜드 생성 컨트롤러
    param : 생성 브랜드 info */
    @PostMapping
    public ResponseFormat<Void> createBoard(@RequestBody BrandCreateDTO create) {
        try {
            brandService.createBrand(create);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*브랜드 전부 읽기 컨트롤러
    param : X */
    @GetMapping
    public ResponseFormat<List<BrandReadDTO>> getAllBrands() {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, brandService.getBrands());
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*브랜드 수정 컨트롤러
    param : 수정 브랜드 info */
    @PutMapping("/{brandId}")
    public ResponseFormat<Void> updateBoardByBoardId(@PathVariable(value = "brandId")Long brandId, @RequestBody BrandUpdateDTO update) {
        try {
            brandService.updateBrand(update);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*브랜드 삭제 컨트롤러
    param : 삭제 브랜드 BrandId*/
    @DeleteMapping("/{brandId}")
    public ResponseFormat<Void> deleteBoardByBoardId(@PathVariable(name = "brandId") Long boardId) {
        try {
            brandService.deleteBrandByBrandId(boardId);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

}
