package com.constantine.polarium.service;

import com.constantine.polarium.dao.PersonDao;
import com.constantine.polarium.model.DoubleText;
import com.constantine.polarium.model.Person;
import com.constantine.polarium.model.cScore;
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
  public void saveOverview(Person person, MultipartFile file) throws IOException {
    //Get the other fields from the older version of the member
    Person old = findById(person.getId());
    List<DoubleText> socialMedia = old.getSocialMedia();
    List<DoubleText> drugsAndFrequency = old.getDrugsAndFrequency();
    List<cScore> timeline = old.getTimeline();

    //Write these to the new version
    person.setSocialMedia(socialMedia);
    person.setDrugsAndFrequency(drugsAndFrequency);
    person.setTimeline(timeline);

    Collections.sort(person.getTimeline());
    //TODO: Make it not required to upload profile image to save
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    if(!fileName.equals("")){
      person.setProfileIconName(fileName);
      personDao.save(person);
      String uploadDir = "src/main/resources/static/rankStar/profile-icons/" + person.getId();
      FileUploadUtil.saveFile(uploadDir, fileName, file);
    }else{
      personDao.save(person);
    }
  }

  @Override
  public void saveOverview(Person person){
    Collections.sort(person.getTimeline());
    Collections.sort(person.getGiftList());
    personDao.save(person);
  }

  @Override
  public void delete(Person person) { personDao.delete(person); }
}
