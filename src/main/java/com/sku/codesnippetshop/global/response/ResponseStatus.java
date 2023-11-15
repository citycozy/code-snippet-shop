package com.sku.codesnippetshop.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResponseStatus {


    //공통 Success Status
    SUCCESS_OK("요청이 성공적으로 처리되었습니다.", HttpStatus.OK),
    SUCCESS_CREATE("요청이 성공적으로 처리되어 새로운 리소스가 생성되었습니다.", HttpStatus.CREATED),
    SUCCESS_ACCEPTED("요청이 성공적으로 처리되었지만, 결과가 아직 완료되지 않았습니다.", HttpStatus.ACCEPTED),
    SUCCESS_NO_CONTENT("요청이 성공적으로 처리되었지만, 응답 데이터가 없습니다.", HttpStatus.NO_CONTENT),

    //공통 fail Status
    FAIL_BAD_REQUEST("클라이언트의 요청이 잘못되었습니다.", HttpStatus.BAD_REQUEST),
    FAIL_UNAUTHORIZED("클라이언트가 인증되지 않았습니다.", HttpStatus.UNAUTHORIZED),
    FAIL_FORBIDDEN("클라이언트가 요청한 리소스에 접근할 권한이 없습니다.", HttpStatus.FORBIDDEN),
    FAIL_NOT_FOUND("클라이언트가 요청한 리소스를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    FAIL_METHOD_NOT_ALLOWED("클라이언트가 요청한 HTTP 메소드가 허용되지 않았습니다.", HttpStatus.METHOD_NOT_ALLOWED),

    //User fail Status
    FAIL_EMAIL_DUPLICATED("클라이언트의 이메일이 중복되었습니다.", HttpStatus.CONFLICT);

    private String message;

    private HttpStatus statusCode;

}