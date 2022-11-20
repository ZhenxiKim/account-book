package com.org.accountbook.exception;

import com.org.accountbook.domain.SpecificExceptionCode;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public class CustomException extends RuntimeException{

	private SpecificExceptionCode exceptionCode;

	public CustomException(SpecificExceptionCode exceptionCode){
		super(exceptionCode.getMsgDetail());
		this.exceptionCode = exceptionCode;
	}

	public CustomException(SpecificExceptionCode exceptionCode, String detailMessage){
		//super(Util.ifEmpty(detailMessage, exceptionCode.getMsgDetail()));
		this.exceptionCode = exceptionCode;
	}

	public CustomException() {
	}

	public SpecificExceptionCode getExceptionCode(){
		return exceptionCode;
	}
}
