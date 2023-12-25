package com.sku.codesnippetshop.domain.admin.filter.domain;

import com.sku.codesnippetshop.domain.admin.BaseEntity;
import com.sku.codesnippetshop.domain.admin.filter.dto.FilterCreateDto;
import com.sku.codesnippetshop.domain.admin.filter.dto.FilterReadDto;
import com.sku.codesnippetshop.domain.admin.filter.dto.FilterUpdateDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@AttributeOverride(
        name = "id",
        column =  @Column(name = "filter_id")
)
public class Filter extends BaseEntity {



    @Builder
    public Filter() {

    }


    public static Filter dtoToEntity(FilterCreateDto create) {
        return Filter.builder()
                .build();
    }

    public static FilterReadDto entityToDto(Filter filter) {
        return FilterReadDto.builder()
                .build();
    }

}
