package com.constantine.polarium.dao;

import com.constantine.polarium.model.Drug;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalDao {
  List<Drug> findAll();
  Drug findById(Long id);
  void save(Drug medical);
  void delete(Drug medical);
}
