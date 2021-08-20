package com.constantine.polarium.service;

import com.constantine.polarium.model.Gift;
import com.constantine.polarium.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface GiftService {
  List<Gift> findAll();
  Gift findById(Long id);
  void save(Gift gift);
  void delete(Gift gift);
}
