package com.trab02.repositories;

import java.util.List;
import java.util.Optional;

import com.trab02.entities.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    public Optional<Course> findByCode(String code);
}
