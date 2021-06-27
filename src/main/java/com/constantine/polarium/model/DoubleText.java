package com.constantine.polarium.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DoubleText {
  @Column(nullable = false)
  private String title;
  private String body;

  public DoubleText(){}

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
