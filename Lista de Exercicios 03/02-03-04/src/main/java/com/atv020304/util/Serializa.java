package com.atv020304.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Serializa<T> {
    private String prefix;

    public Serializa(String filePrefix) {
        this.prefix = filePrefix;
    }

    public boolean apiJava(T obj) {
        try {
            FileOutputStream output = new FileOutputStream(new File(this.prefix + ".txt"));
            ObjectOutputStream stream = new ObjectOutputStream(output);

            stream.writeObject(obj);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean json(T obj) {

        ObjectMapper om = new ObjectMapper();

        try {
            om.writeValue(new File(this.prefix + ".json"), obj);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean xml(T obj) {
        XmlMapper xm = new XmlMapper();
        try {
            xm.writeValue(new File(this.prefix + ".xml"), obj);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
