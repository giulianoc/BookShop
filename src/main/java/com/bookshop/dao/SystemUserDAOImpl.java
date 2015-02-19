/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.dao;

import com.bookshop.domain.SystemUser;
import com.bookshop.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author giuliano
 */
public class SystemUserDAOImpl implements SystemUserDAO {
    Session session = HibernateUtil.getSession();

    @Override
    public SystemUser listSystemUserByUserNo(Integer userNo) {
        return (SystemUser) session.load(SystemUser.class, userNo);
    }    

    @Override
    public SystemUser listSystemUserByUsernameAndPassword(String username, String password) {
      List<SystemUser> systemUsers;
        Transaction transaction = null;
        try{
         transaction = session.beginTransaction();
       System.out.println("username: " + username + ", password: " + password);
        Query query = session.createQuery("from SystemUser where Username = :username and Password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        systemUsers = query.list();

        System.out.println("systemUsers.isEmpty(): " + systemUsers.isEmpty());
         transaction.commit();
      }catch (HibernateException e) {
         if (transaction!=null) transaction.rollback();
         e.printStackTrace(); 
            return null;
      }

        if (systemUsers.isEmpty())
        {
            return null;
        }
        else
        {
            return systemUsers.get(0);
        }
    }
}
