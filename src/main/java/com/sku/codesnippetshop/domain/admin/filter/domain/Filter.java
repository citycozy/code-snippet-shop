package com.sku.codesnippetshop.domain.admin.filter.domain;

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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filter_id")
    private Long filterId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Builder
    private Filter(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Filter dtoToEntity(FilterCreateDto create) {
        return Filter.builder()
                .name(create.getName())
                .description(create.getDescription())
                .build();
    }

    public static FilterReadDto entityToDto(Filter filter) {
        return FilterReadDto.builder()
                .name(filter.getName())
                .description(filter.getDescription())
                .build();
    }

    public void updateFilter(FilterUpdateDTO update) {
        this.name = update.getName();
        this.description = update.getDescription();
    }
}
