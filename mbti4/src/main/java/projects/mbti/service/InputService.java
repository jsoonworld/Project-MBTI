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
    public void saveInput(Input input) {
        inputRepository.save(input);
    }

    public Input findOne(Long itemId) {
        return inputRepository.findOne(itemId);
    }

    public List<Input> findResultMbti(String resultMbti) {
        return inputRepository.findByMbtiResult(resultMbti);
    }

    






}
