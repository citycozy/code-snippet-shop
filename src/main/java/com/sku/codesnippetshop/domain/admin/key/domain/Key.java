package com.sku.codesnippetshop.domain.admin.key.domain;

import com.sku.codesnippetshop.domain.admin.BaseEntity;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyCreateDTO;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyReadDTO;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyUpdateDTO;
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
@AttributeOverride(
        name = "id",
        column = @Column(name = "key_id")
)
public class Key extends BaseEntity {


    @Column(name = "name", length = 100)
    private String name;


    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "description", length = 100)
    private String description;

    @Builder
    private Key(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public void updateKey(KeyUpdateDTO update) {
        this.name = update.getName();
        this.type = update.getType();
        this.description = update.getDescription();
    } // 살펴보기

    public static KeyReadDTO entityToDto(Key key){
        return KeyReadDTO.builder()
                .keyId(key.getId())
                .name(key.getName())
                .type(key.getType())
                .description(key.getDescription())
                .regDt(key.getRegDt())
                .modDt(key.getModDt())
                .build();
    }

    public static Key dtoToEntity(KeyCreateDTO create){
        return Key.builder()
                .name(create.getName())
                .type(create.getType())
                .description(create.getDescription())
                .build();
    }
}
