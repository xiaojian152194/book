/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.persistent;

import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.entity.Book;
import com.an.book.exception.BookException;
import java.util.Collection;
import com.an.book.pojo.search.BookSearch;

/**
 * 该接口是完成对数据库表BOOK_BOOK的持久化申明，包括对该表的增、删、改、查等基本操作的接口定义。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public interface IBookPersistent {
  public static final String OPERATE_TARGET = "com.an.book.Book";

  /**
   * 将对象保存到数据库 BOOK_BOOK 表中。
   *
   * @param book
   *            要保存的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void saveBook(Book book) throws BookException;

  /**
   * 将对象集合保存到数据库 BOOK_BOOK 表中。
   *
   * @param books
   *            要保存的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchSaveBook(Collection<Book> books) throws BookException;

  /**
   * 修改数据库 BOOK_BOOK 表的记录。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param book
   *            要修改的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void updateBook(Book book) throws BookException;

  /**
   * 批量修改数据库 BOOK_BOOK 表的记录。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param books
   *            要修改的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchUpdateBook(Collection<Book> books) throws BookException;

  /**
   * 根据主键删除数据库 BOOK_BOOK 表的记录。
   * 
   * @param book
   *            要删除的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void removeBook(Book book) throws BookException;

  /**
   * 根据主键批量删除数据库 BOOK_BOOK 表的记录。
   *
   * @param books
   *            要删除的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchRemoveBook(Collection<Book> books) throws BookException;

  /**
   * 根据主键查询数据库 BOOK_BOOK 表中的记录，如果未找到将返回NULL。
   * 
   * @param id
   *            要查询的主键。
   * @return 根据主键查询到的对象，查询不到返回 null
   * @throws BookException 运行出错会抛出该异常
   */
  public Book getBookByPrimaryKey(java.lang.String id) throws BookException;

  /**
   * 根据条件进行查询数据库 BOOK_BOOK 表的记录条数。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   * 
   * @param bookSearch
   *            查询条件
   * @return 返回查询到的记录个数
   * @throws BookException 运行出错会抛出该异常
   */
  public Long getCountBook(final BookSearch bookSearch) throws BookException;

  /**
   * 查询数据库 BOOK_BOOK 表的所有记录。
   * @return 返回所有查询到的对象集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<Book> getAllBook() throws BookException;

  /**
   * 分页查询数据库 BOOK_BOOK 表的所有记录。。
   *
   * @param page
   *            分页参数。
   * @return 返回当前页数据以及数据总条数等相关信息
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<Book> paginationGetAllBook(PageSerachParameters page) throws BookException;

  /**
   * 根据条件进行查询数据库 BOOK_BOOK 表的记录。
   * 当查询条件对象当中的属性不为空将按该条件有效。
   *
   * @param bookSearch
   *            查询条件
   * @return 返回所有查询到的对象集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<Book> searchBook(final BookSearch bookSearch) throws BookException;

  /**
   * 根据条件进行，分页查询数据库 BOOK_BOOK 表的记录。
   * 当查询条件对象当中的属性不为空将按该条件有效。
   *
   * @param bookSearch
   *            查询条件
   * @param page
   *            分页参数。
   * @return 返回当前页数据以及数据总条数等相关信息
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<Book> paginationSearchBook(final BookSearch bookSearch, PageSerachParameters page) throws BookException;
}