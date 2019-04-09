/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.controller.springmvc.bg;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.an.book.commons.CommonParameters;
import com.an.book.commons.Contants;
import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.commons.ResponseRange;
import com.an.book.entity.User;
import com.an.book.exception.BookException;
import com.an.book.pojo.search.UserSearch;
import com.an.book.service.IBookService;
import com.an.book.service.ILoginService;

/**
 * 该类是用户控制器。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "/book/user" })
public class UserController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UserController.class);

  @javax.annotation.Resource(name = "com.an.book.BookService")
  private IBookService bookService;
  
  @javax.annotation.Resource(name = "com.an.book.LoginService")
  private ILoginService loginService;


  @RequestMapping(value = { "single" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<User> save(CommonParameters commonParameters, @RequestBody User user) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.save ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter user is : " + user);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      bookService.saveUser(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<User> batchSave(CommonParameters commonParameters, @RequestBody List<User> users) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.batchSave ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter users is : " + users);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      bookService.batchSaveUser(users);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "single" }, method = { RequestMethod.PUT })
  @ResponseBody
  public ResponseRange<User> update(CommonParameters commonParameters, @RequestBody User user) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.update ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter user is : " + user);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      User user1 = new User();
      user1 = bookService.getUserByPrimaryKey(user.getId());
      if(user1.getUsername().equals("admin")){
        throw new BookException("此用户为最高管理员禁止修改！！");
      }
      bookService.updateUser(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.PUT })
  @ResponseBody
  public ResponseRange<User> batchUpdate(CommonParameters commonParameters, @RequestBody List<User> users) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.batchUpdate ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter users is : " + users);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      bookService.batchUpdateUser(users);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "single" }, method = { RequestMethod.DELETE })
  @ResponseBody
  public ResponseRange<User> remove(CommonParameters commonParameters, @RequestBody User user) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.remove ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter user is : " + user);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      User user1 = new User();
      user1 = bookService.getUserByPrimaryKey(user.getId());
      if(user1.getUsername().equals("admin")){
        throw new BookException("此用户为最高管理员禁止删除！！");
      }
      bookService.removeUser(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.DELETE })
  @ResponseBody
  public ResponseRange<User> batchRemove(CommonParameters commonParameters, @RequestBody List<User> users) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.batchRemove ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter users is : " + users);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      bookService.batchRemoveUser(users);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "/{id}" }, method = { RequestMethod.GET })
  @ResponseBody
  public ResponseRange<User> getByPrimaryKey(CommonParameters commonParameters, @PathVariable java.lang.String id) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.getByPrimaryKey ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter id is : " + id);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      responseRange.setData(bookService.getUserByPrimaryKey(id));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.GET })
  @ResponseBody
  public ResponseRange<User> get(CommonParameters commonParameters, UserSearch userSearch) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.get ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter userSearch is : " + userSearch);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (userSearch == null || userSearch.selfIsNull()) {
        if (commonParameters.isPageSerach()) {
          responseRange.setData(bookService.paginationGetAllUser(commonParameters.getPageSerachParameters()));
        } else {
          responseRange.setData(bookService.getAllUser());
        }
      } else {
        if (commonParameters.isPageSerach()) {
          responseRange.setData(bookService.paginationSearchUser(userSearch, commonParameters.getPageSerachParameters()));
        } else {
          responseRange.setData(bookService.searchUser(userSearch));
        }
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "import" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<User> batchImport(CommonParameters commonParameters, User user, @RequestParam CommonsMultipartFile importFile) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.batchImport ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter user is : " + user);
      log.debug("parameter importFile is : " + importFile);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      java.io.InputStream inputXML = new java.io.BufferedInputStream(getClass().getResourceAsStream("/template/read/User.xml"));
      org.jxls.reader.XLSReader mainReader = org.jxls.reader.ReaderBuilder.buildFromXML(inputXML);
      java.io.InputStream inputXLS = new java.io.BufferedInputStream(importFile.getInputStream());
      java.util.List<User> userList = new java.util.LinkedList<>();
      java.util.Map<String, Object> beans = new java.util.HashMap<>();
      beans.put("userList", userList);
      org.jxls.reader.XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
      if (readStatus.isStatusOK()) {
        if (user != null && !user.selfIsNull()) {
          user.cloneThisToCollection(userList);
        }
        bookService.batchSaveUser(userList);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "export" }, method = { RequestMethod.GET })
  @ResponseBody
  public org.springframework.http.ResponseEntity<byte[]> export(CommonParameters commonParameters, UserSearch userSearch) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.export ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter userSearch is : " + userSearch);
    }
    org.springframework.http.ResponseEntity<byte[]> response = null;
    try {
      List<PageRange<User>> pageRangeList = new java.util.LinkedList<>();
      List<String> sheetNames = new java.util.LinkedList<>();
      if (userSearch == null || userSearch.selfIsNull()) {
        PageSerachParameters page = new PageSerachParameters();
        page.setPageSize(60000l);
        long pageIndex = 1;
        PageRange<User> pageRange = null;
        do {
          page.setPageNumber(pageIndex);
          pageRange = bookService.paginationGetAllUser(page);
          pageRangeList.add(pageRange);
          sheetNames.add("第" + pageIndex + "页");
          pageIndex++;
        } while (pageRange.getPageCount() >= pageIndex);
      } else {
        PageSerachParameters page = new PageSerachParameters();
        page.setPageSize(60000l);
        long pageIndex = 1;
        PageRange<User> pageRange = null;
        do {
          page.setPageNumber(pageIndex);
          pageRange = bookService.paginationSearchUser(userSearch, commonParameters.getPageSerachParameters());
          pageRangeList.add(pageRange);
          sheetNames.add("第" + pageIndex + "页");
          pageIndex++;
        } while (pageRange.getPageCount() >= pageIndex);
      }
      java.io.InputStream is = this.getClass().getResourceAsStream("/template/write/User.xls");
      org.jxls.common.Context context = new org.jxls.common.Context();
      context.putVar("pageRangeSet", pageRangeList);
      context.putVar("sheetNames", sheetNames);
      java.io.ByteArrayOutputStream os = new java.io.ByteArrayOutputStream();
      org.jxls.util.JxlsHelper.getInstance().processTemplate(is,os, context);
      org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
      byte[] by= os.toByteArray(); 
      headers.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM);
      headers.setContentDispositionFormData("attachment",java.net.URLEncoder.encode("用户.xls", "UTF-8"));
      headers.setContentLength(by.length);
      response= new org.springframework.http.ResponseEntity<byte[]>(by, headers, org.springframework.http.HttpStatus.OK);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
    }
    return response;
  }
  
  @RequestMapping(value = { "get_user" }, method = { RequestMethod.GET })
  @ResponseBody
  public ResponseRange<User> getUser(CommonParameters commonParameters, HttpServletRequest request) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.getUser ");
      log.debug("parameter commonParameters is : " + commonParameters);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (request.getSession().getAttribute(Contants.LOGIN_PROVE_BG) == null) {
        throw new BookException("用户尚未登陆！！");
      }
      responseRange.setData((User) request.getSession().getAttribute(Contants.LOGIN_PROVE_BG));
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
      log.debug("Staring call UserController.login ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter user is : " + user);
    }
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      if (user == null || user.selfIsNull() || user.getPassword().equals("") || user.getUsername().equals("")) {
        throw new BookException("用户名或密码不能为空！");
      }
      User user1 = new User();
      user1.setUsername(user.getUsername());
      List<User> users = new ArrayList<>(bookService.searchUser1(user1));
      if (users.size() <= 0) {
        throw new BookException("用户不存在！");
      }
      if (users.get(0).getHaveAuthority().equals(Contants.NoOrFalse)) {
        throw new BookException("此用户不是管理员，禁止登陆！");
      }
      user = loginService.login(user);
      request.getSession().setAttribute(Contants.LOGIN_PROVE_BG, user);
      responseRange.setData(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }
  
  @RequestMapping(value = "{logout}", method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<User> logout(CommonParameters commonParameters, HttpServletRequest request) {
    ResponseRange<User> responseRange = new ResponseRange<>();
    try {
      request.getSession().removeAttribute(Contants.LOGIN_PROVE_BG);
    } catch (Exception e) {
      responseRange.setException(e);
    }
    return responseRange;
  }
}
