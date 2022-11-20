package com.org.accountbook.domain.enntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022/10/28
 * 가계부 entity
 */
@Getter
@Setter
@Entity
public class AccountBook extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountBookNo;

	private String accountBookName;

	private Character deleteYn;

	private String memo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "accout_book_no")
	private List<AccountBookDetail> accountBookDetailList = new ArrayList<>();
}
