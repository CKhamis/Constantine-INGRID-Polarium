package com.constantine.polarium.service;

import com.constantine.polarium.dao.PersonDao;
import com.constantine.polarium.model.Person;
import com.constantine.polarium.web.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
  @Autowired
  private PersonDao personDao;

  @Override
  public List<Person> findAll() {
    return personDao.findAll();
  }

  @Override
  public Person findById(Long id) {
    return personDao.findById(id);
  }

  @Override
  public void save(Person person, MultipartFile file) throws IOException {
    //TODO: Make it not required to upload profile image to save
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Collections.sort(person.getTimeline());
    if(!fileName.equals("")){
      person.setProfileIconName(fileName);
      personDao.save(person);
      String uploadDir = "src/main/resources/static/rankStar/profile-icons/" + person.getId();
      FileUploadUtil.saveFile(uploadDir, fileName, file);
    }else{
      personDao.save(person);
    }
  }
  public void save(Person person){
    personDao.save(person);
  }


    @Override
  public void delete(Person person) { personDao.delete(person); }
}
