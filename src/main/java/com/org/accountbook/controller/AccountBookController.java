package com.org.accountbook.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.accountbook.domain.dto.AuthenticatedUser;
import com.org.accountbook.domain.dto.reqeust.AccountBookDetailRegisterDto;
import com.org.accountbook.domain.dto.reqeust.AccountBookDetailUpdateDto;
import com.org.accountbook.domain.dto.reqeust.AccountBookRegisterDto;
import com.org.accountbook.domain.dto.reqeust.AccountBookUpdateDto;
import com.org.accountbook.service.AccountBookService;
import com.org.accountbook.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account-book")
public class AccountBookController {

	private final AccountBookService accountBookService;
	private final MemberService memberService;

	/**
	 * 가계부 등록
	 * @param accountBookRegisterDto
	 * @param user
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> registerAccountBook(@Valid @RequestBody AccountBookRegisterDto accountBookRegisterDto, @AuthenticationPrincipal AuthenticatedUser user) {
		accountBookService.registerAccountBook(accountBookRegisterDto, user.getMemberNo());
		return ResponseEntity.ok().build();
	}

	/**
	 * 가계부 목록 조회
	 * @param user
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAccountBookList(@AuthenticationPrincipal AuthenticatedUser user) {
		return ResponseEntity.ok().body(memberService.getMemberDetail(user.getMemberNo()).getAccountBookList());
	}

	/**
	 * 가계부 조회
	 * @param accountBookNo
	 * @return
	 */
	@GetMapping("/{accountBookNo}")
	public ResponseEntity<?> getAccountBook(@PathVariable Long accountBookNo) {
		return ResponseEntity.ok().body(accountBookService.getAccountBook(accountBookNo));
	}

	/**
	 * 가계부 수정
	 * @param accountBookNo
	 * @param accountBookUpdateDto
	 * @return
	 */
	@PutMapping("/{accountBookNo}")
	ResponseEntity<?> updateAccountBook(@PathVariable Long accountBookNo, @Valid @RequestBody AccountBookUpdateDto accountBookUpdateDto) {
		return ResponseEntity.ok().body(accountBookService.updateAccountBook(accountBookNo, accountBookUpdateDto));
	}

	/**
	 * 가계부 삭제
	 * @param accountBookNo
	 * @return
	 */
	@DeleteMapping("/{accountBookNo}")
	ResponseEntity<?> deleteAccountBook(@PathVariable Long accountBookNo) {
		accountBookService.deleteAccountBook(accountBookNo);
		return ResponseEntity.ok().build();
	}

	/**
	 * 가계부 상세 등록
	 * @param accountBookNo
	 * @param accountBookRegisterDto
	 * @return
	 */
	@PostMapping("{accountBookNo}/detail")
	public ResponseEntity<?> registerAccountBookDetail(@PathVariable Long accountBookNo, @Valid @RequestBody AccountBookDetailRegisterDto accountBookRegisterDto) {
		accountBookService.registerAccountBookDetail(accountBookNo, accountBookRegisterDto);
		return ResponseEntity.ok().build();
	}

	/**
	 * 가계부 상세 수정
	 * @param accountBookNo
	 * @param accountBookDetailNo
	 * @param accountBookDetailUpdateDto
	 * @return
	 */
	@PutMapping("/{accountBookNo}/detail/{accountBookDetailNo}")
	ResponseEntity<?> updateAccountBookDetail(@PathVariable("accountBookNo") Long accountBookNo, @PathVariable("accountBookDetailNo") Long accountBookDetailNo
		, @Valid @RequestBody AccountBookDetailUpdateDto accountBookDetailUpdateDto) {
		return ResponseEntity.ok().body(accountBookService.updateAccountBookDetail(accountBookNo, accountBookDetailNo, accountBookDetailUpdateDto));
	}

	/**
	 * 가계부 상세 삭제
	 * @param accountBookNo
	 * @param accountBookDetailNo
	 * @return
	 */
	@DeleteMapping("/{accountBookNo}/detail/{accountBookDetailNo}")
	ResponseEntity<?> deleteAccountBookDetail(@PathVariable("accountBookNo") Long accountBookNo, @PathVariable("accountBookDetailNo") Long accountBookDetailNo) {
		return ResponseEntity.ok().body(accountBookService.deleteAccountBookDetail(accountBookNo, accountBookDetailNo));
	}


	/**
	 * 가계부 상세 조회
	 * @param accountBookNo
	 * @param accountBookDetailNo
	 * @return
	 */
	@GetMapping("/{accountBookNo}/detail/{accountBookDetailNo}")
	public ResponseEntity<?> getAccountBookDetail(@PathVariable("accountBookNo") Long accountBookNo, @PathVariable("accountBookDetailNo") Long accountBookDetailNo) {
		return ResponseEntity.ok().body(accountBookService.getAccountBookDetail(accountBookNo, accountBookDetailNo));
	}
}
