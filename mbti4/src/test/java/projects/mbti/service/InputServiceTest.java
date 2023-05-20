package projects.mbti.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import projects.mbti.domain.Input;
import projects.mbti.repository.InputRepository;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InputServiceTest {

    @Autowired InputService inputService;

    @Autowired InputRepository inputRepository;

    @Autowired EntityManager em;

    @Test
    public void mbti입력확인하기() throws Exception {
        //given
        Input input = new Input();
        input.setEI("E");
        input.setNS("N");
        input.setFT("T");
        input.setJP("J");

        //when
        // Input savedInput = inputRepository.save(input);
        inputRepository.save(input);
        Input savedInput = inputRepository.findOne(input.getId());

        //then

        assertEquals(input, inputRepository.findOne(input.getId()));
        assertEquals(input.getEI(), savedInput.getEI());
        assertEquals(input.getNS(), savedInput.getNS());
        assertEquals(input.getFT(), savedInput.getFT());
        assertEquals(input.getJP(), savedInput.getJP());
        assertEquals(input.getMbtiResult(), savedInput.getMbtiResult());

    }

}