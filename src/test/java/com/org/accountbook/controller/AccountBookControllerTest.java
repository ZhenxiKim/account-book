package com.org.accountbook.controller;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.org.accountbook.domain.enntity.Member;
import com.org.accountbook.security.JwtAuthenticationFilter;
import com.org.accountbook.security.JwtTokenProvider;
import com.org.accountbook.service.MemberService;

/**
 * @author jhkim
 * @since 2022-10-31
 *
 */
@MockBean(JpaMetamodelMappingContext.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(MemberController.class)
@DisplayName("MemberController 테스트")
class AccountBookControllerTest {
	private MockMvc mockMvc;

	@MockBean
	private MemberService memberService;

	@MockBean
	JwtAuthenticationFilter jwtAuthenticationFilter;

	@MockBean
	AuthenticationManager authenticationManager;

	@MockBean
	JwtTokenProvider jwtTokenProvider;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new MemberController(memberService))
			.addFilters(new CharacterEncodingFilter("UTF-8", true))
			.build();
	}

	@Test
	@DisplayName("회원가입 테스트")
	public void signUp() throws Exception {
		//given
		Member member  = new Member();
		member.setMemberEmail("test@gmail.com");
		member.setMemberName("testName");
		member.setMemberPassword("1234");
		member.setAccountBookList(new ArrayList<>());

		given(memberService.signUp(any()))
			.willReturn(member);

		final ResultActions actions =
			mockMvc.perform(
				post("/api/member/signup")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.characterEncoding("UTF-8")
					.content(
						"{"
							+ "  \"email\" : \"test@gmail.com\", "
							+ "  \"password\" : \"1234\", "
							+ "  \"name\": \"testName\""
							+ "}"));

		// then
		actions
			.andExpect(status().isOk())
			.andExpect(jsonPath("email").value("test@gmail.com"))
			.andExpect(jsonPath("password").value("1234"))
			.andExpect(jsonPath("name").value("testName"));
	}
}