package org.ministar.toy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ministar.toy.domain.Member;
import org.ministar.toy.servicee.SignService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SignController {

    private final SignService signService;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("hello","hello");
        return "/sign/login";
    }

    @GetMapping("/join")
    public String joinForm(Model model){
        model.addAttribute("joinForm",new JoinForm());
        return "/sign/join";
    }

    @PostMapping("/join")
    public String joinMember(JoinForm joinForm){
        Member member = new Member(joinForm.getEmail(),joinForm.getPassword(),joinForm.getAddress1(),joinForm.getAddress2(),joinForm.getInterests());
        signService.joinMember(member);


        return "redirect:/login";
    }

}
