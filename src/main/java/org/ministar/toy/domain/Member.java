package org.ministar.toy.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    public Long id;

    public String email;
    public String password;
    public String addr;
    public String spec_addr;
    @Enumerated(EnumType.STRING)
    public Interests interests;

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
