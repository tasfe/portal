package com.portal.dao.impl;

import org.springframework.stereotype.Service;

import com.portal.common.PageEntity;
import com.portal.common.PagingResult;
import com.portal.dao.IFavDao;
import com.portal.entity.Fav;

@Service
public class FavDao extends BaseDao<Fav, Long> implements IFavDao {

  @Override
  public PagingResult<Fav> selectPagination(PageEntity param) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(Fav t) {
    super.update("update", t);
  }
}
