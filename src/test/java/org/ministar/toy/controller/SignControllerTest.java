package org.ministar.toy.controller;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.ministar.toy.domain.Interests;
import org.ministar.toy.domain.Member;
import org.ministar.toy.servicee.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SignControllerTest {

    @Autowired
    private SignService signService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Rollback
    void joinMember() {


        //given
        String email = "email@email.com";
        String pwd = passwordEncoder.encode("123123");
        String plainPwd = "123123";
        String addr1 = "고양시";
        String addr2 = "원흥동";
        Interests interests = Interests.STOCK;

        JoinForm joinForm = new JoinForm(email,plainPwd,interests,addr1,addr2);


        //when
        Long memberId = signService.joinMember(joinForm);
        em.flush();
        em.clear();
        Member findMember = signService.findMember(memberId);

        //then
        assertEquals(email , findMember.getEmail());
        assertEquals(true , passwordEncoder.matches(plainPwd , findMember.getPassword()));
        assertEquals(addr1 , findMember.getAddr());
        assertEquals(addr2 , findMember.getSpec_addr());
        assertEquals(interests , findMember.getInterests());
    }
}