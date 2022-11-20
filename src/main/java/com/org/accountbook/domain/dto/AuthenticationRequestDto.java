package com.org.accountbook.domain.dto;

import lombok.Getter;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@Getter
public class AuthenticationRequestDto {
	private String email;
	private String password;

	public AuthenticationRequestDto(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
