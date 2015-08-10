package com.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.IAssetDao;
import com.portal.entity.Asset;
import com.portal.service.IAssetService;

@Service
public class AssetService implements IAssetService {

  @Autowired
  IAssetDao assetDao;

  @Override
  public void create(Asset asset) {
    assetDao.save(asset);

  }

  @Override
  public void delete(String ids) {
    assetDao.deleteByIds(ids);

  }

  @Override
  public List<Asset> findByKeyWord(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return assetDao.findByKeyWord(params);
  }

  @Override
  public List<Asset> findList(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return assetDao.findList(params);
  }

  @Override
  public Long findListCount(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return assetDao.findListCount(params);
  }

  @Override
  public Asset findOne(Long id) {
    // TODO Auto-generated method stub
    return assetDao.findById(id);
  }

  @Override
  public void update(Asset asset) {
    assetDao.update(asset);
  }

}
