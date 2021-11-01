package com.trab01.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.trab01.App;
import com.trab01.model.User;

public class ReadRegister {
    private List<User> users;

    public ReadRegister() {
        this.users = new ArrayList<>();
    }

    public void read() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Storage.STORAGE_RESOURCE_PATH + "/" + Register.REGISTER_CSV_FILE_NAME));

        this.users.clear();
        String userRaw;

        while (scanner.hasNextLine()) {
            userRaw = scanner.nextLine();
            if (!userRaw.isEmpty()) {
                String[] userDataRaw = userRaw.split("\t");
                String uuid = userDataRaw[0];
                String name = userDataRaw[1];
                String email = userDataRaw[2];
                String hashed_password = userDataRaw[3];
                String age = userDataRaw[4];

                List<File> filesUsers = App.getFilesEntry(new File(Storage.STORAGE_RESOURCE_PATH + "/users"));

                boolean alreadyExists = false;
                for (File file : filesUsers) {
                    if (file.getName().contains(uuid)) {
                        alreadyExists = true;
                        break;
                    }
                }

                if (!alreadyExists) { // se não existir
                    User user = new User(UUID.fromString(uuid), email, hashed_password, name, Integer.valueOf(age));
                    this.users.add(user);
                }
            }

        }

    }

    public List<User> getUsers() {
        return users;
    }
}
