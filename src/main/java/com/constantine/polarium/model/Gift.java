package com.constantine.polarium.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Gift implements Comparable<Gift>{
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private boolean outgoing;
  @Column(nullable = false)
  private Date transactionDate;
  private String details;

  public Gift(){}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public boolean isOutgoing() {
    return outgoing;
  }

  public void setOutgoing(boolean outgoing) {
    this.outgoing = outgoing;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  @Override
  public int compareTo(Gift o) {
    return this.getTransactionDate().compareTo(o.getTransactionDate());
  }
}
