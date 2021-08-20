package com.constantine.polarium.service;

import com.constantine.polarium.dao.ContactDao;
import com.constantine.polarium.model.DoubleText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{
  @Autowired
  private ContactDao contactDao;

  @Override
  public List<DoubleText> findAll() {
    return contactDao.findAll();
  }

  @Override
  public DoubleText findById(Long id) {
    return contactDao.findById(id);
  }

  @Override
  public void save(DoubleText contact){
    contactDao.save(contact);
  }

  @Override
  public void delete(DoubleText contact) { contactDao.delete(contact); }
}
