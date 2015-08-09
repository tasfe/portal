package com.portal.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.portal.common.PageEntity;
import com.portal.common.PagingResult;
import com.portal.dao.IAssetDao;
import com.portal.entity.Asset;

@Service
public class AssetDao extends BaseDao<Asset, Long> implements IAssetDao {

  private final String namespace = Asset.class.getName();

  @Override
  public void create(Asset asset) {
    super.save(asset);
  }

  @Override
  public void deleteByIds(String ids) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", ids);
    sqlSession.update(namespace + ".deleteByIds", params);

  }

  @Override
  public List<Asset> findByKeyWord(Map<String, Object> params) {

    return sqlSession.selectList(namespace + ".findByKeyWord", params);
  }

  @Override
  public List<Asset> findList(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return sqlSession.selectList(namespace + ".findList", params);
  }

  @Override
  public Long findListCount(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return sqlSession.selectOne(namespace + ".findListCount", params);
  }

  @Override
  public PagingResult<Asset> selectPagination(PageEntity param) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(Asset t) {
    super.update("update", t);
  }

}
