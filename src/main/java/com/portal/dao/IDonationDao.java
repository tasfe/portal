package com.portal.dao;

import java.util.List;
import java.util.Map;

import com.portal.entity.Donation;

public interface IDonationDao extends IBaseDao<Donation, Long> {

  public void create(Donation donation);

  public void deleteByIds(String ids);

  public List<Donation> findByKeyWord(Map<String, Object> params);

  public List<Donation> findList(Map<String, Object> params);

  public Long findListCount(Map<String, Object> params);
}
