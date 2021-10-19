package com.atv020304.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

@JsonRootName("Pessoa")
public class Pessoa implements Serializable {

    @JacksonXmlProperty(localName = "name")
    private String name;

    @JacksonXmlProperty(localName = "cpf")
    private String cpf;

    @JacksonXmlProperty(localName = "phone")
    private String phone;

    public Pessoa() {
        super();
    }

    public Pessoa(String name, String cpf, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Pessoa { ");

        builder.append("name: \"" + name + "\", ");
        builder.append("cpf: \"" + cpf + "\", ");
        builder.append("phone: \"" + phone + "\" ");

        builder.append("}");

        return builder.toString();
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}
