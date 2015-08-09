package com.portal.service;

import java.util.List;
import java.util.Map;

import com.portal.entity.Trust;

public interface ITrustService {

  public void create(Trust trust);

  public void delete(String ids);

  public List<Trust> findByKeyWord(Map<String, Object> params);

  public List<Trust> findList(Map<String, Object> params);

  public Long findListCount(Map<String, Object> params);

  public Trust findOne(Long id);

}
