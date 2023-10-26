package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* Spring Bean을 등록하는 2가지 방법
 1. 컴포넌트 스캔과 자동 의존관계 설정 -> Controller, Service, Repository 어노테이션 선언
 2. 자바 코드로 직접 Bean 등록하기 */

// 여기서는 2번 방법을 구현, 후에 MemoryMemberRepository를 다른 Repository로 바꿀 예정이므로 수정이 용이한 방향으로 구현

@Configuration
public class SpringConfig {
   @Bean
   public MemberService memberService() {
       return new MemberService(memberRepository());
   }

   @Bean
    public MemberRepository memberRepository() {
       return new MemoryMemberRepository();
   }
}
