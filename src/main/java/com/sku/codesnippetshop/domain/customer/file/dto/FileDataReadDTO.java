package com.sku.codesnippetshop.domain.customer.file.dto;

import lombok.*;
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FileDataReadDTO {
        private Long fileId;

        private String fileName;

        private String filePath;

        private Long itemId;

        private Long brandId;
}
