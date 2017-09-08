package com.yliao.test;

import com.yliao.dao.BookDAO;
import com.yliao.po.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
* Created by superyao12@sina.com on 2017-09-06 22:10:20.
*spring 测试基类
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class SpringTestCase extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected BookDAO bookDAO;
    @Test
    public void test () {
        List<Book> allBooks = bookDAO.getAllBooks();
    }
}