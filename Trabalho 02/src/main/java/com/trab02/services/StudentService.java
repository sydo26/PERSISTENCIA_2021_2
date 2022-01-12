package com.trab02.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.trab02.dtos.StudentStoreDTO;
import com.trab02.entities.Student;
import com.trab02.interfaces.IStudentAndCountCourse;
import com.trab02.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student store(StudentStoreDTO studentStoreDto) {

        boolean existsStudentEmail = this.studentRepository.findByEmail(studentStoreDto.getEmail()).isPresent();

        if (existsStudentEmail)
            return null;

        boolean existsStudentCpf = this.studentRepository.findByCpf(studentStoreDto.getCpf()).isPresent();

        if (existsStudentCpf)
            return null;

        boolean existsStudentRegistration = this.studentRepository.findByRegistration(studentStoreDto.getRegistration())
                .isPresent();

        if (existsStudentRegistration)
            return null;

        Student student = this.studentRepository.save(studentStoreDto.getStudent());

        return student;
    }

    public List<Student> findByAfterAndInThisDate(LocalDate date) {
        return this.studentRepository.findByDate(date);
    }

    public Student findStudentByRegistration(String registration) {

        Optional<Student> studentOptional = this.studentRepository.findByRegistration(registration);

        if (!studentOptional.isPresent())
            return null;

        return studentOptional.get();
    }

    public List<Student> find() {
        return this.studentRepository.findAll();
    }

    public List<Student> findStudentAndCoursesByName(String name) {
        return this.studentRepository.findByNameAndReturnCourses(name);
    }

    public List<Student> findStudentsByCourseCode(String code) {
        return this.studentRepository.findStudentsByCourseCode(code);
    }

    public List<IStudentAndCountCourse> findStudentsAndCountCourses() {
        return this.studentRepository.findAllStudentsAndCountCourses();
    }

}
