package com.sku.codesnippetshop.domain.brand.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BrandCreateDTO {
    private String name;
}
