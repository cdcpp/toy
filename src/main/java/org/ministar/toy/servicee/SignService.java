package org.ministar.toy.servicee;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ministar.toy.controller.JoinForm;
import org.ministar.toy.domain.Member;
import org.ministar.toy.repository.SignRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class SignService {

    private final SignRepository signRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long joinMember(JoinForm joinForm){
        Member member = new Member(joinForm.getEmail(),passwordEncoder.encode(joinForm.getPassword()),joinForm.getAddress1(),joinForm.getAddress2(),joinForm.getInterests());
        signRepository.save(member);
        return member.getId();
    }

    public Member findMember(Long id){
        return signRepository.findOne(id);
    }

}
