package projects.mbti.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import projects.mbti.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {em.persist(member);}

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByStudentId(Long id) {
        return em.createQuery("select m from Member m where m.studentId = :studentId", Member.class)
                .setParameter("studentId", id)
                .getResultList();
    }



}
