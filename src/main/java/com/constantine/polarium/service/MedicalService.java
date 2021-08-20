package com.constantine.polarium.service;

import com.constantine.polarium.model.Drug;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicalService {
  List<Drug> findAll();
  Drug findById(Long id);
  void save(Drug medical);
  void delete(Drug medical);
}
