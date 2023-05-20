package projects.mbti.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.mbti.domain.Member;
import projects.mbti.repository.MemberRepository;


import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 멤버 등록
     */

    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByStudentId(member.getStudentId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 멤버입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }


}
