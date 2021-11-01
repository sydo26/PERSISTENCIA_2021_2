package com.trab01.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.mindrot.jbcrypt.BCrypt;

public class User extends Person {

    private UUID uuid;
    private String email;
    private String hashedPassword; // hashed

    @JsonIgnore
    private String type;

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }

    public static User createUser(String email, String password, String name, Integer age) {
        return new User(UUID.randomUUID(), email, User.hashPassword(password), name, age);
    }

    public User(UUID uuid, String email, String hashed_password, String name, Integer age) {
        super(name, age);
        this.uuid = uuid;
        this.email = email;
        this.hashedPassword = hashed_password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public User() {
        super();
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.hashedPassword);
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((hashedPassword == null) ? 0 : hashedPassword.hashCode());
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (hashedPassword == null) {
            if (other.hashedPassword != null)
                return false;
        } else if (!hashedPassword.equals(other.hashedPassword))
            return false;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    public String toCsvString() {
        return uuid + "\t" + getName() + "\t" + email + "\t" + hashedPassword + "\t" + getAge();
    }

    @Override
    public String toString() {
        return "[uuid=" + uuid + ", name=" + getName() + ", email=" + email + ", age=" + getAge() + "]";
    }
}
