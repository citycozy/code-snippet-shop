package com.sku.codesnippetshop.domain.admin.scenario.api;


import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioCreateDTO;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioReadDTO;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioUpdateDTO;
import com.sku.codesnippetshop.domain.admin.scenario.service.ScenarioService;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scenarios")
@RequiredArgsConstructor
public class ScenarioController {

    private final ScenarioService scenarioService;


    /*시나리오 생성 컨트롤러
    param : 생성 시나리오 info */
    @PostMapping
    public ResponseFormat<Void> createBoard(@RequestBody ScenarioCreateDTO create) {
        try {
            scenarioService.createScenario(create);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*시나리오 전부 읽기 컨트롤러
    param : X */
    @GetMapping
    public ResponseFormat<List<ScenarioReadDTO>> getAllScenarios() {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, scenarioService.getScenarios());
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*시나리오 수정 컨트롤러
    param : 수정 시나리오 info */
    @PutMapping("/{scenarioId}")
    public ResponseFormat<Void> updateBoardByBoardId(@PathVariable(value = "scenarioId")Long scenarioId, @RequestBody ScenarioUpdateDTO update) {
        try {
            scenarioService.updateScenario(update, scenarioId);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*시나리오 삭제 컨트롤러
    param : 삭제 시나리오 ScenarioId*/
    @DeleteMapping("/{scenarioId}")
    public ResponseFormat<Void> deleteBoardByBoardId(@PathVariable(name = "scenarioId") Long boardId) {
        try {
            scenarioService.deleteScenarioByScenarioId(boardId);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(com.sku.codesnippetshop.global.response.ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
