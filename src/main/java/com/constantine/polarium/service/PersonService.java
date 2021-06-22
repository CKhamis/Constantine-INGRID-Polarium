package com.constantine.polarium.service;

import com.constantine.polarium.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
  List<Person> findAll();
  Person findById(Long id);
  void save(Person category);
  void delete(Person category);
}
