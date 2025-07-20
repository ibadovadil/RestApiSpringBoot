package com.rest.webservices.restful_web_services.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {
    private Integer id;
    @Size(min = 3, max = 20,message = "Name should be between 3 and 20 characters")
    private String name;
    @Past(message = "Birth date should be in the past")
    private LocalDate brithDate;

    public User(Integer id, String name, LocalDate brithDate) {
        this.id = id;
        this.name = name;
        this.brithDate = brithDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(LocalDate brithDate) {
        this.brithDate = brithDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brithDate=" + brithDate +
                '}';
    }
}
