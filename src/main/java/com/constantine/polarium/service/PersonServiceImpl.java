package com.constantine.polarium.service;

import com.constantine.polarium.dao.PersonDao;
import com.constantine.polarium.model.DoubleText;
import com.constantine.polarium.model.Gift;
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
  public void saveProfileIcon(MultipartFile file, Long personId) throws IOException {
    Person old = findById(personId);
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    if(!fileName.equals("")){
      old.setProfileIconName(fileName);
      personDao.save(old);
      String uploadDir = "src/main/resources/static/rankStar/profile-icons/" + personId;
      FileUploadUtil.saveFile(uploadDir, fileName, file);
    }else{
      personDao.save(old);
    }
  }


  @Override
  public void saveOverview(Person person){
    //Get the other fields from the older version of the member
    Person old = findById(person.getId());
    List<DoubleText> socialMedia = old.getSocialMedia();
    List<DoubleText> drugsAndFrequency = old.getDrugsAndFrequency();
    List<cScore> timeline = old.getTimeline();
    List<Gift> giftHistory = old.getGiftList();

    //Sort the lists
    Collections.sort(timeline);
    Collections.sort(giftHistory);

    //Write these to the new version
    person.setSocialMedia(socialMedia);
    person.setDrugsAndFrequency(drugsAndFrequency);
    person.setTimeline(timeline);
    person.setGiftList(giftHistory);

    //Transfer profile icon
    person.setProfileIconName(old.getProfileIconName());

    personDao.save(person);
  }

  @Override
  public void save(Person person){
    //Sort the lists
    Collections.sort(person.getTimeline());
    Collections.sort(person.getGiftList());

    personDao.save(person);
  }

  @Override
  public void delete(Person person) { personDao.delete(person); }

  @Override
  public void saveNew(Person person, MultipartFile file) throws IOException {
    //TODO: Make it not required to upload profile image to save
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    person.setProfileIconName(fileName);
    personDao.save(person);

    String uploadDir = "src/main/resources/static/rankStar/profile-icons/" + person.getId();
    FileUploadUtil.saveFile(uploadDir, fileName, file);
  }
}
