package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given (다음이 주어졌을 때)
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when (다음과 같은 상황이라면)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then (기대 결과)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}