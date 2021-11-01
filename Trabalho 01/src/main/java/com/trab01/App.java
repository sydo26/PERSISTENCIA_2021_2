package com.trab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trab01.interfaces.MenuCallback;
import com.trab01.interfaces.VarScannerCallback;
import com.trab01.model.User;
import com.trab01.services.Menu;
import com.trab01.services.MenuOptionPrint;
import com.trab01.services.ReadRegister;
import com.trab01.services.Register;
import com.trab01.services.Storage;
import com.trab01.services.VarScanner;

public class App {

    public static List<File> getFilesEntry(final File folder) {
        List<File> files = new ArrayList<File>();
        if (folder.exists()) {

            for (final File fileEntry : folder.listFiles()) {
                if (!fileEntry.isDirectory()) {
                    files.add(fileEntry);
                }
            }
        }

        return files;
    }

    public static void main(String[] args) throws IOException {
        System.setProperty("file.encoding", "UTF-8");
        Menu menu = new Menu();

        menu.addOption("Registrar usuários", 1, new MenuCallback() {

            @Override
            public void callback(String key, Scanner scanner) {
                MenuOptionPrint printer = new MenuOptionPrint();

                printer.saveln("\n[" + key.toUpperCase() + "]\n");

                int nameIdx = printer.save("Qual seu nome?\n>");
                String name = VarScanner.nextName(scanner, new VarScannerCallback() {
                    @Override
                    public void callback(String line) {
                        Menu.clearScreen();
                        printer.error("Nome inválido, não se poder ter caracteres especiais fora o espaço.");
                        printer.print();
                    }
                });

                Menu.clearScreen();
                printer.updateAndPrint(nameIdx, name);

                int emailIdx = printer.save("\nAgora informe um e-mail.\n>");
                String email = VarScanner.nextEmail(scanner, new VarScannerCallback() {
                    @Override
                    public void callback(String line) {
                        Menu.clearScreen();
                        printer.error("E-mail inválido, digite um e-mail como o exemplo: example@gmail.com");
                        printer.print();
                    }
                });
                Menu.clearScreen();
                printer.updateAndPrint(emailIdx, email);

                int ageIdx = printer.save("\nQuantos anos você tem?\n>");

                int age = VarScanner.nextAge(scanner, new VarScannerCallback() {
                    @Override
                    public void callback(String line) {
                        Menu.clearScreen();
                        printer.error("A idade deve se um número inteiro de 1 até no máximo 200.");
                        printer.print();

                    }
                });
                Menu.clearScreen();
                printer.updateAndPrint(ageIdx, String.valueOf(age) + " anos");

                int passIdx = printer.save("\nInforme uma senha.\n>");
                String password = VarScanner.nextPassword(scanner, new VarScannerCallback() {
                    @Override
                    public void callback(String line) {
                        Menu.clearScreen();
                        printer.error("A senha deve ter no mínimo 4 e no máximo 30 caracteres.");
                        printer.print();
                    }
                });

                Menu.clearScreen();
                printer.updateAndPrint(passIdx, password);

                Menu.clearScreen();
                printer.println();

                printer.save("\nDeseja cadastrar essas informações? (S/N)\nSim > ");

                String response = scanner.nextLine();
                if ("n não nao no".indexOf(response.toLowerCase()) < 0 || response.isEmpty()) {

                    Register register = new Register();

                    try {
                        register.open();
                        register.append(User.createUser(email, password, name, age));
                        register.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Menu.clearScreen();
                    System.out.println("Dados salvos com sucesso! Pressione enter para voltar ao menu.\n");
                    System.out.print("[ENTER] ");
                    scanner.nextLine();
                }

            }
        });

        menu.addOption("Serializar usuários registrados", 2, new MenuCallback() {
            @Override
            public void callback(String key, Scanner scanner) {
                MenuOptionPrint printer = new MenuOptionPrint();
                printer.saveln("\n[" + key.toUpperCase() + "]\n");

                ReadRegister readRegister = new ReadRegister();
                try {
                    readRegister.read();
                    if (readRegister.getUsers().size() == 0) {
                        System.out.println(
                                "Nenhum usuário disponível para serialização. Pressione enter para voltar ao menu.\n");
                        System.out.print("[ENTER] ");
                        scanner.nextLine();
                        return;
                    }
                    printer.saveln("Usuários registrados:\n");
                    printer.saveln(String.format("%s\t%-36s\t%-20s\t%s", "INDEX", "UUID", "NOME", "IDADE"));
                    int idx = 0;
                    for (User user : readRegister.getUsers()) {
                        printer.saveln(String.format("%-3d\t%s\t%-20s\t%d", idx++, user.getUuid(), user.getName(),
                                user.getAge()));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                int indexIdx = printer.save("\nEscolha um usuário pelo index\n> ");

                int index = VarScanner.nextNumber(scanner, new VarScannerCallback() {
                    @Override
                    public void callback(String line) {
                        Menu.clearScreen();
                        printer.error("O index informado não existe!");
                        printer.print();
                    }
                }, readRegister.getUsers().size() - 1, 0);

                Menu.clearScreen();
                printer.updateAndPrint(indexIdx, String.valueOf(index));

                printer.save(String.format("\nDeseja serializar o usuário %s? (S/N)\nSim > ",
                        readRegister.getUsers().get(index).getName()));

                String response = scanner.nextLine();
                if ("n não nao no".indexOf(response.toLowerCase()) < 0 || response.isEmpty()) {
                    Menu.clearScreen();

                    User userSelected = readRegister.getUsers().get(index);
                    Storage storage = new Storage(userSelected.getUuid().toString(), "users");

                    storage.saveJson(userSelected);
                    storage.saveXml(userSelected);

                    System.out.println("Usuário salvo com sucesso! Pressione enter para voltar ao menu.\n");
                    System.out.print("[ENTER] ");
                    scanner.nextLine();
                }
            }
        });

        menu.addOption("Visualizar usuários serializados", 3, new MenuCallback() {
            @Override
            public void callback(String key, Scanner scanner) {
                System.out.println("\n[" + key.toUpperCase() + "]\n");

                List<User> users = Storage.readAll("users");

                if (users.size() == 0) {
                    System.out.println("Nenhum usuário serializado. Pressione enter para voltar ao menu.\n");
                    System.out.print("[ENTER] ");
                    scanner.nextLine();
                    return;
                }

                System.out.println("Usuários serializados:\n");
                System.out.println(String.format("%-4s\t%-36s\t%-20s\t%s", "TIPO", "UUID", "NOME", "IDADE"));
                for (User user : users) {
                    System.out.println(String.format("%-4s\t%s\t%-20s\t%d", user.getType(), user.getUuid(),
                            user.getName(), user.getAge()));
                }

                System.out.println("\nPressione enter para voltar ao menu.\n");
                System.out.print("[ENTER] ");
                scanner.nextLine();
            }
        });

        menu.addOption("Validar senha de usuário serializado", 4, new MenuCallback() {
            @Override
            public void callback(String key, Scanner scanner) {

                MenuOptionPrint printer = new MenuOptionPrint();

                printer.saveln("\n[" + key.toUpperCase() + "]\n");

                List<User> users = Storage.readAll("users");

                if (users.size() == 0) {
                    System.out.println("Não existe nenhum usuário serializado. Pressione enter para voltar ao menu.\n");
                    System.out.print("[ENTER] ");
                    scanner.nextLine();
                    return;
                }

                int emailIdx = printer.save("\nQual é o seu e-mail?\n>");
                String email = VarScanner.nextEmail(scanner, new VarScannerCallback() {
                    @Override
                    public void callback(String line) {
                        Menu.clearScreen();
                        printer.error("E-mail inválido, digite um e-mail como o exemplo: example@gmail.com");
                        printer.print();
                    }
                });

                Menu.clearScreen();
                printer.updateAndPrint(emailIdx, email);

                int passIdx = printer.save("\nQual é a sua senha?\n>");
                String password = VarScanner.nextPassword(scanner, new VarScannerCallback() {
                    @Override
                    public void callback(String line) {
                        Menu.clearScreen();
                        printer.error("A senha deve ter no mínimo 4 e no máximo 30 caracteres.");
                        printer.print();
                    }
                });

                Menu.clearScreen();
                printer.updateAndPrint(passIdx, password);

                Menu.clearScreen();
                printer.println();

                boolean foundedUser = false;
                boolean correctedThePassword = false;
                User userFounded = null;
                for (User user : users) {
                    if (user.getEmail().equalsIgnoreCase(email)) {
                        foundedUser = true;
                        correctedThePassword = user.checkPassword(password);
                        userFounded = user;
                        break;
                    }
                }

                if (!foundedUser) {
                    Menu.clearScreen();
                    System.out.println(
                            "\nNão foi encontrado nenhum usuário com o e-mail informado. Pressione enter para voltar ao menu.\n");
                    System.out.print("[ENTER] ");
                    scanner.nextLine();
                    return;
                } else {

                    if (correctedThePassword) {
                        Menu.clearScreen();
                        System.out.println("\nUsuário:\n");

                        System.out.println(userFounded);

                        System.out.println("\nParabéns, você acertou a senha. Pressione enter para voltar ao menu.\n");
                        System.out.print("[ENTER] ");
                        scanner.nextLine();
                        return;
                    } else {
                        Menu.clearScreen();
                        System.out.println(
                                "\nUsuário encontrado, porém senha incorreta. Pressione enter para voltar ao menu.\n");
                        System.out.print("[ENTER] ");
                        scanner.nextLine();
                    }

                }

            }
        });

        menu.addOption("Sair", 5, new MenuCallback() {
            @Override
            public void callback(String key, Scanner scanner) {
                menu.stop();
            }
        });

        menu.start();

    }
}
