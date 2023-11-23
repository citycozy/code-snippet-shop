package com.sku.codesnippetshop.domain.member.service;

import com.sku.codesnippetshop.domain.member.dao.MemberRepository;
import com.sku.codesnippetshop.domain.member.domain.Member;
import com.sku.codesnippetshop.domain.member.dto.MemberCreateDTO;
import com.sku.codesnippetshop.domain.member.dto.MemberReadDTO;
import com.sku.codesnippetshop.domain.member.dto.MemberUpdateDTO;
import com.sku.codesnippetshop.global.error.DuplicatedException;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    /*회원 생성 서비스
    param : 생성 회원 info*/
    @Transactional
    public void createMember(MemberCreateDTO create) {
        final Member member = Member.dtoToEntity(create);
        memberRepository.save(member);
    }

    /*회원 정보 읽기 서비스
    param : 읽을 회원 아이디(pk)*/
    public MemberReadDTO getMemberByMemberId(Long memberId) {
        final Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        return Member.entityToDto(member);
    }

    /*회원 정보 수정 서비스
    param : 수정 회원 아이디(pk), 수정 info*/
    @Transactional
    public void updateMember(Long memberId, MemberUpdateDTO update) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        member.updateMember(update);
    }

    /*회원 정보 삭제 서비스
    param : 삭제 회원 아이디(pk)*/
    @Transactional
    public void deleteMemberByMemberId(Long memberId) {
        final Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        memberRepository.delete(member);
    }


    /*이메일 중복 체크*/
    public void isEmailAlreadyExists(String email) throws DuplicatedException {
        if (memberRepository.existsByUsername(email))
            throw new DuplicatedException(ResponseStatus.FAIL_EMAIL_DUPLICATED);
    }

}
