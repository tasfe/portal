package com.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.portal.entity.User;
import com.portal.service.IUserService;

@Service
public class UserService implements IUserService {

  @Override
  public List<User> findAllBankDtos() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Map<String, String>> getLikeBank(String province, String cityName, String bankName, String linkBranName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Map<String, String>> getOpenBank(String province, String cityName, String bankName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public User Login(String name) {
    // TODO Auto-generated method stub
    return null;
  }
  // @Resource
  // private IUserDao<User> bankDao;
  //
  // public static Map<String, User> bankMap = new HashMap<String, User>();
  //
  // @Override
  // public List<User> findAllBankDtos() {
  // List<User> list = new ArrayList<User>(bankMap.values());
  // return list;
  // }
  //
  // @Override
  // public List<Map<String, String>> getLikeBank(String province, String cityName, String bankName,
  // String linkBranName) {
  // return bankDao.getLikeBank(province, cityName, bankName, linkBranName);
  // }
  //
  // @Override
  // public List<Map<String, String>> getOpenBank(String province, String cityName, String bankName)
  // {
  // return bankDao.getOpenBank(province, cityName, bankName);
  // }
  //
  // @Override
  // public User Login(String name) {
  // return bankDao.Login(name);
  // }

}
