/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.persistent.implement.jdbc;

import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.commons.SecurityContext;
import com.an.book.commons.Sort;
import com.an.book.entity.User;
import com.an.book.persistent.IUserPersistent;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import com.an.book.exception.BookException;
import java.util.Collection;
import com.an.book.pojo.search.UserSearch;

/**
 * 该类是完成对数据库表BOOK_USER的持久化实现，包括对该表的增、删、改、查等基本操作的的具休实现。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
@org.springframework.stereotype.Repository("com.an.book.UserPersistent")
public class UserPersistentImpl extends BasePersistent implements IUserPersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UserPersistentImpl.class);


  public static final String TABLE_NAME = "BOOK_USER";
  public static final String TABLE_ALIAS = "user";

  public static final String COLUMN_ID = "ID";
  public static final String COLUMN_USERNAME = "USERNAME";
  public static final String COLUMN_PASSWORD = "PASSWORD";
  public static final String COLUMN_HAVE_AUTHORITY = "HAVE_AUTHORITY";
  public static final String COLUMN_CREATE_DATE = "CREATE_DATE";

  public static final LinkedHashSet<String> COLUMNS = new LinkedHashSet<>();
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
    COLUMNS.add(COLUMN_USERNAME);
    COLUMNS.add(COLUMN_PASSWORD);
    COLUMNS.add(COLUMN_HAVE_AUTHORITY);
    COLUMNS.add(COLUMN_CREATE_DATE);


    COLUMNS_PARAMETER.put(COLUMN_ID , "id");
    COLUMNS_PARAMETER.put(COLUMN_USERNAME , "username");
    COLUMNS_PARAMETER.put(COLUMN_PASSWORD , "password");
    COLUMNS_PARAMETER.put(COLUMN_HAVE_AUTHORITY , "haveAuthority");
    COLUMNS_PARAMETER.put(COLUMN_CREATE_DATE , "createDate");


    PRIMARY_KEY.add(COLUMN_ID);

    KEY_SEARCH_COLUMNS.add(COLUMN_USERNAME);
    INSERT_SQL = generateInsertSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, NOT_INSERTABLE_COLUMNS);
    UPDATE_SQL = generateUpdateSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, PRIMARY_KEY, NOT_UPDATABLE_COLUMNS);
    DELETE_SQL_BY_PRIMARY_KEY = generateDeleteSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY);
    SELECT_BASE_SQL = generateBaseSelectSql(TABLE_NAME, COLUMNS, PRIMARY_KEY, TABLE_ALIAS);
    COUNT_BASE_SQL = generateBaseCountSql(TABLE_NAME, PRIMARY_KEY, TABLE_ALIAS);
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public User saveUser(User user) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.saveUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      this.namedParameterJdbcTemplate.update(INSERT_SQL.toString(), new BeanPropertySqlParameterSource(user));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new BookException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new BookException(" 错误:" + e.getMessage() , e);
    }
    return user;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void batchSaveUser(Collection<User> users) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.batchSaveUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(INSERT_SQL.toString(), SqlParameterSourceUtils.createBatch(users.toArray()));
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
  public void updateUser(User user) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.updateUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      this.namedParameterJdbcTemplate.update(UPDATE_SQL.toString(), new BeanPropertySqlParameterSource(user));
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
  public void batchUpdateUser(Collection<User> users) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.batchUpdateUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(UPDATE_SQL.toString(), SqlParameterSourceUtils.createBatch(users.toArray()));
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
  public void removeUser(User user) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.removeUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      paramSource.addValue("id", user.getId());
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
  public void batchRemoveUser(Collection<User> users) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.batchRemoveUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(DELETE_SQL_BY_PRIMARY_KEY.toString(), SqlParameterSourceUtils.createBatch(users.toArray()));
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
  public User getUserByPrimaryKey(java.lang.String id) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.getUserByPrimaryKey ");
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
      Collection<User> userList = this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(User.class));
      return (userList != null && !userList.isEmpty() && userList.size() > 0) ? userList.iterator().next() : null;
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
  public Long getCountUser(final UserSearch userSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.getCountUser ");
      log.debug("parameter userSearch is : " + userSearch);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_BASE_SQL);
      if (userSearch != null){
        buildObjectValueIsNotNullOfSql(countSql, userSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())) {
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          countSql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(userSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          return this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
        }
      }
      return this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), new BeanPropertySqlParameterSource(userSearch), Long.class);
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
  public Collection<User> getAllUser() throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.getAllUser ");
    }
    try {
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          appendOrderBy(sql);
          return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(User.class));
        }
      }
      appendOrderBy(sql);
      return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(User.class));
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
  public PageRange<User> paginationGetAllUser(PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.paginationGetAllUser ");
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
      PageRange<User> pageRange = new PageRange<>(page);
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
            Collection<User> userList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(User.class));
            pageRange.setDatas(userList);
          }
          return pageRange;
        }
      }
      Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
      pageRange.setTotalCount(count);
      if (count > 0) {
        SqlParameterSource pageParamSource = super.getPaginationParameter(paramSource, page);
        appendOrderBy(sql);
        Collection<User> userList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(User.class));
        pageRange.setDatas(userList);
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
  public Collection<User> searchUser(final UserSearch userSearch) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.searchUser ");
      log.debug("parameter userSearch is : " + userSearch);
    }
    try {
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      if (userSearch != null){
        buildObjectValueIsNotNullOfSql(sql, userSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(userSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          appendOrderBy(sql);
          return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(User.class));
        }
      }
      appendOrderBy(sql);
      return this.namedParameterJdbcTemplate.query(sql.toString(), new BeanPropertySqlParameterSource(userSearch), BeanPropertyRowMapper.newInstance(User.class));
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
  public Collection<User> searchUser1(final User user) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.user ");
      log.debug("parameter user is : " + user);
    }
    try {
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      if (user != null){
        buildObjectValueIsNotNullOfSql1(sql, user);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(user));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          appendOrderBy(sql);
          return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(User.class));
        }
      }
      appendOrderBy(sql);
      return this.namedParameterJdbcTemplate.query(sql.toString(), new BeanPropertySqlParameterSource(user), BeanPropertyRowMapper.newInstance(User.class));
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
  public PageRange<User> paginationSearchUser(final UserSearch userSearch, PageSerachParameters page) throws BookException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.paginationSearchUser ");
      log.debug("parameter userSearch is : " + userSearch);
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
      PageRange<User> pageRange = new PageRange<User>(page);
      StringBuilder countSql = new StringBuilder(COUNT_BASE_SQL);
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      if (userSearch != null){
        buildObjectValueIsNotNullOfSql(countSql, userSearch);
        buildObjectValueIsNotNullOfSql(sql, userSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          countSql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(userSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
          pageRange.setTotalCount(count);
          if (count > 0) {
            SqlParameterSource pageParamSource = super.getPaginationParameter(paramSource, page);
            appendOrderBy(sql);
            Collection<User> userList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(User.class));
            pageRange.setDatas(userList);
          }
          return pageRange;
        }
      }
      Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(),new BeanPropertySqlParameterSource(userSearch), Long.class);
      pageRange.setTotalCount(count);
      if (count > 0) {
        SqlParameterSource paramSource = super.getPaginationParameter(new BeanPropertySqlParameterSource(userSearch), page);
        appendOrderBy(sql);
        Collection<User> userList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), paramSource, BeanPropertyRowMapper.newInstance(User.class));
        pageRange.setDatas(userList);
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

  private final void buildObjectValueIsNotNullOfSql(StringBuilder sql, UserSearch userSearch) {
    if (userSearch.getUsername() != null && userSearch.getUsername().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_USERNAME).append(" = :username");
    }
    if (userSearch.getPassword() != null && userSearch.getPassword().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_PASSWORD).append(" = :password");
    }
    if (userSearch.getHaveAuthority() != null && userSearch.getHaveAuthority().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_HAVE_AUTHORITY).append(" = :haveAuthority");
    }
    if (userSearch.getCreateDate() != null) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_CREATE_DATE).append(" = :createDate");
    }
  }
  private final void buildObjectValueIsNotNullOfSql1(StringBuilder sql, User user) {
    if (user.getUsername() != null && user.getUsername().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_USERNAME).append(" = :username");
    }
    if (user.getPassword() != null && user.getPassword().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_PASSWORD).append(" = :password");
    }
    if (user.getHaveAuthority() != null && user.getHaveAuthority().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_HAVE_AUTHORITY).append(" = :haveAuthority");
    }
    if (user.getCreateDate() != null) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_CREATE_DATE).append(" = :createDate");
    }
  }
}