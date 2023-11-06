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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    @NotNull
    private Long addressId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp createDate;

    @NotNull
    @Column(name = "modify_date")
    @UpdateTimestamp
    private Timestamp modifyDate;
}
