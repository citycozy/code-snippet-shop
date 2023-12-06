package com.sku.codesnippetshop.domain.admin.scenario.service;

import com.sku.codesnippetshop.domain.admin.scenario.dao.ScenarioRepository;
import com.sku.codesnippetshop.domain.admin.scenario.domain.Scenario;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioCreateDTO;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioReadDTO;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioUpdateDTO;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class ScenarioService {

    private final ScenarioRepository scenarioRepository;

    /*키 생성 서비스
   param : 생성 키 info*/
    @Transactional
    public void createScenario(ScenarioCreateDTO create){
        final Scenario scenario = Scenario.dtoToEntity(create);
        scenarioRepository.save(scenario);
    }

    /*키 전부읽기 서비스
    param : X */
    public List<ScenarioReadDTO> getScenarios(){
        final List<Scenario> scenarioList = scenarioRepository.findAll();

        return scenarioList.stream()
                .map(Scenario::entityToDto)
                .toList();
    }


    /*키 수정 서비스
    param : 수정 키 아이디(pk), 수정 info*/
    @Transactional
    public void updateScenario(ScenarioUpdateDTO update, Long scenarioId){

        Scenario scenario = scenarioRepository.findById(scenarioId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        scenario.updateScenario(update);
    }

    /*키 삭제 서비스
    param : 삭제 키 아이디(pk)*/
    @Transactional
    public void deleteScenarioByScenarioId(Long scenarioId){
        final Scenario scenario = scenarioRepository
                .findById(scenarioId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        scenarioRepository.delete(scenario);
    }
}
