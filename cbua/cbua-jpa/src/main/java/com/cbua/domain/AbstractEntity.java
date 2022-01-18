package com.cbua.domain;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@Getter
public abstract class AbstractEntity {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    private UUID id;

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object other) {

        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (this.getClass() != ProxyUtils.getUserClass(other)) {
            return false;
        }
        var that = (AbstractEntity) other;
        return null != this.id && this.id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += (null == id) ? 0 : id.hashCode() * 31;
        return hashCode;
    }
}
