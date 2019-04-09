/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.persistent.implement.jdbc;

import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.commons.SecurityContext;
import com.an.book.commons.Sort;
import com.an.book.entity.BookRecord;
import com.an.book.persistent.IBookRecordPersistent;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import com.an.book.exception.BookException;
import java.util.Collection;
import com.an.book.pojo.search.BookRecordSearch;

/**
 * 该类是完成对数据库表BOOK_BOOK_RECORD的持久化实现，包括对该表的增、删、改、查等基本操作的的具休实现。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
@org.springframework.stereotype.Repository("com.an.book.BookRecordPersistent")
public class BookRecordPersistentImpl extends BasePersistent implements IBookRecordPersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(BookRecordPersistentImpl.class);


  public static final String TABLE_NAME = "BOOK_BOOK_RECORD";
  public static final String TABLE_ALIAS = "bookRecord";

  public static final String COLUMN_ID = "ID";
  public static final String COLUMN_BOOK_NAME = "BOOK_NAME";
  public static final String COLUMN_BOOK_NUM = "BOOK_NUM";
  public static final String COLUMN_BORROW_DATE = "BORROW_DATE";
  public static final String COLUMN_BACK_DATE = "BACK_DATE";
  public static final String COLUMN_USER_ID = "USER_ID";
  public static final String VIRTUAL_COLUMN_USER_USERNAME = new StringBuilder("(SELECT ").append(UserPersistentImpl.COLUMN_USERNAME)
    .append(" FROM ").append(UserPersistentImpl.TABLE_NAME).append(" AS ").append(UserPersistentImpl.TABLE_ALIAS)
    .append(" WHERE ").append(UserPersistentImpl.TABLE_ALIAS).append('.').append(UserPersistentImpl.COLUMN_ID)
    .append(" = ").append(TABLE_ALIAS).append('.').append(COLUMN_USER_ID).append(") AS ").append("USER_USERNAME").toString();

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
    COLUMNS.add(COLUMN_BOOK_NUM);
    COLUMNS.add(COLUMN_BORROW_DATE);
    COLUMNS.add(COLUMN_BACK_DATE);
    COLUMNS.add(COLUMN_USER_ID);
    VIRTUAL_COLUMNS.add(VIRTUAL_COLUMN_USER_USERNAME) ;


    COLUMNS_PARAMETER.put(COLUMN_ID , "id");
    COLUMNS_PARAMETER.put(COLUMN_BOOK_NAME , "bookName");
    COLUMNS_PARAMETER.put(COLUMN_BOOK_NUM , "bookNum");
    COLUMNS_PARAMETER.put(COLUMN_BORROW_DATE , "borrowDate");
    COLUMNS_PARAMETER.put(COLUMN_BACK_DATE , "backDate");
    COLUMNS_PARAMETER.put(COLUMN_USER_ID , "userId");


    PRIMARY_KEY.add(COLUMN_ID);

    NOT_INSERTABLE_COLUMNS.addAll(VIRTUAL_COLUMNS);
    NOT_UPDATABLE_COLUMNS.addAll(VIRTUAL_COLUMNS);
    KEY_SEARCH_COLUMNS.add(COLUMN_USER_ID);
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
  public void saveBookRecord(BookRecord bookRecord) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.saveBookRecord ");
      log.debug("parameter bookRecord is : " + bookRecord);
    }
    try {
      if (bookRecord == null || bookRecord.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
      }
      this.namedParameterJdbcTemplate.update(INSERT_SQL.toString(), new BeanPropertySqlParameterSource(bookRecord));
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
  public void batchSaveBookRecord(Collection<BookRecord> bookRecords) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.batchSaveBookRecord ");
      log.debug("parameter bookRecords is : " + bookRecords);
    }
    try {
      if (bookRecords == null || bookRecords.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookRecords不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(INSERT_SQL.toString(), SqlParameterSourceUtils.createBatch(bookRecords.toArray()));
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
  public void updateBookRecord(BookRecord bookRecord) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.updateBookRecord ");
      log.debug("parameter bookRecord is : " + bookRecord);
    }
    try {
      if (bookRecord == null || bookRecord.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
      }
      this.namedParameterJdbcTemplate.update(UPDATE_SQL.toString(), new BeanPropertySqlParameterSource(bookRecord));
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
  public void batchUpdateBookRecord(Collection<BookRecord> bookRecords) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.batchUpdateBookRecord ");
      log.debug("parameter bookRecords is : " + bookRecords);
    }
    try {
      if (bookRecords == null || bookRecords.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookRecords不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(UPDATE_SQL.toString(), SqlParameterSourceUtils.createBatch(bookRecords.toArray()));
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
  public void removeBookRecord(BookRecord bookRecord) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.removeBookRecord ");
      log.debug("parameter bookRecord is : " + bookRecord);
    }
    try {
      if (bookRecord == null || bookRecord.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
      }
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      paramSource.addValue("id", bookRecord.getId());
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
  public void batchRemoveBookRecord(Collection<BookRecord> bookRecords) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.batchRemoveBookRecord ");
      log.debug("parameter bookRecords is : " + bookRecords);
    }
    try {
      if (bookRecords == null || bookRecords.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookRecords不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(DELETE_SQL_BY_PRIMARY_KEY.toString(), SqlParameterSourceUtils.createBatch(bookRecords.toArray()));
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
  public BookRecord getBookRecordByPrimaryKey(java.lang.String id) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.getBookRecordByPrimaryKey ");
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
      Collection<BookRecord> bookRecordList = this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(BookRecord.class));
      return (bookRecordList != null && !bookRecordList.isEmpty() && bookRecordList.size() > 0) ? bookRecordList.iterator().next() : null;
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
  public Long getCountBookRecord(final BookRecordSearch bookRecordSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.getCountBookRecord ");
      log.debug("parameter bookRecordSearch is : " + bookRecordSearch);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_BASE_SQL);
      if (bookRecordSearch != null){
        buildObjectValueIsNotNullOfSql(countSql, bookRecordSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())) {
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          countSql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(bookRecordSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          return this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
        }
      }
      return this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), new BeanPropertySqlParameterSource(bookRecordSearch), Long.class);
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
  public Collection<BookRecord> getAllBookRecord() throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.getAllBookRecord ");
    }
    try {
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          appendOrderBy(sql);
          return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(BookRecord.class));
        }
      }
      appendOrderBy(sql);
      return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(BookRecord.class));
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
  public PageRange<BookRecord> paginationGetAllBookRecord(PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.paginationGetAllBookRecord ");
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
      PageRange<BookRecord> pageRange = new PageRange<>(page);
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
            Collection<BookRecord> bookRecordList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(BookRecord.class));
            pageRange.setDatas(bookRecordList);
          }
          return pageRange;
        }
      }
      Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
      pageRange.setTotalCount(count);
      if (count > 0) {
        SqlParameterSource pageParamSource = super.getPaginationParameter(paramSource, page);
        appendOrderBy(sql);
        Collection<BookRecord> bookRecordList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(BookRecord.class));
        pageRange.setDatas(bookRecordList);
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
  public Collection<BookRecord> searchBookRecord(final BookRecordSearch bookRecordSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.searchBookRecord ");
      log.debug("parameter bookRecordSearch is : " + bookRecordSearch);
    }
    try {
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      if (bookRecordSearch != null){
        buildObjectValueIsNotNullOfSql(sql, bookRecordSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(bookRecordSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          appendOrderBy(sql);
          return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(BookRecord.class));
        }
      }
      appendOrderBy(sql);
      return this.namedParameterJdbcTemplate.query(sql.toString(), new BeanPropertySqlParameterSource(bookRecordSearch), BeanPropertyRowMapper.newInstance(BookRecord.class));
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
  public PageRange<BookRecord> paginationSearchBookRecord(final BookRecordSearch bookRecordSearch, PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordPersistent.paginationSearchBookRecord ");
      log.debug("parameter bookRecordSearch is : " + bookRecordSearch);
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
      PageRange<BookRecord> pageRange = new PageRange<BookRecord>(page);
      StringBuilder countSql = new StringBuilder(COUNT_BASE_SQL);
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      if (bookRecordSearch != null){
        buildObjectValueIsNotNullOfSql(countSql, bookRecordSearch);
        buildObjectValueIsNotNullOfSql(sql, bookRecordSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          countSql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(bookRecordSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
          pageRange.setTotalCount(count);
          if (count > 0) {
            SqlParameterSource pageParamSource = super.getPaginationParameter(paramSource, page);
            appendOrderBy(sql);
            Collection<BookRecord> bookRecordList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(BookRecord.class));
            pageRange.setDatas(bookRecordList);
          }
          return pageRange;
        }
      }
      Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(),new BeanPropertySqlParameterSource(bookRecordSearch), Long.class);
      pageRange.setTotalCount(count);
      if (count > 0) {
        SqlParameterSource paramSource = super.getPaginationParameter(new BeanPropertySqlParameterSource(bookRecordSearch), page);
        appendOrderBy(sql);
        Collection<BookRecord> bookRecordList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), paramSource, BeanPropertyRowMapper.newInstance(BookRecord.class));
        pageRange.setDatas(bookRecordList);
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

  private final void buildObjectValueIsNotNullOfSql(StringBuilder sql, BookRecordSearch bookRecordSearch) {
    if (bookRecordSearch.getBookName() != null && bookRecordSearch.getBookName().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_BOOK_NAME).append(" = :bookName");
    }
    if (bookRecordSearch.getBookNum() != null && bookRecordSearch.getBookNum().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_BOOK_NUM).append(" = :bookNum");
    }
    if (bookRecordSearch.getBorrowDate() != null) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_BORROW_DATE).append(" = :borrowDate");
    }
    if (bookRecordSearch.getBackDate() != null) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_BACK_DATE).append(" = :backDate");
    }
    if (bookRecordSearch.getUserId() != null && bookRecordSearch.getUserId().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_USER_ID).append(" = :userId");
    }
  }
}