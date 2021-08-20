package com.constantine.polarium.dao;

import com.constantine.polarium.model.Person;
import com.constantine.polarium.model.cScore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cScoreDao {
  List<cScore> findAll();
  cScore findById(Long id);
  void save(cScore score);
  void delete(cScore score);
}
