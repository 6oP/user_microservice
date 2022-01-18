package com.cbua.address.domain;

import com.cbua.domain.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "cbua_user")
public class User extends AbstractEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id")
    private Address address;

    private UUID userId;

    public User(Address address, UUID userId) {
        this.address = address;
        this.userId = userId;
    }
}
