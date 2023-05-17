package projects.mbti.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import projects.mbti.domain.Input;
import projects.mbti.domain.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InputRepository {
    private final EntityManager em;
    public void save(Input input) {
        em.persist(input);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);}

    public List<Input> findAllOfMbti(String allOfInputs) {
        return em.createQuery("SELECT a FROM Input a WHERE a.allOfInputs = :allOfInputs", Input.class)
                .setParameter("allOfInputs", allOfInputs)
                .getResultList();
    }

}
