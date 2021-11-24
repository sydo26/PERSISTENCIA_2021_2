package com.lista04.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "create")
@Getter
@Setter
public class Employee {

    Integer id, registration;

    @NonNull
    private String name, email, phone, cpf;

    @Override
    public String toString() {
        return String.format("%-7d\t%-9d\t%-20s\t%-20s\t%-11s\t%-11s", id, registration, name, email, phone, cpf);
    }

}
