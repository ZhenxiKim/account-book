package com.org.accountbook.service.impl;

import org.springframework.stereotype.Service;

import com.org.accountbook.domain.dto.AuthenticationRequestDto;
import com.org.accountbook.domain.dto.AuthenticationResponseDto;
import com.org.accountbook.domain.enntity.Member;
import com.org.accountbook.exception.NotExistMemberException;
import com.org.accountbook.repository.MemberRepository;
import com.org.accountbook.security.JwtTokenProvider;
import com.org.accountbook.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto) {
        Member member = memberRepository.findByMemberEmail(authenticationRequestDto.getEmail());
        if(member == null) {
            throw new NotExistMemberException();
        }
        return new AuthenticationResponseDto(jwtTokenProvider.createToken(member.getMemberEmail()));
    }

}
