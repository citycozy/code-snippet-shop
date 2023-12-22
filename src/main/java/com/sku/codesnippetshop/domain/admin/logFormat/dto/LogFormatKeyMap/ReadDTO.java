package com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormatKeyMap;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReadDTO {
    private Long logFormatKeyMapId;
    private Long logFormatId;
    private Long keyId;
    private LocalDateTime regDt;
    private LocalDateTime modDt;

}
