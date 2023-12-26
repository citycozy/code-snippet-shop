package com.sku.codesnippetshop.domain.admin.filter.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FilterCreateDto {

    private String key;
    private Long filterId;
    private String logicalOperator;
    private String value;


}
