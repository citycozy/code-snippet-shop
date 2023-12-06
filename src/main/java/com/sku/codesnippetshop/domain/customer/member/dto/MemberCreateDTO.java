package com.sku.codesnippetshop.domain.customer.member.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberCreateDTO {

    private String username;
    private String password;
    private String name;
    private String currentAddress;

}
