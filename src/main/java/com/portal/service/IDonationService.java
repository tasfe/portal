package com.portal.service;

import java.util.List;
import java.util.Map;

import com.portal.entity.Donation;

public interface IDonationService {

  public void create(Donation donation);

  public void delete(String ids);

  public List<Donation> findByKeyWord(Map<String, Object> params);

  public List<Donation> findList(Map<String, Object> params);

  public Long findListCount(Map<String, Object> params);

  public Donation findOne(Long id);

  public void update(Donation donation);

}
