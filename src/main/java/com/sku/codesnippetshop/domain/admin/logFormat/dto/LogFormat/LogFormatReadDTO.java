package com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LogFormatReadDTO {

    private Long logFormatId;
    private String name;
    private String description;
    private LocalDateTime regDt;
    private LocalDateTime modDt;


}
