package com.sku.codesnippetshop.domain.member.api;


import com.sku.codesnippetshop.domain.member.dto.MemberCreateDTO;
import com.sku.codesnippetshop.domain.member.dto.MemberReadDTO;
import com.sku.codesnippetshop.domain.member.dto.MemberUpdateDTO;
import com.sku.codesnippetshop.domain.member.service.MemberService;
import com.sku.codesnippetshop.global.error.DuplicatedException;
import com.sku.codesnippetshop.global.error.NotFoundException;
import com.sku.codesnippetshop.global.response.ResponseFormat;
import com.sku.codesnippetshop.global.response.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    /*회원 생성 컨트롤러
    param : 생성 회원 info*/
    @PostMapping
    public ResponseFormat<Void> createMember(@RequestBody @Validated MemberCreateDTO create) {
        try {
            memberService.createMember(create);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (DuplicatedException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_EMAIL_DUPLICATED);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }


    /*회원 정보 조회 컨트롤러
    param : 조회 회원 MemberId*/
    @GetMapping("/{memberId}")
    public ResponseFormat<MemberReadDTO> getMemberByMemberId(@PathVariable(name = "memberId") Long memberId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, memberService.getMemberByMemberId(memberId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*회원 정보 수정 컨트롤러
    param : 수정 회원 MemberId, 수정 회원 info*/
    @PutMapping("/{memberId}")
    public ResponseFormat<Void> updateMemberByMemberId(@PathVariable(name = "memberId") Long memberId,@RequestBody @Validated MemberUpdateDTO update) {
        try {
            memberService.updateMember(memberId, update);
            return ResponseFormat.success(com.sku.codesnippetshop.global.response.ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (DuplicatedException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_EMAIL_DUPLICATED);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*회원 삭제 컨트롤러
    param : 삭제 회원 MemberId*/
    @DeleteMapping("/{memberId}")
    public ResponseFormat<Void> deleteMemberByMemberId(@PathVariable(name = "memberId") Long memberId) {
        try {
            memberService.deleteMemberByMemberId(memberId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

        @PostMapping("/email-check")
    public ResponseFormat<Void> checkDuplicateEmail(@RequestBody String username) {
        try {
            System.out.println(username);
            memberService.isEmailAlreadyExists(username);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        }
        catch (DuplicatedException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_EMAIL_DUPLICATED);
        }catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
