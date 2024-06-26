package com.healthacta.common.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @Column(name = "id")
    private short id;

    @Column(name = "name")
    private String name;

    @Column(name = "biological")
    private boolean biological;

    public Gender(short id, String name) {
        this.id = id;
        this.name = name;
        this.biological = false;
    }

    public Gender(short id, String name, boolean bio) {
        this.id = id;
        this.name = name;
        this.biological = bio;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBiological() {
        return biological;
    }

    public void setBiological(boolean biological) {
        this.biological = biological;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (biological ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Gender other = (Gender) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (biological != other.biological)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Gender [id=" + id + ", name=" + name + ", biological=" + biological + "]";
    }

}
