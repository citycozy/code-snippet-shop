package com.sku.codesnippetshop.domain.file.dto;

import com.sku.codesnippetshop.domain.item.domain.Item;
import jakarta.validation.constraints.NotNull;
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
