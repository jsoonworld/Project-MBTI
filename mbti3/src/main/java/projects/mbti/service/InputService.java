package projects.mbti.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.mbti.domain.Input;
import projects.mbti.repository.InputRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InputService {
    private final InputRepository inputRepository;

    @Transactional
    public Long saveInput(String EI, String NS, String FT, String JP) {
        Input input = new Input(EI, NS, FT, JP);
        validateDuplicateUser(input);
        inputRepository.save(input);
        return input.getId();
    }

    private void validateDuplicateUser(Input input) {
        List<Input> findMbti = inputRepository.findByFullOfMbti(input.getFullOfMbti());
        if (!findMbti.isEmpty()) {
            throw new IllegalStateException("이미 MBTI를 입력하였습니다.");
        }
    }




}
