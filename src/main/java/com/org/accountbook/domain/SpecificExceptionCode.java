package com.org.accountbook.domain;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public enum SpecificExceptionCode {
	NOT_EXIST_MEMBER_EXCEPTION(500,'M',"가입되지않은 회원의 정보입니다."),
	EXIST_MEMBER_EXCEPTION(500,'M',"이미 가입된 회원의 정보입니다."),
	EXIST_ACCOUNT_BOOK_EXCEPTION(500,'A',"이미 존재하는 가계부명입니다."),
	NOT_EXIST_ACCOUNT_BOOK_EXCEPTION(500,'A',"등록되지않은 가계부명입니다."),
	NOT_EXIST_ACCOUNT_BOOK_DETAIL_EXCEPTION(500,'D',"등록되지않은 가계부 상세입니다."),
	VALIDATION_EXCEPTION(400,'M',"입력값이 잘못되었습니다.");
	private final int httpCode;
	private final char exceptionGroup;
	private final String msgDetail;

	SpecificExceptionCode(final int httpCode, final char exceptionGroup, final String msgDetail) {
		this.httpCode = httpCode;
		this.exceptionGroup = exceptionGroup;
		this.msgDetail = msgDetail;
	}

	public String getExceptionCode() {
		return exceptionGroup + Integer.toString(httpCode);
	}

	public String getMsgDetail() {
		return msgDetail;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public char getExceptionGroup() {
		return exceptionGroup;
	}
}
