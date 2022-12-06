package com.teksystems.springboot.database.dao;

import java.util.List;
import java.util.Map;

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

    public Course findCourseById(Integer id);

    @Query(value = "select instructor, count(*) as cnt " + "from courses \r\n"
            + "where instructor is not null and instructor!= \"\" " + "group by instructor "
            + "order by instructor", nativeQuery = true)
    public List<Map<String, Object>> instructorCourseCount();

    public Course findByName(String name);
}
