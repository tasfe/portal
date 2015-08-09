package com.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.IBookDao;
import com.portal.entity.Book;
import com.portal.service.IBookService;

@Service
public class BookService implements IBookService {

  @Autowired
  IBookDao bookDao;

  @Override
  public void create(Book book) {
    bookDao.save(book);

  }
}
