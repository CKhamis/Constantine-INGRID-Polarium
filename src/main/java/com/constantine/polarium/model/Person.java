package com.constantine.polarium.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String profileIconName;

  //General Info
  @Column(nullable = false)
  private String firstName;
  private String middleName;
  @Column(nullable = false)
  private String lastName;
  private String mbp;
  private String relationship;
  private String sexuality;
  private String sex;
  private String description;
  private String status;
  private Date birthday;
  private Integer yearMet;

  //Basic Communications
  private String email;
  private String phoneNumber;

  //Contact
  @OneToMany(mappedBy = "person")
  private List<Contact> socialMedia = new ArrayList<>();

  //Medical
  @OneToMany(mappedBy = "person")
  private List<Drug> drugsAndFrequency = new ArrayList<>();

  //Gift & Gift History
  @OneToMany(mappedBy = "person")
  private List<Gift> giftList = new ArrayList<>();

  //cScore Value
  @OneToMany(mappedBy = "person")
  private List<cScore> timeline = new ArrayList<>();

  //Getters and Setters

  @Transient
  public String getPhotosImagePath() {
    if (profileIconName == null || id == null) return null;
    String path = "/rankStar/profile-icons/" + id + "/" + profileIconName;
    return path;
  }

  public String getProfileIconName() {
    return profileIconName;
  }

  public void setProfileIconName(String profileIconName) {
    this.profileIconName = profileIconName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public List<Contact> getSocialMedia() {
    return socialMedia;
  }

  public void setSocialMedia(List<Contact> socialMedia) {
    this.socialMedia = socialMedia;
  }

  public List<Drug> getDrugsAndFrequency() {
    return drugsAndFrequency;
  }

  public void setDrugsAndFrequency(List<Drug> drugsAndFrequency) {
    this.drugsAndFrequency = drugsAndFrequency;
  }

  public void setMbp(String mbp) {
    this.mbp = mbp;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMbp() {
    return mbp;
  }

  public void setMBP(String mbp) {
    this.mbp = mbp;
  }

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }

  public String getSexuality() {
    return sexuality;
  }

  public void setSexuality(String sexuality) {
    this.sexuality = sexuality;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Integer getYearMet() {
    return yearMet;
  }

  public void setYearMet(Integer yearMet) {
    this.yearMet = yearMet;
  }

  public List<cScore> getTimeline() {
    return timeline;
  }

  public void setTimeline(List<cScore> timeline) {
    this.timeline = timeline;
  }

  public List<Gift> getGiftList() {
    return giftList;
  }

  public void setGiftList(List<Gift> giftList) {
    this.giftList = giftList;
  }
}
