package com.cbua.address.domain;

import com.cbua.domain.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "cbua_address")
public class Address extends AbstractEntity {

    public Address(String addressOne, String addressTwo, String city, Integer zip, String country) {
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }

    @OneToMany(mappedBy = "address")
    public List<User> users = new ArrayList<>();

    public String addressOne;

    public String addressTwo;

    public String city;

    public Integer zip;

    public String country;
}
