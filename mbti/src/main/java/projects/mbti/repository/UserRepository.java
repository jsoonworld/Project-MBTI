package projects.mbti.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import projects.mbti.domain.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public void save(User user) {em.persist(user);}

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select m from User m", User.class)
                .getResultList();
    }

    public List<User> findByStudentId(Long id) {
        return em.createQuery("select m from User m where m.studentId = :studentId", User.class)
                .setParameter("studentId", id)
                .getResultList();
    }
}
