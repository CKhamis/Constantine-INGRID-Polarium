package com.constantine.polarium.service;

import com.constantine.polarium.dao.MedicalDao;
import com.constantine.polarium.model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalService{
  @Autowired
  private MedicalDao medicalDao;

  @Override
  public List<Drug> findAll() {
    return medicalDao.findAll();
  }

  @Override
  public Drug findById(Long id) {
    return medicalDao.findById(id);
  }

  @Override
  public void save(Drug medical){
    medicalDao.save(medical);
  }

  @Override
  public void delete(Drug medical) { medicalDao.delete(medical); }

}
