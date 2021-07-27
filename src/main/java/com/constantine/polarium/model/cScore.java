package com.constantine.polarium.model;

import org.hibernate.validator.constraints.Length;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class cScore implements Comparable<cScore>{

  @Column(nullable = false)
  private Date date;
  private long value;
  private String note;
  @Column(length = 1)
  private String momentum;

  public cScore(Date date, long value) {
    this.date = date;
    this.value = value;
  }

  public cScore(){}

  //Getters and Setters

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
