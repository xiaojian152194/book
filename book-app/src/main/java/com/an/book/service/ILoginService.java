package com.an.book.service;

import com.an.book.entity.User;
import com.an.book.exception.BookException;

public interface ILoginService {
  /**
   * 前端用户登录方法
   *
   * @param user
   * @return
   * @throws MusicException
   */
  public User login(User user) throws BookException;

  /**
   * 前端用户注册方法
   *
   * @param user
   * @return
   * @throws MusicException
   */
  public User register(User user) throws BookException;
}
