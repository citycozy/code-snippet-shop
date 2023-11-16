package com.sku.codesnippetshop.domain.Brand.domain;

import com.sku.codesnippetshop.domain.Brand.dto.BrandCreateDTO;
import com.sku.codesnippetshop.domain.Brand.dto.BrandReadDTO;
import com.sku.codesnippetshop.domain.Brand.dto.BrandUpdateDTO;
import com.sku.codesnippetshop.domain.Member.domain.Member;
import com.sku.codesnippetshop.domain.Member.dto.MemberCreateDTO;
import com.sku.codesnippetshop.domain.Member.dto.MemberReadDTO;
import com.sku.codesnippetshop.domain.Member.dto.MemberUpdateDTO;
import com.sku.codesnippetshop.domain.Member.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "name",length = 30)
    private String name;

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime regDt;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modDt;


    @Builder
    private Brand(String name) {
        this.name = name;
    }


    public void updateBrand(BrandUpdateDTO update) {
        this.name = update.getName();
    }

    public static BrandReadDTO entityToDto(Brand brand){
        return BrandReadDTO.builder()
                .brandId(brand.brandId)
                .name(brand.getName())
                .regDt(brand.getRegDt())
                .modDt(brand.getModDt())
                .build();
    }

    public static Brand dtoToEntity(BrandCreateDTO create){
        return Brand.builder()
                .name(create.getName())
                .build();
    }


}
