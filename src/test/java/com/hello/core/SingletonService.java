package com.hello.core;

import com.hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
* Singleton Pattern 단점
*
* 1. 싱글톤 패턴 구현 코드가 길다
* 2. 의존 관계상 클라이언트가 구체 클래스에 의존 -> DIP, OCP 위반
* 3. 테스트 하기 어렵다
* 4. 내부 속성을 변경하거나 초기화 하기 어렵다
* 5. 생성자가 private이기에 자식 클래스를 만들기 어렵다
* 6. 유연성이 떨어진다
*/

public class SingletonService {

    // [1] static 영역에 객체 1개만 생성
    private static final SingletonService instance = new SingletonService();

    // [2] public으로 열어서 객체 인스턴스가 필요하면 아래의 static 메서드를 통해서만 조회하도록
    public static SingletonService getInstance() {
        return instance;
    }

    // [3] 생성자를 private으로 선언해 외부에서 new 키워드로 또 다른 객체를 생성할 수 없게 함
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() {
        // new SingletonService(); -> private 생성자이기 때문에 컴파일 오류 발생

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // 참조값 동일
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // singletonService1 == singletonService2
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();
    }

    /*
    * Singleton Container
    * - 스프링 컨테이너는 싱글턴 패턴을 적용하지 않아도 객체 인스턴스를 싱글톤으로 관리한다
    * - Singleton Registry
    */
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값 동일
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 == memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}