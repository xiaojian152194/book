/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.persistent;

import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.entity.BookImage;
import com.an.book.exception.BookException;
import java.util.Collection;
import com.an.book.pojo.search.BookImageSearch;

/**
 * 该接口是完成对数据库表BOOK_BOOK_IMAGE的持久化申明，包括对该表的增、删、改、查等基本操作的接口定义。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public interface IBookImagePersistent {
  public static final String OPERATE_TARGET = "com.an.book.BookImage";

  /**
   * 将对象保存到数据库 BOOK_BOOK_IMAGE 表中。
   *
   * @param bookImage
   *            要保存的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void saveBookImage(BookImage bookImage) throws BookException;

  /**
   * 将对象集合保存到数据库 BOOK_BOOK_IMAGE 表中。
   *
   * @param bookImages
   *            要保存的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchSaveBookImage(Collection<BookImage> bookImages) throws BookException;

  /**
   * 修改数据库 BOOK_BOOK_IMAGE 表的记录。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param bookImage
   *            要修改的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void updateBookImage(BookImage bookImage) throws BookException;

  /**
   * 批量修改数据库 BOOK_BOOK_IMAGE 表的记录。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param bookImages
   *            要修改的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchUpdateBookImage(Collection<BookImage> bookImages) throws BookException;

  /**
   * 根据主键删除数据库 BOOK_BOOK_IMAGE 表的记录。
   * 
   * @param bookImage
   *            要删除的对象。
   * @throws BookException 运行出错会抛出该异常
   */
  public void removeBookImage(BookImage bookImage) throws BookException;

  /**
   * 根据主键批量删除数据库 BOOK_BOOK_IMAGE 表的记录。
   *
   * @param bookImages
   *            要删除的对象集合。
   * @throws BookException 运行出错会抛出该异常
   */
  public void batchRemoveBookImage(Collection<BookImage> bookImages) throws BookException;

  /**
   * 根据主键查询数据库 BOOK_BOOK_IMAGE 表中的记录，如果未找到将返回NULL。
   * 
   * @param id
   *            要查询的主键。
   * @return 根据主键查询到的对象，查询不到返回 null
   * @throws BookException 运行出错会抛出该异常
   */
  public BookImage getBookImageByPrimaryKey(java.lang.String id) throws BookException;

  /**
   * 根据条件进行查询数据库 BOOK_BOOK_IMAGE 表的记录条数。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   * 
   * @param bookImageSearch
   *            查询条件
   * @return 返回查询到的记录个数
   * @throws BookException 运行出错会抛出该异常
   */
  public Long getCountBookImage(final BookImageSearch bookImageSearch) throws BookException;

  /**
   * 查询数据库 BOOK_BOOK_IMAGE 表的所有记录。
   * @return 返回所有查询到的对象集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<BookImage> getAllBookImage() throws BookException;

  /**
   * 分页查询数据库 BOOK_BOOK_IMAGE 表的所有记录。。
   *
   * @param page
   *            分页参数。
   * @return 返回当前页数据以及数据总条数等相关信息
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<BookImage> paginationGetAllBookImage(PageSerachParameters page) throws BookException;

  /**
   * 根据条件进行查询数据库 BOOK_BOOK_IMAGE 表的记录。
   * 当查询条件对象当中的属性不为空将按该条件有效。
   *
   * @param bookImageSearch
   *            查询条件
   * @return 返回所有查询到的对象集合
   * @throws BookException 运行出错会抛出该异常
   */
  public Collection<BookImage> searchBookImage(final BookImageSearch bookImageSearch) throws BookException;

  /**
   * 根据条件进行，分页查询数据库 BOOK_BOOK_IMAGE 表的记录。
   * 当查询条件对象当中的属性不为空将按该条件有效。
   *
   * @param bookImageSearch
   *            查询条件
   * @param page
   *            分页参数。
   * @return 返回当前页数据以及数据总条数等相关信息
   * @throws BookException 运行出错会抛出该异常
   */
  public PageRange<BookImage> paginationSearchBookImage(final BookImageSearch bookImageSearch, PageSerachParameters page) throws BookException;
}