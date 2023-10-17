package com.try_security.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    @EmbeddedId
    private CompositeKey compositeKey;
//    @Column(name="username")
//    private String username;
//    @Column(name="authority")
//    private String authority;

    public Authority(){}

    public CompositeKey getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(CompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }
}
