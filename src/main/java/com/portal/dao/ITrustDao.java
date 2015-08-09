package com.portal.dao;

import java.util.List;
import java.util.Map;

import com.portal.entity.Trust;

public interface ITrustDao extends IBaseDao<Trust, Long> {

  public void create(Trust trust);

  public void deleteByIds(String ids);

  public List<Trust> findByKeyWord(Map<String, Object> params);

  public List<Trust> findList(Map<String, Object> params);

  public Long findListCount(Map<String, Object> params);
}
