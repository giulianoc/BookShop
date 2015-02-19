/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author giuliano
 */
@Entity
@Table(name = "Books", uniqueConstraints = {@UniqueConstraint(columnNames={"ISBN"})})
public class Book implements java.io.Serializable {
    @Id
    @GeneratedValue
    @Column(name = "BookNo")
    private int bookNo;
    @Column(name = "BookName")
    private String bookName;
    @Column(name = "PublisherName")
    private String publisherName;
    @Column(name = "Category")
    private String category;
    @Column(name = "ISBN")
    private String ISBN;
    @Column(name = "Edition")
    private String edition;
    @Column(name = "FirstAuthor")
    private String firstAuthor;
    @Column(name = "SecondAuthor")
    private String secondAuthor;
    @Column(name = "ThirdAuthor")
    private String thirdAuthor;
    @Column(name = "FourthAuthor")
    private String fourthAuthor;
    @Column(name = "Synopsis")
    private String synopsis;
    @Column(name = "AboutAuthors")
    private String aboutAuthors;
    @Column(name = "TopicsCovered")
    private String topicsCovered;
    @Column(name = "ContentsCDROM")
    private String contentsCDROM;
    @Column(name = "Year")
    private int year;
    @Column(name = "Cost")
    private int cost;

    public Book() {
    }

    public Book(int bookNo, String bookName, String publisherName, String category,
        String ISBN, String edition, String firstAuthor, String secondAuthor,
        String thirdAuthor, String fourthAuthor, String synopsis, String aboutAuthors,
        String topicsCovered, String contentsCDROM, int year, int cost) 
    {
        this.bookNo = bookNo;        
        this.bookName = bookName;
        this.publisherName = publisherName;
        this.category = category;
        this.ISBN = ISBN;
        this.edition = edition;
        this.firstAuthor = firstAuthor;
        this.secondAuthor = secondAuthor;
        this.thirdAuthor = thirdAuthor;
        this.fourthAuthor = fourthAuthor;
        this.synopsis = synopsis;
        this.aboutAuthors = aboutAuthors;
        this.topicsCovered = topicsCovered;
        this.contentsCDROM = contentsCDROM;
        this.year = year;
        this.cost = cost;
    }

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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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
}
