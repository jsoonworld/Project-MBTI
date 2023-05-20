package projects.mbti.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import projects.mbti.domain.Input;
import projects.mbti.domain.Member;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InputRepository {

    private final EntityManager em;

    public void save(Input input) {em.persist(input);}


    public Input findOne(Long id) {
        return em.find(Input.class, id);
    }

    public List<Input> findAll() {
        return em.createQuery("select i from Input i", Input.class)
                .getResultList();
    }

    public List<Input> findByMbtiSplitedEI(String EI) {
        return em.createQuery("select i from Input i where i.EI = :EI", Input.class)
                .setParameter("EI", EI)
                .getResultList();
    }

    public List<Input> findByMbtiSplitedNS(String NS) {
        return em.createQuery("select i from Input i where i.NS = :NS", Input.class)
                .setParameter("NS", NS)
                .getResultList();
    }

    public List<Input> findByMbtiSplitedFT(String FT) {
        return em.createQuery("select i from Input i where i.FT = :FT", Input.class)
                .setParameter("FT", FT)
                .getResultList();
    }

    public List<Input> findByMbtiSplitedJP(String JP) {
        return em.createQuery("select i from Input i where i.JP = :JP", Input.class)
                .setParameter("JP", JP)
                .getResultList();
    }


    public List<Input> findByMbtiResult(String mbtiResult) {
        return em.createQuery("select i from Input i where i.mbtiResult = :mbtiResult", Input.class)
                .setParameter("mbtiResult", mbtiResult)
                .getResultList();
    }


}
