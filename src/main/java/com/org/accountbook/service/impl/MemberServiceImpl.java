package com.org.accountbook.service.impl;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.accountbook.domain.dto.MemberSignUpDto;
import com.org.accountbook.domain.enntity.Member;
import com.org.accountbook.exception.ExistMemberException;
import com.org.accountbook.repository.MemberRepository;
import com.org.accountbook.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jhkim
 * @since 2022-10-28
 *
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public Member signUp(MemberSignUpDto memberSignUpDto) {

		boolean isExist = isExistMember(memberSignUpDto);
		Member memberEntity = new Member();
		if(isExist) {
			memberEntity.setMemberName(memberSignUpDto.getName());
			memberEntity.setMemberEmail(memberSignUpDto.getEmail());
			memberEntity.setMemberPassword(passwordEncoder.encode(memberSignUpDto.getPassword()));
			memberEntity.setMemberSignupDate(LocalDateTime.now());
			return memberRepository.save(memberEntity);
		}
		return memberEntity;
	}


	@Override
	public boolean isExistMember(MemberSignUpDto memberSignUpDto) {
		Member member = memberRepository.findByMemberEmail(memberSignUpDto.getEmail());
		if(member != null) {
			throw new ExistMemberException();
		}
		return true;
	}

	@Override
	public Member getMemberDetail(Long memberNo) {
		 return memberRepository.findAccountBookListByMemberNo(memberNo).orElse(null);
	}

}
