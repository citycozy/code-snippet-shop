package com.sku.codesnippetshop.domain.admin.filter.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FilterUpdateDTO {

    private String name;
    private String description;
}


