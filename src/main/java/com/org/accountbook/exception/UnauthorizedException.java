package com.org.accountbook.exception;

import com.org.accountbook.domain.SpecificExceptionCode;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public class UnauthorizedException extends CustomException {

	public UnauthorizedException(SpecificExceptionCode notExistMemberException) {
		super(notExistMemberException);
	}
}
