package com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormatKeyMap;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateDTO {

    private Long keyId;
    private Long logFormatId;

}
