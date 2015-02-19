/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.action;

import com.bookshop.dao.BookDAO;
import com.bookshop.dao.BookDAOImpl;
// import com.bookShop.dbConnection.DBConnection;
import com.bookshop.domain.Book;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author giuliano
 */
public class UpdateBookAction extends ActionSupport{
    private String bookName;
    private String publisherName;
    private String category;
    private String isbn;
    private String edition;
    private String firstAuthor;
    private String secondAuthor;
    private String thirdAuthor;
    private String fourthAuthor;
    private String synopsis;
    private String aboutAuthors;
    private String topicsCovered;
    private String contentsCDROM;
    private int bookNo;
    private int year;
    private int cost;

    private BookDAO bookDAO = new BookDAOImpl();

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getFirstAuthor() {
        return firstAuthor;
    }

    public void setFirstAuthor(String firstAuthor) {
        this.firstAuthor = firstAuthor;
    }

    public String getSecondAuthor() {
        return secondAuthor;
    }

    public void setSecondAuthor(String secondAuthor) {
        this.secondAuthor = secondAuthor;
    }

    public String getThirdAuthor() {
        return thirdAuthor;
    }

    public void setThirdAuthor(String thirdAuthor) {
        this.thirdAuthor = thirdAuthor;
    }

    public String getFourthAuthor() {
        return fourthAuthor;
    }

    public void setFourthAuthor(String fourthAuthor) {
        this.fourthAuthor = fourthAuthor;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getAboutAuthors() {
        return aboutAuthors;
    }

    public void setAboutAuthors(String aboutAuthors) {
        this.aboutAuthors = aboutAuthors;
    }

    public String getTopicsCovered() {
        return topicsCovered;
    }

    public void setTopicsCovered(String topicsCovered) {
        this.topicsCovered = topicsCovered;
    }

    public String getContentsCDROM() {
        return contentsCDROM;
    }

    public void setContentsCDROM(String contentsCDROM) {
        this.contentsCDROM = contentsCDROM;
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String execute() throws Exception {
        Book book = new Book(bookNo, bookName, publisherName, category,
            isbn, edition, firstAuthor, secondAuthor,
            thirdAuthor, fourthAuthor, synopsis, aboutAuthors,
            topicsCovered, contentsCDROM, year, cost);

        bookDAO.saveBook(book);

        /*
        DBConnection db = new DBConnection();
        db.getConnection();
        String SQL = "UPDATE Books SET BookName ='" + bookName +
            "', FirstAuthor = '" + firstAuthor + "', SecondAuthor = '" + secondAuthor +
            "', ThirdAuthor = '" + thirdAuthor + "', FourthAuthor ='" + fourthAuthor + 
            "', PublisherName = '" + publisherName + "', Category = '" + category +
            "', ISBN = '" + isbn + "', Edition ='" + edition + "', Year = " + year +
            ", Cost = " + cost + ", Synopsis = '" + synopsis +
            "', AboutAuthors = '" + aboutAuthors + "', TopicsCovered = '" + topicsCovered +
            "', ContentsCDROM = '" + contentsCDROM + "' WHERE BookNo = " + bookNo;
        db.stmt.executeUpdate(SQL);
        db.removeConnection();
        */
        
        return SUCCESS;    
    }
}
