package com.sku.codesnippetshop.domain.admin.codeTable.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CodeTableReadDTO {

    private Long codeTableId;
    private Long keyId;
    private String name;
    private String code;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
