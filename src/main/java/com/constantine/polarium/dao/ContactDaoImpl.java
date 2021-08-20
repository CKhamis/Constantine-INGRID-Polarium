package com.constantine.polarium.dao;

import com.constantine.polarium.model.DoubleText;
import com.constantine.polarium.model.Gift;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao{
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @SuppressWarnings("unchecked")
  public List<DoubleText> findAll() {
    // Open a session
    Session session = sessionFactory.openSession();

    // Get all people with a Hibernate criteria
    List<DoubleText> all = session.createCriteria(DoubleText.class).list();

    // Close session
    session.close();

    return all;
  }

  @Override
  public DoubleText findById(Long id) {
    Session session = sessionFactory.openSession();
    DoubleText p = session.get(DoubleText.class,id);
    session.close();
    return p;
  }

  @Override
  public void save(DoubleText contact) {
    // Open a session
    Session session = sessionFactory.openSession();

    // Begin a transaction
    session.beginTransaction();

    // Save the person
    session.saveOrUpdate(contact);

    // Commit the transaction
    session.getTransaction().commit();

    // Close the session
    session.close();
  }

  @Override
  public void delete(DoubleText contact) {
    // Open a session
    Session session = sessionFactory.openSession();

    // Begin a transaction
    session.beginTransaction();

    // Save the person
    session.delete(contact);

    // Commit the transaction
    session.getTransaction().commit();

    // Close the session
    session.close();
  }
}
