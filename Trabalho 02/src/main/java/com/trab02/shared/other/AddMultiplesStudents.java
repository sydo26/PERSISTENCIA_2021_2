package com.trab02.shared.other;

import java.time.LocalDate;

import com.trab02.dtos.CourseStoreDTO;
import com.trab02.dtos.StudentStoreDTO;
import com.trab02.entities.Course;
import com.trab02.entities.Student;
import com.trab02.services.CourseService;
import com.trab02.services.StudentCourseService;
import com.trab02.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddMultiplesStudents {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentCourseService studentCourseService;

    public void run() {
        Course c1 = this.courseService.store(CourseStoreDTO.of("QX00001", "Sistemas da Informação"));
        Course c2 = this.courseService.store(CourseStoreDTO.of("QX00002", "Engenharia de Software"));
        Course c3 = this.courseService.store(CourseStoreDTO.of("QX00003", "Ciências da Computação"));
        Course c4 = this.courseService.store(CourseStoreDTO.of("QX00004", "Engenharia da Computação"));
        Course c5 = this.courseService.store(CourseStoreDTO.of("QX00005", "Redes"));
        Course c6 = this.courseService.store(CourseStoreDTO.of("QX00006", "Design"));
        Course c7 = this.courseService.store(CourseStoreDTO.of("QX00007", "Analista de Sistemas"));
        Course c8 = this.courseService.store(CourseStoreDTO.of("QX00008", "Engenharia Mecânica"));
        Course c9 = this.courseService.store(CourseStoreDTO.of("QX00009", "Medicina"));

        Student s1 = this.studentService
                .store(StudentStoreDTO.of("498969", "sydoafk@gmail.com", "07006978378", "Vinicius Roque",
                        LocalDate.of(2001, 12, 24)));

        Student s2 = this.studentService
                .store(StudentStoreDTO.of("138969", "asgoasogka@gmail.com", "13006972371", "Marcela Gomes",
                        LocalDate.of(2002, 10, 2)));

        Student s3 = this.studentService
                .store(StudentStoreDTO.of("198963", "rogeriosouza@gmail.com", "41206974373", "Rogério Souza",
                        LocalDate.of(1997, 12, 2)));
        Student s4 = this.studentService
                .store(StudentStoreDTO.of("392961", "marcelobezerra@gmail.com", "17206978374", "Marcelo Bezerra",
                        LocalDate.of(2002, 11, 14)));
        Student s5 = this.studentService
                .store(StudentStoreDTO.of("448362", "laramacedo@gmail.com", "12952952429", "Lara Macedo",
                        LocalDate.of(1999, 9, 30)));
        Student s6 = this.studentService
                .store(StudentStoreDTO.of("418269", "viniciuscoelho@gmail.com", "01252121225", "Vinicius Coelho",
                        LocalDate.of(2004, 10, 4)));
        Student s7 = this.studentService
                .store(StudentStoreDTO.of("498569", "bernadodasilva@gmail.com", "24020522992", "Bernado da Silva",
                        LocalDate.of(2000, 3, 3)));
        Student s8 = this.studentService
                .store(StudentStoreDTO.of("291169", "victorsoares@gmail.com", "21512091225", "Victor Soares",
                        LocalDate.of(1980, 3, 10)));
        Student s9 = this.studentService
                .store(StudentStoreDTO.of("598911", "pedromaciel@gmail.com", "25912912052", "Pedro Maciel",
                        LocalDate.of(2005, 5, 5)));
        Student s10 = this.studentService
                .store(StudentStoreDTO.of("291111", "sabrinamateus@gmail.com", "25122952424", "Sabrina Mateus",
                        LocalDate.of(2002, 1, 24)));

        try {
            if (c1 != null) {
                if (s1 != null) {
                    this.studentCourseService.store(s1.getId(), c1.getId());
                }

                if (s2 != null) {
                    this.studentCourseService.store(s2.getId(), c1.getId());
                }
            }

            if (c2 != null) {
                if (s1 != null) {
                    this.studentCourseService.store(s1.getId(), c2.getId());
                }

                if (s3 != null) {
                    this.studentCourseService.store(s3.getId(), c2.getId());
                }

                if (s4 != null) {
                    this.studentCourseService.store(s4.getId(), c2.getId());
                }

                if (s5 != null) {
                    this.studentCourseService.store(s5.getId(), c2.getId());
                }
            }

            if (c3 != null) {
                if (s3 != null) {
                    this.studentCourseService.store(s3.getId(), c3.getId());
                }

                if (s6 != null) {
                    this.studentCourseService.store(s6.getId(), c3.getId());
                }
            }

            if (c7 != null) {
                if (s8 != null) {
                    this.studentCourseService.store(s8.getId(), c7.getId());
                }

                if (s2 != null) {
                    this.studentCourseService.store(s2.getId(), c7.getId());
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }

    }

}
