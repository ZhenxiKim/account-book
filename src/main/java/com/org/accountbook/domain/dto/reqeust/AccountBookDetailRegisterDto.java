package com.org.accountbook.domain.dto.reqeust;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.org.accountbook.domain.enntity.TransactionType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022-10-30
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class AccountBookDetailRegisterDto {

	@NotNull
	private String place;

	@NotNull
	private long amount;

	@NotNull
	private LocalDateTime transactionDate;

	@NotNull
	private TransactionType transactionType;

	private String memo;
}
