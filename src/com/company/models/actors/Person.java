package com.company.models.actors;

import com.company.models.Address;
import com.company.models.Auditable;
import jdk.nashorn.internal.objects.annotations.Getter;

public abstract class Person extends Auditable {
    String name;
    String email;
    Address address;
    String password;
    Account account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
