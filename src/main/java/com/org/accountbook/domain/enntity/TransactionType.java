package com.org.accountbook.domain.enntity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jhkim
 * @since 2022/10/28
 *
 */
public enum TransactionType {
	@JsonProperty("μμ")
	INCOME,
	@JsonProperty("μ§μΆ")
	EXPENSE;

}
