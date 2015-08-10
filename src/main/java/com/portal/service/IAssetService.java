package com.portal.service;

import java.util.List;
import java.util.Map;

import com.portal.entity.Asset;

public interface IAssetService {

  public void create(Asset asset);

  public void delete(String ids);

  public List<Asset> findByKeyWord(Map<String, Object> params);

  public List<Asset> findList(Map<String, Object> params);

  public Long findListCount(Map<String, Object> params);

  public Asset findOne(Long id);

  public void update(Asset asset);

}
