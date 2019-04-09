/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.service;

import com.an.book.exception.BookException;
import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.entity.BookRecord;
import java.util.Collection;
import com.an.book.pojo.search.BookRecordSearch;
import com.an.book.entity.User;
import com.an.book.pojo.search.UserSearch;
import com.an.book.entity.Book;
import com.an.book.pojo.search.BookSearch;
import com.an.book.entity.BookImage;
import com.an.book.pojo.search.BookImageSearch;

/**
 * 该接口是对以下对象操作的接口。
 * <b>图书借阅记录</b>
 * <b>用户</b>
 * <b>图书信息</b>
 * <b>图书图片信息</b>
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public interface IBookService {

  // BookRecordPersistentImpl
  /**
   * 保存单个图书借阅记录对象。
   *
   * @param bookRecord
   *            要保存的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void saveBookRecord(BookRecord bookRecord) throws BookException;

  /**
   * 批量保存图书借阅记录对象。
   *
   * @param bookRecords
   *            要保存的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchSaveBookRecord(Collection<BookRecord> bookRecords) throws BookException;

  /**
   * 修改单个图书借阅记录对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param bookRecord
   *            要修改的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void updateBookRecord(BookRecord bookRecord) throws BookException;

  /**
   * 批量修改图书借阅记录对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param bookRecords
   *            要修改的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchUpdateBookRecord(Collection<BookRecord> bookRecords) throws BookException;

  /**
   * 删除图书借阅记录对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   * 
   * @param bookRecord
   *            要删除的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void removeBookRecord(BookRecord bookRecord) throws BookException;

  /**
   * 批量删除图书借阅记录对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   *
   * @param bookRecords
   *            要删除的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchRemoveBookRecord(Collection<BookRecord> bookRecords) throws BookException;

  /**
   * 根据主键查询图书借阅记录对象，如果未找到将返回NULL。
   * 
   * @param id
   *            要查询的主键。
   * @return 查询到的对象如果没有查到返回null
   * @throws BookException 运行出错会抛出该异常
   */
  public BookRecord getBookRecordByPrimaryKey(java.lang.String id) throws BookException;

  /**
   * 根据条件进行查询图书借阅记录对象个数。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   * 
   * @param bookRecordSearch
   *            查询条件
   * @return 查询到的数据条数
   * @throws BookException 运行出错会抛出该异常
   */
  public Long getCountBookRecord(final BookRecordSearch bookRecordSearch) throws BookException;

  /**
   * 查询所有图书借阅记录对象。
   *
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<BookRecord> getAllBookRecord() throws BookException;

  /**
   * 分页查询图书借阅记录对象。
   *
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<BookRecord> paginationGetAllBookRecord(PageSerachParameters page) throws BookException;

  /**
   * 根据条件进行查询图书借阅记录对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param bookRecordSearch
   *            查询条件
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<BookRecord> searchBookRecord(final BookRecordSearch bookRecordSearch) throws BookException;

  /**
   * 根据条件进行，分页查询图书借阅记录对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param bookRecordSearch
   *            查询条件
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<BookRecord> paginationSearchBookRecord(final BookRecordSearch bookRecordSearch, PageSerachParameters page) throws BookException;

  // UserPersistentImpl
  /**
   * 保存单个用户对象。
   *
   * @param user
   *            要保存的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public User saveUser(User user) throws BookException;

  /**
   * 批量保存用户对象。
   *
   * @param users
   *            要保存的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchSaveUser(Collection<User> users) throws BookException;

  /**
   * 修改单个用户对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param user
   *            要修改的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void updateUser(User user) throws BookException;

  /**
   * 批量修改用户对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param users
   *            要修改的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchUpdateUser(Collection<User> users) throws BookException;

  /**
   * 删除用户对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   * 
   * @param user
   *            要删除的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void removeUser(User user) throws BookException;

  /**
   * 批量删除用户对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   *
   * @param users
   *            要删除的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchRemoveUser(Collection<User> users) throws BookException;

  /**
   * 根据主键查询用户对象，如果未找到将返回NULL。
   * 
   * @param id
   *            要查询的主键。
   * @return 查询到的对象如果没有查到返回null
   * @throws BookException 运行出错会抛出该异常
   */
  public User getUserByPrimaryKey(java.lang.String id) throws BookException;

  /**
   * 根据条件进行查询用户对象个数。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   * 
   * @param userSearch
   *            查询条件
   * @return 查询到的数据条数
   * @throws BookException 运行出错会抛出该异常
   */
  public Long getCountUser(final UserSearch userSearch) throws BookException;

  /**
   * 查询所有用户对象。
   *
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<User> getAllUser() throws BookException;

  /**
   * 分页查询用户对象。
   *
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<User> paginationGetAllUser(PageSerachParameters page) throws BookException;

  /**
   * 根据条件进行查询用户对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param userSearch
   *            查询条件
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<User> searchUser(final UserSearch userSearch) throws BookException;
  
  /**
   * 根据条件进行查询用户对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param user
   *            查询条件
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<User> searchUser1(final User user) throws BookException;

  /**
   * 根据条件进行，分页查询用户对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param userSearch
   *            查询条件
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<User> paginationSearchUser(final UserSearch userSearch, PageSerachParameters page) throws BookException;

  // BookPersistentImpl
  /**
   * 保存单个图书信息对象。
   *
   * @param book
   *            要保存的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void saveBook(Book book) throws BookException;

  /**
   * 批量保存图书信息对象。
   *
   * @param books
   *            要保存的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchSaveBook(Collection<Book> books) throws BookException;

  /**
   * 修改单个图书信息对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param book
   *            要修改的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void updateBook(Book book) throws BookException;

  /**
   * 批量修改图书信息对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param books
   *            要修改的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchUpdateBook(Collection<Book> books) throws BookException;

  /**
   * 删除图书信息对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   * 
   * @param book
   *            要删除的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void removeBook(Book book) throws BookException;

  /**
   * 批量删除图书信息对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   *
   * @param books
   *            要删除的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchRemoveBook(Collection<Book> books) throws BookException;

  /**
   * 根据主键查询图书信息对象，如果未找到将返回NULL。
   * 
   * @param id
   *            要查询的主键。
   * @return 查询到的对象如果没有查到返回null
   * @throws BookException 运行出错会抛出该异常
   */
  public Book getBookByPrimaryKey(java.lang.String id) throws BookException;

  /**
   * 根据条件进行查询图书信息对象个数。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   * 
   * @param bookSearch
   *            查询条件
   * @return 查询到的数据条数
   * @throws BookException 运行出错会抛出该异常
   */
  public Long getCountBook(final BookSearch bookSearch) throws BookException;

  /**
   * 查询所有图书信息对象。
   *
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<Book> getAllBook() throws BookException;

  /**
   * 分页查询图书信息对象。
   *
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<Book> paginationGetAllBook(PageSerachParameters page) throws BookException;

  /**
   * 根据条件进行查询图书信息对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param bookSearch
   *            查询条件
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<Book> searchBook(final BookSearch bookSearch) throws BookException;

  /**
   * 根据条件进行，分页查询图书信息对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param bookSearch
   *            查询条件
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<Book> paginationSearchBook(final BookSearch bookSearch, PageSerachParameters page) throws BookException;

  // BookImagePersistentImpl
  /**
   * 保存单个图书图片信息对象。
   *
   * @param bookImage
   *            要保存的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void saveBookImage(BookImage bookImage) throws BookException;

  /**
   * 批量保存图书图片信息对象。
   *
   * @param bookImages
   *            要保存的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchSaveBookImage(Collection<BookImage> bookImages) throws BookException;

  /**
   * 修改单个图书图片信息对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param bookImage
   *            要修改的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void updateBookImage(BookImage bookImage) throws BookException;

  /**
   * 批量修改图书图片信息对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param bookImages
   *            要修改的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchUpdateBookImage(Collection<BookImage> bookImages) throws BookException;

  /**
   * 删除图书图片信息对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   * 
   * @param bookImage
   *            要删除的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void removeBookImage(BookImage bookImage) throws BookException;

  /**
   * 批量删除图书图片信息对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   *
   * @param bookImages
   *            要删除的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchRemoveBookImage(Collection<BookImage> bookImages) throws BookException;

  /**
   * 根据主键查询图书图片信息对象，如果未找到将返回NULL。
   * 
   * @param id
   *            要查询的主键。
   * @return 查询到的对象如果没有查到返回null
   * @throws BookException 运行出错会抛出该异常
   */
  public BookImage getBookImageByPrimaryKey(java.lang.String id) throws BookException;

  /**
   * 根据条件进行查询图书图片信息对象个数。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   * 
   * @param bookImageSearch
   *            查询条件
   * @return 查询到的数据条数
   * @throws BookException 运行出错会抛出该异常
   */
  public Long getCountBookImage(final BookImageSearch bookImageSearch) throws BookException;

  /**
   * 查询所有图书图片信息对象。
   *
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<BookImage> getAllBookImage() throws BookException;

  /**
   * 分页查询图书图片信息对象。
   *
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<BookImage> paginationGetAllBookImage(PageSerachParameters page) throws BookException;

  /**
   * 根据条件进行查询图书图片信息对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param bookImageSearch
   *            查询条件
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<BookImage> searchBookImage(final BookImageSearch bookImageSearch) throws BookException;

  /**
   * 根据条件进行，分页查询图书图片信息对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param bookImageSearch
   *            查询条件
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<BookImage> paginationSearchBookImage(final BookImageSearch bookImageSearch, PageSerachParameters page) throws BookException;

}