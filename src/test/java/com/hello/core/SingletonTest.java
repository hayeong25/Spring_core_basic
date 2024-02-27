package com.hello.core;

import com.hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {

        /*
        * AppConfig : 요청할 때마다 새로운 객체 생성하기 때문에 메모리 낭비 ↑
        *
        * -> 해당 객체가 1개만 생성되고, 서로 공유하며 사용할 수 있도록
        * -> Singleton
        */

        AppConfig appConfig = new AppConfig();

        // 1 조회 : 호출할 때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();

        // 2 조회 : 호출할 때마다 객체 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값 다름
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        
        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }
}