package com.constantine.polarium.dao;

import com.constantine.polarium.model.Contact;
import com.constantine.polarium.model.Drug;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDao {
  List<Contact> findAll();
  Contact findById(Long id);
  void save(Contact contact);
  void delete(Contact contact);
}
