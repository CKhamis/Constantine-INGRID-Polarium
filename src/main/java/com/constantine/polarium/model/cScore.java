package com.constantine.polarium.model;

import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class cScore implements Comparable<cScore>{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(nullable = false, unique = true)
  private Date date;
  private long value;
  private String note;
  @Column(length = 1)
  private String momentum;

  @OneToOne
  private Person person;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public cScore(Date date, long value) {
    this.date = date;
    this.value = value;
  }

  public cScore(){}

  //Getters and Setters

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public String getMomentum() {
    return momentum;
  }

  public void setMomentum(String momentum) {
    this.momentum = momentum;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public long getValue() {
    return value;
  }

  public void setValue(long value) {
    this.value = value;
  }

  @Override
  public int compareTo(cScore o) {
    return this.date.compareTo(o.getDate());
  }
}
