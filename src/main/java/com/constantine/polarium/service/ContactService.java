package com.constantine.polarium.service;

import com.constantine.polarium.model.DoubleText;
import com.constantine.polarium.model.cScore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
  List<DoubleText> findAll();
  DoubleText findById(Long id);
  void save(DoubleText contact);
  void delete(DoubleText contact);
}
