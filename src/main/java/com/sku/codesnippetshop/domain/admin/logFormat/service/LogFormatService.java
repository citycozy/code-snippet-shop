package com.sku.codesnippetshop.domain.admin.logFormat.service;

import com.sku.codesnippetshop.domain.admin.logFormat.dao.LogFormatKeyMapRepository;
import com.sku.codesnippetshop.domain.admin.logFormat.dao.LogFormatRepository;
import com.sku.codesnippetshop.domain.admin.logFormat.domain.LogFormat;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatCreateDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatReadDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatUpdateDTO;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LogFormatService {

    private final LogFormatRepository logFormatRepository;
    private final LogFormatKeyMapRepository logFormatKeyMapRepository;
    /*로그 포맷 생성 서비스
   param : 생성 로그 포맷 info*/
    @Transactional
    public Long createLogFormat(LogFormatCreateDTO create){
        final LogFormat logFormat = LogFormat.dtoToEntity(create);
        logFormatRepository.save(logFormat);
        return logFormat.getId();
    }

    /*로그 포맷 전부읽기 서비스
    param : X */
    public List<LogFormatReadDTO> getLogFormats(){
        final List<LogFormat> logFormatList = logFormatRepository.findAll();

        return logFormatList.stream()
                .map(LogFormat::entityToDto)
                .toList();
    }


    /*로그 포맷 수정 서비스
    param : 수정 로그 포맷 아이디(pk), 수정 info*/
    @Transactional
    public void updateLogFormat(LogFormatUpdateDTO update, Long logFormatId){

        LogFormat logFormat = logFormatRepository.findById(logFormatId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        logFormat.updateLogFormat(update);
    }

    /*로그 포맷 삭제 서비스
    param : 삭제 로그 포맷 아이디(pk)*/
    @Transactional
    public void deleteLogFormatByLogFormatId(Long logFormatId){
        final LogFormat logFormat = logFormatRepository
                .findById(logFormatId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        logFormatKeyMapRepository.deleteByLogFormat_Id(logFormatId);
        logFormatRepository.delete(logFormat);
    }
}
