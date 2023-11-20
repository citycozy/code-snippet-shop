package com.sku.codesnippetshop.domain.member.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberUpdateDTO {
    private String password;
    private String name;
    private String currentAddress;
}
