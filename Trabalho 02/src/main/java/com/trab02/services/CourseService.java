package com.trab02.services;

import java.util.List;

import com.trab02.dtos.CourseStoreDTO;
import com.trab02.entities.Course;
import com.trab02.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course store(CourseStoreDTO courseStoreDto) {

        boolean existsCourseCode = this.courseRepository.findByCode(courseStoreDto.getCode()).isPresent();

        if (existsCourseCode)
            return null;

        Course course = this.courseRepository.save(courseStoreDto.getCourse());

        return course;
    }

    public List<Course> find() {
        return this.courseRepository.findAll();
    }

}
