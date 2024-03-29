# Spring Core - Basic
### Inflearn
[스프링 핵심 원리 - 기본편](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8)

***

### 비즈니스 요구사항과 설계
#### 회원
1. 회원 가입 및 조회
2. 회원 등급은 BASIC, VIP
3. 회원 데이터는 자체 구축한 DB 혹은 외부 시스템 연동 (미정)

![image](https://github.com/hayeong25/Spring_core_basic/assets/76962775/59be3076-02e7-437a-9e92-ab3055398608)

![image](https://github.com/hayeong25/Spring_core_basic/assets/76962775/80e10b80-9dd5-4690-81e9-44042858ecaa)

***

#### 주문과 할인 정책
1. 회원은 상품을 주문할 수 있다.
2. 회원 등급에 따라 할인 정책 적용
3. 모든 VIP 등급은 1,000원 할인해주는 고정 금액 할인 적용 (추후 변동 가능)
4. 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못 했고, 오픈 직전까지 고민을 미루고 싶다. 최악의 경우 할인을 적용하지 않을 수도 있다. (미정)

![image](https://github.com/hayeong25/Spring_core_basic/assets/76962775/7477b3b3-c866-49a9-b0e6-4ac4823f7b01)

![image](https://github.com/hayeong25/Spring_core_basic/assets/76962775/422ad80d-f06d-4914-97d6-136f6a0f9f2b)

***

#### 새로운 할인 정책
1. 고정 금액 할인이 아닌 정률 10% 할인으로 변경

![image](https://github.com/hayeong25/Spring_core_basic/assets/76962775/19850cca-5fe2-4b5e-98ae-1dc68debe402)

***

### 관심사의 분리
#### AppConfig : 구현 객체를 생성하고 의존관계 연결하는 설정 클래스

![image](https://github.com/hayeong25/Spring_core_basic/assets/76962775/4e43f233-3fbb-4b23-babd-2bcf234f7b60)

***

### Spring Bean
#### ApplicationContext : Spring Container
#### BeanFactory : Spring Container의 최상위 인터페이스. Spring Bean 관리 및 조회

![image](https://github.com/hayeong25/Spring_core_basic/assets/76962775/33494a6e-9c59-4b89-be49-48de8185c9c1)

![image](https://github.com/hayeong25/Spring_core_basic/assets/76962775/6b736807-80c0-40f1-a953-3517d421e11c)

***

