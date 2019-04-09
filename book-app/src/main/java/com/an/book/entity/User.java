/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.entity;


/**
 * 用户的实体类，关联的表名为BOOK_USER。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public class User implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String id; // 账号ID

  protected java.lang.String username; // 用户名

  protected java.lang.String password; // 密码

  protected java.lang.String haveAuthority; // 是否为管理员

  protected java.lang.Long createDate; // 创建时间

  /**
   * 返回用户对象的账号ID的值。
   * @return 用户对象的账号ID的值
   */
  public final java.lang.String getId() {
    return this.id;
  }

  /**
   * 设置用户对象的账号ID的值。
   *
   * @param id 
   *            账号ID的值
   */
  public final void setId(java.lang.String id) {
    this.id = id;
  }

  /**
   * 返回用户对象的用户名的值。
   * @return 用户对象的用户名的值
   */
  public final java.lang.String getUsername() {
    return this.username;
  }

  /**
   * 设置用户对象的用户名的值。
   *
   * @param username 
   *            用户名的值
   */
  public final void setUsername(java.lang.String username) {
    this.username = username;
  }

  /**
   * 返回用户对象的密码的值。
   * @return 用户对象的密码的值
   */
  public final java.lang.String getPassword() {
    return this.password;
  }

  /**
   * 设置用户对象的密码的值。
   *
   * @param password 
   *            密码的值
   */
  public final void setPassword(java.lang.String password) {
    this.password = password;
  }

  /**
   * 返回用户对象的是否为管理员的值。
   * @return 用户对象的是否为管理员的值
   */
  public final java.lang.String getHaveAuthority() {
    return this.haveAuthority;
  }

  /**
   * 设置用户对象的是否为管理员的值。
   *
   * @param haveAuthority 
   *            是否为管理员的值
   */
  public final void setHaveAuthority(java.lang.String haveAuthority) {
    this.haveAuthority = haveAuthority;
  }

  /**
   * 返回用户对象的创建时间的值。
   * @return 用户对象的创建时间的值
   */
  public final java.lang.Long getCreateDate() {
    return this.createDate;
  }

  /**
   * 设置用户对象的创建时间的值。
   *
   * @param createDate 
   *            创建时间的值
   */
  public final void setCreateDate(java.lang.Long createDate) {
    this.createDate = createDate;
  }



  @Override
  public String toString() {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }

  @Override
  public boolean equals(Object object) {
    return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, object);
  }

  @Override
  public int hashCode() {
    return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(this);
  }

  /**
   * 判断当前用户对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.id != null ) { return false; }
    if(this.username != null ) { return false; }
    if(this.password != null ) { return false; }
    if(this.haveAuthority != null ) { return false; }
    if(this.createDate != null ) { return false; }
    return true;
  }

  /**
   * 检查用户对象与目标用户对象的逻辑版本是否一致。
   *
   * @param entity
   *            要对比的用户对象。
   * @return true代表两个对象的版本一致，false代表两个对象的版本不一致
   */
  public boolean checkVersion(User entity){
    if (this == entity) return true;
    if (entity == null || getClass() != entity.getClass()) return false;
    return true;
  }

  /**
   * 将当前用户对象当中的非空属性，逐一克隆到目标用户当中。
   *
   * @param entity
   *            将被克隆到的目标用户对象。
   */
  public void cloneThis(User entity ) {
    if (this.id != null && this.id.trim().length() > 0) 
      entity.id = this.id;
    if (this.username != null && this.username.trim().length() > 0) 
      entity.username = this.username;
    if (this.password != null && this.password.trim().length() > 0) 
      entity.password = this.password;
    if (this.haveAuthority != null && this.haveAuthority.trim().length() > 0) 
      entity.haveAuthority = this.haveAuthority;
    if (this.createDate != null) 
      entity.createDate = this.createDate;
  }

  /**
   * 将当前用户对象当中的非空属性，逐一克隆到到目标用户对象集合当中。
   *
   * @param entities
   *            将被克隆到的目标用户对象集合。
   */
  public void cloneThisToCollection(java.util.Collection<User> entities ) {
    for(User entity : entities) {
      cloneThis(entity);
    }
  }

  /**
   * 将当前用户对象的主键的值设置为null。
   */
  public void clearPrimaryKeyValue() {
    this.id = null;
  }
}