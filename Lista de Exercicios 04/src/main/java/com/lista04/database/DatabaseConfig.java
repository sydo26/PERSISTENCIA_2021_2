package com.lista04.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class DatabaseConfig {

    private String fileName;
    private Reader file;
    protected Map<String, Object> yamlMap;
    protected Yaml yaml;

    public String user, pass, database, host;
    public int port;

    public DatabaseConfig(String fileName) {
        this.fileName = String.format("resources/%s", fileName);
        this.yaml = new Yaml();
        try {
            this.file = new FileReader(this.fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DatabaseConfig load() throws IOException {
        this.yamlMap = yaml.load(this.file);

        Map<String, Object> postgres = (Map<String, Object>) yamlMap.get("postgres");

        this.host = (String) postgres.get("host");
        this.user = (String) postgres.get("user");
        this.pass = (String) postgres.get("pass");
        this.database = (String) postgres.get("database");
        this.port = (int) postgres.get("port");

        this.file.close();
        return this;
    }

    public String getFileName() {
        return fileName;
    }

}
