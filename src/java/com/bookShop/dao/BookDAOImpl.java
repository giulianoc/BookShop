/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookShop.dao;

import com.bookShop.domain.Book;
import com.bookShop.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author giuliano
 */
public class BookDAOImpl implements BookDAO {
    Session session = HibernateUtil.getSession();
    Transaction transaction;

    @Override
    public void saveBook(Book book) {
        try {
            transaction = session.beginTransaction();
            session.merge(book);
            transaction.commit();
        } catch (Exception e) {
            if (book != null)
            {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void deleteBook(Book book) {
        transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
    }

    @Override
    public List<Book> listBooks() {
        return session.createQuery("from Books").list();
    }

    @Override
    public Book listBookByBookNo(Integer bookNo) {
        return (Book) session.load(Book.class, bookNo);
    }
}
