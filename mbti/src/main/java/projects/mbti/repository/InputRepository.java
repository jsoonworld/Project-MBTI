package projects.mbti.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import projects.mbti.domain.input.Input;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InputRepository {

    private final EntityManager em;

    public void save(Input input) {
        if (input.getId() == null) {
            em.persist(input);
        } else {
            em.merge(input);
        }
    }

    public Input findOne(Long id) {
        return em.find(Input.class, id);
    }

    public List<Input> findAll() {
        return em.createQuery("select  i from Input i", Input.class)
                .getResultList();
    }


}
