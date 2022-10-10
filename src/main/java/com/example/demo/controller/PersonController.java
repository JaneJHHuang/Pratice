package com.example.demo.controller;

import com.example.demo.dao.entity.PersonEntity;
import com.example.demo.dto.request.IdentifiedPersonRequest;
import com.example.demo.dto.request.PersonRequest;
import com.example.demo.dto.request.PersonResponse;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController (final  PersonService personService) {
        this.personService = personService;
    }
    @PostMapping("/person")
    public void save(@RequestBody final PersonRequest personRequest) {
        personService.save(personRequest);

    }

    @GetMapping("/person/{firstName}")
    public List<PersonResponse> get(@RequestParam final String firstName) {
        return personService.get(firstName);
    }

    @PutMapping("/person")
    public void put(@RequestBody final IdentifiedPersonRequest identifiedPersonRequest) {
        personService.put(identifiedPersonRequest);
    }

    @DeleteMapping("/person/{id}")
    public void  delete(@RequestParam final String id) {
        personService.delete(id);
    }

}
