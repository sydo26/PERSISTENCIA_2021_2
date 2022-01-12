package com.trab02.dtos;

import com.trab02.entities.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor(staticName = "of")
@Getter
public class CourseStoreDTO {
    @NonNull
    private String code, name;

    public Course getCourse() {
        return Course.of(code, name);
    }
}
