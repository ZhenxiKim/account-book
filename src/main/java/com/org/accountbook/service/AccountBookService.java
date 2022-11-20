package com.org.accountbook.service;

import com.org.accountbook.domain.dto.reqeust.AccountBookDetailRegisterDto;
import com.org.accountbook.domain.dto.reqeust.AccountBookDetailUpdateDto;
import com.org.accountbook.domain.dto.reqeust.AccountBookRegisterDto;
import com.org.accountbook.domain.dto.reqeust.AccountBookUpdateDto;
import com.org.accountbook.domain.enntity.AccountBook;
import com.org.accountbook.domain.enntity.AccountBookDetail;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public interface AccountBookService {
	void registerAccountBook(AccountBookRegisterDto accountBookRegisterDto, Long memberNo);

	AccountBook getAccountBook(Long accountBookNo);

	AccountBook updateAccountBook(Long accountBookNo, AccountBookUpdateDto accountBookUpdateDto);

	AccountBook deleteAccountBook(Long accountBookNo);

	void registerAccountBookDetail(Long accountBookNo, AccountBookDetailRegisterDto accountBookRegisterDto);

	AccountBookDetail updateAccountBookDetail(Long accountBookNo, Long accountBookDetailNo, AccountBookDetailUpdateDto accountBookDetailUpdateDto);

	AccountBookDetail deleteAccountBookDetail(Long accountBookNo, Long accountBookDetailNo);

	AccountBookDetail getAccountBookDetail(Long accountBookNo, Long accountBookDetailNo);

}


