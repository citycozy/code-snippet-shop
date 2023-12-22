package com.sku.codesnippetshop.domain.admin.logFormat.service;

import com.sku.codesnippetshop.domain.admin.key.dao.KeyRepository;
import com.sku.codesnippetshop.domain.admin.key.domain.Key;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyReadDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dao.LogFormatKeyMapRepository;
import com.sku.codesnippetshop.domain.admin.logFormat.dao.LogFormatRepository;
import com.sku.codesnippetshop.domain.admin.logFormat.domain.LogFormat;
import com.sku.codesnippetshop.domain.admin.logFormat.domain.LogFormatKeyMap;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormatKeyMap.CreateDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormatKeyMap.ReadDTO;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LogFormatKeyMapService {


    private final KeyRepository keyRepository;
    private final LogFormatRepository logFormatRepository;
    private final LogFormatKeyMapRepository logFormatKeyMapRepository;
    /*로그 포맷 키 맵 테이블 생성 서비스
   param : 생성 로그 포맷 키 맵 테이블 info*/
    @Transactional
    public void createLogFormatKeyMap(CreateDTO create){
        final Key key = keyRepository.findById(create.getKeyId()).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final LogFormat logFormat = logFormatRepository.findById(create.getLogFormatId()).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final LogFormatKeyMap logFormatKeyMap = LogFormatKeyMap.dtoToEntity(key, logFormat);
        logFormatKeyMapRepository.save(logFormatKeyMap);
    }

    /*특정 키의 로그 포맷 키 맵 테이블 전부 읽기 서비스
    param : X */
    public List<KeyReadDTO> getLogFormatKeyMapsByLogFormatId(Long logFormatId){
        final List<LogFormatKeyMap> logFormatKeyMapList = logFormatKeyMapRepository.findByLogFormat_Id(logFormatId );

        return logFormatKeyMapList.stream()
                .map(logFormatKeyMap -> {
                    Long keyId = logFormatKeyMap.getKey().getId();
                    Key key = keyRepository.findById(keyId).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND)); // Key를 가져옴

                    return Key.entityToDto(key);
                    // Key가 존재하는 경우 ReadDTO를 생성, 그렇지 않으면 null 반환
                }).toList();


    }
//
//
//    /*로그 포맷 키 맵 테이블 수정 서비스
//    param : 수정 로그 포맷 키 맵 테이블 아이디(pk), 수정 info*/
//    @Transactional
//    public void updateLogFormatKeyMap(UpdateDTO update, Long logFormatKeyMapId){
//
//        LogFormatKeyMap logFormatKeyMap = logFormatKeyMapRepository.findById(logFormatKeyMapId)
//                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
//
//        logFormatKeyMap.updateLogFormatKeyMap(update);
//    }
//
//    /*로그 포맷 키 맵 테이블 삭제 서비스
//    param : 삭제 로그 포맷 키 맵 테이블 아이디(pk)*/
//    @Transactional
//    public void deleteLogFormatKeyMapByLogFormatKeyMapId(Long logFormatKeyMapId){
//        final LogFormatKeyMap logFormatKeyMap = logFormatKeyMapRepository
//                .findById(logFormatKeyMapId)
//                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
//
//        logFormatKeyMapRepository.delete(logFormatKeyMap);
//    }
}
