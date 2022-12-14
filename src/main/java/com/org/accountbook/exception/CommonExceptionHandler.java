package com.org.accountbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.org.accountbook.domain.SpecificExceptionCode;
import com.org.accountbook.domain.dto.ErrorResponseDto;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jhkim
 * @since 2022-10-28
 *
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException e) {
		ErrorResponseDto errorResponseDto = ErrorResponseDto
			.builder()
			.code(SpecificExceptionCode.VALIDATION_EXCEPTION.getExceptionCode())
			.msg(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
			.build();
		return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomException(CustomException e) {
		SpecificExceptionCode exceptionCode = e.getExceptionCode();
		ErrorResponseDto responseDto = ErrorResponseDto
			.builder()
			.code(exceptionCode.getExceptionCode())
			.msg(exceptionCode.getMsgDetail())
			.data(null)
			.build();
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
	}
}
