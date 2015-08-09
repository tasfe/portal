package com.portal.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.portal.common.PageEntity;
import com.portal.common.PagingResult;
import com.portal.dao.IAccountDao;
import com.portal.entity.Account;

@Service
public class AccountDao extends BaseDao<Account, Long> implements IAccountDao {

  private final String namespace = Account.class.getName();

  @Override
  public Account findByPhone(String mobilePhone) {
    // TODO Auto-generated method stub
    return sqlSession.selectOne(namespace + ".findByPhone", mobilePhone);
  }

  @Override
  public Account findByPhoneAndType(String mobilePhone, int userType) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("mobilePhone", mobilePhone);
    params.put("userType", userType);
    return sqlSession.selectOne(namespace + ".findByPhoneAndType", params);
  }

  @Override
  public PagingResult<Account> selectPagination(PageEntity param) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(Account t) {
    super.update("update", t);
  }

}
