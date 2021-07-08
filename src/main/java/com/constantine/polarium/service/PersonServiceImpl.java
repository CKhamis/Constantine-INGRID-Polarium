package com.constantine.polarium.service;

import com.constantine.polarium.dao.PersonDao;
import com.constantine.polarium.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
  @Autowired
  private PersonDao personDao;

  @Override
  public List<Person> findAll() {
    return personDao.findAll();
  }

  @Override
  public Person findById(Long id) {
    return personDao.findById(id);
  }

  @Override
  public void save(Person person, MultipartFile file) {
    try{
      person.setProfileIcon(file.getBytes());
      personDao.save(person);
    } catch(IOException e) {
      System.err.println("Unable to get byte array from uploaded file.");
    }
  }

  @Override
  public void delete(Person person) { personDao.delete(person); }
}
