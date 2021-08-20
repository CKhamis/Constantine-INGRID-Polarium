package com.constantine.polarium.service;

import com.constantine.polarium.model.cScore;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface cScoreService {
  List<cScore> findAll();
  cScore findById(Long id);
  void save(cScore score);
  void delete(cScore score);
}
