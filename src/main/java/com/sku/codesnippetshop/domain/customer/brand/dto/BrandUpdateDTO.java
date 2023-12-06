package com.sku.codesnippetshop.domain.customer.brand.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BrandUpdateDTO {
    private Long brandId;
    private String name;

}
