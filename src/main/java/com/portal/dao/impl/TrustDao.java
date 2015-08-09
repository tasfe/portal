package com.portal.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.portal.common.PageEntity;
import com.portal.common.PagingResult;
import com.portal.dao.ITrustDao;
import com.portal.entity.Trust;

@Service
public class TrustDao extends BaseDao<Trust, Long> implements ITrustDao {

  private final String namespace = Trust.class.getName();

  @Override
  public void create(Trust trust) {
    super.save(trust);
  }

  @Override
  public void deleteByIds(String ids) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", ids);
    sqlSession.update(namespace + ".deleteByIds", params);
  }

  @Override
  public List<Trust> findByKeyWord(Map<String, Object> params) {

    return sqlSession.selectList(namespace + ".findByKeyWord", params);
  }

  @Override
  public List<Trust> findList(Map<String, Object> params) {
    return sqlSession.selectList(namespace + ".findList", params);
  }

  @Override
  public Long findListCount(Map<String, Object> params) {
    return sqlSession.selectOne(namespace + ".findListCount", params);
  }

  @Override
  public PagingResult<Trust> selectPagination(PageEntity param) {
    return null;
  }

  @Override
  public void update(Trust t) {
    super.update("update", t);
  }

}
