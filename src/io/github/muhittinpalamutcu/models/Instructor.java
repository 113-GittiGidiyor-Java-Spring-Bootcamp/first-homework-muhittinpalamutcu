package io.github.muhittinpalamutcu.models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Objects;

@Entity
public class Instructor extends Person {
    private String phoneNumber;

    public Instructor(String name, String address, String phoneNumber) {
        super(name, address);
        this.phoneNumber = phoneNumber;
    }

    public Instructor(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Instructor(){

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumber);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
