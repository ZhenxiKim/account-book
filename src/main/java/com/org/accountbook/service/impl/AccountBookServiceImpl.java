package com.org.accountbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.org.accountbook.domain.dto.reqeust.AccountBookDetailRegisterDto;
import com.org.accountbook.domain.dto.reqeust.AccountBookDetailUpdateDto;
import com.org.accountbook.domain.dto.reqeust.AccountBookRegisterDto;
import com.org.accountbook.domain.dto.reqeust.AccountBookUpdateDto;
import com.org.accountbook.domain.enntity.AccountBook;
import com.org.accountbook.domain.enntity.AccountBookDetail;
import com.org.accountbook.domain.enntity.Member;
import com.org.accountbook.exception.ExistAccountBookException;
import com.org.accountbook.exception.NotExistAccountBookDetailException;
import com.org.accountbook.exception.NotExistAccountBookException;
import com.org.accountbook.exception.NotExistMemberException;
import com.org.accountbook.repository.AccountBookRepository;
import com.org.accountbook.repository.MemberRepository;
import com.org.accountbook.service.AccountBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountBookServiceImpl implements AccountBookService {

	private final Character deleteYn = 'N';
	private final MemberRepository memberRepository;
	private final AccountBookRepository accountBookRepository;

	@Override
	public void registerAccountBook(AccountBookRegisterDto dto, Long memberNo) {
		Member member = memberRepository.findByMemberNo(memberNo).orElseThrow(NotExistMemberException::new);
		List<AccountBook> accountBookList = member.getAccountBookList();
		List<String> accountBookNameList = new ArrayList<>();
		for(int i=0; i<accountBookList.size(); i++) {
			accountBookNameList.add(accountBookList.get(i).getAccountBookName());
		}
		if(accountBookNameList.contains(dto.getAccountBookName())) {
			throw new ExistAccountBookException();
		}
		AccountBook accountBook = new AccountBook();
		accountBook.setAccountBookName(dto.getAccountBookName());
		accountBook.setDeleteYn('N');
		accountBook.setMemo(dto.getMemo());
		accountBookList.add(accountBook);
		memberRepository.save(member);
	}

	@Override
	public AccountBook getAccountBook(Long accountBookNo) {
		return accountBookRepository.findByAccountBookNoAndDeleteYn(accountBookNo, deleteYn).orElse(null);
	}

	@Override
	public AccountBook updateAccountBook(Long accountBookNo, AccountBookUpdateDto accountBookUpdateDto) {
		return accountBookRepository.findByAccountBookNoAndDeleteYn(accountBookNo, deleteYn)
			.map(accountBook -> {
				accountBook.setAccountBookName(accountBookUpdateDto.getAccountBookName());
				accountBook.setMemo(accountBookUpdateDto.getMemo());
				return accountBookRepository.save(accountBook);
			}).orElseThrow(NotExistAccountBookException::new);
	}

	@Override
	public AccountBook deleteAccountBook(Long accountBookNo) {
		return accountBookRepository.findByAccountBookNo(accountBookNo)
			.map(accountBook -> {
				accountBook.setDeleteYn('Y');
				return accountBookRepository.save(accountBook);
			}).orElseThrow(NotExistAccountBookException::new);
	}

	@Override
	public void registerAccountBookDetail(Long accountBookNo, AccountBookDetailRegisterDto accountBookRegisterDto) {
		AccountBook accountBook = accountBookRepository.findByAccountBookNo(accountBookNo)
			.orElseThrow(NotExistAccountBookException::new);
		List<AccountBookDetail> accountBookDetailList = accountBook.getAccountBookDetailList();
		AccountBookDetail detail = AccountBookDetail.builder()
			.place(accountBookRegisterDto.getPlace())
			.amount(accountBookRegisterDto.getAmount())
			.transactionDate(accountBookRegisterDto.getTransactionDate())
			.transactionType(accountBookRegisterDto.getTransactionType())
			.memo(accountBookRegisterDto.getMemo())
			.deleteYn('N')
			.build();
		accountBookDetailList.add(detail);
		accountBookRepository.save(accountBook);


	}

	@Override
	public AccountBookDetail updateAccountBookDetail(Long accountBookNo, Long accountBookDetailNo, AccountBookDetailUpdateDto accountBookDetailUpdateDto) {
		AccountBook accountBook = accountBookRepository.findByAccountBookNo(accountBookNo).orElseThrow(NotExistAccountBookException::new);
		List<AccountBookDetail> detailList = accountBook.getAccountBookDetailList();
		List<Long> accountBookDetailNoList = new ArrayList<>();
		for (AccountBookDetail detail: detailList) {
			accountBookDetailNoList.add(detail.getAccountBookDetailNo());
		}
		if(!accountBookDetailNoList.contains(accountBookNo)) {
			throw new NotExistAccountBookDetailException();
		}
		AccountBookDetail accountBookDetail = null;
		for(int i=0; i<detailList.size(); i++) {
			if(detailList.get(i).getAccountBookDetailNo() == accountBookDetailNo) {
				accountBookDetail = detailList.get(i);
				accountBookDetail.setPlace(accountBookDetailUpdateDto.getPlace());
				accountBookDetail.setAmount(accountBookDetailUpdateDto.getAmount());
				accountBookDetail.setTransactionDate(accountBookDetailUpdateDto.getTransactionDate());
				accountBookDetail.setTransactionType(accountBookDetailUpdateDto.getTransactionType());
				accountBookDetail.setMemo(accountBookDetailUpdateDto.getMemo());
			}
		}
		accountBookRepository.save(accountBook);
		return accountBookDetail;
	}

	@Override
	public AccountBookDetail deleteAccountBookDetail(Long accountBookNo, Long accountBookDetailNo) {
		AccountBook accountBook = accountBookRepository.findByAccountBookNo(accountBookNo).orElseThrow(NotExistAccountBookException::new);
		List<AccountBookDetail> detailList = accountBook.getAccountBookDetailList();
		List<Long> accountBookDetailNoList = new ArrayList<>();
		for (AccountBookDetail detail: detailList) {
			accountBookDetailNoList.add(detail.getAccountBookDetailNo());
		}
		if(!accountBookDetailNoList.contains(accountBookNo)) {
			throw new NotExistAccountBookDetailException();
		}
		AccountBookDetail accountBookDetail = null;
		for (int i = 0; i < detailList.size(); i++) {
			if (detailList.get(i).getAccountBookDetailNo() == accountBookDetailNo) {
				accountBookDetail = detailList.get(i);
				accountBookDetail.setDeleteYn('Y');
			}
		}
		accountBookRepository.save(accountBook);
		return accountBookDetail;
	}
	@Override
	public AccountBookDetail getAccountBookDetail(Long accountBookNo, Long accountBookDetailNo) {
		AccountBook accountBook = accountBookRepository.findByAccountBookNoAndDeleteYn(accountBookNo, deleteYn).orElseThrow(NotExistAccountBookException::new);

		List<AccountBookDetail> detailList = accountBook.getAccountBookDetailList();
		for(AccountBookDetail detail : detailList) {
			if(detail.getAccountBookDetailNo().equals(accountBookDetailNo)) return detail;
		}
		return null;
	}
}
