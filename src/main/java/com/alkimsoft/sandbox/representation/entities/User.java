package com.alkimsoft.sandbox.representation.entities;

/**
 * Created by doğukan on 28.06.2016.
 */
public class User {
private String name;
    private String surname;
    private String jop;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }
}
