package projects.mbti.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.mbti.domain.input.Input;
import projects.mbti.repository.InputRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InputService {

    private final InputRepository inputRepository;

    @Transactional
    public void saveItem(Input item) {
        inputRepository.save(item);
    }

    public Input findOne(Long inputId) {
        return inputRepository.findOne(inputId);
    }


}
