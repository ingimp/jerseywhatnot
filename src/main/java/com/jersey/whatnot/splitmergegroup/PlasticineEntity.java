package com.jersey.whatnot.splitmergegroup;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "plasticine")
public class PlasticineEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "plasticine_relation",
            joinColumns = {@JoinColumn(name = "oldPlasticineId")},
            inverseJoinColumns = {@JoinColumn(name = "newPlasticineId")})
    private Set<PlasticineEntity> children = new HashSet<PlasticineEntity>();

    @ManyToMany(mappedBy = "children")
    private Set<PlasticineEntity> parents = new HashSet<PlasticineEntity>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<PlasticineEntity> getChildren() {
        return children;
    }

    public void setChildren(Set<PlasticineEntity> children) {
        this.children = children;
    }

    public Set<PlasticineEntity> getParents() {
        return parents;
    }

    public void setParents(Set<PlasticineEntity> parents) {
        this.parents = parents;
    }

    boolean isSingle() {
        return getParents().size() == 0 && getChildren().size() == 0;
    }

    boolean isMiddleStatus() {
        return getParents().size() > 0 && getChildren().size() > 0;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
