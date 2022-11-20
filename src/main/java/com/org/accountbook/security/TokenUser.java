package com.org.accountbook.security;

import io.jsonwebtoken.Claims;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@Getter
@Setter
public class TokenUser {
	private String userEmail;

	public TokenUser(Claims claims) {
		this.userEmail = String.valueOf(claims.get("sub"));
	}

}
