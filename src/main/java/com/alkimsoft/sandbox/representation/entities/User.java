package com.alkimsoft.sandbox.representation.entities;

import com.alkimsoft.sandbox.representation.core.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by doğukan on 28.06.2016.
 */
@Entity
public class User extends BaseEntity {
    private String name;
    private String surname;
    private String job;

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
