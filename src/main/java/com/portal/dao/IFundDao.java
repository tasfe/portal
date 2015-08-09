package com.portal.dao;

import java.util.List;
import java.util.Map;

import com.portal.entity.Fund;

public interface IFundDao extends IBaseDao<Fund, Long> {

  public void create(Fund fund);

  public void deleteByIds(String ids);

  public List<Fund> findByKeyWord(Map<String, Object> params);

  public List<Fund> findList(Map<String, Object> params);

  public Long findListCount(Map<String, Object> params);
}
