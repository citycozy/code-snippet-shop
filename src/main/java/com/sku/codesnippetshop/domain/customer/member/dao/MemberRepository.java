package com.sku.codesnippetshop.domain.customer.member.dao;

import com.sku.codesnippetshop.domain.customer.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUsername(String email);

    Member findByUsername(String username);


}
