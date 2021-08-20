package com.constantine.polarium.dao;

import com.constantine.polarium.model.DoubleText;
import com.constantine.polarium.model.cScore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDao {
  List<DoubleText> findAll();
  DoubleText findById(Long id);
  void save(DoubleText contact);
  void delete(DoubleText contact);
}
