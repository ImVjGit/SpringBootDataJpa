package com.SpringBootDataJpa.SpringBootDataJpa.repository;

import com.SpringBootDataJpa.SpringBootDataJpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}
