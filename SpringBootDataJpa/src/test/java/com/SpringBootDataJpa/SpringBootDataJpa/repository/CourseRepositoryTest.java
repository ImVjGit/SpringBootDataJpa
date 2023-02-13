package com.SpringBootDataJpa.SpringBootDataJpa.repository;

import com.SpringBootDataJpa.SpringBootDataJpa.entity.Course;
import com.SpringBootDataJpa.SpringBootDataJpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses()
    {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public  void saveCourseWithTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Tanika")
                .lastName("Jonka").build();

        Course course = Course.builder()
                .credit(456)
                .title("Python")
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }


}