package com.org.accountbook.domain.dto.reqeust;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class AccountBookRegisterDto {
	@NotNull
	private String accountBookName;
	private String memo;
}
