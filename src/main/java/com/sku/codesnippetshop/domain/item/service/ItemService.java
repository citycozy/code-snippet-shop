package com.sku.codesnippetshop.domain.item.service;

import com.sku.codesnippetshop.domain.brand.dao.BrandRepository;
import com.sku.codesnippetshop.domain.brand.domain.Brand;
import com.sku.codesnippetshop.domain.item.dao.ItemRepository;
import com.sku.codesnippetshop.domain.item.domain.Item;
import com.sku.codesnippetshop.domain.item.dto.ItemReadDto;
import com.sku.codesnippetshop.domain.item.dto.ItemCreateDto;
import com.sku.codesnippetshop.domain.item.dto.ItemUpdateDto;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final BrandRepository brandRepository;
    /* 제품 등록 서비스
    param : 등록 제품 info*/
    @Transactional
    public Item regItem(ItemCreateDto create) {
        final Brand brand = brandRepository.findById(create.getBrandId()).orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        final Item item = Item.dtoToEntity(create, brand);
        itemRepository.save(item);

        return item;
    }

    /* 제품 정보 읽기 서비스
    param : 읽을 제품 아이디(pk) */
    public ItemReadDto getItemByItemId(Long itemId) {
        final Item item = itemRepository
                .findById(itemId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        return Item.entityToDTO(item);
    }

    /* 제품 정보 수정 서비스
    param : 수정 제품 아이디(pk) */
    @Transactional
    public void updateItem(Long itemId, ItemUpdateDto update) {
        Item item = itemRepository
                .findById(itemId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        item.updateItem(update);
    }

    /* 제품 정보 삭제 서비스
    param : 삭제 제품 아이디(pk) */
    @Transactional
    public void deleteItemByItemId(Long itemId) {
        final Item item = itemRepository
                .findById(itemId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        itemRepository.delete(item);
    }
}
