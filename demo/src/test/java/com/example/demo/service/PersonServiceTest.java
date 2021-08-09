package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PersonServiceTest {
    
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    private Person person;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        person = new Person();
        person.setId(25);
        person.setName("Brandon");
        person.setLastName("Ortiz");
        person.setEmail("Example@demo.com");

    }

    @Test
    void getAllperson(){
        when(personRepository.findAll()).thenReturn(Stream
        .of(person).collect(Collectors.toList()));
        assertEquals(1, personService.getAllperson().size());
    }

    @Test
    void create (){
        when(personRepository.save(person)).thenReturn(person);
        assertEquals(person, personService.create(person));
    }

    @Test
    void delete(){
        personService.delete(person);
        verify(personRepository, times(1)).delete(person);
    }

    @Test
    void findById(){
        when(personRepository.findById(person.getId()))
        .thenReturn(Stream.of(person).collect(Collectors.toList()));
        assertEquals(1, personService.findById(person.getId()).size());
    }
}
