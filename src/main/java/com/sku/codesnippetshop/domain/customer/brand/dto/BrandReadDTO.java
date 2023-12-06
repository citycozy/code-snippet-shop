package com.sku.codesnippetshop.domain.customer.brand.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BrandReadDTO {
    private Long brandId;
    private String name;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
