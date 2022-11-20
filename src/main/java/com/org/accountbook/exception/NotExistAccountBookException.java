package com.org.accountbook.exception;

import com.org.accountbook.domain.SpecificExceptionCode;

/**
 * @author jhkim
 * @since 2022-10-30
 *
 */
public class NotExistAccountBookException extends CustomException {

	public NotExistAccountBookException() {
		super(SpecificExceptionCode.NOT_EXIST_ACCOUNT_BOOK_EXCEPTION);
	}
}
