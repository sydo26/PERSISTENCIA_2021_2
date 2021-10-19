package com.atv020304;

import java.io.IOException;

import com.atv020304.models.Pessoa;
import com.atv020304.models.Pessoas;
import com.atv020304.util.Desserializa;
import com.atv020304.util.Serializa;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

public final class App {
    public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

        Pessoas pessoas = new Pessoas();

        /** Adiciona as pessoas */
        pessoas.add(new Pessoa("Vini", "1295912952", "125125125"));
        pessoas.add(new Pessoa("Marcus", "12912512512", "12412412412"));
        pessoas.add(new Pessoa("Gabi", "2512512412512", "125124124214"));
        pessoas.add(new Pessoa("Roger", "43563262362", "661251241217"));
        pessoas.add(new Pessoa("Pedro", "1212614162", "1251231261261"));

        System.out.println("\nObjeto a ser deserializado:\n");
        System.out.println(pessoas);

        System.out.println("\n============================================\n");

        /** Salva nos arquivos determinados */
        Serializa<Pessoas> serializa = new Serializa<Pessoas>("resources/pessoas");
        if (serializa.xml(pessoas)) {
            System.out.println("SERIALIZA: Serializado para XML!");
        }

        if (serializa.json(pessoas)) {
            System.out.println("SERIALIZA: Serializado para JSON!");
        }

        if (serializa.apiJava(pessoas)) {
            System.out.println("SERIALIZA: Serializado para apiJava!");
        }

        /** Lê os arquivos determinados */
        Desserializa<Pessoas> deserializa = new Desserializa<Pessoas>("resources/pessoas", Pessoas.class);
        Pessoas ps1 = deserializa.xml();
        Pessoas ps2 = deserializa.json();
        Pessoas ps3 = deserializa.apiJava();

        System.out.println("\n============================================\n");

        System.out.println("\nResultados da deserialização:\n");
        System.out.println("(xml) " + ps1 + "\n");
        System.out.println("(json) " + ps2 + "\n");
        System.out.println("(apiJava) " + ps3 + "\n");

    }
}
