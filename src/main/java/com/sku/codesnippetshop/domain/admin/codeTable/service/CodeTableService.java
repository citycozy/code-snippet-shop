package com.sku.codesnippetshop.domain.admin.codeTable.service;

import com.sku.codesnippetshop.domain.admin.codeTable.dao.CodeTableRepository;
import com.sku.codesnippetshop.domain.admin.codeTable.domain.CodeTable;
import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableCreateDTO;
import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableReadDTO;
import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableUpdateDTO;
import com.sku.codesnippetshop.domain.admin.key.dao.KeyRepository;
import com.sku.codesnippetshop.domain.admin.key.domain.Key;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CodeTableService {

    private final CodeTableRepository codeTableRepository;
    private final KeyRepository keyRepository;
    /*코드 테이블 생성 서비스
   param : 생성 코드 테이블 info*/
    @Transactional
    public void createCodeTable(CodeTableCreateDTO create){
        final Key key = keyRepository.findById(create.getKeyId()).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        final CodeTable codeTable = CodeTable.dtoToEntity(create, key);
        codeTableRepository.save(codeTable);
    }

    /*특정 키의 코드 테이블 전부 읽기 서비스
    param : X */
    public List<CodeTableReadDTO> getCodeTablesByKeyId(Long keyId){
        final List<CodeTable> codeTableList = codeTableRepository.findByKey_KeyId(keyId );

        return codeTableList.stream()
                .map(CodeTable::entityToDto)
                .toList();
    }


    /*코드 테이블 수정 서비스
    param : 수정 코드 테이블 아이디(pk), 수정 info*/
    @Transactional
    public void updateCodeTable(CodeTableUpdateDTO update, Long codeTableId){

        CodeTable codeTable = codeTableRepository.findById(codeTableId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        codeTable.updateCodeTable(update);
    }

    /*코드 테이블 삭제 서비스
    param : 삭제 코드 테이블 아이디(pk)*/
    @Transactional
    public void deleteCodeTableByCodeTableId(Long codeTableId){
        final CodeTable codeTable = codeTableRepository
                .findById(codeTableId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        codeTableRepository.delete(codeTable);
    }
}
