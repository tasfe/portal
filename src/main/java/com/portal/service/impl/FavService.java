package com.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.IFavDao;
import com.portal.entity.Fav;
import com.portal.service.IFavService;

@Service
public class FavService implements IFavService {

  @Autowired
  IFavDao favDao;

  @Override
  public void createOne(Fav fav) {
    favDao.save(fav);
  }

}
