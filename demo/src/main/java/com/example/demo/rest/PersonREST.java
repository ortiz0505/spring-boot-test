package com.example.demo.rest;

import java.net.URI;
import java.util.List;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.models.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping ("/person")
public class PersonREST {
    
    @Autowired
    private PersonService personService;

    @PostMapping
    private ResponseEntity<Person>save(@RequestBody Person person){
        Person temp = personService.create(person);

        try {
            return ResponseEntity.created(new URI("/person"+temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Person>> listAllPerson (){
        return ResponseEntity.ok(personService.getAllperson());

    }

    @DeleteMapping
    private ResponseEntity<Void> deletePerson(@RequestBody Person person){
        personService.delete(person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (value = "delete/{id}")
    private ResponseEntity<Void> deletePerson(@PathVariable ("id") int id){
        personService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "id/{id}")
    private ResponseEntity<List<Person>> listPersonForId(@PathVariable("id") int id) {
        return ResponseEntity.ok(personService.findById(id));
    }

}
