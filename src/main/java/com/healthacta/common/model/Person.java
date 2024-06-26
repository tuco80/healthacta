package com.healthacta.common.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends AuditMetadata{

    @Id
    @Column(name = "id")
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "preferred_name")
    private String preferredName;

    @Column(name = "physiological_gender_fk")
    @Enumerated(EnumType.ORDINAL)
    private Gender physiologicalGender;

    @Column(name = "preferred_gender_fk")
    @Enumerated(EnumType.ORDINAL)
    private Gender preferredGender;

    @Column(name = "government_id")
    private String governmentId;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(name = "date_of_decease")
    private LocalDateTime dateOfDecease;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(String governmentId) {
        this.governmentId = governmentId;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getDateOfDecease() {
        return dateOfDecease;
    }

    public void setDateOfDecease(LocalDateTime dateOfDecease) {
        this.dateOfDecease = dateOfDecease;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((preferredName == null) ? 0 : preferredName.hashCode());
        result = prime * result + ((governmentId == null) ? 0 : governmentId.hashCode());
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        result = prime * result + ((dateOfDecease == null) ? 0 : dateOfDecease.hashCode());
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
        Person other = (Person) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (middleName == null) {
            if (other.middleName != null)
                return false;
        } else if (!middleName.equals(other.middleName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (preferredName == null) {
            if (other.preferredName != null)
                return false;
        } else if (!preferredName.equals(other.preferredName))
            return false;
        if (governmentId == null) {
            if (other.governmentId != null)
                return false;
        } else if (!governmentId.equals(other.governmentId))
            return false;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (dateOfDecease == null) {
            if (other.dateOfDecease != null)
                return false;
        } else if (!dateOfDecease.equals(other.dateOfDecease))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", middleName=" + middleName + 
                ", lastName=" + lastName + ", preferredName=" + preferredName + 
                ", governmentId=" + governmentId + ", dateOfBirth=" + dateOfBirth
                + ", dateOfDecease=" + dateOfDecease + "]";
    }

}
