package hello.spring;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final MemberRepository memberRepository;

    public Controller(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    
    // @GetMapping("/")
    // public String hello(){
    //     return "hello";
    // }
    @GetMapping("/{username}/{password}")
    public Member save(@PathVariable String username, @PathVariable String password){
        Member member = new Member(null, username, password);
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }

    @GetMapping("/list")
    public List<Member> findAll(){
        List<Member> members = memberRepository.findAll();
        return members;
    }
}
