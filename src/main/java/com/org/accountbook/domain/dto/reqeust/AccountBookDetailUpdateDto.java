package com.org.accountbook.domain.dto.reqeust;

import java.time.LocalDateTime;

import com.org.accountbook.domain.enntity.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022-10-30
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountBookDetailUpdateDto {

	private String place;
	private long amount;
	private LocalDateTime transactionDate;
	private TransactionType transactionType;
	private String memo;
}
