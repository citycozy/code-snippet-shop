package com.sku.codesnippetshop.domain.Address;

import com.sku.codesnippetshop.domain.Member.domain.Member;
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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    @NotNull
    private Long addressId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member memberId;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "reg_dt")
    @CreatedDate
    private LocalDateTime regDt;

    @NotNull
    @Column(name = "mod_dt")
    @LastModifiedDate
    private LocalDateTime modDt;
}
