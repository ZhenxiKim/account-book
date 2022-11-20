package com.org.accountbook.service;

import com.org.accountbook.domain.dto.MemberSignUpDto;
import com.org.accountbook.domain.enntity.Member;

/**
 * @author jhkim
 * @since 2022-10-28
 *
 */
public interface MemberService {
	Member signUp(MemberSignUpDto memberSignUpDto);
	boolean isExistMember(MemberSignUpDto memberSignUpDto);
	Member getMemberDetail(Long memberNo);
}
