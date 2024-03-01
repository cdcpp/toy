package org.ministar.toy.controller;

import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.ministar.toy.domain.Interests;
import org.ministar.toy.utils.ShaUtil;


@Getter
@Setter
public class JoinForm {

    public String Email;
    public String password;
    public Interests interests;
    public String address1;
    public String address2;


    public void setPassword(String password) {
        ShaUtil sha = new ShaUtil();
        this.password = sha.sha256Encode(password);
    }

}
