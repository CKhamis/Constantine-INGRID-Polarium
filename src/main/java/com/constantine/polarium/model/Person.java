package com.constantine.polarium.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  private byte[] profileIcon;

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
  private LocalDateTime dateCreated;

  //Contact
  @ElementCollection
  private List<DoubleText> socialMedia = new ArrayList<>();

  //Medical
  @ElementCollection
  private List<DoubleText> drugsAndFrequency = new ArrayList<>();

  //Gift & Gift History
  //private ArrayList<DatedMessage> Incoming, Outgoing;
  private String considering;

  //cScore Value
  @ElementCollection
  private List<cScore> timeline = new ArrayList<>();

  //Constructors
  public Person(PersonBuilder builder){
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.middleName = builder.middleName;
    this.mbp = builder.mbp;
    this.description = builder.description;
    this.birthday = builder.birthday;
    this.relationship = builder.relationship;
    this.sex = builder.sex;
    this.sexuality = builder.sexuality;
    this.status = builder.status;
    this.yearMet = builder.yearMet;
    this.dateCreated = LocalDateTime.now();
  }

  public Person(){
    this.dateCreated = LocalDateTime.now();
  }

  //Getters and Setters

  public List<DoubleText> getSocialMedia() {
    return socialMedia;
  }

  public void setSocialMedia(List<DoubleText> socialMedia) {
    this.socialMedia = socialMedia;
  }

  public List<DoubleText> getDrugsAndFrequency() {
    return drugsAndFrequency;
  }

  public void setDrugsAndFrequency(List<DoubleText> drugsAndFrequency) {
    this.drugsAndFrequency = drugsAndFrequency;
  }

  public void setMbp(String mbp) {
    this.mbp = mbp;
  }

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public byte[] getProfileIcon() {
    return profileIcon;
  }

  public void setProfileIcon(byte[] profileIcon) {
    this.profileIcon = profileIcon;
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

  private static class PersonBuilder{
    private String firstName, middleName, lastName, mbp, relationship, sexuality, sex, description, status;
    private Date birthday;
    private Integer yearMet;

    public PersonBuilder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public PersonBuilder withRelationship(String relationship) {
      this.relationship = relationship;
      return this;
    }

    public PersonBuilder withMyersBriggs(String mbp) {
      this.mbp = mbp;
      return this;
    }

    public PersonBuilder withSexuality(String sexuality) {
      this.sexuality = sexuality;
      return this;
    }

    public PersonBuilder withSex(String sex) {
      this.sex = sex;
      return this;
    }

    public PersonBuilder withDescription(String description) {
      this.description = description;
      return this;
    }

    public PersonBuilder withStatus(String status) {
      this.status = status;
      return this;
    }

    public PersonBuilder withMiddleName(String middleName) {
      this.middleName = middleName;
      return this;
    }

    public PersonBuilder withBirthday(Date birthday) {
      this.birthday = birthday;
      return this;
    }

    public PersonBuilder withMyersBriggs(Integer yearMet) {
      this.yearMet = yearMet;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }
}
