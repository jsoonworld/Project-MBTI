package projects.mbti.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import projects.mbti.domain.input.Input;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StaticsRepository {

    private final EntityManager em;
    public List<Input> findAll() { //통계에서
        return em.createQuery("select  i from Input i", Input.class)
                .getResultList();
    }
}
