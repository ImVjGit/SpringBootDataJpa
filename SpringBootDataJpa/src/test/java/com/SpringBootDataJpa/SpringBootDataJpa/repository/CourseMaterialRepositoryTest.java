package com.SpringBootDataJpa.SpringBootDataJpa.repository;

import com.SpringBootDataJpa.SpringBootDataJpa.entity.Course;
import com.SpringBootDataJpa.SpringBootDataJpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial(){

        Course courseobj = Course.builder()
                .title("Java")
                .credit(98)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.Google.com")
                .course(courseobj)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCoursesMaterials()
    {
        List<CourseMaterial> courseMaterialList= courseMaterialRepository.findAll();
        System.out.println(courseMaterialList);
    }

}