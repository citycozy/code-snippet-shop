package com.sku.codesnippetshop.domain.admin.codeTable.domain;

import com.sku.codesnippetshop.domain.admin.BaseEntity;
import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableCreateDTO;
import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableReadDTO;
import com.sku.codesnippetshop.domain.admin.codeTable.dto.CodeTableUpdateDTO;
import com.sku.codesnippetshop.domain.admin.key.domain.Key;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyCreateDTO;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyReadDTO;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyUpdateDTO;
import com.sku.codesnippetshop.domain.customer.brand.domain.Brand;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "code_table")
@AttributeOverride(
        name = "id",
        column = @Column(name = "code_table_id")
)
public class CodeTable extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key_id", referencedColumnName = "key_id")
    private Key key;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "code", length = 100)
    private String code;


    @Builder
    private CodeTable(Key key, String name, String code) {
        this.key = key;
        this.name = name;
        this.code = code;
    }

    public void updateCodeTable(CodeTableUpdateDTO update) {
        this.name = update.getName();
        this.code = update.getCode();
    }

    public static CodeTableReadDTO entityToDto(CodeTable codeTable){
        return CodeTableReadDTO.builder()
                .codeTableId(codeTable.getId())
                .keyId(codeTable.getKey().getId())
                .name(codeTable.getName())
                .code(codeTable.getCode())
                .regDt(codeTable.getRegDt())
                .modDt(codeTable.getModDt())
                .build();
    }

    public static CodeTable dtoToEntity(CodeTableCreateDTO create, Key key){
        return CodeTable.builder()
                .key(key)
                .name(create.getName())
                .code(create.getCode())
                .build();
    }
}
