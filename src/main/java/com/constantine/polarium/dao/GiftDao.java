package com.constantine.polarium.dao;

import com.constantine.polarium.model.Gift;
import com.constantine.polarium.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftDao {
  List<Gift> findAll();
  Gift findById(Long id);
  void save(Gift gift);
  void delete(Gift gift);
}
