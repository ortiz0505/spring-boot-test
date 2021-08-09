package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person create (Person person){
        return personRepository.save(person);
    }

    public List <Person> getAllperson(){
        return personRepository.findAll();
    }

    public void delete (Person person){
        personRepository.delete(person);
    }

    public void deleteById(int id){
        personRepository.deleteById(id);
    }

    public List <Person> findById(int id){
        return personRepository.findById(id);
    }

    
}
