package com.constantine.polarium.dao;

import com.constantine.polarium.model.Contact;
import com.constantine.polarium.model.Drug;
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
  public List<Contact> findAll() {
    // Open a session
    Session session = sessionFactory.openSession();

    // Get all people with a Hibernate criteria
    List<Contact> all = session.createCriteria(Contact.class).list();

    // Close session
    session.close();

    return all;
  }

  @Override
  public Contact findById(Long id) {
    Session session = sessionFactory.openSession();
    Contact p = session.get(Contact.class,id);
    session.close();
    return p;
  }

  @Override
  public void save(Contact contact) {
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
  public void delete(Contact contact) {
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
