package com.trab02.shared.ui.screens;

import com.trab02.entities.Student;
import com.trab02.services.StudentService;
import com.trab02.shared.ui.IUI;
import com.trab02.shared.ui.Screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuOptionDScreen extends IUI {

    MenuOptionDScreen() {
        super();
    }

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) {

        Screen.clear();
        System.out.println("\n[Questão D]\n");

        System.out.println("Informe uma matrícula.");
        System.out.print("> ");
        String registration = this.scanner.nextLine().split(" ")[0].trim();

        Student student = this.studentService.findStudentByRegistration(registration);

        if (student != null) {
            System.out.println(String.format("\n%-20s\t%-60s\n", "Nome", "Email"));
            System.out.println(String.format("%-20s\t%-60s", student.getName(), student.getEmail()));

        } else {
            System.out.println("\nNenhum estudante encontrado com a matrícula (" + registration + ")");
        }

        System.out.println();
        System.out.println("\nPara voltar ao menu bastar apertar [ENTER].");

        this.scanner.nextLine();

    }
}
