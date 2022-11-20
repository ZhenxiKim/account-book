package com.org.accountbook.service;

import com.org.accountbook.domain.dto.AuthenticationRequestDto;
import com.org.accountbook.domain.dto.AuthenticationResponseDto;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public interface AuthenticationService {
	AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto);

}
