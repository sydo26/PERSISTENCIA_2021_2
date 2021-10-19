package com.atv020304.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Desserializa<T> {
    private String prefix;
    private Class<T> type;

    public Desserializa(String filePrefix, Class<T> type) {
        this.prefix = filePrefix;
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public T apiJava() {
        try {
            FileInputStream output = new FileInputStream(new File(this.prefix + ".txt"));
            ObjectInputStream stream = new ObjectInputStream(output);

            Object obj = stream.readObject();

            output.close();
            stream.close();
            return (T) obj;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }

    }

    public T json() {

        ObjectMapper om = new ObjectMapper();

        try {
            return om.readValue(new File(this.prefix + ".json"), type);
        } catch (IOException e) {
            return null;
        }
    }

    public T xml() {

        XmlMapper xm = new XmlMapper();
        try {
            return xm.readValue(new File(this.prefix + ".xml"), type);
        } catch (IOException e) {
            return null;
        }
    }
}
