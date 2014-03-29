package com.jersey.whatnot.ormappingspike;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "dc")
public class DcEntity {
    private Integer uid;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "uid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return getUid().toString();
    }
}
