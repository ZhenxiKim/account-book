package com.org.accountbook.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.accountbook.domain.dto.AuthenticatedUser;
import com.org.accountbook.domain.enntity.Member;
import com.org.accountbook.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@RequiredArgsConstructor
@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {
	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByMemberEmail(username);
		return AuthenticatedUser.builder()
			.memberNo(member.getMemberNo())
			.memberEmail(member.getMemberEmail())
			.memberName(member.getMemberName())
			.build();
	}
}
