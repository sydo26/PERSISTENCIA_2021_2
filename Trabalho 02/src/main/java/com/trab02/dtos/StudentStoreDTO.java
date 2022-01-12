package com.trab02.dtos;

import java.time.LocalDate;

import com.trab02.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor(staticName = "of")
@Getter
public class StudentStoreDTO {
    @NonNull
    private String registration, email, cpf, name;

    @NonNull
    private LocalDate birthDate;

    public Student getStudent() {
        return Student.of(cpf, registration, email, name, birthDate);
    }
}
