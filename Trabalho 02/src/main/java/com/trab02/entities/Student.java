package com.trab02.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "student")
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Student {

    @ToString.Exclude
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentCourse> studentCourses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true, nullable = false)
    private String cpf;

    @NonNull
    @Column(unique = true, nullable = false)
    private String registration;

    @NonNull
    @Column(unique = true, nullable = false)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(nullable = false, name = "birth_date")
    private LocalDate birthDate;

}
