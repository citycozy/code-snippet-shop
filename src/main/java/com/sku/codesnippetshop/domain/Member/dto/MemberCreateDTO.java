package com.sku.codesnippetshop.domain.Member.dto;

import com.sku.codesnippetshop.domain.Member.enums.UserRole;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberCreateDTO {

    private String email;
    private String password;
    private String name;
    private String currentAddress;

}
