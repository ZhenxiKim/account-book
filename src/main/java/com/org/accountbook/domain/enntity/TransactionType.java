package com.org.accountbook.domain.enntity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jhkim
 * @since 2022/10/28
 *
 */
public enum TransactionType {
	@JsonProperty("수입")
	INCOME,
	@JsonProperty("지출")
	EXPENSE;

}
