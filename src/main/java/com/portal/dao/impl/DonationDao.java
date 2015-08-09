package com.portal.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.portal.common.PageEntity;
import com.portal.common.PagingResult;
import com.portal.dao.IDonationDao;
import com.portal.entity.Donation;

@Service
public class DonationDao extends BaseDao<Donation, Long> implements IDonationDao {

  private final String namespace = Donation.class.getName();

  @Override
  public void create(Donation donation) {
    super.save(donation);

  }

  @Override
  public void deleteByIds(String ids) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", ids);
    sqlSession.update(namespace + ".deleteByIds", params);

  }

  @Override
  public List<Donation> findByKeyWord(Map<String, Object> params) {

    return sqlSession.selectList(namespace + ".findByKeyWord", params);
  }

  @Override
  public List<Donation> findList(Map<String, Object> params) {

    return sqlSession.selectList(namespace + ".findList", params);
  }

  @Override
  public Long findListCount(Map<String, Object> params) {
    return sqlSession.selectOne(namespace + ".findListCount", params);
  }

  @Override
  public PagingResult<Donation> selectPagination(PageEntity param) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(Donation t) {
    super.update("update", t);
  }
}
