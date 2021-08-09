package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person , Integer>{
    
    List<Person> findById(int id);
}
