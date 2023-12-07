package com.sku.codesnippetshop.domain.admin.codeTable.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CodeTableCreateDTO {
    private Long keyId;
    private String name;
    private String code;
}
