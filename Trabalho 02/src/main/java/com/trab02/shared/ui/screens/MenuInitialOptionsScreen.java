package com.trab02.shared.ui.screens;

import com.trab02.shared.ui.IUI;
import com.trab02.shared.ui.Screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class MenuInitialOptionsScreen extends IUI {

    @Autowired
    private MenuOptionAScreen menuOptionAScreen;
    @Autowired
    private MenuOptionBScreen menuOptionBScreen;
    @Autowired
    private MenuOptionCScreen menuOptionCScreen;
    @Autowired
    private MenuOptionDScreen menuOptionDScreen;
    @Autowired
    private MenuOptionEScreen menuOptionEScreen;

    public MenuInitialOptionsScreen() {
        super();
    }

    void printMenu() {
        Screen.clear();
        System.out.println("\n[Questões]\n");
        System.out.println(
                "a) Mostrar os nomes os alunos e todas as suas disciplinas cursadas somente para alunos com nomes contendo determinada string.");
        System.out.println();

        System.out.println(
                "b) Dado um código de disciplina, mostrar todos os alunos que a cursaram.");
        System.out.println();

        System.out.println(
                "c) Mostrar os nomes de todos os alunos com suas respectivas quantidades de disciplinas cursadas.");
        System.out.println();

        System.out.println(
                "d) Dada uma matrícula, mostrar o nome e email do aluno.");
        System.out.println();

        System.out.println(
                "e) Dada uma data, mostrar somente os alunos que nasceram depois dela.");
        System.out.println("\n");

        System.out.println("Digite \"exit\" para sair.\n");

        System.out.print("> ");
    }

    @Override
    public void run(String... args) {

        String line;
        boolean running = true;

        while (running) {
            this.printMenu();

            line = this.scanner.nextLine();

            String option = line.split(" ")[0].trim().toLowerCase();

            switch (option) {
                case "a":
                    this.menuOptionAScreen.run(args);
                    break;
                case "b":
                    this.menuOptionBScreen.run(args);
                    break;
                case "c":
                    this.menuOptionCScreen.run(args);
                    break;
                case "d":
                    this.menuOptionDScreen.run(args);
                    break;
                case "e":
                    this.menuOptionEScreen.run(args);
                    break;
                case "exit":
                    running = false;
                    break;

                default:
                    break;
            }

        }
    }

}
