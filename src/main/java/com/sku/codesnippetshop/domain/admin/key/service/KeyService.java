package com.sku.codesnippetshop.domain.admin.key.service;

import com.sku.codesnippetshop.domain.admin.key.dao.KeyRepository;
import com.sku.codesnippetshop.domain.admin.key.domain.Key;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyCreateDTO;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyReadDTO;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyUpdateDTO;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class KeyService {

    private final KeyRepository keyRepository;

    /*키 생성 서비스
   param : 생성 키 info*/
    @Transactional
    public void createKey(KeyCreateDTO create){
        final Key key = Key.dtoToEntity(create);
        keyRepository.save(key);
    }

    /*키 전부읽기 서비스
    param : X */
    public List<KeyReadDTO> getKeys(){
        final List<Key> keyList = keyRepository.findAll();

        return keyList.stream()
                .map(Key::entityToDto)
                .toList();
    }


    /*키 수정 서비스
    param : 수정 키 아이디(pk), 수정 info*/
    @Transactional
    public void updateKey(KeyUpdateDTO update, Long keyId){

        Key key = keyRepository.findById(keyId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        key.updateKey(update);
    }

    /*키 삭제 서비스
    param : 삭제 키 아이디(pk)*/
    @Transactional
    public void deleteKeyByKeyId(Long keyId){
        final Key key = keyRepository
                .findById(keyId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        keyRepository.delete(key);
    }
}
