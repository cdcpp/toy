package org.ministar.toy.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    public Long id;

    private String email;
    private String password;
    private String addr;
    private String spec_addr;
    @Enumerated(EnumType.STRING)
    private Interests interests;

    @Enumerated(EnumType.STRING)
    private Role role;


    public Member(String email, String password, String addr, String spec_addr, Interests interests) {
        this.email = email;
        this.password = password;
        this.addr = addr;
        this.spec_addr = spec_addr;
        this.interests = interests;
    }

    protected Member() {

    }
}
