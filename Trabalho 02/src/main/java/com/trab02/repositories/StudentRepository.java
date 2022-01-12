package com.trab02.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.trab02.entities.Student;
import com.trab02.interfaces.IStudentAndCountCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s join fetch s.studentCourses sc join fetch sc.course c where lower(s.name) like concat('%',lower(:name),'%')")
    List<Student> findByNameAndReturnCourses(@Param("name") String name);

    @Query("select s from Student s join fetch s.studentCourses sc join fetch sc.course c where lower(c.code) = lower(:code)")
    List<Student> findStudentsByCourseCode(@Param("code") String code);

    @Query("select s as student, count(sc.id) as countCourses from Student s full join s.studentCourses sc group by s.id")
    List<IStudentAndCountCourse> findAllStudentsAndCountCourses();

    @Query("select st from Student st where st.birthDate >= :birthDate")
    public List<Student> findByDate(@Param("birthDate") LocalDate birthDate);

    public Optional<Student> findByEmail(String email);

    public Optional<Student> findByCpf(String cpf);

    public Optional<Student> findByRegistration(String registration);

}
