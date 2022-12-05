package com.teksystems.springboot.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teksystems.springboot.database.entity.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
