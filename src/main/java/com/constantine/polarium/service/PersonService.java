package com.constantine.polarium.service;

import com.constantine.polarium.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface PersonService {
  List<Person> findAll();
  Person findById(Long id);
  void saveOverview(Person person, MultipartFile file) throws IOException;
  void delete(Person category);
  void saveNew(Person person, MultipartFile file) throws IOException;
  void saveOverview(Person member);
}
