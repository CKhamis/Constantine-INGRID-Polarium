package com.constantine.polarium.dao;

import com.constantine.polarium.model.DoubleText;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalDao {
  List<DoubleText> findAll();
  DoubleText findById(Long id);
  void save(DoubleText medical);
  void delete(DoubleText medical);
}
