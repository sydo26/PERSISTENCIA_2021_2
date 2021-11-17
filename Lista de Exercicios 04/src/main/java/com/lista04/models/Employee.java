package com.lista04.models;

public class Employee {
    private Integer id, registration;
    private String cpf, name, email, phone;

    /** Create employee object */
    public static Employee create(String name, String email, String phone, String cpf) {
        Employee e = new Employee();
        e.setCpf(cpf);
        e.setEmail(email);
        e.setName(name);
        e.setPhone(phone);

        return e;
    }

    public Employee(int id, int registration, String name, String email, String phone, String cpf) {
        this.id = id;
        this.registration = registration;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Employee() {
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return String.format("%-7d\t%-9d\t%-20s\t%-20s\t%-11s\t%-11s", id, registration, name, email, phone, cpf);
    }

}
