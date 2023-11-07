package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    @NotNull
    private Long memberId;

    @NotNull
    @Column(name = "email",length = 100)
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "grade",length = 100, columnDefinition = "default '일반'")
    private String grade;

    @NotNull
    @Column(name = "role",length = 100, columnDefinition = "default '회원'")
    private String role;

    @Column(name = "current_address",length = 100)
    private String currentAddress;

    @NotNull
    @Column(name = "create_date")
    @CreatedDate
    private LocalDateTime createDate;

    @NotNull
    @Column(name = "modify_date")
    @LastModifiedDate
    private LocalDateTime modifyDate;

}
