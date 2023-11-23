package com.sku.codesnippetshop.domain.member.dao;

import com.sku.codesnippetshop.domain.member.domain.Member;
import com.sku.codesnippetshop.domain.orderdetail.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUsername(String email);
}
