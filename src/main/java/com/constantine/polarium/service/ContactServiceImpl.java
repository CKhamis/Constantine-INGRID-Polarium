package com.constantine.polarium.service;

import com.constantine.polarium.dao.ContactDao;
import com.constantine.polarium.model.Contact;
import com.constantine.polarium.model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{
  @Autowired
  private ContactDao contactDao;

  @Override
  public List<Contact> findAll() {
    return contactDao.findAll();
  }

  @Override
  public Contact findById(Long id) {
    return contactDao.findById(id);
  }

  @Override
  public void save(Contact contact){
    contactDao.save(contact);
  }

  @Override
  public void delete(Contact contact) { contactDao.delete(contact); }
}
