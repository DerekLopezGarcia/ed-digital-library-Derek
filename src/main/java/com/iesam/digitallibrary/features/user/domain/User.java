package com.iesam.digitallibrary.features.user.domain;

import java.awt.desktop.AppReopenedEvent;

public class User {
    protected String name;
    protected String email;
    protected String DNI;

    public User(String name, String email, String DNI) {
        this.name = name;
        this.email = email;
        this.DNI = DNI;
    }

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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
