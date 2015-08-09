package com.portal.dao.impl;

import org.springframework.stereotype.Service;

import com.portal.common.PageEntity;
import com.portal.common.PagingResult;
import com.portal.dao.IBookDao;
import com.portal.entity.Book;

@Service
public class BookDao extends BaseDao<Book, Long> implements IBookDao {

  @Override
  public PagingResult<Book> selectPagination(PageEntity param) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(Book t) {
    super.update("update", t);
  }
}
