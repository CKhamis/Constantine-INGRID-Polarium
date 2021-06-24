package com.constantine.polarium.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "person_id")
  private Long id;

  @Lob
  private byte[] profileIcon;

  //General Info
  @Column(name = "first_name", nullable = false)
  private String firstName;
  @Column(name = "middle_name")
  private String middleName;
  @Column(name = "last_name", nullable = false)
  private String lastName;
  @Column(name = "mb")
  private String mbp;
  @Column(name = "place_met")
  private String placeMet;
  @Column(name = "sexuality")
  private String sexuality;
  @Column(name = "sex")
  private String sex;
  @Column(name = "description")
  private String description;
  @Column(name = "status")
  private String status;
  @Column(name = "birthday")
  private Date birthday;
  @Column(name = "year_met")
  private Integer yearMet;
  @Column(name = "date_created")
  private LocalDateTime dateCreated;
  //Notes
  //private ArrayList<DatedMessage> notes;

  //Contact
  //private TreeSet<DoubleText> socialMedia;

  //Medical
  //private TreeSet<DoubleText> drugsAndFrequency;

  //Gift & Gift History
  //private ArrayList<DatedMessage> Incoming, Outgoing;
  //private String considering;

  //cScore Value
  @OneToMany
  private List<cScore> timeline = new ArrayList<>();

  //Constructors
  public Person(PersonBuilder builder){
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.middleName = builder.middleName;
    this.mbp = builder.mbp;
    this.description = builder.description;
    this.birthday = builder.birthday;
    this.placeMet = builder.placeMet;
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

  public String getPlaceMet() {
    return placeMet;
  }

  public void setPlaceMet(String placeMet) {
    this.placeMet = placeMet;
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
    private String firstName, middleName, lastName, mbp, placeMet, sexuality, sex, description, status;
    private Date birthday;
    private Integer yearMet;

    public PersonBuilder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public PersonBuilder withPlaceMet(String placeMet) {
      this.placeMet = placeMet;
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
