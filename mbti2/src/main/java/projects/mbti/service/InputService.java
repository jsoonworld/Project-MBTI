package projects.mbti.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.mbti.TendencyStatus;
import projects.mbti.domain.Input;
import projects.mbti.domain.User;
import projects.mbti.repository.InputRepository;
import projects.mbti.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InputService {

    private final InputRepository inputRepository;



    private void validateDuplicateUser(Input input) {
        List<Input> findMbti = inputRepository.findAllOfMbti(input.getAllOfInputs());
        if (!findMbti.isEmpty()) {
            throw new IllegalStateException("이미 MBTI를 입력하였습니다.");
        }
    }

}
