package com.trab02.entities;

import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.*;

import lombok.*;

@NamedQuery(name = "findByStudentAndCourseId", query = "select stc from StudentCourse stc WHERE stc.courseId = :courseId AND stc.studentId = :studentId")
@Entity
@Table(name = "student_course")
@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @NonNull
    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    @ToString.Exclude
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    @ToString.Exclude
    private Course course;

}
