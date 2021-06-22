package com.constantine.polarium.dao;

import com.constantine.polarium.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao {
  List<Person> findAll();
  Person findById(Long id);
  void save(Person category);
  void delete(Person category);
}
