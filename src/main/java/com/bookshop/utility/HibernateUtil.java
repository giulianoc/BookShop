/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author giuliano
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;
    
    public static SessionFactory configureSessionFactory()
            throws HibernateException {
        Configuration configuration = new Configuration();

        configuration.configure();

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        
        serviceRegistryBuilder.applySettings(configuration.getProperties());

        serviceRegistry = serviceRegistryBuilder.build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
       return sessionFactory;
    }
    
    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
