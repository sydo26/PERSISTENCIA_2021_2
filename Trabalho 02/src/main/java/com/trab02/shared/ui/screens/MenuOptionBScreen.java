package com.trab02.shared.ui.screens;

import java.util.List;

import com.trab02.entities.Student;
import com.trab02.services.StudentService;
import com.trab02.shared.ui.IUI;
import com.trab02.shared.ui.Screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuOptionBScreen extends IUI {

    MenuOptionBScreen() {
        super();
    }

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) {

        Screen.clear();
        System.out.println("\n[Questão B]\n");

        System.out.println(
                "Digite um código de um curso para mostrar todos os alunos que já cursaram. Ex: QX00001, QX00002, QX00003.");
        System.out.print("> ");
        String code = this.scanner.nextLine().split(" ")[0].trim().toUpperCase();

        // System.out.println(code);

        System.out.println(String.format("\n%-3s\t%-20s\t%-11s\t%-60s\n", "ID", "Nome", "Cpf", "Email"));

        List<Student> students = this.studentService.findStudentsByCourseCode(code);

        // System.out.println(students);
        for (Student student : students) {
            System.out.println(
                    String.format("%-3s\t%-20s\t%-11s\t%-60s", String.valueOf(student.getId()),
                            student.getName(),
                            student.getCpf(), student.getEmail()));
        }

        System.out.println("\nPara voltar ao menu bastar apertar [ENTER].");

        this.scanner.nextLine();

    }
}
