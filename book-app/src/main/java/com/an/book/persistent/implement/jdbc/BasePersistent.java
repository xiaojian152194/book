/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.persistent.implement.jdbc;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.an.book.commons.PageSerachParameters;
import com.an.book.commons.Sort;

/**
 * 该类是持久化的基础实现，包括拼接Sql的方法。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public class BasePersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(BasePersistent.class);

  protected JdbcTemplate jdbcTemplate;
  protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @javax.annotation.Resource
  public void setDataSource(javax.sql.DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  protected static final String SEARCH_KEY_PARAMETER = "searchKey";
  protected static final String FIRST_RESLUT_PARAMETER = "firstReslut";
  protected static final String PAGE_SIZE_PARAMETER = "pageSize";

  protected static final StringBuilder generateInsertSql(String tableName, Set<String> columns, Map<String, String> columnsParameter, Set<String> notInsertableColumns) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BasePersistent.generateInsertSql .");
      log.debug("parameter tableName is : " + tableName);
      log.debug("parameter columns is : " + columns);
      log.debug("parameter columnsParameter is : " + columnsParameter);
      log.debug("parameter notInsertableColumns is : " + notInsertableColumns);
    }
    StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append('(');
    StringBuilder values = new StringBuilder();
    boolean isFirst = true;
    for (String column : columns) {
      if (notInsertableColumns != null && notInsertableColumns.contains(column)) {
        continue;
      }
      if (isFirst) {
        isFirst = false;
      } else {
        sql.append(',');
        values.append(',');
      }
      sql.append(column);
      values.append(':').append(columnsParameter.get(column));
    }
    sql.append(") VALUES (");
    sql.append(values);
    sql.append(')');
    if (log.isInfoEnabled()) {
      log.info("generate insert sql is : " + sql.toString());
    }
    return sql;
  }

  protected static final StringBuilder generateUpdateSql(String tableName, Set<String> columns, Map<String, String> columnsParameter, Set<String> primaryKey) {
    return generateUpdateSql(tableName, columns, columnsParameter, primaryKey, null, null);
  }
  
  protected static final StringBuilder generateUpdateSql(String tableName, Set<String> columns, Map<String, String> columnsParameter, Set<String> primaryKey, String version) {
    return generateUpdateSql(tableName, columns, columnsParameter, primaryKey, version, null);
  }
  
  protected static final StringBuilder generateUpdateSql(String tableName, Set<String> columns, Map<String, String> columnsParameter, Set<String> primaryKey, Set<String> notUpdatableColumns) {
    return generateUpdateSql(tableName, columns, columnsParameter, primaryKey, null, notUpdatableColumns);
  }

  protected static final StringBuilder generateUpdateSql(String tableName, Set<String> columns, Map<String, String> columnsParameter, Set<String> primaryKey, String version, Set<String> notUpdatableColumns) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BasePersistent.generateUpdateSql .");
      log.debug("parameter tableName is : " + tableName);
      log.debug("parameter columns is : " + columns);
      log.debug("parameter columnsParameter is : " + columnsParameter);
      log.debug("parameter primaryKey is : " + primaryKey);
      log.debug("parameter notUpdatableColumns is : " + notUpdatableColumns);
    }
    StringBuilder sql = new StringBuilder("UPDATE ").append(tableName).append(" SET ");
    boolean isFirst = true;
    for (String column : columns) {
      if (notUpdatableColumns != null && notUpdatableColumns.contains(column)) {
        continue;
      }
      if (primaryKey != null && primaryKey.contains(column)) {
        continue;
      }
      if (isFirst) {
        isFirst = false;
      } else {
        sql.append(',');
      }
      if (column.equals(version)) {
        sql.append(column).append('=').append(column).append(" + 1 ");
      } else {
        sql.append(column).append('=').append(':').append(columnsParameter.get(column));
      }
    }
    if (primaryKey != null && !primaryKey.isEmpty()) {
      sql.append(" WHERE ");
      isFirst = true;
      for (String column : primaryKey) {
        if (isFirst) {
          isFirst = false;
        } else {
          sql.append(" AND ");
        }
        sql.append(column).append('=').append(':').append(columnsParameter.get(column));
      }
      if (version != null && version.trim().length() > 0) {
        if (!isFirst) {
          sql.append(" AND ");
        }
        sql.append(version).append('=').append(':').append(columnsParameter.get(version));
      }
    }
    if (log.isInfoEnabled()) {
      log.info("generate update sql is : " + sql.toString());
    }
    return sql;
  }

  protected static final StringBuilder generateDeleteSql(String tableName, Map<String, String> columnsParameter, Set<String> columns) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BasePersistent.generateDeleteSql. ");
      log.debug("parameter tableName is : " + tableName);
      log.debug("parameter columnsParameter is : " + columnsParameter);
      log.debug("parameter columns is : " + columns);
    }
    StringBuilder sql = new StringBuilder("DELETE FROM ").append(tableName).append(" WHERE ");
    boolean isFirst = true;
    for (String column : columns) {
      if (isFirst) {
        isFirst = false;
      } else {
        sql.append(" AND ");
      }
      sql.append(column).append('=').append(':').append(columnsParameter.get(column));
    }
    if (log.isInfoEnabled()) {
      log.info("generate delete sql is : " + sql.toString());
    }
    return sql;
  }

  protected static final StringBuilder generateBaseSelectSql(String tableName, Set<String> columns, Set<String> primaryKey) {
    return generateBaseSelectSql(tableName, columns, null, primaryKey, null);
  }

  protected static final StringBuilder generateBaseSelectSql(String tableName, Set<String> columns, Set<String> primaryKey, String alias) {
    return generateBaseSelectSql(tableName, columns, null, primaryKey, alias);
  }

  protected static final StringBuilder generateBaseSelectSql(String tableName, Set<String> columns, Set<String> virtualColumns, Set<String> primaryKey) {
    return generateBaseSelectSql(tableName, columns, virtualColumns, primaryKey, null);
  }

  protected static final StringBuilder generateBaseSelectSql(String tableName, Set<String> columns, Set<String> virtualColumns, Set<String> primaryKey, String alias) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BasePersistent.generateBaseSelectSql.");
      log.debug("parameter tableName is : " + tableName);
      log.debug("parameter columns is : " + columns);
      log.debug("parameter virtualColumns is : " + virtualColumns);
      log.debug("parameter primaryKey is : " + primaryKey);
      log.debug("parameter alias is : " + alias);
    }
    StringBuilder sql = new StringBuilder("SELECT ");
    boolean isFirst = true;
    for (String column : columns) {
      if (isFirst) {
        isFirst = false;
      } else {
        sql.append(',');
      }
      if (alias != null && !alias.trim().isEmpty()) {
        sql.append(alias).append(".");
      }
      sql.append(column);
    }
    if (virtualColumns != null && !virtualColumns.isEmpty()) {
      isFirst = true;
      for (String column : virtualColumns) {
        if (sql.length() > 7) {
          sql.append(',');
        } else {
          if (isFirst) {
            isFirst = false;
          } else {
            sql.append(',');
          }
        }
        sql.append(column);
      }
    }
    sql.append(" FROM ").append(tableName);
    if (alias != null && !alias.trim().isEmpty()) {
      sql.append(" ").append(alias);
    }
    if (primaryKey != null && !primaryKey.isEmpty()) {
      isFirst = true;
      for (String column : primaryKey) {
        if (isFirst) {
          sql.append(" WHERE ");
          isFirst = false;
        } else {
          sql.append(" AND ");
        }
        if (alias != null && !alias.trim().isEmpty()) {
          sql.append(alias).append(".");
        }
        sql.append(column).append(" IS NOT NULL ");
      }
    }
    if (log.isInfoEnabled()) {
      log.info("generate base select  sql is : " + sql.toString());
    }
    return sql;
  }

  protected static final StringBuilder generateBaseCountSql(String tableName, Set<String> primaryKey) {
    return generateBaseCountSql(tableName, primaryKey, null);
  }

  protected static final StringBuilder generateBaseCountSql(String tableName, Set<String> primaryKey, String alias) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BasePersistent.generateBaseCountSql.");
      log.debug("parameter tableName is : " + tableName);
      log.debug("parameter primaryKey is : " + primaryKey);
      log.debug("parameter alias is : " + alias);
    }
    StringBuilder sql = new StringBuilder("SELECT ");
    if (primaryKey != null && !primaryKey.isEmpty() && primaryKey.size() == 1) {
      sql.append(" count(");
      if (alias != null && !alias.trim().isEmpty()) {
        sql.append(alias).append(".");
      }
      sql.append(primaryKey.iterator().next());
      sql.append(") AS COUNTS ");
    } else {
      sql.append(" count(*) AS COUNTS ");
    }
    sql.append(" FROM ").append(tableName);
    if (alias != null && !alias.trim().isEmpty()) {
      sql.append(" ").append(alias);
    }
    if (primaryKey != null && !primaryKey.isEmpty()) {
      boolean isFirst = true;
      for (String column : primaryKey) {
        if (isFirst) {
          sql.append(" WHERE ");
          isFirst = false;
        } else {
          sql.append(" AND ");
        }
        if (alias != null && !alias.trim().isEmpty()) {
          sql.append(alias).append(".");
        }
        sql.append(column).append(" IS NOT NULL ");
      }
    }
    if (log.isInfoEnabled()) {
      log.info("generate base count sql is : " + sql.toString());
    }
    return sql;
  }

  protected static final StringBuilder generateKeySearchSql(String tableName, Set<String> columns, Set<String> searchColumns) {
    return generateKeySearchSql(tableName, columns, null, searchColumns, null);
  }

  protected static final StringBuilder generateKeySearchSql(String tableName, Set<String> columns, Set<String> searchColumns, String alias) {
    return generateKeySearchSql(tableName, columns, null, searchColumns, alias);
  }

  protected static final StringBuilder generateKeySearchSql(String tableName, Set<String> columns, Set<String> virtualColumns, Set<String> searchColumns) {
    return generateKeySearchSql(tableName, columns, virtualColumns, searchColumns, null);
  }

  protected static final StringBuilder generateKeySearchSql(String tableName, Set<String> columns, Set<String> virtualColumns, Set<String> searchColumns, String alias) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BasePersistent.generateKeySearchSql.");
      log.debug("parameter tableName is : " + tableName);
      log.debug("parameter columns is : " + columns);
      log.debug("parameter virtualColumns is : " + virtualColumns);
      log.debug("parameter searchColumns is : " + searchColumns);
    }
    StringBuilder sql = new StringBuilder("SELECT ");
    boolean isFirst = true;
    for (String column : columns) {
      if (isFirst) {
        isFirst = false;
      } else {
        sql.append(',');
      }
      if (alias != null && !alias.trim().isEmpty()) {
        sql.append(alias).append(".");
      }
      sql.append(column);
    }
    if (virtualColumns != null && !virtualColumns.isEmpty()) {
      isFirst = true;
      for (String column : virtualColumns) {
        if (sql.length() > 7) {
          sql.append(',');
        } else {
          if (isFirst) {
            isFirst = false;
          } else {
            sql.append(',');
          }
        }
        sql.append(column);
      }
    }
    sql.append(" FROM ").append(tableName);
    if (alias != null && !alias.trim().isEmpty()) {
      sql.append(" ").append(alias);
    }
    if (searchColumns != null && !searchColumns.isEmpty()) {
      sql.append(" WHERE (");
      isFirst = true;
      for (String column : searchColumns) {
        if (isFirst) {
          isFirst = false;
        } else {
          sql.append(" OR ");
        }
        if (alias != null && !alias.trim().isEmpty()) {
          sql.append(alias).append(".");
        }
        sql.append(column).append(" LIKE ").append(":").append(SEARCH_KEY_PARAMETER);
      }
      sql.append(")");
    }
    if (log.isInfoEnabled()) {
      log.info("generate key search sql is : " + sql.toString());
    }
    return sql;
  }

  protected final StringBuilder generateWhereSql(Set<String> columns, Map<String, String> columnsParameter) {
    return generateWhereSql(columns, columnsParameter, null);
  }

  protected final StringBuilder generateWhereSql(Set<String> columns, Map<String, String> columnsParameter, String alias) {
    StringBuilder sql = new StringBuilder();
    boolean isFirst = true;
    for (String column : columns) {
      if (isFirst) {
        isFirst = false;
      } else {
        sql.append(" AND ");
      }
      if (alias != null && !alias.trim().isEmpty()) {
        sql.append(alias).append(".");
      }
      sql.append(column).append(" = ").append(':').append(columnsParameter.get(column));
    }
    return sql;
  }

  protected final StringBuilder generateKeySearchWhereSql(Set<String> searchColumns, String alias) {
    StringBuilder sql = new StringBuilder("(");
    boolean isFirst = true;
    for (String column : searchColumns) {
      if (isFirst) {
        isFirst = false;
      } else {
        sql.append(" OR ");
      }
      if (alias != null && !alias.trim().isEmpty()) {
        sql.append(alias).append(".");
      }
      sql.append(column).append(" LIKE ").append(":").append(SEARCH_KEY_PARAMETER);
    }
    sql.append(")");
    return sql;
  }

  protected final StringBuilder getCountBySimpleSql(StringBuilder selectSql) {
    StringBuilder sql = new StringBuilder("SELECT count(1) AS COUNTS ");
    String baseSql = selectSql.substring(selectSql.toString().toUpperCase().lastIndexOf(" FROM "));
    if (selectSql.lastIndexOf(" GROUP BY ") != -1) {
      baseSql = baseSql.substring(0, baseSql.lastIndexOf(" GROUP BY ") + 1);
    }
    return sql.append(baseSql);
  }

  protected final StringBuilder getPaginationBySimpleSql(StringBuilder selectSql) {
    StringBuilder sql = new StringBuilder();
    if (isLimit()) {
      sql.append(selectSql).append(" LIMIT ").append(":").append(FIRST_RESLUT_PARAMETER).append(" , ").append(":").append(PAGE_SIZE_PARAMETER);
    }
    if (isSubQuery()) {
      sql.append(" SELECT * FROM ( ");
      sql.append(" SELECT S_B_QUERY.*, ROWNUM AS RN FROM (").append(selectSql).append(") AS S_B_QUERY ");
      sql.append(" WHERE ROWNUM <= :pageSize ");
      sql.append(" WHERE RN >= :firstReslut ");
    }
    if (isfetchOffset()) {
      sql.append(selectSql).append(" OFFSET ").append(":").append(FIRST_RESLUT_PARAMETER).append(" ROWS FETCH NEXT ");
      sql.append(":").append(PAGE_SIZE_PARAMETER).append(" ROWS ONLY");
    }
    return sql;
  }

  protected final void appendOrderBy(StringBuilder sql, Map<String, String> columnsParameter, Collection<Sort> sortCollection) {
    appendOrderBy(sql, columnsParameter, sortCollection, null);
  }

  protected final void appendOrderBy(StringBuilder sql, Map<String, String> columnsParameter, Collection<Sort> sortCollection, String alias) {
    StringBuilder orderBy = new StringBuilder();
    boolean isFirst = true;
    for (Sort sort : sortCollection) {
      if (sort != null) {
        String column = null;
        for (String key : columnsParameter.keySet()) {
          if (columnsParameter.get(key).equals(sort.getProperty())) {
            column = key;
            break;
          }
        }
        if (column != null && !column.trim().isEmpty()) {
          if (isFirst) {
            isFirst = false;
          } else {
            orderBy.append(" , ");
          }
          if (alias != null && !alias.trim().isEmpty()) {
            orderBy.append(alias).append(".");
          }
          orderBy.append(column);
          if (sort.isAsc()) {
            orderBy.append(" ASC ");
          }
          if (sort.isDesc()) {
            orderBy.append(" DESC ");
          }
        }
      }
    }
    if (orderBy.length() > 0) {
      if (sql.toString().toUpperCase().lastIndexOf("ORDER BY") != -1) {
        sql.append(", ").append(orderBy);
      } else {
        sql.append(" ORDER BY ").append(orderBy);
      }
    }
  }

  private final boolean isLimit() {
    try {
      String productName = this.jdbcTemplate.getDataSource().getConnection().getMetaData().getDatabaseProductName().toUpperCase();
      if (productName.indexOf("MYSQL") != -1 || productName.indexOf("MARIADB") != -1 || productName.indexOf("SQLITE") != -1) {
        return true;
      }
    } catch (SQLException e) {
    }
    return false;
  }

  private final boolean isSubQuery() {
    try {
      String productName = this.jdbcTemplate.getDataSource().getConnection().getMetaData().getDatabaseProductName().toUpperCase();
      if (productName.indexOf("ORACLE") != -1 || productName.indexOf("DB2") != -1) {
        return true;
      }
    } catch (SQLException e) {
    }
    return false;
  }

  private final boolean isfetchOffset() {
    try {
      String productName = this.jdbcTemplate.getDataSource().getConnection().getMetaData().getDatabaseProductName().toUpperCase();
      if (productName.indexOf("DERBY") != -1) {
        return true;
      }
    } catch (SQLException e) {
    }
    return false;
  }

  protected final SqlParameterSource getPaginationParameter(SqlParameterSource sqlParameterSource, PageSerachParameters page) {
    MapSqlParameterSource mapSqlParameterSource = null;
    if (sqlParameterSource == null) {
      mapSqlParameterSource = new MapSqlParameterSource();
    } else if (sqlParameterSource instanceof BeanPropertySqlParameterSource) {
      mapSqlParameterSource = new MapSqlParameterSource();
      for (String paramName : ((BeanPropertySqlParameterSource) sqlParameterSource).getReadablePropertyNames()) {
        mapSqlParameterSource.addValue(paramName, sqlParameterSource.getValue(paramName));
      }
    } else if (sqlParameterSource instanceof MapSqlParameterSource) {
      mapSqlParameterSource = (MapSqlParameterSource) sqlParameterSource;
    }
    mapSqlParameterSource.addValue(FIRST_RESLUT_PARAMETER, page.getFirstReslut());
    mapSqlParameterSource.addValue(PAGE_SIZE_PARAMETER, page.getPageSize());
    return mapSqlParameterSource;
  }

  protected final MapSqlParameterSource getMapSqlParameterSource(BeanPropertySqlParameterSource beanPropertySqlParameterSource) {
    MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
    for (String paramName : beanPropertySqlParameterSource.getReadablePropertyNames()) {
      mapSqlParameterSource.addValue(paramName, beanPropertySqlParameterSource.getValue(paramName));
    }
    return mapSqlParameterSource;
  }

  protected final String getLikeValue(String value) {
    if (value != null && !value.isEmpty()) {
      return "%" + value + "%";
    }
    return value;
  }

  protected final String getBeforeLikeValue(String value) {
    if (value != null && !value.isEmpty()) {
      return "%" + value;
    }
    return value;
  }

  protected final String getAfterLikeValue(String value) {
    if (value != null && !value.isEmpty()) {
      return value + "%";
    }
    return value;
  }
}