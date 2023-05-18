package projects.mbti.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.mbti.domain.User;
import projects.mbti.repository.UserRepository;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long login(User user){
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user){
        List<User> findUsers = userRepository.findByStudentId(user.getStudentId());
        if(!findUsers.isEmpty()){
            throw new IllegalStateException("중복입니다.");
        }
    }
}
