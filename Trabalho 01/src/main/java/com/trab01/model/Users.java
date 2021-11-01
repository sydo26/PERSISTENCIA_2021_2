package com.trab01.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonRootName("Users")
public class Users implements Serializable {

    @JacksonXmlProperty(localName = "User")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<User> users;

    public Users() {
        super();
    }

    public void add(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
