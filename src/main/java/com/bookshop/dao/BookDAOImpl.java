/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.dao;

import com.bookshop.domain.Book;
import com.bookshop.utility.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javassist.compiler.TokenId;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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
            // throw e;
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
    public List<Book> listBooks(String bookNameCriteria, String isbnCriteria) 
    {
        if (bookNameCriteria == null && isbnCriteria == null)
        {
            return new ArrayList<Book>();
        }
        
        /*
        Query query;
        
        if (isbnCriteria == null) 
        {
            query = session.createQuery("FROM Books WHERE BookName LIKE '%" + bookNameCriteria + "%'");
        } 
        else if(bookNameCriteria == null) 
        {
            query = session.createQuery("FROM Books WHERE ISBN LIKE '%" + isbnCriteria + "%'");
        }
        else // if(bookNameCriteria != null && isbnCriteria != null) 
        {
            query = session.createQuery("FROM Books WHERE ISBN LIKE '%" + isbnCriteria + "%' AND BookName LIKE '%" + bookNameCriteria + "%'");
        }
        
        return query.list();
        */
        
        Criteria criteria = session.createCriteria(Book.class);

        if (isbnCriteria == null) 
        {
            Criterion bookNameCriterion = Restrictions.like("bookName", bookNameCriteria, MatchMode.ANYWHERE);
            criteria.add(bookNameCriterion);
        } 
        else if(bookNameCriteria == null) 
        {
            Criterion isbnCriterion = Restrictions.like("ISBN", isbnCriteria, MatchMode.ANYWHERE);
            criteria.add(isbnCriterion);
        }
        else // if(bookNameCriteria != null && isbnCriteria != null) 
        {
            Criterion bookNameCriterion = Restrictions.like("bookName", bookNameCriteria, MatchMode.ANYWHERE);
            Criterion isbnCriterion = Restrictions.like("ISBN", isbnCriteria, MatchMode.ANYWHERE);
            LogicalExpression orExp = Restrictions.and(bookNameCriterion, isbnCriterion);
            criteria.add(orExp);
        }

        return criteria.list();
    }

    @Override
    public List<Book> listBooks(String searchCriteria) 
    {
        if (searchCriteria == null)
        {
            return new ArrayList<Book>();
        }       
        
        Criteria criteria = session.createCriteria(Book.class);

        Criterion bookNameCriterion = Restrictions.like("bookName", searchCriteria, MatchMode.ANYWHERE);
        Criterion isbnCriterion = Restrictions.like("ISBN", searchCriteria, MatchMode.ANYWHERE);
        Criterion editionCriterion = Restrictions.like("edition", searchCriteria, MatchMode.ANYWHERE);
        // Criterion yearCriterion = Restrictions.eq("year", searchCriteria);
        Criterion synopsisCriterion = Restrictions.like("synopsis", searchCriteria, MatchMode.ANYWHERE);
        Criterion aboutAuthorsCriterion = Restrictions.like("aboutAuthors", searchCriteria, MatchMode.ANYWHERE);
        Criterion topicsCoveredCriterion = Restrictions.like("topicsCovered", searchCriteria, MatchMode.ANYWHERE);
        Criterion contentsCDROMCriterion = Restrictions.like("contentsCDROM", searchCriteria, MatchMode.ANYWHERE);
        // Criterion costCriterion = Restrictions.like("cost", searchCriteria, MatchMode.ANYWHERE);
        Criterion firstAuthorCriterion = Restrictions.like("firstAuthor", searchCriteria, MatchMode.ANYWHERE);
        Criterion secondAuthorCriterion = Restrictions.like("secondAuthor", searchCriteria, MatchMode.ANYWHERE);
        Criterion thirdAuthorCriterion = Restrictions.like("thirdAuthor", searchCriteria, MatchMode.ANYWHERE);
        Criterion fourthAuthorCriterion = Restrictions.like("fourthAuthor", searchCriteria, MatchMode.ANYWHERE);
       
        criteria.add(Restrictions.disjunction().add(bookNameCriterion).add(isbnCriterion).add(editionCriterion).
            add(synopsisCriterion).add(aboutAuthorsCriterion).add(topicsCoveredCriterion).add(contentsCDROMCriterion).
            add(firstAuthorCriterion).add(secondAuthorCriterion).add(thirdAuthorCriterion).add(fourthAuthorCriterion));

        return criteria.list();
    }

    @Override
    public Book listBookByBookNo(Integer bookNo) {
        return (Book) session.load(Book.class, bookNo);
    }
}
