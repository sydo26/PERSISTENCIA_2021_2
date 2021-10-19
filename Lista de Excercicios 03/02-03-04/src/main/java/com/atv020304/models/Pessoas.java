package com.atv020304.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

@JsonRootName("Pessoas")
public class Pessoas implements Serializable {

    @JacksonXmlProperty(localName = "Pessoa")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Pessoa> pessoas;

    public Pessoas() {
        super();
        this.pessoas = new ArrayList<Pessoa>();
    }

    public void add(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Pessoas [ \n");
        for (Pessoa pessoa : pessoas) {
            builder.append("\t" + pessoa + "\n");
        }

        builder.append("]");

        return builder.toString();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
