package com.org.accountbook.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022-10-28
 *
 */
@Getter
@Setter
@Builder
public class ErrorResponseDto {
	private String msg;
	private Object data;

	private String code;

	public ErrorResponseDto(String msg, Object data, String code) {
		this.msg = msg;
		this.data = data;
		this.code = code;
	}
}
