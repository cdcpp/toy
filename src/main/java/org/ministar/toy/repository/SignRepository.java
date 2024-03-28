package org.ministar.toy.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.ministar.toy.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SignRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findMemberEmail(String email){
        return em.createQuery("select m from Member m where m.email = :email")
                .setParameter("email",email)
                .getResultList();
    }

}
