package projects.mbti.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import projects.mbti.domain.Member;
import projects.mbti.repository.MemberRepository;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 멤버_가입() throws Exception {
        //given
        Member member = new Member();
        member.setStudentId(20191764L);

        //when
        Long saveId = memberService.join(member);
        List<Member> members = memberRepository.findByStudentId(member.getStudentId());

        //then

        assertEquals(member, memberRepository.findOne(saveId));
        assertEquals(member, members.get(0));

    }


    @Test(expected = IllegalStateException.class)
    public void 중복_멤버_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setStudentId(20191764L);

        Member member2 = new Member();
        member2.setStudentId(20191764L);

        //when
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야 한다!!!

        memberRepository.findByStudentId(member1.getStudentId());
        memberRepository.findByStudentId(member2.getStudentId());

        //then
        fail("예외가 발생해야 한다.");
    }


}