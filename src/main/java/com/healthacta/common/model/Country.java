package com.healthacta.common.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Country {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;

    @Column(name = "phone_code")
    private int phoneCode;

    @Column(name = "name")
    private String name;

    @Column(name = "official_name")
    private String officialName;

    @Column(name = "iso_alpha_2")
    private String isoAlpha2;

    @Column(name = "iso_alpha_3")
    private String isoAlpha3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(int phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getIsoAlpha2() {
        return isoAlpha2;
    }

    public void setIsoAlpha2(String isoAlpha2) {
        this.isoAlpha2 = isoAlpha2;
    }

    public String getIsoAlpha3() {
        return isoAlpha3;
    }

    public void setIsoAlpha3(String isoAlpha3) {
        this.isoAlpha3 = isoAlpha3;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + phoneCode;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((officialName == null) ? 0 : officialName.hashCode());
        result = prime * result + ((isoAlpha2 == null) ? 0 : isoAlpha2.hashCode());
        result = prime * result + ((isoAlpha3 == null) ? 0 : isoAlpha3.hashCode());
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
        Country other = (Country) obj;
        if (id != other.id)
            return false;
        if (phoneCode != other.phoneCode)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (officialName == null) {
            if (other.officialName != null)
                return false;
        } else if (!officialName.equals(other.officialName))
            return false;
        if (isoAlpha2 == null) {
            if (other.isoAlpha2 != null)
                return false;
        } else if (!isoAlpha2.equals(other.isoAlpha2))
            return false;
        if (isoAlpha3 == null) {
            if (other.isoAlpha3 != null)
                return false;
        } else if (!isoAlpha3.equals(other.isoAlpha3))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Country [id=" + id + ", phoneCode=" + phoneCode + ", name=" + name + 
               ", officialName=" + officialName + ", isoAlpha2=" + isoAlpha2 + 
               ", isoAlpha3=" + isoAlpha3 + "]";
    }

}
