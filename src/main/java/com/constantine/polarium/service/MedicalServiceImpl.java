package com.constantine.polarium.service;

import com.constantine.polarium.dao.MedicalDao;
import com.constantine.polarium.model.DoubleText;
import com.constantine.polarium.model.Gift;
import com.constantine.polarium.model.Person;
import com.constantine.polarium.model.cScore;
import com.constantine.polarium.web.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalService{
  @Autowired
  private MedicalDao medicalDao;

  @Override
  public List<DoubleText> findAll() {
    return medicalDao.findAll();
  }

  @Override
  public DoubleText findById(Long id) {
    return medicalDao.findById(id);
  }

  @Override
  public void save(DoubleText medical){
    medicalDao.save(medical);
  }

  @Override
  public void delete(DoubleText medical) { medicalDao.delete(medical); }

}
