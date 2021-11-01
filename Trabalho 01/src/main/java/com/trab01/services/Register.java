package com.trab01.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import com.trab01.model.User;

public class Register {
    public static final String REGISTER_CSV_FILE_NAME = "data.csv";

    private PrintWriter writer = null;
    private File file;

    public Register() {
        this.file = new File(Storage.STORAGE_RESOURCE_PATH + "/" + Register.REGISTER_CSV_FILE_NAME);
    }

    public void open() throws FileNotFoundException {
        this.writer = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(this.file, true), StandardCharsets.UTF_8));
    }

    public void close() throws IOException {
        if (this.writer != null)
            this.writer.close();
    }

    public boolean append(User user) throws IOException {
        try {
            // this.output.write(user.toCsvString().getBytes());
            this.writer.println(user.toCsvString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
