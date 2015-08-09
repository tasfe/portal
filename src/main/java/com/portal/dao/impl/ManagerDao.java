package com.portal.dao.impl;

import org.springframework.stereotype.Service;

import com.portal.common.PageEntity;
import com.portal.common.PagingResult;
import com.portal.dao.IManagerDao;
import com.portal.entity.Manager;

@Service
public class ManagerDao extends BaseDao<Manager, Long> implements IManagerDao {

  private final String namespace = Manager.class.getName();

  @Override
  public Manager findByPhone(String mobilePhone) {
    // TODO Auto-generated method stub
    return sqlSession.selectOne(namespace + ".findByPhone", mobilePhone);
  }

  @Override
  public PagingResult<Manager> selectPagination(PageEntity param) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(Manager t) {
    super.update("update", t);
  }
}
