/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookShop.action;

import com.bookShop.dbConnection.DBConnection;
import com.bookShop.domain.Book;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author giuliano
 */
public class SearchBooksAction extends ActionSupport {
    private String searchCriteria;
    private ArrayList<Book> books = new ArrayList<Book>();

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String execute() throws Exception {
        DBConnection db = new DBConnection();
        db.getConnection();
        String SQL = "SELECT * FROM Books WHERE BookName LIKE '%" + searchCriteria +
            "%' OR ISBN LIKE '%" + searchCriteria + "%' OR Edition LIKE '%" + searchCriteria +
            "%' OR Year LIKE '%" + searchCriteria + "%' OR Synopsis LIKE '%" + searchCriteria +
            "%' OR AboutAuthors LIKE '%" + searchCriteria + "%' OR TopicsCovered LIKE '%" +
            searchCriteria + "%' OR ContentsCDROM LIKE '%" + searchCriteria + "%' OR Cost LIKE '%" +
            searchCriteria  + "%' OR FirstAuthor LIKE '%" + searchCriteria + "%' OR SecondAuthor LIKE '%" +
            searchCriteria + "%' OR ThirdAuthor LIKE '%" + searchCriteria + "%' OR FourthAuthor LIKE '%" +
            searchCriteria + "%'";
        System.out.println(SQL);
        ResultSet rs = db.stmt.executeQuery(SQL);
        while(rs.next()){
            Book bk = new Book(rs.getInt("BookNo"), rs.getString("BookName"),
                rs.getString("PublisherName"), rs.getString("Category"),
                rs.getString("ISBN"), rs.getString("Edition"), rs.getString("FirstAuthor"), 
                rs.getString("SecondAuthor"), rs.getString("ThirdAuthor"), 
                rs.getString("FourthAuthor"), rs.getString("Synopsis"), 
                rs.getString("AboutAuthors"), rs.getString("TopicsCovered"),
                rs.getString("ContentsCDROM"), rs.getInt("Year"), rs.getInt("Cost"));
            books.add(bk);
        }
        db.removeConnection();
         
        return SUCCESS;
    }
    
    
}
