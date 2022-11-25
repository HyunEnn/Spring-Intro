package First.FirstSpring;

import First.FirstSpring.repository.MemberRepository;
import First.FirstSpring.repository.MemoryMemberRepository;
import First.FirstSpring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    // memberRepositoryf를 스프링 컨테이너에 주입시키고 MemberService 에 주입시킨 repository
    // 넣고 MemberService를 스프링 컨테이너에 주입시킨다.

}
