package com.example.demo.service;

import com.example.demo.dao.entity.PersonEntity;
import com.example.demo.dao.repository.PersonRepository;
import com.example.demo.dto.request.IdentifiedPersonRequest;
import com.example.demo.dto.request.PersonRequest;
import com.example.demo.dto.request.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void save(final PersonRequest personRequest){
        final PersonEntity personEntity = PersonEntity.builder()
                .firstName(personRequest.getFirstName())
                .lastName(personRequest.getLastName())
                .dateOfBirth(personRequest.getDateOfBirth())
                .build();

        personRepository.save(personEntity);
    }

    public void put(final IdentifiedPersonRequest identifiedPersonRequest){
        final PersonEntity personEntity = PersonEntity.builder()
                .id(identifiedPersonRequest.getId())
                .firstName(identifiedPersonRequest.getFirstName())
                .lastName(identifiedPersonRequest.getLastName())
                .dateOfBirth(identifiedPersonRequest.getDateOfBirth())
                .build();
        personRepository.save(personEntity);
    }
    public List<PersonResponse> get(final String firstName) {

        final List<PersonEntity> personEntities = personRepository.findPersonEntitiesByFirstName(firstName);

        final List<PersonResponse> personResponses = personEntities.stream()
                .map(personEntity ->  PersonResponse.builder()
                        .userId(personEntity.getId())
                        .firstName(personEntity.getFirstName())
                        .lastName(personEntity.getLastName())
                        .dateOfBirth(personEntity.getDateOfBirth())
                        .build())
                .collect(Collectors.toList());
        return personResponses;
    }

    public void delete(final String id) {
        personRepository.delete(PersonEntity.builder().id(UUID.fromString(id)).build());
    }
}
