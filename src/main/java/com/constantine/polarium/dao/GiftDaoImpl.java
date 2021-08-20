package com.constantine.polarium.dao;

import com.constantine.polarium.model.Gift;
import com.constantine.polarium.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GiftDaoImpl implements GiftDao{
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @SuppressWarnings("unchecked")
  public List<Gift> findAll() {
    // Open a session
    Session session = sessionFactory.openSession();

    // Get all people with a Hibernate criteria
    List<Gift> all = session.createCriteria(Gift.class).list();

    // Close session
    session.close();

    return all;
  }

  @Override
  public Gift findById(Long id) {
    Session session = sessionFactory.openSession();
    Gift p = session.get(Gift.class,id);
    session.close();
    return p;
  }

  @Override
  public void save(Gift gift) {
    // Open a session
    Session session = sessionFactory.openSession();

    // Begin a transaction
    session.beginTransaction();

    // Save the person
    session.saveOrUpdate(gift);

    // Commit the transaction
    session.getTransaction().commit();

    // Close the session
    session.close();
  }

  @Override
  public void delete(Gift gift) {
    // Open a session
    Session session = sessionFactory.openSession();

    // Begin a transaction
    session.beginTransaction();

    // Save the person
    session.delete(gift);

    // Commit the transaction
    session.getTransaction().commit();

    // Close the session
    session.close();
  }
}
