package com.constantine.polarium.dao;

import com.constantine.polarium.model.Person;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao{
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @SuppressWarnings("unchecked")
  public List<Person> findAll() {
    // Open a session
    Session session = sessionFactory.openSession();

    // Get all people with a Hibernate criteria
    List<Person> people = session.createCriteria(Person.class).list();

    // Close session
    session.close();

    return people;
  }

  @Override
  public Person findById(Long id) {
    Session session = sessionFactory.openSession();
    Person p = session.get(Person.class,id);
    Hibernate.initialize(p.getTimeline());
    Hibernate.initialize(p.getSocialMedia());
    Hibernate.initialize(p.getDrugsAndFrequency());
    Hibernate.initialize(p.getGiftList());
    session.close();
    return p;
  }

  @Override
  public void save(Person person) {
    // Open a session
    Session session = sessionFactory.openSession();

    // Begin a transaction
    session.beginTransaction();

    // Save the person
    session.saveOrUpdate(person);

    // Commit the transaction
    session.getTransaction().commit();

    // Close the session
    session.close();
  }

  @Override
  public void delete(Person person) {
    // Open a session
    Session session = sessionFactory.openSession();

    // Begin a transaction
    session.beginTransaction();

    // Save the person
    session.delete(person);

    // Commit the transaction
    session.getTransaction().commit();

    // Close the session
    session.close();
  }
}
