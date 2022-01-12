package com.trab02.shared.ui.screens;

import java.util.List;

import com.trab02.entities.Student;
import com.trab02.entities.StudentCourse;
import com.trab02.services.StudentService;
import com.trab02.shared.ui.IUI;
import com.trab02.shared.ui.Screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuOptionAScreen extends IUI {

    MenuOptionAScreen() {
        super();
    }

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) {

        Screen.clear();
        System.out.println("\n[Questão A]\n");

        System.out.println("Procurar aluno pelo nome. Ex: Maria, vini.");
        System.out.print("> ");
        String name = this.scanner.nextLine();

        System.out.println(String.format("\n%-20s\t%-100s\n", "Nome", "Cursos"));

        List<Student> students = this.studentService.findStudentAndCoursesByName(name);

        for (Student student : students) {
            System.out.print(String.format("%-20s\t", student.getName()));

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < student.getStudentCourses().size(); i++) {

                StudentCourse studentCourse = student.getStudentCourses().get(i);

                if (i == 0) {
                    builder.append(studentCourse.getCourse().getName());
                } else {
                    builder.append(", " + studentCourse.getCourse().getName());
                }

            }

            System.out.print(String.format("%-100s", builder.toString()));
            System.out.println();
        }

        System.out.println("\nPara voltar ao menu bastar apertar [ENTER].");

        this.scanner.nextLine();

    }
}
