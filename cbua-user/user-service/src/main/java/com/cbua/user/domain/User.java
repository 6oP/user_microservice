package com.cbua.user.domain;

import com.cbua.domain.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "cbua_user")
public class User extends AbstractEntity {

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @OneToMany(mappedBy = "user")
    private List<Address> addresses = new ArrayList<>();

    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String password;
}

