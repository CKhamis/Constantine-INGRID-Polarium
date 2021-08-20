package com.constantine.polarium.service;

import com.constantine.polarium.dao.GiftDao;
import com.constantine.polarium.model.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftServiceImpl implements GiftService{
  @Autowired
  private GiftDao giftDao;

  @Override
  public List<Gift> findAll() {
    return giftDao.findAll();
  }

  @Override
  public Gift findById(Long id) {
    return giftDao.findById(id);
  }

  @Override
  public void save(Gift gift){
    giftDao.save(gift);
  }

  @Override
  public void delete(Gift gift) { giftDao.delete(gift); }
}
