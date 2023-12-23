package com.sku.codesnippetshop.domain.admin.logFormat.api;

import com.sku.codesnippetshop.domain.admin.key.dto.KeyReadDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormatKeyMap.CreateDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormatKeyMap.ReadDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.service.LogFormatKeyMapService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/log-format-key-map")
@RequiredArgsConstructor
public class LogFormatKeyMapController {

    private final LogFormatKeyMapService logFormatKeyMapService;


    /*로그 포맷 로그 포맷 맵 생성 컨트롤러
    param : 생성 로그 포맷 로그 포맷 맵 info */
    @PostMapping
    public ResponseFormat<Void> createBoard(@RequestBody List<CreateDTO> createList) {
        try {
            for(CreateDTO create : createList) {
                logFormatKeyMapService.createLogFormatKeyMap(create);
            }
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*특정 로그 포맷의 로그 포맷 로그 포맷 맵 전부 읽기 컨트롤러
    param : X */
    @GetMapping("/{logFormatId}")
    public ResponseFormat<List<KeyReadDTO>> getAllLogFormatKeyMaps(@PathVariable(value = "logFormatId") Long logFormatId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, logFormatKeyMapService.getLogFormatKeyMapsByLogFormatId(logFormatId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
//
//    /*로그 포맷 로그 포맷 맵 수정 컨트롤러
//    param : 수정 로그 포맷 로그 포맷 맵 info */
//    @PutMapping("/{logFormatKeyMapId}")
//    public ResponseFormat<Void> updateBoardByBoardId(@PathVariable(value = "logFormatKeyMapId")Long logFormatKeyMapId, @RequestBody LogFormatKeyMapUpdateDTO update) {
//        try {
//            logFormatKeyMapService.updateLogFormatKeyMap(update, logFormatKeyMapId);
//            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
//        } catch (NotFoundException e) {
//            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
//        } catch (RuntimeException e) {
//            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
//        }
//    }
//
//    /*로그 포맷 로그 포맷 맵 삭제 컨트롤러
//    param : 삭제 로그 포맷 로그 포맷 맵 LogFormatKeyMapId*/
//    @DeleteMapping("/{logFormatKeyMapId}")
//    public ResponseFormat<Void> deleteBoardByBoardId(@PathVariable(name = "logFormatKeyMapId") Long logFormatKeyMapId) {
//        try {
//            logFormatKeyMapService.deleteLogFormatKeyMapByLogFormatKeyMapId(logFormatKeyMapId);
//            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
//        } catch (NotFoundException e) {
//            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
//        } catch (RuntimeException e) {
//            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
//        }
//    }
}
