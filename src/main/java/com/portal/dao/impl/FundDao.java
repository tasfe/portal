package com.portal.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.portal.common.PageEntity;
import com.portal.common.PagingResult;
import com.portal.dao.IFundDao;
import com.portal.entity.Fund;

@Service
public class FundDao extends BaseDao<Fund, Long> implements IFundDao {

  private final String namespace = Fund.class.getName();

  @Override
  public void create(Fund fund) {
    super.save(fund);

  }

  @Override
  public void deleteByIds(String ids) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", ids);
    sqlSession.update(namespace + ".deleteByIds", params);

  }

  @Override
  public List<Fund> findByKeyWord(Map<String, Object> params) {

    return sqlSession.selectList(namespace + ".findByKeyWord", params);
  }

  @Override
  public List<Fund> findList(Map<String, Object> params) {

    return sqlSession.selectList(namespace + ".findList", params);
  }

  @Override
  public Long findListCount(Map<String, Object> params) {

    return sqlSession.selectOne(namespace + ".findListCount", params);
  }

  @Override
  public PagingResult<Fund> selectPagination(PageEntity param) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(Fund t) {
    super.update("update", t);
  }
}
