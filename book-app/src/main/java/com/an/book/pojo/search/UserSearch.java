/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.pojo.search;

import java.io.Serializable;
import com.an.book.entity.User;

/**
 * 用户的查询条件类。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public final class UserSearch implements Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String username; // eq用户名的参数值

  protected java.lang.String password; // eq密码的参数值

  protected java.lang.String haveAuthority; // eq是否为管理员的参数值

  protected java.lang.Long createDate; // eq创建时间的参数值

  /**
   * 返回用户对象的eq用户名的参数值的值。
   * @return 用户对象的eq用户名的参数值的值
   */
  public final java.lang.String getUsername() {
    return this.username;
  }

  /**
   * 设置用户对象的eq用户名的参数值的值。
   *
   * @param username 
   *            eq用户名的参数值的值
   */
  public final void setUsername(java.lang.String username) {
    this.username = username;
  }
    
  /**
   * 返回用户对象的eq密码的参数值的值。
   * @return 用户对象的eq密码的参数值的值
   */
  public final java.lang.String getPassword() {
    return this.password;
  }

  /**
   * 设置用户对象的eq密码的参数值的值。
   *
   * @param password 
   *            eq密码的参数值的值
   */
  public final void setPassword(java.lang.String password) {
    this.password = password;
  }
    
  /**
   * 返回用户对象的eq是否为管理员的参数值的值。
   * @return 用户对象的eq是否为管理员的参数值的值
   */
  public final java.lang.String getHaveAuthority() {
    return this.haveAuthority;
  }

  /**
   * 设置用户对象的eq是否为管理员的参数值的值。
   *
   * @param haveAuthority 
   *            eq是否为管理员的参数值的值
   */
  public final void setHaveAuthority(java.lang.String haveAuthority) {
    this.haveAuthority = haveAuthority;
  }
    
  /**
   * 返回用户对象的eq创建时间的参数值的值。
   * @return 用户对象的eq创建时间的参数值的值
   */
  public final java.lang.Long getCreateDate() {
    return this.createDate;
  }

  /**
   * 设置用户对象的eq创建时间的参数值的值。
   *
   * @param createDate 
   *            eq创建时间的参数值的值
   */
  public final void setCreateDate(java.lang.Long createDate) {
    this.createDate = createDate;
  }
    

  /**
   * 判断当前用户对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.username != null ) { return false; }
    if(this.password != null ) { return false; }
    if(this.haveAuthority != null ) { return false; }
    if(this.createDate != null ) { return false; }
    return true;
  }

  @Override
  public String toString() {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }

  public void setEntity(User entity) {
    this.username = entity.getUsername();
    this.password = entity.getPassword();
    this.haveAuthority = entity.getHaveAuthority();
    this.createDate = entity.getCreateDate();
  }
}