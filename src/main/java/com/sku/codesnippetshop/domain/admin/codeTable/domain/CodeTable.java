package com.sku.codesnippetshop.domain.admin.codeTable.domain;

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
public class CodeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_table_id")
    private Long codeTableId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key_id", referencedColumnName = "key_id")
    private Key key;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "reg_dt")
    @CreatedDate
    private LocalDateTime regDt;

    @Column(name = "mod_dt")
    @LastModifiedDate
    private LocalDateTime modDt;

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
                .codeTableId(codeTable.getCodeTableId())
                .keyId(codeTable.getKey().getKeyId())
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
