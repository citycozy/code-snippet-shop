package com.sku.codesnippetshop.domain.admin.logFormat.api;

import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatCreateDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatReadDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatUpdateDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.service.LogFormatService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/log-formats")
@RequiredArgsConstructor
public class LogFormatController {

    private final LogFormatService logFormatService;

    /*로그 포맷 생성 컨트롤러
  param : 생성 로그 포맷 info */
    @PostMapping
    public ResponseFormat<Long> createLogFormat(@RequestBody LogFormatCreateDTO create) {
        try {
            Long logFormatId = logFormatService.createLogFormat(create);

            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_CREATE, logFormatId);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*로그 포맷 전부 읽기 컨트롤러
    param : X */
    @GetMapping
    public ResponseFormat<List<LogFormatReadDTO>> getAllLogFormats() {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, logFormatService.getLogFormats());
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*로그 포맷 수정 컨트롤러
    param : 수정 로그 포맷 info */
    @PutMapping("/{logFormatId}")
    public ResponseFormat<Void> updateBoardByBoardId(@PathVariable(value = "logFormatId")Long logFormatId, @RequestBody LogFormatUpdateDTO update) {
        try {
            logFormatService.updateLogFormat(update, logFormatId);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*로그 포맷 삭제 컨트롤러
    param : 삭제 로그 포맷 LogFormatId*/
    @DeleteMapping("/{logFormatId}")
    public ResponseFormat<Void> deleteBoardByBoardId(@PathVariable(name = "logFormatId") Long logFormatId) {
        try {
            logFormatService.deleteLogFormatByLogFormatId(logFormatId);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
