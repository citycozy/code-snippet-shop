package com.sku.codesnippetshop.domain.admin.key.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KeyCreateDTO {
    private String name;
    private String type;
    private String description;
}
