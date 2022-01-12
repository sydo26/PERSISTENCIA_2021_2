package com.trab02.shared.ui.screens;

import java.time.LocalDate;
import java.util.List;

import com.trab02.entities.Student;
import com.trab02.services.StudentService;
import com.trab02.shared.ui.IUI;
import com.trab02.shared.ui.Screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuOptionEScreen extends IUI {

    MenuOptionEScreen() {
        super();
    }

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) {

        Screen.clear();
        System.out.println("\n[Questão A]\n");

        System.out.println(
                "Informe uma data para listar todos os alunos que nasceram neste data ou depois. Ex: 24-12-2001 (DD-MM-YYYY)");
        System.out.print("> ");
        String[] date = this.scanner.nextLine().trim().split(" ")[0].split("-");

        if (date.length != 3) {
            System.out.println("Data inválida!");
        } else {
            int year, month, day;

            try {
                day = Integer.parseInt(date[0]);
                month = Integer.parseInt(date[1]);
                year = Integer.parseInt(date[2]);

                LocalDate localDate = LocalDate.of(year, month, day);

                List<Student> students = this.studentService.findByAfterAndInThisDate(localDate);

                System.out.println(
                        String.format("\n%-3s\t%-9s\t%-20s\t%-20s\n", "Id", "Matrícula", "Nome", "Data de nascimento"));

                for (Student student : students) {
                    System.out.println(String.format("%-3s\t%-9s\t%-20s\t%-20s", student.getId(),
                            student.getRegistration(), student.getName(), student.getBirthDate().toString()));
                }

            } catch (Exception e) {
                System.out.println("Data inválida!");
            }
        }

        System.out.println();
        System.out.println("\nPara voltar ao menu bastar apertar [ENTER].");

        this.scanner.nextLine();

    }
}
