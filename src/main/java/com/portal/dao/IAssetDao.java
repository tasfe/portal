package com.portal.dao;

import java.util.List;
import java.util.Map;

import com.portal.entity.Asset;

public interface IAssetDao extends IBaseDao<Asset, Long> {

  public void create(Asset asset);

  public void deleteByIds(String ids);

  public List<Asset> findByKeyWord(Map<String, Object> params);

  public List<Asset> findList(Map<String, Object> params);

  public Long findListCount(Map<String, Object> params);

}
