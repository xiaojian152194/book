package com.an.book.controller.springmvc.fg;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.an.book.commons.CommonParameters;
import com.an.book.commons.Contants;
import com.an.book.commons.ResponseRange;
import com.an.book.controller.springmvc.bg.UserController;
import com.an.book.entity.User;
import com.an.book.exception.BookException;
import com.an.book.service.ILoginService;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "/book" })
public class LoginController {
  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UserController.class);

  @javax.annotation.Resource(name = "com.an.book.LoginService")
  private ILoginService loginService;

  @RequestMapping(value = { "get_user" }, method = { RequestMethod.GET })
  @ResponseBody
  public ResponseRange<User> getUser(CommonParameters commonParameters, HttpServletRequest request) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginController.getUser ");
      log.debug("parameter commonParameters is : " + commonParameters);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (request.getSession().getAttribute(Contants.LOGIN_PROVE_FG) == null) {
        throw new BookException("用户尚未登录");
      }
      responseRange.setData((User) request.getSession().getAttribute(Contants.LOGIN_PROVE_FG));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "login" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<User> login(CommonParameters commonParameters, @RequestBody User user, HttpServletRequest request) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginController.login ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter user is : " + user);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (user == null || user.selfIsNull() || user.getUsername().equals("") || user.getPassword().equals("")) {
        throw new BookException("用户名或密码不能为空！");
      }
      user = loginService.login(user);
      request.getSession().setAttribute(Contants.LOGIN_PROVE_FG, user);
      responseRange.setData(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "register" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<User> register(CommonParameters commonParameters, @RequestBody User user) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginController.register ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter user is : " + user);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (user == null || user.selfIsNull() || user.getUsername().equals("") || user.getPassword().equals("")) {
        throw new BookException("必填项不能为空！");
      }
      user = loginService.register(user);
      responseRange.setData(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "logout" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<User> logout(CommonParameters commonParameters, HttpServletRequest request) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginController.logout ");
      log.debug("parameter commonParameters is : " + commonParameters);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      request.getSession().removeAttribute(Contants.LOGIN_PROVE_FG);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }
}
