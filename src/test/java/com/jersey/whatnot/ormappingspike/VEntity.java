package com.jersey.whatnot.ormappingspike;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v", schema = "public", catalog = "pgdbtest")
public class VEntity {
    private Integer uid;
    private Integer rVIId;

    @Id
    @Column(name = "uid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "r_v_i_id", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getrVIId() {
        return rVIId;
    }

    public void setrVIId(Integer rVIId) {
        this.rVIId = rVIId;
    }

    @Override
    public String toString() {
        return getUid().toString() + " : " + getrVIId();
    }
}
