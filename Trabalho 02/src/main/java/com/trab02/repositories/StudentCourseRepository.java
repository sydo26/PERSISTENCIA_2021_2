package com.trab02.repositories;

import java.util.Optional;

import com.trab02.entities.StudentCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    @Query(name = "findByStudentAndCourseId")
    public Optional<StudentCourse> findByStudentAndCourse(@Param("studentId") Long studentId,
            @Param("courseId") Long courseId);

}