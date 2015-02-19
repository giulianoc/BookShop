/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.utility;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.hibernate.HibernateException;

/**
 *
 * @author giuliano
 */
public class BookShopDispatcher extends StrutsPrepareAndExecuteFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
        
        try {
            HibernateUtil.configureSessionFactory();
            System.out.println("Application successful initialized");
        }
        catch(HibernateException e){
            System.out.println("Exception: " + e.getMessage());
            throw new ServletException();
        }
    }

}
