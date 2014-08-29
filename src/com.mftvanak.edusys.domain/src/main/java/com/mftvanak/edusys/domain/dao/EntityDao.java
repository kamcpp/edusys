package com.mftvanak.edusys.domain.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mftvanak.edusys.domain.HibernateUtil;


public abstract class EntityDao < T > {

  private Class < T > type;

  public EntityDao (Class < T > type) {
    this.type = type;
  }

  public void save (T entity) {
    Session session = HibernateUtil.getSessionFactory ().openSession ();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction ();
      session.saveOrUpdate (entity);
      transaction.commit ();
    } catch (HibernateException e) {
      transaction.rollback ();
      e.printStackTrace ();
      throw e;
    } finally {
      session.close ();
    }
  }

  @SuppressWarnings ("unchecked")
  public void delete (Long id) {
    Session session = HibernateUtil.getSessionFactory ().openSession ();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction ();
      T entity = (T) session.get (type, id);
      session.delete (entity);
      transaction.commit ();
    } catch (HibernateException e) {
      transaction.rollback ();
      e.printStackTrace ();
      throw e;
    } finally {
      session.close ();
    }
  }

  @SuppressWarnings ("unchecked")
  public T getById (Long id) {
    Session session = HibernateUtil.getSessionFactory ().openSession ();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction ();
      T entity = (T) session.get (type, id);
      transaction.commit ();
      return entity;
    } catch (HibernateException e) {
      transaction.rollback ();
      e.printStackTrace ();
      throw e;
    } finally {
      session.close ();
    }
  }

  public List < T > getAll () {
    String className = type.toString ();
    String[] tokens = type.toString ().split (" ");
    if (tokens.length > 1) {
      className = tokens[1];
    }
    List < T > entities = executeQueryAsList ("from " + className, null, 0);
    return entities;
  }

  @SuppressWarnings ({"unchecked", "rawtypes"})
  protected List < T > executeQueryAsList (String query, Map < String, Object > params, int numberOfRows) {
    Session session = HibernateUtil.getSessionFactory ().openSession ();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction ();
      Query q = session.createQuery (query);
      if (params != null) {
        for (String key : params.keySet ()) {
          q.setParameter (key, params.get (key));
        }
      }
      if (numberOfRows > 0) {
        q.setMaxResults (numberOfRows);
      }
      List result = q.list ();
      transaction.commit ();
      return result;
    } catch (HibernateException e) {
      transaction.rollback ();
      e.printStackTrace ();
      throw e;
    } finally {
      session.close ();
    }
  }
}
