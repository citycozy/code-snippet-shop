package com.sku.codesnippetshop.domain.admin.scMapScenarioAssociation.service;

import com.sku.codesnippetshop.domain.admin.codeTable.dao.CodeTableRepository;
import com.sku.codesnippetshop.domain.admin.codeTable.domain.CodeTable;
import com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.dao.SCMapRepository;
import com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.domain.SCMap;
import com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.dto.SCMapCreateDTO;
import com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.dto.SCMapReadDTO;
import com.sku.codesnippetshop.domain.admin.scenario.dao.ScenarioRepository;
import com.sku.codesnippetshop.domain.admin.scenario.domain.Scenario;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SCMapService {

    private final SCMapRepository scMapRepository;
    private final CodeTableRepository codeTableRepository;
    private final ScenarioRepository scenarioRepository;

    /*키 시나리오 매핑 생성 서비스
    param : 생성 키 시나리오 매핑 info*/
    @Transactional
    public void createSCMap(SCMapCreateDTO create){
        final Scenario scenario = scenarioRepository.findById(create.getScenarioId()).orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final CodeTable codeTable = codeTableRepository.findById(create.getCodeTableId()).orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final SCMap scMap = SCMap.dtoToEntity(create, codeTable, scenario);
        scMapRepository.save(scMap);
    }

    /*키 시나리오 매핑 전부읽기 서비스
    param : X */
    public List<SCMapReadDTO> getSCMaps(){
        final List<SCMap> scMapList = scMapRepository.findAll();

        return scMapList.stream()
                .map(SCMap::entityToDto)
                .toList();
    }


//    /*키 시나리오 매핑 수정 서비스
//    param : 수정 키 시나리오 매핑 아이디(pk), 수정 info*/
//    @Transactional
//    public void updateSCMap(SCMapUpdateDTO update, Long scMapId){
//
//        SCMap scMap = scMapRepository.findById(scMapId)
//                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
//
//        scMap.updateSCMap(update);
//    }

    /*키 시나리오 매핑 삭제 서비스
    param : 삭제 키 시나리오 매핑 아이디(pk)*/
    @Transactional
    public void deleteSCMapBySCMapId(Long scMapId){
        final SCMap scMap = scMapRepository
                .findById(scMapId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        scMapRepository.delete(scMap);
    }
}
