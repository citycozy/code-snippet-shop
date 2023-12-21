package com.sku.codesnippetshop.domain.admin.key.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KeyReadDTO {
    private Long keyId;
    private String name;
    private String type;
    private String description;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
