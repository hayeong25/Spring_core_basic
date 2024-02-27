package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        /*
        * ApplicationContext : 스프링 컨테이너
        *
        * AppConfig를 사용해 직접 객체 생성하던 방식 -> 스프링 컨테이너를 통해 DI 하는 방식
        * @Configuration이 붙은 AppConfig를 설정 정보로 사용
        * @Bean 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록 (스프링 컨테이너에 등록된 객체 = 스프링 빈)
        *
        * */

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}