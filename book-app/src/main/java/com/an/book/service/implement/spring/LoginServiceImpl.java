package com.an.book.service.implement.spring;

import java.util.ArrayList;
import java.util.List;

import com.an.book.commons.Contants;
import com.an.book.entity.User;
import com.an.book.exception.BookException;
import com.an.book.service.IBookService;
import com.an.book.service.ILoginService;

@org.springframework.stereotype.Service("com.an.book.LoginService")

public class LoginServiceImpl implements ILoginService {
  @javax.annotation.Resource(name = "com.an.book.BookService")
  private IBookService bookService;

  @Override
  public User login(User user) throws BookException {
    User searchUser = new User(), success = null;
    searchUser.setUsername(user.getUsername());
    List<User> users = new ArrayList<>(bookService.searchUser1(searchUser));
    if (users.isEmpty()) {
      throw new BookException(" 用户名不存在 ");
    }
    success = users.get(0);
    if (!success.getPassword().equals(user.getPassword())) {
      throw new BookException(" 密码错误 ");
    }
    return success;
  }

  @Override
  public User register(User user) throws BookException {
    User searchUser = new User(), success = null;
    searchUser.setUsername(user.getUsername());
    List<User> users = new ArrayList<>(bookService.searchUser1(searchUser));
    if (!users.isEmpty()) {
        throw new BookException(user.getUsername() + " 已被注册 ");
    }
    user.setHaveAuthority(Contants.NoOrFalse);
    success = bookService.saveUser(user);
    return success;
  }

}
