package com.portal.service;

import java.util.List;
import java.util.Map;

import com.portal.entity.Fund;

public interface IFundService {

  public void create(Fund fund);

  public void delete(String ids);

  public List<Fund> findByKeyWord(Map<String, Object> params);

  public List<Fund> findList(Map<String, Object> params);

  public Long findListCount(Map<String, Object> params);

  public Fund findOne(Long id);

  public void update(Fund fund);

}
