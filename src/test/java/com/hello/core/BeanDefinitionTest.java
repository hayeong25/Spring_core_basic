package com.hello.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
* BeanDefinition : Spring Bean 설정 메타 정보
*
* BeanClassName : 생성할 빈의 클래스명
* factoryBeanName : 팩토리 역할의 빈 이름 ex) appConfig
* factoryMethodName : 빈을 생성할 팩토리 메서드 ex) memberService
* Scope : 싱글톤
* lazyInit : 스프링 컨테이너 생성 시, 빈을 바로 생성하지 않고 실제로 빈을 사용할 때까지 최대한 생성을 지연시킬지 여부
* InitMethodName : 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드명
* DestroyMethodName : 빈의 생명 주기가 끝나서 제거되기 직전에 호출되는 메서드명
* Constructor arguments, Properties: 의존관계 주입에서 사용
*/

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//  GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName" + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}