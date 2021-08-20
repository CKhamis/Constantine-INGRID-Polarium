package com.constantine.polarium.service;

import com.constantine.polarium.model.Contact;
import com.constantine.polarium.model.Drug;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
  List<Contact> findAll();
  Contact findById(Long id);
  void save(Contact contact);
  void delete(Contact contact);
}
