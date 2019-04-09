/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.service.implement.spring;

import java.util.Collection;
import java.util.UUID;

import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.entity.Book;
import com.an.book.entity.BookImage;
import com.an.book.entity.BookRecord;
import com.an.book.entity.User;
import com.an.book.exception.BookException;
import com.an.book.persistent.IBookImagePersistent;
import com.an.book.persistent.IBookPersistent;
import com.an.book.persistent.IBookRecordPersistent;
import com.an.book.persistent.IUserPersistent;
import com.an.book.pojo.search.BookImageSearch;
import com.an.book.pojo.search.BookRecordSearch;
import com.an.book.pojo.search.BookSearch;
import com.an.book.pojo.search.UserSearch;
import com.an.book.service.IBookService;

/**
 * 该类是以下对象操作的业务具休实现。
 * 图书借阅记录
 * 用户
 * 图书信息
 * 图书图片信息
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
@org.springframework.stereotype.Service("com.an.book.BookService")
@org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = java.lang.Exception.class)
public class BookServiceImpl implements IBookService {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(BookServiceImpl.class);

  @javax.annotation.Resource(name = "com.an.book.BookRecordPersistent")
  private IBookRecordPersistent bookRecordPersistent;

  @javax.annotation.Resource(name = "com.an.book.UserPersistent")
  private IUserPersistent userPersistent;

  @javax.annotation.Resource(name = "com.an.book.BookPersistent")
  private IBookPersistent bookPersistent;

  @javax.annotation.Resource(name = "com.an.book.BookImagePersistent")
  private IBookImagePersistent bookImagePersistent;

  @org.springframework.beans.factory.annotation.Autowired
  protected org.springframework.context.ApplicationEventPublisher publisher;
  // BookRecordPersistentImpl
  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveBookRecord(BookRecord bookRecord) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.saveBookRecord ");
      log.debug("parameter bookRecord is : " + bookRecord);
    }
    try {
      if (bookRecord == null || bookRecord.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
      }
      bookRecord.clearPrimaryKeyValue();
      if (bookRecord.getId() == null || bookRecord.getId().trim().length() < 1) {
        bookRecord.setId(UUID.randomUUID().toString());
      }
      bookRecordPersistent.saveBookRecord(bookRecord);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveBookRecord(Collection<BookRecord> bookRecords) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchSaveBookRecord ");
      log.debug("parameter bookRecords is : " + bookRecords);
    }
    try {
      if (bookRecords == null || bookRecords.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookRecords不能为空。");
      }
      for(BookRecord bookRecord : bookRecords) {
        if(bookRecord == null || bookRecord.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
        }
        bookRecord.clearPrimaryKeyValue();
        if (bookRecord.getId() == null || bookRecord.getId().trim().length() < 1) {
          bookRecord.setId(UUID.randomUUID().toString());
        }
      }
      bookRecordPersistent.batchSaveBookRecord(bookRecords);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateBookRecord(BookRecord bookRecord) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.updateBookRecord ");
      log.debug("parameter bookRecord is : " + bookRecord);
    }
    try {
      if (bookRecord == null || bookRecord.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
      }
      if (bookRecord.getId() == null || bookRecord.getId().trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      BookRecord bookRecordOld = bookRecordPersistent.getBookRecordByPrimaryKey(bookRecord.getId());
      if (bookRecordOld == null) {
        throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
      }
      bookRecordPersistent.updateBookRecord(bookRecord);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateBookRecord(Collection<BookRecord> bookRecords) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchUpdateBookRecord ");
      log.debug("parameter bookRecords is : " + bookRecords);
    }
    try {
      if (bookRecords == null || bookRecords.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookRecords不能为空。");
      }
      for(BookRecord bookRecord : bookRecords) {
        if(bookRecord == null || bookRecord.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
        }
        if (bookRecord.getId() == null || bookRecord.getId().trim().length() < 1) {
          throw new java.lang.IllegalArgumentException("id不能为空。");
        }
        BookRecord bookRecordOld = bookRecordPersistent.getBookRecordByPrimaryKey(bookRecord.getId());
        if (bookRecordOld == null) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
      }
      bookRecordPersistent.batchUpdateBookRecord(bookRecords);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeBookRecord(BookRecord bookRecord) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.removeBookRecord ");
      log.debug("parameter bookRecord is : " + bookRecord);
    }
    try {
      if (bookRecord == null || bookRecord.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
      }
      java.util.Set<BookRecord> deleteBookRecords = new java.util.LinkedHashSet<>();
      if (bookRecord.getId() != null && bookRecord.getId().trim().length() > 0) {
        BookRecord bookRecordOld = bookRecordPersistent.getBookRecordByPrimaryKey(bookRecord.getId());
        if (bookRecordOld == null ) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
        deleteBookRecords.add(bookRecordOld);
      } else {
        BookRecordSearch bookRecordSearch = new BookRecordSearch();
        bookRecordSearch.setEntity(bookRecord);
        deleteBookRecords.addAll(bookRecordPersistent.searchBookRecord(bookRecordSearch));
      }
      if (deleteBookRecords != null && !deleteBookRecords.isEmpty()) {
        bookRecordPersistent.batchRemoveBookRecord(deleteBookRecords);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveBookRecord(Collection<BookRecord> bookRecords) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchRemoveBookRecord ");
      log.debug("parameter bookRecords is : " + bookRecords);
    }
    try {
      if (bookRecords == null || bookRecords.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookRecords不能为空。");
      }
      java.util.Set<BookRecord> deleteBookRecords = new java.util.LinkedHashSet<>();
      for(BookRecord bookRecord : bookRecords) {
        if (bookRecord.getId() != null && bookRecord.getId().trim().length() > 0) {
          BookRecord bookRecordOld = bookRecordPersistent.getBookRecordByPrimaryKey(bookRecord.getId());
          if (bookRecordOld == null ) {
            throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
          }
          deleteBookRecords.add(bookRecordOld);
        } else {
          BookRecordSearch bookRecordSearch = new BookRecordSearch();
          bookRecordSearch.setEntity(bookRecord);
          deleteBookRecords.addAll(bookRecordPersistent.searchBookRecord(bookRecordSearch));
        }
      }
      if (deleteBookRecords != null && !deleteBookRecords.isEmpty()) {
        bookRecordPersistent.batchRemoveBookRecord(deleteBookRecords);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BookRecord getBookRecordByPrimaryKey(java.lang.String id) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getBookRecordByPrimaryKey ");
      log.debug("parameter id is : " + id);
    }
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      return bookRecordPersistent.getBookRecordByPrimaryKey(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getCountBookRecord(final BookRecordSearch bookRecordSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getCountBookRecord ");
      log.debug("parameter bookRecordSearch is : " + bookRecordSearch);
    }
    try {
      return bookRecordPersistent.getCountBookRecord(bookRecordSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<BookRecord> getAllBookRecord() throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getAllBookRecord ");
    }
    try {
      return bookRecordPersistent.getAllBookRecord();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<BookRecord> paginationGetAllBookRecord(PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.paginationGetAllBookRecord ");
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return bookRecordPersistent.paginationGetAllBookRecord(page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<BookRecord> searchBookRecord(final BookRecordSearch bookRecordSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.searchBookRecord ");
      log.debug("parameter bookRecordSearch is : " + bookRecordSearch);
    }
    try {
      return bookRecordPersistent.searchBookRecord(bookRecordSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<BookRecord> paginationSearchBookRecord(final BookRecordSearch bookRecordSearch, PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.paginationSearchBookRecord ");
      log.debug("parameter bookRecordSearch is : " + bookRecordSearch);
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return bookRecordPersistent.paginationSearchBookRecord(bookRecordSearch, page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  // UserPersistentImpl
  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public User saveUser(User user) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.saveUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      user.clearPrimaryKeyValue();
      if (user.getId() == null || user.getId().trim().length() < 1) {
        user.setId(UUID.randomUUID().toString());
      }
      user.setCreateDate(System.currentTimeMillis());
      return userPersistent.saveUser(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveUser(Collection<User> users) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchSaveUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      for(User user : users) {
        if(user == null || user.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("user不能为空。");
        }
        user.clearPrimaryKeyValue();
        if (user.getId() == null || user.getId().trim().length() < 1) {
          user.setId(UUID.randomUUID().toString());
        }
      }
      userPersistent.batchSaveUser(users);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateUser(User user) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.updateUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      if (user.getId() == null || user.getId().trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      User userOld = userPersistent.getUserByPrimaryKey(user.getId());
      if (userOld == null) {
        throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
      }
      user.setCreateDate(System.currentTimeMillis());
      userPersistent.updateUser(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateUser(Collection<User> users) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchUpdateUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      for(User user : users) {
        if(user == null || user.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("user不能为空。");
        }
        if (user.getId() == null || user.getId().trim().length() < 1) {
          throw new java.lang.IllegalArgumentException("id不能为空。");
        }
        User userOld = userPersistent.getUserByPrimaryKey(user.getId());
        if (userOld == null) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
      }
      userPersistent.batchUpdateUser(users);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeUser(User user) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.removeUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      java.util.Set<User> deleteUsers = new java.util.LinkedHashSet<>();
      if (user.getId() != null && user.getId().trim().length() > 0) {
        User userOld = userPersistent.getUserByPrimaryKey(user.getId());
        if (userOld == null ) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
        deleteUsers.add(userOld);
      } else {
        UserSearch userSearch = new UserSearch();
        userSearch.setEntity(user);
        deleteUsers.addAll(userPersistent.searchUser(userSearch));
      }
      if (deleteUsers != null && !deleteUsers.isEmpty()) {
        for(User deleteUser : deleteUsers) {
          BookSearch cascadeDeleteBookSearch = new BookSearch();
          cascadeDeleteBookSearch.setUserId(deleteUser.getId());
          Long count0 = bookPersistent.getCountBook(cascadeDeleteBookSearch);
          if (count0 > 0) {
            throw new BookException(" 数据被图书信息引用不能删除。");
          }
          BookRecordSearch cascadeDeleteBookRecordSearch = new BookRecordSearch();
          cascadeDeleteBookRecordSearch.setUserId(deleteUser.getId());
          Long count1 = bookRecordPersistent.getCountBookRecord(cascadeDeleteBookRecordSearch);
          if (count1 > 0) {
            throw new BookException(" 数据被图书借阅记录引用不能删除。");
          }
        }
        userPersistent.batchRemoveUser(deleteUsers);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveUser(Collection<User> users) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchRemoveUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      java.util.Set<User> deleteUsers = new java.util.LinkedHashSet<>();
      for(User user : users) {
        if (user.getId() != null && user.getId().trim().length() > 0) {
          User userOld = userPersistent.getUserByPrimaryKey(user.getId());
          if (userOld == null ) {
            throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
          }
          deleteUsers.add(userOld);
        } else {
          UserSearch userSearch = new UserSearch();
          userSearch.setEntity(user);
          deleteUsers.addAll(userPersistent.searchUser(userSearch));
        }
      }
      if (deleteUsers != null && !deleteUsers.isEmpty()) {
        for(User deleteUser : deleteUsers) {
          BookSearch cascadeDeleteBookSearch = new BookSearch();
          cascadeDeleteBookSearch.setUserId(deleteUser.getId());
          Long count0 = bookPersistent.getCountBook(cascadeDeleteBookSearch);
          if (count0 > 0) {
            throw new BookException(" 数据被图书信息引用不能删除。");
          }
          BookRecordSearch cascadeDeleteBookRecordSearch = new BookRecordSearch();
          cascadeDeleteBookRecordSearch.setUserId(deleteUser.getId());
          Long count1 = bookRecordPersistent.getCountBookRecord(cascadeDeleteBookRecordSearch);
          if (count1 > 0) {
            throw new BookException(" 数据被图书借阅记录引用不能删除。");
          }
        }
        userPersistent.batchRemoveUser(deleteUsers);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public User getUserByPrimaryKey(java.lang.String id) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getUserByPrimaryKey ");
      log.debug("parameter id is : " + id);
    }
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      return userPersistent.getUserByPrimaryKey(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getCountUser(final UserSearch userSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getCountUser ");
      log.debug("parameter userSearch is : " + userSearch);
    }
    try {
      return userPersistent.getCountUser(userSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<User> getAllUser() throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getAllUser ");
    }
    try {
      return userPersistent.getAllUser();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<User> paginationGetAllUser(PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.paginationGetAllUser ");
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return userPersistent.paginationGetAllUser(page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<User> searchUser(final UserSearch userSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.searchUser ");
      log.debug("parameter userSearch is : " + userSearch);
    }
    try {
      return userPersistent.searchUser(userSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<User> searchUser1(final User user) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.user ");
      log.debug("parameter user is : " + user);
    }
    try {
      return userPersistent.searchUser1(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<User> paginationSearchUser(final UserSearch userSearch, PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.paginationSearchUser ");
      log.debug("parameter userSearch is : " + userSearch);
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return userPersistent.paginationSearchUser(userSearch, page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  // BookPersistentImpl
  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveBook(Book book) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.saveBook ");
      log.debug("parameter book is : " + book);
    }
    try {
      if (book == null || book.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("book不能为空。");
      }
      book.clearPrimaryKeyValue();
      if (book.getId() == null || book.getId().trim().length() < 1) {
        book.setId(UUID.randomUUID().toString());
      }
      bookPersistent.saveBook(book);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveBook(Collection<Book> books) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchSaveBook ");
      log.debug("parameter books is : " + books);
    }
    try {
      if (books == null || books.isEmpty()) {
        throw new java.lang.IllegalArgumentException("books不能为空。");
      }
      for(Book book : books) {
        if(book == null || book.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("book不能为空。");
        }
        book.clearPrimaryKeyValue();
        if (book.getId() == null || book.getId().trim().length() < 1) {
          book.setId(UUID.randomUUID().toString());
        }
      }
      bookPersistent.batchSaveBook(books);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateBook(Book book) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.updateBook ");
      log.debug("parameter book is : " + book);
    }
    try {
      if (book == null || book.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("book不能为空。");
      }
      if (book.getId() == null || book.getId().trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      Book bookOld = bookPersistent.getBookByPrimaryKey(book.getId());
      if (bookOld == null) {
        throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
      }
      bookPersistent.updateBook(book);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateBook(Collection<Book> books) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchUpdateBook ");
      log.debug("parameter books is : " + books);
    }
    try {
      if (books == null || books.isEmpty()) {
        throw new java.lang.IllegalArgumentException("books不能为空。");
      }
      for(Book book : books) {
        if(book == null || book.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("book不能为空。");
        }
        if (book.getId() == null || book.getId().trim().length() < 1) {
          throw new java.lang.IllegalArgumentException("id不能为空。");
        }
        Book bookOld = bookPersistent.getBookByPrimaryKey(book.getId());
        if (bookOld == null) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
      }
      bookPersistent.batchUpdateBook(books);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeBook(Book book) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.removeBook ");
      log.debug("parameter book is : " + book);
    }
    try {
      if (book == null || book.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("book不能为空。");
      }
      java.util.Set<Book> deleteBooks = new java.util.LinkedHashSet<>();
      if (book.getId() != null && book.getId().trim().length() > 0) {
        Book bookOld = bookPersistent.getBookByPrimaryKey(book.getId());
        if (bookOld == null ) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
        deleteBooks.add(bookOld);
      } else {
        BookSearch bookSearch = new BookSearch();
        bookSearch.setEntity(book);
        deleteBooks.addAll(bookPersistent.searchBook(bookSearch));
      }
      if (deleteBooks != null && !deleteBooks.isEmpty()) {
        for(Book deleteBook : deleteBooks) {
          BookImageSearch cascadeDeleteBookImageSearch = new BookImageSearch();
          cascadeDeleteBookImageSearch.setBookId(deleteBook.getId());
          Long count0 = bookImagePersistent.getCountBookImage(cascadeDeleteBookImageSearch);
          if (count0 > 0) {
            throw new BookException(" 数据被图书图片信息引用不能删除。");
          }
        }
        bookPersistent.batchRemoveBook(deleteBooks);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveBook(Collection<Book> books) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchRemoveBook ");
      log.debug("parameter books is : " + books);
    }
    try {
      if (books == null || books.isEmpty()) {
        throw new java.lang.IllegalArgumentException("books不能为空。");
      }
      java.util.Set<Book> deleteBooks = new java.util.LinkedHashSet<>();
      for(Book book : books) {
        if (book.getId() != null && book.getId().trim().length() > 0) {
          Book bookOld = bookPersistent.getBookByPrimaryKey(book.getId());
          if (bookOld == null ) {
            throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
          }
          deleteBooks.add(bookOld);
        } else {
          BookSearch bookSearch = new BookSearch();
          bookSearch.setEntity(book);
          deleteBooks.addAll(bookPersistent.searchBook(bookSearch));
        }
      }
      if (deleteBooks != null && !deleteBooks.isEmpty()) {
        for(Book deleteBook : deleteBooks) {
          BookImageSearch cascadeDeleteBookImageSearch = new BookImageSearch();
          cascadeDeleteBookImageSearch.setBookId(deleteBook.getId());
          Long count0 = bookImagePersistent.getCountBookImage(cascadeDeleteBookImageSearch);
          if (count0 > 0) {
            throw new BookException(" 数据被图书图片信息引用不能删除。");
          }
        }
        bookPersistent.batchRemoveBook(deleteBooks);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Book getBookByPrimaryKey(java.lang.String id) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getBookByPrimaryKey ");
      log.debug("parameter id is : " + id);
    }
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      return bookPersistent.getBookByPrimaryKey(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getCountBook(final BookSearch bookSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getCountBook ");
      log.debug("parameter bookSearch is : " + bookSearch);
    }
    try {
      return bookPersistent.getCountBook(bookSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Book> getAllBook() throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getAllBook ");
    }
    try {
      return bookPersistent.getAllBook();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<Book> paginationGetAllBook(PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.paginationGetAllBook ");
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return bookPersistent.paginationGetAllBook(page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Book> searchBook(final BookSearch bookSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.searchBook ");
      log.debug("parameter bookSearch is : " + bookSearch);
    }
    try {
      return bookPersistent.searchBook(bookSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<Book> paginationSearchBook(final BookSearch bookSearch, PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.paginationSearchBook ");
      log.debug("parameter bookSearch is : " + bookSearch);
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return bookPersistent.paginationSearchBook(bookSearch, page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  // BookImagePersistentImpl
  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveBookImage(BookImage bookImage) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.saveBookImage ");
      log.debug("parameter bookImage is : " + bookImage);
    }
    try {
      if (bookImage == null || bookImage.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookImage不能为空。");
      }
      bookImage.clearPrimaryKeyValue();
      if (bookImage.getId() == null || bookImage.getId().trim().length() < 1) {
        bookImage.setId(UUID.randomUUID().toString());
      }
      bookImagePersistent.saveBookImage(bookImage);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveBookImage(Collection<BookImage> bookImages) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchSaveBookImage ");
      log.debug("parameter bookImages is : " + bookImages);
    }
    try {
      if (bookImages == null || bookImages.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookImages不能为空。");
      }
      for(BookImage bookImage : bookImages) {
        if(bookImage == null || bookImage.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("bookImage不能为空。");
        }
        bookImage.clearPrimaryKeyValue();
        if (bookImage.getId() == null || bookImage.getId().trim().length() < 1) {
          bookImage.setId(UUID.randomUUID().toString());
        }
      }
      bookImagePersistent.batchSaveBookImage(bookImages);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateBookImage(BookImage bookImage) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.updateBookImage ");
      log.debug("parameter bookImage is : " + bookImage);
    }
    try {
      if (bookImage == null || bookImage.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookImage不能为空。");
      }
      if (bookImage.getId() == null || bookImage.getId().trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      BookImage bookImageOld = bookImagePersistent.getBookImageByPrimaryKey(bookImage.getId());
      if (bookImageOld == null) {
        throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
      }
      bookImagePersistent.updateBookImage(bookImage);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateBookImage(Collection<BookImage> bookImages) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchUpdateBookImage ");
      log.debug("parameter bookImages is : " + bookImages);
    }
    try {
      if (bookImages == null || bookImages.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookImages不能为空。");
      }
      for(BookImage bookImage : bookImages) {
        if(bookImage == null || bookImage.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("bookImage不能为空。");
        }
        if (bookImage.getId() == null || bookImage.getId().trim().length() < 1) {
          throw new java.lang.IllegalArgumentException("id不能为空。");
        }
        BookImage bookImageOld = bookImagePersistent.getBookImageByPrimaryKey(bookImage.getId());
        if (bookImageOld == null) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
      }
      bookImagePersistent.batchUpdateBookImage(bookImages);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeBookImage(BookImage bookImage) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.removeBookImage ");
      log.debug("parameter bookImage is : " + bookImage);
    }
    try {
      if (bookImage == null || bookImage.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookImage不能为空。");
      }
      java.util.Set<BookImage> deleteBookImages = new java.util.LinkedHashSet<>();
      if (bookImage.getId() != null && bookImage.getId().trim().length() > 0) {
        BookImage bookImageOld = bookImagePersistent.getBookImageByPrimaryKey(bookImage.getId());
        if (bookImageOld == null ) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
        deleteBookImages.add(bookImageOld);
      } else {
        BookImageSearch bookImageSearch = new BookImageSearch();
        bookImageSearch.setEntity(bookImage);
        deleteBookImages.addAll(bookImagePersistent.searchBookImage(bookImageSearch));
      }
      if (deleteBookImages != null && !deleteBookImages.isEmpty()) {
        bookImagePersistent.batchRemoveBookImage(deleteBookImages);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveBookImage(Collection<BookImage> bookImages) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.batchRemoveBookImage ");
      log.debug("parameter bookImages is : " + bookImages);
    }
    try {
      if (bookImages == null || bookImages.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookImages不能为空。");
      }
      java.util.Set<BookImage> deleteBookImages = new java.util.LinkedHashSet<>();
      for(BookImage bookImage : bookImages) {
        if (bookImage.getId() != null && bookImage.getId().trim().length() > 0) {
          BookImage bookImageOld = bookImagePersistent.getBookImageByPrimaryKey(bookImage.getId());
          if (bookImageOld == null ) {
            throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
          }
          deleteBookImages.add(bookImageOld);
        } else {
          BookImageSearch bookImageSearch = new BookImageSearch();
          bookImageSearch.setEntity(bookImage);
          deleteBookImages.addAll(bookImagePersistent.searchBookImage(bookImageSearch));
        }
      }
      if (deleteBookImages != null && !deleteBookImages.isEmpty()) {
        bookImagePersistent.batchRemoveBookImage(deleteBookImages);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BookImage getBookImageByPrimaryKey(java.lang.String id) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getBookImageByPrimaryKey ");
      log.debug("parameter id is : " + id);
    }
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      return bookImagePersistent.getBookImageByPrimaryKey(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getCountBookImage(final BookImageSearch bookImageSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getCountBookImage ");
      log.debug("parameter bookImageSearch is : " + bookImageSearch);
    }
    try {
      return bookImagePersistent.getCountBookImage(bookImageSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<BookImage> getAllBookImage() throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.getAllBookImage ");
    }
    try {
      return bookImagePersistent.getAllBookImage();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<BookImage> paginationGetAllBookImage(PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.paginationGetAllBookImage ");
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return bookImagePersistent.paginationGetAllBookImage(page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<BookImage> searchBookImage(final BookImageSearch bookImageSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.searchBookImage ");
      log.debug("parameter bookImageSearch is : " + bookImageSearch);
    }
    try {
      return bookImagePersistent.searchBookImage(bookImageSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<BookImage> paginationSearchBookImage(final BookImageSearch bookImageSearch, PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookService.paginationSearchBookImage ");
      log.debug("parameter bookImageSearch is : " + bookImageSearch);
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return bookImagePersistent.paginationSearchBookImage(bookImageSearch, page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

}