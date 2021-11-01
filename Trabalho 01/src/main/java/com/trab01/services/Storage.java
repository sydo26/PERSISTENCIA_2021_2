package com.trab01.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.trab01.App;
import com.trab01.model.User;

public class Storage {

    public static final String STORAGE_RESOURCE_PATH = "./data";
    private String fileNameWithoutExt;

    public Storage(String fileNameWithoutExt, String pathFolder) {
        this.fileNameWithoutExt = Storage.STORAGE_RESOURCE_PATH + "/" + pathFolder + "/" + fileNameWithoutExt;
        try {
            Files.createDirectories(Paths.get(Storage.STORAGE_RESOURCE_PATH + "/" + pathFolder + "/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readAll(String pathFolder) {
        List<User> users = new ArrayList<>();
        List<File> filesUsers = App.getFilesEntry(new File(Storage.STORAGE_RESOURCE_PATH + "/" + pathFolder));

        for (File file : filesUsers) {
            // read json
            if (file.getName().contains(".json")) {
                ObjectMapper om = new ObjectMapper();

                try {
                    User user = om.readValue(file, User.class);
                    user.setType("JSON");
                    users.add(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (file.getName().contains(".xml")) {
                XmlMapper xm = new XmlMapper();
                try {
                    User user = xm.readValue(file, User.class);
                    user.setType("XML");
                    users.add(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return users;

    }

    public boolean saveJson(User user) {
        ObjectMapper om = new ObjectMapper();

        try {
            om.writeValue(new File(this.fileNameWithoutExt + ".json"), user);
            System.out.println();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveXml(User user) {
        XmlMapper xm = new XmlMapper();
        try {
            xm.writeValue(new File(this.fileNameWithoutExt + ".xml"), user);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
