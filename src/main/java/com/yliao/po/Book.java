package com.yliao.po;

import java.util.Date;
import java.io.Serializable;

/**
* Created by superyao12@sina.com on 2017-09-06 22:10:20.
 * 图书实体
 */
public class Book implements Serializable{
    /**
     * 编号
     */
    private int id;
    /**
     * 书名
     */
    private String title;
    /**
     * 价格
     */
    private double price;
    /**
     * 出版日期
     */
    private Date publishDate;

    public Book(int id, String title, double price, Date publishDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
    }
    
    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
@Override
public String toString() {
return this.getTitle()+"---"+this.getId()+"----"+this.getPrice()+"--------";
}
}