package com.SpringBootDataJpa.SpringBootDataJpa.repository;

import com.SpringBootDataJpa.SpringBootDataJpa.entity.Course;
import com.SpringBootDataJpa.SpringBootDataJpa.entity.CourseMaterial;
import com.SpringBootDataJpa.SpringBootDataJpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher()
    {

        Course courseOs = Course.builder()
                .title("Os")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(courseOs)
                .url("www.os.com")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Govinda")
                .lastName("Pawar")
                //.courses(List.of(courseOs))
                .build();
        teacherRepository.save(teacher);
    }
}