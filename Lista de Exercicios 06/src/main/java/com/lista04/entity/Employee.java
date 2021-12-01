package com.lista04.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

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
@Setter()
@Entity()
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(name = "employee_uniques", columnNames = {
        "registration", "cpf" }))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @GenericGenerator(name = "registration_seq", strategy = "registration_seq")
    @GeneratedValue(generator = "registration_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "registration", nullable = false, insertable = false)
    Integer registration;

    @NonNull
    private String name, email, phone, cpf;

    @Override
    public String toString() {
        return String.format("%-7d\t%-9d\t%-20s\t%-20s\t%-11s\t%-11s", id,
                registration, name, email, phone, cpf);
    }

}
