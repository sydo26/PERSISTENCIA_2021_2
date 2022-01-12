package com.trab02.shared.ui.screens;

import java.util.List;

import com.trab02.entities.Student;
import com.trab02.interfaces.IStudentAndCountCourse;
import com.trab02.services.StudentService;
import com.trab02.shared.ui.IUI;
import com.trab02.shared.ui.Screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuOptionCScreen extends IUI {

    MenuOptionCScreen() {
        super();
    }

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) {

        Screen.clear();
        System.out.println("\n[Questão C]\n");

        System.out.println(String.format("\n%-3s\t%-20s\t%-20s\n", "Id", "Nome", "Quantidade de cursos"));

        List<IStudentAndCountCourse> studentsAndCountCourses = this.studentService.findStudentsAndCountCourses();

        for (IStudentAndCountCourse studentAndCountCourses : studentsAndCountCourses) {
            Student student = studentAndCountCourses.getStudent();
            Long count = studentAndCountCourses.getCountCourses();
            System.out.println(
                    String.format("%-3s\t%-20s\t%-20s", student.getId(), student.getName(), String.valueOf(count)));
        }

        System.out.println("\nPara voltar ao menu bastar apertar [ENTER].");

        this.scanner.nextLine();

    }
}
