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
public class ManageSearchBooksAction extends ActionSupport{
    private String searchISBN;
    private String searchBookName;
    private ArrayList<Book> books = new ArrayList<Book>();
    
    public String getSearchISBN() {
        return searchISBN;
    }

    public void setSearchISBN(String searchISBN) {
        this.searchISBN = searchISBN;
    }

    public String getSearchBookName() {
        return searchBookName;
    }

    public void setSearchBookName(String searchBookName) {
        this.searchBookName = searchBookName;
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
        String SQL = "";
        if (searchISBN == null) {
            SQL = "SELECT * FROM Books WHERE BookName LIKE '%" + searchBookName + "%'";
        } else if(searchBookName == null) {
            SQL = "SELECT * FROM Books WHERE ISBN LIKE '%" + searchISBN + "%'";
        } else if(searchBookName != null && searchISBN != null) {
            SQL = "SELECT * FROM Books WHERE ISBN LIKE '%" + searchISBN + "%' AND BookName LIKE '%" + searchBookName + "%'";
        }
        System.out.println(SQL);
        ResultSet rs = db.stmt.executeQuery(SQL);
        while(rs.next()){
            Book bk = new Book(rs.getInt("BookNo"), rs.getString("BookName"), rs.getString("PublisherName"), rs.getString("Category"), rs.getString("ISBN"), rs.getString("Edition"), rs.getString("FirstAuthor"), rs.getString("SecondAuthor"), rs.getString("ThirdAuthor"), rs.getString("FourthAuthor"), rs.getString("Synopsis"), rs.getString("AboutAuthors"), rs.getString("TopicsCovered"), rs.getString("ContentsCDROM"), rs.getInt("Year"), rs.getInt("Cost"));
            books.add(bk);
        }
        db.removeConnection();
        
        return SUCCESS;
    }
    
}
