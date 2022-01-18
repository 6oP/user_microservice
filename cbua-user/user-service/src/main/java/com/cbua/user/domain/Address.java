package com.cbua.user.domain;

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
@Table(name = "cbua_address")
public class Address extends AbstractEntity {


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private UUID addressId;

    public Address(User user, UUID addressId) {
        this.user = user;
        this.addressId = addressId;
    }
}
