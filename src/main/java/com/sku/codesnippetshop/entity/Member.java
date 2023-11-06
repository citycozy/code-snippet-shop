package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
    @CreationTimestamp
    private Timestamp createDate;

    @NotNull
    @Column(name = "modify_date")
    @UpdateTimestamp
    private Timestamp modifyDate;

}
