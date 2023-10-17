package com.try_security.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class CompositeKey implements Serializable {
    @Column(name="authority")
    private String authority;
    @Column(name="username")
    private String username;
    public CompositeKey(){}

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
