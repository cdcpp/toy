package org.ministar.toy.controller;

import lombok.Getter;
import lombok.Setter;
import org.ministar.toy.domain.Interests;
import org.springframework.security.crypto.password.PasswordEncoder;


@Getter
@Setter
public class JoinForm {


    public String Email;
    public String password;
    public String address1;

    public String address2;
    public Interests interests;


    public JoinForm(){

    }


    public JoinForm(String email, String password, Interests interests, String address1, String address2) {
        this.Email = email;
        this.password = password;
        this.interests = interests;
        this.address1 = address1;
        this.address2 = address2;
    }
}
