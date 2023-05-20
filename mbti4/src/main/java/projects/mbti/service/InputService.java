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
    public Long save(Input input) {
        inputRepository.save(input);
        return input.getId();
    }

    public Input findOne(Long itemId) {
        return inputRepository.findOne(itemId);
    }

    public List<Input> findByResultMbti(String resultMbti) {
        return inputRepository.findByMbtiResult(resultMbti);
    }

    public List<Input> findByMbtiSplitedEI(String EI) {
        return inputRepository.findByMbtiSplitedEI(EI);
    }
    public List<Input> findByMbtiSplitedNS(String NS) {
        return inputRepository.findByMbtiSplitedNS(NS);
    }
    public List<Input> findByMbtiplitedFT(String FT) {
        return inputRepository.findByMbtiSplitedFT(FT);
    }
    public List<Input> findByMbtiSplitedJP(String JP) {
        return inputRepository.findByMbtiSplitedJP(JP);
    }


}
