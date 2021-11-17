package com.lista04.database;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import org.postgresql.Driver;

public class PgConnection {
    private Connection connection = null;
    private String host, user, pass, database;
    private int port;

    public PgConnection(String host, String user, String pass, String database) {

        this.user = user;
        this.pass = pass != null ? pass.isBlank() || pass.isEmpty() ? null : pass : null;
        this.database = database;
        this.host = host;
        this.port = 5432;
    }

    public PgConnection(String host, String user, String pass, String database, int port) {
        this.user = user;
        this.pass = pass != null ? pass.isBlank() || pass.isEmpty() ? null : pass : null;
        this.database = database;
        this.host = host;
        this.port = port;
    }

    /** Inicia a conexão com o banco postgresql */
    public Connection start() {
        try {
            DriverManager.registerDriver(new Driver());
            String url = String.format("jdbc:postgresql://%s:%d/%s", host, port, database);

            this.connection = DriverManager.getConnection(url, user, pass != null ? pass : "");

            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void initDatabase(String fileName) throws IOException, SQLException {
        FileInputStream input = new FileInputStream("resources/" + fileName);

        Scanner scanner = new Scanner(input);

        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }

        this.connection.prepareStatement(builder.toString()).execute();

        scanner.close();
    }

    public void close() {
        try {
            this.connection.close();
            this.connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getHost() {
        return host;
    }

    public String getDatabase() {
        return database;
    }

    public String getPass() {
        return pass;
    }

    public int getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public Connection getConnection() {
        return connection;
    }
}
