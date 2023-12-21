package com.sku.codesnippetshop.domain.admin.logFormat.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LogFormatUpdateDTO {


    private String name;
    private String description;

}
