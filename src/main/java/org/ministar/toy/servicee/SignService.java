package org.ministar.toy.servicee;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ministar.toy.domain.Member;
import org.ministar.toy.repository.SignRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class SignService {

    private final SignRepository signRepository;


    @Transactional
    public Long joinMember(Member member){
       signRepository.save(member);
       return member.getId();
    }

    public Member findMember(Long id){
        return signRepository.findOne(id);
    }

}
