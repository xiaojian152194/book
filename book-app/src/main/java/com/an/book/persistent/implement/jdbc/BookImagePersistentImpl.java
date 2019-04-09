/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.persistent.implement.jdbc;

import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.commons.SecurityContext;
import com.an.book.commons.Sort;
import com.an.book.entity.BookImage;
import com.an.book.persistent.IBookImagePersistent;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import com.an.book.exception.BookException;
import java.util.Collection;
import com.an.book.pojo.search.BookImageSearch;

/**
 * 该类是完成对数据库表BOOK_BOOK_IMAGE的持久化实现，包括对该表的增、删、改、查等基本操作的的具休实现。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
@org.springframework.stereotype.Repository("com.an.book.BookImagePersistent")
public class BookImagePersistentImpl extends BasePersistent implements IBookImagePersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(BookImagePersistentImpl.class);


  public static final String TABLE_NAME = "BOOK_BOOK_IMAGE";
  public static final String TABLE_ALIAS = "bookImage";

  public static final String COLUMN_ID = "ID";
  public static final String COLUMN_BOOK_NAME = "BOOK_NAME";
  public static final String COLUMN_BOOK_REAL_NAME = "BOOK_REAL_NAME";
  public static final String COLUMN_BOOK_PATH = "BOOK_PATH";
  public static final String COLUMN_UPLOAD_TIME = "UPLOAD_TIME";
  public static final String COLUMN_UPLOAD_IP = "UPLOAD_IP";
  public static final String COLUMN_BOOK_ID = "BOOK_ID";
  public static final String VIRTUAL_COLUMN_BOOK_BOOK_NAME = new StringBuilder("(SELECT ").append(BookPersistentImpl.COLUMN_BOOK_NAME)
    .append(" FROM ").append(BookPersistentImpl.TABLE_NAME).append(" AS ").append(BookPersistentImpl.TABLE_ALIAS)
    .append(" WHERE ").append(BookPersistentImpl.TABLE_ALIAS).append('.').append(BookPersistentImpl.COLUMN_ID)
    .append(" = ").append(TABLE_ALIAS).append('.').append(COLUMN_BOOK_ID).append(") AS ").append("BOOK_BOOK_NAME").toString();

  public static final LinkedHashSet<String> COLUMNS = new LinkedHashSet<>();
  public static final LinkedHashSet<String> VIRTUAL_COLUMNS = new LinkedHashSet<>();
  public static final LinkedHashSet<String> PRIMARY_KEY = new LinkedHashSet<>();
  public static final LinkedHashMap<String, String> COLUMNS_PARAMETER = new LinkedHashMap<>();

  private static final LinkedHashSet<String> NOT_INSERTABLE_COLUMNS = new LinkedHashSet<>();
  private static final LinkedHashSet<String> NOT_UPDATABLE_COLUMNS = new LinkedHashSet<>();

  public static final LinkedHashSet<String> KEY_SEARCH_COLUMNS = new LinkedHashSet<>();

  private static final StringBuilder INSERT_SQL;
  private static final StringBuilder UPDATE_SQL;
  private static final StringBuilder DELETE_SQL_BY_PRIMARY_KEY;
  public static final StringBuilder SELECT_BASE_SQL;
  public static final StringBuilder COUNT_BASE_SQL;
  static {
    COLUMNS.add(COLUMN_ID);
    COLUMNS.add(COLUMN_BOOK_NAME);
    COLUMNS.add(COLUMN_BOOK_REAL_NAME);
    COLUMNS.add(COLUMN_BOOK_PATH);
    COLUMNS.add(COLUMN_UPLOAD_TIME);
    COLUMNS.add(COLUMN_UPLOAD_IP);
    COLUMNS.add(COLUMN_BOOK_ID);
    VIRTUAL_COLUMNS.add(VIRTUAL_COLUMN_BOOK_BOOK_NAME) ;


    COLUMNS_PARAMETER.put(COLUMN_ID , "id");
    COLUMNS_PARAMETER.put(COLUMN_BOOK_NAME , "bookName");
    COLUMNS_PARAMETER.put(COLUMN_BOOK_REAL_NAME , "bookRealName");
    COLUMNS_PARAMETER.put(COLUMN_BOOK_PATH , "bookPath");
    COLUMNS_PARAMETER.put(COLUMN_UPLOAD_TIME , "uploadTime");
    COLUMNS_PARAMETER.put(COLUMN_UPLOAD_IP , "uploadIp");
    COLUMNS_PARAMETER.put(COLUMN_BOOK_ID , "bookId");


    PRIMARY_KEY.add(COLUMN_ID);

    NOT_INSERTABLE_COLUMNS.addAll(VIRTUAL_COLUMNS);
    NOT_UPDATABLE_COLUMNS.addAll(VIRTUAL_COLUMNS);
    KEY_SEARCH_COLUMNS.add(COLUMN_BOOK_ID);
    INSERT_SQL = generateInsertSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, NOT_INSERTABLE_COLUMNS);
    UPDATE_SQL = generateUpdateSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, PRIMARY_KEY, NOT_UPDATABLE_COLUMNS);
    DELETE_SQL_BY_PRIMARY_KEY = generateDeleteSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY);
    SELECT_BASE_SQL = generateBaseSelectSql(TABLE_NAME, COLUMNS, VIRTUAL_COLUMNS, PRIMARY_KEY, TABLE_ALIAS);
    COUNT_BASE_SQL = generateBaseCountSql(TABLE_NAME, PRIMARY_KEY, TABLE_ALIAS);
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public void saveBookImage(BookImage bookImage) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.saveBookImage ");
      log.debug("parameter bookImage is : " + bookImage);
    }
    try {
      if (bookImage == null || bookImage.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookImage不能为空。");
      }
      this.namedParameterJdbcTemplate.update(INSERT_SQL.toString(), new BeanPropertySqlParameterSource(bookImage));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void batchSaveBookImage(Collection<BookImage> bookImages) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.batchSaveBookImage ");
      log.debug("parameter bookImages is : " + bookImages);
    }
    try {
      if (bookImages == null || bookImages.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookImages不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(INSERT_SQL.toString(), SqlParameterSourceUtils.createBatch(bookImages.toArray()));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void updateBookImage(BookImage bookImage) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.updateBookImage ");
      log.debug("parameter bookImage is : " + bookImage);
    }
    try {
      if (bookImage == null || bookImage.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookImage不能为空。");
      }
      this.namedParameterJdbcTemplate.update(UPDATE_SQL.toString(), new BeanPropertySqlParameterSource(bookImage));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void batchUpdateBookImage(Collection<BookImage> bookImages) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.batchUpdateBookImage ");
      log.debug("parameter bookImages is : " + bookImages);
    }
    try {
      if (bookImages == null || bookImages.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookImages不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(UPDATE_SQL.toString(), SqlParameterSourceUtils.createBatch(bookImages.toArray()));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void removeBookImage(BookImage bookImage) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.removeBookImage ");
      log.debug("parameter bookImage is : " + bookImage);
    }
    try {
      if (bookImage == null || bookImage.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookImage不能为空。");
      }
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      paramSource.addValue("id", bookImage.getId());
      this.namedParameterJdbcTemplate.update(DELETE_SQL_BY_PRIMARY_KEY.toString(), paramSource);
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void batchRemoveBookImage(Collection<BookImage> bookImages) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.batchRemoveBookImage ");
      log.debug("parameter bookImages is : " + bookImages);
    }
    try {
      if (bookImages == null || bookImages.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookImages不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(DELETE_SQL_BY_PRIMARY_KEY.toString(), SqlParameterSourceUtils.createBatch(bookImages.toArray()));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BookImage getBookImageByPrimaryKey(java.lang.String id) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.getBookImageByPrimaryKey ");
      log.debug("parameter id is : " + id);
    }
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_ID).append(" = :").append(COLUMNS_PARAMETER.get(COLUMN_ID));
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      paramSource.addValue(COLUMNS_PARAMETER.get(COLUMN_ID), id);
      Collection<BookImage> bookImageList = this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(BookImage.class));
      return (bookImageList != null && !bookImageList.isEmpty() && bookImageList.size() > 0) ? bookImageList.iterator().next() : null;
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getCountBookImage(final BookImageSearch bookImageSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.getCountBookImage ");
      log.debug("parameter bookImageSearch is : " + bookImageSearch);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_BASE_SQL);
      if (bookImageSearch != null){
        buildObjectValueIsNotNullOfSql(countSql, bookImageSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())) {
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          countSql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(bookImageSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          return this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
        }
      }
      return this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), new BeanPropertySqlParameterSource(bookImageSearch), Long.class);
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<BookImage> getAllBookImage() throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.getAllBookImage ");
    }
    try {
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          appendOrderBy(sql);
          return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(BookImage.class));
        }
      }
      appendOrderBy(sql);
      return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(BookImage.class));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<BookImage> paginationGetAllBookImage(PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.paginationGetAllBookImage ");
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      if (page.getFirstReslut() < 0) {
        throw new java.lang.IllegalArgumentException("page.firstReslut取值错误，最大为。大于等于0");
      }
      if (page.getPageSize() < 1) {
        throw new java.lang.IllegalArgumentException("page.maxReslut取值错误，最大为。大于等于1");
      }
      PageRange<BookImage> pageRange = new PageRange<>(page);
      StringBuilder countSql = new StringBuilder(COUNT_BASE_SQL);
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())) {
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          countSql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
          pageRange.setTotalCount(count);
          if (count > 0) {
            SqlParameterSource pageParamSource = super.getPaginationParameter(paramSource, page);
            appendOrderBy(sql);
            Collection<BookImage> bookImageList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(BookImage.class));
            pageRange.setDatas(bookImageList);
          }
          return pageRange;
        }
      }
      Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
      pageRange.setTotalCount(count);
      if (count > 0) {
        SqlParameterSource pageParamSource = super.getPaginationParameter(paramSource, page);
        appendOrderBy(sql);
        Collection<BookImage> bookImageList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(BookImage.class));
        pageRange.setDatas(bookImageList);
      }
      return pageRange;
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<BookImage> searchBookImage(final BookImageSearch bookImageSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.searchBookImage ");
      log.debug("parameter bookImageSearch is : " + bookImageSearch);
    }
    try {
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      if (bookImageSearch != null){
        buildObjectValueIsNotNullOfSql(sql, bookImageSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(bookImageSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          appendOrderBy(sql);
          return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(BookImage.class));
        }
      }
      appendOrderBy(sql);
      return this.namedParameterJdbcTemplate.query(sql.toString(), new BeanPropertySqlParameterSource(bookImageSearch), BeanPropertyRowMapper.newInstance(BookImage.class));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<BookImage> paginationSearchBookImage(final BookImageSearch bookImageSearch, PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImagePersistent.paginationSearchBookImage ");
      log.debug("parameter bookImageSearch is : " + bookImageSearch);
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      if (page.getFirstReslut() < 0) {
        throw new java.lang.IllegalArgumentException("page.firstReslut取值错误，最大为。大于等于0");
      }
      if (page.getPageSize() < 1) {
        throw new java.lang.IllegalArgumentException("page.maxReslut取值错误，最大为。大于等于1");
      }
      PageRange<BookImage> pageRange = new PageRange<BookImage>(page);
      StringBuilder countSql = new StringBuilder(COUNT_BASE_SQL);
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      if (bookImageSearch != null){
        buildObjectValueIsNotNullOfSql(countSql, bookImageSearch);
        buildObjectValueIsNotNullOfSql(sql, bookImageSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          countSql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(bookImageSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
          pageRange.setTotalCount(count);
          if (count > 0) {
            SqlParameterSource pageParamSource = super.getPaginationParameter(paramSource, page);
            appendOrderBy(sql);
            Collection<BookImage> bookImageList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(BookImage.class));
            pageRange.setDatas(bookImageList);
          }
          return pageRange;
        }
      }
      Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(),new BeanPropertySqlParameterSource(bookImageSearch), Long.class);
      pageRange.setTotalCount(count);
      if (count > 0) {
        SqlParameterSource paramSource = super.getPaginationParameter(new BeanPropertySqlParameterSource(bookImageSearch), page);
        appendOrderBy(sql);
        Collection<BookImage> bookImageList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), paramSource, BeanPropertyRowMapper.newInstance(BookImage.class));
        pageRange.setDatas(bookImageList);
      }
      return pageRange;
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
  }


  protected final void appendOrderBy(StringBuilder sql) {
    java.util.Set<Sort> sortList = new java.util.LinkedHashSet<>();
    if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())) {
      if (SecurityContext.getOperateInfo().getSortList() != null && !SecurityContext.getOperateInfo().getSortList().isEmpty()) {
        sortList.addAll(SecurityContext.getOperateInfo().getSortList());
      }
    }
    if (sortList != null && !sortList.isEmpty()) {
      appendOrderBy(sql, COLUMNS_PARAMETER, sortList, TABLE_ALIAS);
    }
  }

  private final void buildObjectValueIsNotNullOfSql(StringBuilder sql, BookImageSearch bookImageSearch) {
    if (bookImageSearch.getBookName() != null && bookImageSearch.getBookName().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_BOOK_NAME).append(" = :bookName");
    }
    if (bookImageSearch.getBookRealName() != null && bookImageSearch.getBookRealName().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_BOOK_REAL_NAME).append(" = :bookRealName");
    }
    if (bookImageSearch.getBookPath() != null && bookImageSearch.getBookPath().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_BOOK_PATH).append(" = :bookPath");
    }
    if (bookImageSearch.getUploadTime() != null) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_UPLOAD_TIME).append(" = :uploadTime");
    }
    if (bookImageSearch.getUploadIp() != null && bookImageSearch.getUploadIp().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_UPLOAD_IP).append(" = :uploadIp");
    }
    if (bookImageSearch.getBookId() != null && bookImageSearch.getBookId().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_BOOK_ID).append(" = :bookId");
    }
  }
}