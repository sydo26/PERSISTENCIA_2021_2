package com.trab02.entities;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "course")
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Course {

    @ToString.Exclude
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<StudentCourse> studentCourses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true, nullable = false)
    private String code;

    @NonNull
    @Column(nullable = false)
    private String name;

}
