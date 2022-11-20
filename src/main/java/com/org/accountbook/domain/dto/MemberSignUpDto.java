package com.org.accountbook.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author jhkim
 * @since 2022-10-28
 * 회원가입 dto
 */
@NoArgsConstructor
@Getter
public class MemberSignUpDto {

	@NotNull(message = "이메일은 필수값 입니다.")
	@Email
	@Size(max = 100, message = "이메일을 100자리 이하로 입력하세요.")
	private String email;

	@NotNull(message = "비밀번호는 필수값 입니다.")
	private String password;

	@NotBlank(message = "사용할 이름을 입력해주세요.")
	private String name;
}
