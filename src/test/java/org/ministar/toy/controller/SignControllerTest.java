package org.ministar.toy.controller;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ministar.toy.domain.Interests;
import org.ministar.toy.domain.Member;
import org.ministar.toy.servicee.SignService;
import org.ministar.toy.utils.ShaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SignControllerTest {

    @Autowired
    SignService signService;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    @Rollback
    void joinMember() {


        //given
        ShaUtil sha = new ShaUtil();
        String email = "email@email.com";
        String pwd = sha.sha256Encode("123123");
        String addr1 = "고양시";
        String addr2 = "원흥동";
        String interests = "STOCK";

        Member member = new Member(email,pwd,addr1,addr2,Interests.STOCK);

        //when
        Long memberId = signService.joinMember(member);
        em.flush();
        em.clear();
        Member findMember = signService.findMember(memberId);

        //then
        assertEquals(email , findMember.getEmail());
        assertEquals(pwd , findMember.getPassword());
        assertEquals(addr1 , findMember.getAddr());
        assertEquals(addr2 , findMember.getSpec_addr());
        assertEquals(interests , findMember.getInterests().toString());
    }
}