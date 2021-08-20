package com.constantine.polarium.service;

import com.constantine.polarium.model.DoubleText;
import com.constantine.polarium.model.cScore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicalService {
  List<DoubleText> findAll();
  DoubleText findById(Long id);
  void save(DoubleText medical);
  void delete(DoubleText medical);
}
