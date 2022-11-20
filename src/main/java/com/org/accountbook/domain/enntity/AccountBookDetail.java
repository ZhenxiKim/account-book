package com.org.accountbook.domain.enntity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022/10/28
 * 가계부 상세 entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class AccountBookDetail extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountBookDetailNo;

	private String place;

	private long amount;

	private LocalDateTime transactionDate;

	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	private String memo;

	private Character deleteYn;

}
