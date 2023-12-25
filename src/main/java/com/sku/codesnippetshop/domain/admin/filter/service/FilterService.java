package com.sku.codesnippetshop.domain.admin.filter.service;

import com.sku.codesnippetshop.domain.admin.filter.dao.FilterKeyMapRepository;
import com.sku.codesnippetshop.domain.admin.filter.dao.FilterRepository;
import com.sku.codesnippetshop.domain.admin.filter.domain.Filter;
import com.sku.codesnippetshop.domain.admin.filter.domain.FilterKeyMap;
import com.sku.codesnippetshop.domain.admin.filter.dto.FilterCreateDto;
import com.sku.codesnippetshop.domain.admin.filter.dto.FilterReadDto;
import com.sku.codesnippetshop.domain.admin.filter.dto.FilterUpdateDTO;
import com.sku.codesnippetshop.domain.admin.key.dao.KeyRepository;
import com.sku.codesnippetshop.domain.admin.key.domain.Key;
import com.sku.codesnippetshop.domain.admin.scenario.domain.Scenario;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioUpdateDTO;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class FilterService {

    private final FilterRepository filterRepository;
    private final FilterKeyMapRepository filterKeyMapRepository;
    private final KeyRepository keyRepository;
    /* 필터 생성 서비스
    param : 생성 필터 info */
    @Transactional
    public Long createFilter(List<FilterCreateDto> createDtoList) {

        final Filter filter = Filter.builder().build();
        filterRepository.save(filter);

        for(FilterCreateDto each : createDtoList){
            final Key key = keyRepository.findByName(each.getKey());
            FilterKeyMap filterKeyMap = FilterKeyMap.dtoToEntity(each, filter,key);
            filterKeyMapRepository.save(filterKeyMap);
        }
        System.out.println("??"+filter.getId());
        return filter.getId();
    }

    /* 필터 전부 읽기 서비스
    param : X */
    public List<FilterReadDto> getFilters() {
        final List<Filter> filterList = filterRepository.findAll();

        return filterList.stream()
                .map(Filter::entityToDto)
                .toList();
    }

    public List<FilterReadDto> getFiltersByFilterId(Long filterId) {
        final Optional<Filter> filterList = filterRepository.findById(filterId);

        return filterList.stream()
                .map(Filter::entityToDto)
                .toList();
    }

//    /* 필터 수정 서비스
//    param : 수정 필터 아이디(pk), 수정 info*/
//    @Transactional
//    public void updateFilter(FilterUpdateDTO update, Long filterId){
//
//        Filter filter = filterRepository.findById(filterId)
//                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
//
//        filter.updateFilter(update);
//    }

    /* 필터 삭제 서비스
    param : 삭제 필터 아이디(pk)*/
    @Transactional
    public void deleteFilterByFilterId(Long filterId){
        final Filter filter = filterRepository
                .findById(filterId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        filterRepository.delete(filter);
    }



}
