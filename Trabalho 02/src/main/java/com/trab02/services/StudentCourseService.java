package com.trab02.services;

import com.trab02.entities.StudentCourse;
import com.trab02.repositories.CourseRepository;
import com.trab02.repositories.StudentCourseRepository;
import com.trab02.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public StudentCourse store(Long studentId, Long courseId) throws Exception {

        boolean studentExists = this.studentRepository.findById(studentId).isPresent();

        if (!studentExists)
            throw new Exception(String.format("Estudante de id %d não encontrado.", studentId));

        boolean courseExists = this.courseRepository.findById(courseId).isPresent();

        if (!courseExists)
            throw new Exception(String.format("Curso de id %d não encontrado.", courseId));

        boolean relationHasExists = this.studentCourseRepository.findByStudentAndCourse(studentId, courseId)
                .isPresent();

        if (relationHasExists)
            throw new Exception(
                    String.format("Estudante de id %d já está está no curso de id %d.", studentId, courseId));

        return this.studentCourseRepository.save(StudentCourse.of(studentId, courseId));
    }
}
