package com.teksystems.springboot.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teksystems.springboot.database.entity.Course;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> {

    @Query("select c from Course c where c.name = :name")
    public List<Course> findByCourseName(String name);

    public List<Course> findByNameContaining(String name);

    public List<Course> findByInstructorContaining(String instructor);

    public List<Course> findByNameOrInstructor(String name, String instructor);
}
