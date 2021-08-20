package com.constantine.polarium.service;

import com.constantine.polarium.dao.cScoreDao;
import com.constantine.polarium.model.cScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
