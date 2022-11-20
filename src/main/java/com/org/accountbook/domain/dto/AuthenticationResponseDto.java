package com.org.accountbook.domain.dto;

import lombok.Getter;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@Getter
public class AuthenticationResponseDto {
	private String token;

	public AuthenticationResponseDto(String token) {
		this.token = token;
	}
}
