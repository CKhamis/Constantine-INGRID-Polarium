package com.constantine.polarium.dao;

import com.constantine.polarium.model.cScore;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class cScoreDaoImpl implements cScoreDao {
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @SuppressWarnings("unchecked")
  public List<cScore> findAll() {
    // Open a session
    Session session = sessionFactory.openSession();

    // Get all people with a Hibernate criteria
    List<cScore> all = session.createCriteria(cScore.class).list();

    // Close session
    session.close();

    return all;
  }

  @Override
  public cScore findById(Long id) {
    Session session = sessionFactory.openSession();
    cScore p = session.get(cScore.class,id);
    session.close();
    return p;
  }

  @Override
  public void save(cScore score) {
    // Open a session
    Session session = sessionFactory.openSession();

    // Begin a transaction
    session.beginTransaction();

    // Save the person
    session.saveOrUpdate(score);

    // Commit the transaction
    session.getTransaction().commit();

    // Close the session
    session.close();
  }

  @Override
  public void delete(cScore score) {
    // Open a session
    Session session = sessionFactory.openSession();

    // Begin a transaction
    session.beginTransaction();

    // Save the person
    session.delete(score);

    // Commit the transaction
    session.getTransaction().commit();

    // Close the session
    session.close();
  }
}
