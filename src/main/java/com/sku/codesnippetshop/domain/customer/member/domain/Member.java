package com.sku.codesnippetshop.domain.customer.member.domain;

import com.sku.codesnippetshop.domain.customer.member.dto.MemberReadDTO;
import com.sku.codesnippetshop.domain.customer.member.enums.UserRole;
import com.sku.codesnippetshop.domain.customer.member.dto.MemberCreateDTO;
import com.sku.codesnippetshop.domain.customer.member.dto.MemberUpdateDTO;
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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "email", unique = true, length = 100)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "grade", length = 100)
    private String grade;

    @Column(name = "role", length = 100)
    private UserRole role;

    @Column(name = "current_address", length = 100)
    private String currentAddress;

    @Column(name = "reg_dt")
    @CreatedDate
    private LocalDateTime regDt;

    @Column(name = "mod_dt")
    @LastModifiedDate
    private LocalDateTime modDt;


    @Builder
    private Member(String username, String password, String name, String currentAddress) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = UserRole.USER;
        this.grade = "normal";
        this.currentAddress = currentAddress;
    }


    public void updateMember(MemberUpdateDTO update) {
        this.password = update.getPassword();
        this.name = update.getName();
        this.currentAddress = update.getCurrentAddress();
    }

    public static MemberReadDTO entityToDto(Member member) {
        return MemberReadDTO.builder()
                .username(member.getUsername())
                .name(member.getName())
                .grade(member.getGrade())
                .role(member.getRole())
                .currentAddress(member.getCurrentAddress())
                .regDt(member.getRegDt())
                .modDt(member.getModDt())
                .build();
    }

    public static Member dtoToEntity(MemberCreateDTO create) {
        return Member.builder()
                .username(create.getUsername())
                .password(create.getPassword())
                .name(create.getName())
                .currentAddress(create.getCurrentAddress())
                .build();
    }
}
