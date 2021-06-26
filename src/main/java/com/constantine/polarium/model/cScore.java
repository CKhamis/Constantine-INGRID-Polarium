package com.constantine.polarium.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class cScore {
  /*@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;*/

  @Column(nullable = false)
  private Date date;
  private long value;

  public cScore(Date date, long value) {
    this.date = date;
    this.value = value;
  }

  /*public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }*/

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
}
