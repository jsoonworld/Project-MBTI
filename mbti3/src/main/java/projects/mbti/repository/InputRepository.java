package projects.mbti.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import projects.mbti.domain.Input;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InputRepository {
    private final EntityManager em;

    public void save(Input input){
        em.persist(input);
    }

    public List<Input> findByFullOfMbti(String fullOfMbti) {
        return em.createQuery("SELECT i FROM Input i WHERE i.fullOfMbti = :fullOfMbti", Input.class)
                .setParameter("fullOfMbti", fullOfMbti)
                .getResultList();
    }
}
