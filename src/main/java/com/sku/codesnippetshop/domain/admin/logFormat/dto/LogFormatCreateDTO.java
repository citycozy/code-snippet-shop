package com.sku.codesnippetshop.domain.admin.logFormat.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LogFormatCreateDTO {

    private String name;
    private String description;


}
