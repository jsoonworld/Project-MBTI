package projects.mbti.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.mbti.domain.User;
import projects.mbti.repository.UserRepository;

import java.util.List;



@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
    }

    private void validateDuplicateUser(User user) {
        List<User> existingUsers = userRepository.findByStudentId(user.getStudentId());
        if (!existingUsers.isEmpty()) {
            throw new IllegalStateException("중복된 사용자입니다.");
        }
    }
}

