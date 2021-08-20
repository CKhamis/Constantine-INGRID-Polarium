package com.constantine.polarium.service;

import com.constantine.polarium.dao.PersonDao;
import com.constantine.polarium.dao.cScoreDao;
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
public class cScoreServiceImpl implements cScoreService{
  @Autowired
  private cScoreDao cScoreDao;

  @Override
  public List<cScore> findAll() {
    return cScoreDao.findAll();
  }

  @Override
  public cScore findById(Long id) {
    return cScoreDao.findById(id);
  }

  @Override
  public void save(cScore score){
    cScoreDao.save(score);
  }

  @Override
  public void delete(cScore score) { cScoreDao.delete(score); }
}
