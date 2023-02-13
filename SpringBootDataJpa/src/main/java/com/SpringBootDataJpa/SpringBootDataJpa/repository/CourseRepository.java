package com.SpringBootDataJpa.SpringBootDataJpa.repository;

import com.SpringBootDataJpa.SpringBootDataJpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
