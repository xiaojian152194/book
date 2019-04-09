/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.entity;


/**
 * 图书信息的实体类，关联的表名为BOOK_BOOK。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public class Book implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String id; // 图书ID

  protected java.lang.String bookIdentifier; // 图书编号

  protected java.lang.String bookName; // 图书名

  protected java.lang.String bookNum; // 图书数量

  protected java.lang.String bookDesc; // 图书简介

  protected java.lang.String borrow; // 是否允许借出

  protected java.lang.String userId; // 所属用户ID

  // 虚拟列
  protected java.lang.String userUsername; // 用户名

  /**
   * 返回图书信息对象的图书ID的值。
   * @return 图书信息对象的图书ID的值
   */
  public final java.lang.String getId() {
    return this.id;
  }

  /**
   * 设置图书信息对象的图书ID的值。
   *
   * @param id 
   *            图书ID的值
   */
  public final void setId(java.lang.String id) {
    this.id = id;
  }

  /**
   * 返回图书信息对象的图书编号的值。
   * @return 图书信息对象的图书编号的值
   */
  public final java.lang.String getBookIdentifier() {
    return this.bookIdentifier;
  }

  /**
   * 设置图书信息对象的图书编号的值。
   *
   * @param bookIdentifier 
   *            图书编号的值
   */
  public final void setBookIdentifier(java.lang.String bookIdentifier) {
    this.bookIdentifier = bookIdentifier;
  }

  /**
   * 返回图书信息对象的图书名的值。
   * @return 图书信息对象的图书名的值
   */
  public final java.lang.String getBookName() {
    return this.bookName;
  }

  /**
   * 设置图书信息对象的图书名的值。
   *
   * @param bookName 
   *            图书名的值
   */
  public final void setBookName(java.lang.String bookName) {
    this.bookName = bookName;
  }

  /**
   * 返回图书信息对象的图书数量的值。
   * @return 图书信息对象的图书数量的值
   */
  public final java.lang.String getBookNum() {
    return this.bookNum;
  }

  /**
   * 设置图书信息对象的图书数量的值。
   *
   * @param bookNum 
   *            图书数量的值
   */
  public final void setBookNum(java.lang.String bookNum) {
    this.bookNum = bookNum;
  }

  /**
   * 返回图书信息对象的图书简介的值。
   * @return 图书信息对象的图书简介的值
   */
  public final java.lang.String getBookDesc() {
    return this.bookDesc;
  }

  /**
   * 设置图书信息对象的图书简介的值。
   *
   * @param bookDesc 
   *            图书简介的值
   */
  public final void setBookDesc(java.lang.String bookDesc) {
    this.bookDesc = bookDesc;
  }

  /**
   * 返回图书信息对象的是否允许借出的值。
   * @return 图书信息对象的是否允许借出的值
   */
  public final java.lang.String getBorrow() {
    return this.borrow;
  }

  /**
   * 设置图书信息对象的是否允许借出的值。
   *
   * @param borrow 
   *            是否允许借出的值
   */
  public final void setBorrow(java.lang.String borrow) {
    this.borrow = borrow;
  }

  /**
   * 返回图书信息对象的所属用户ID的值。
   * @return 图书信息对象的所属用户ID的值
   */
  public final java.lang.String getUserId() {
    return this.userId;
  }

  /**
   * 设置图书信息对象的所属用户ID的值。
   *
   * @param userId 
   *            所属用户ID的值
   */
  public final void setUserId(java.lang.String userId) {
    this.userId = userId;
  }

  /**
   * 返回图书信息对象的用户名的值。
   * @return 图书信息对象的用户名的值
   */
  public final java.lang.String getUserUsername() {
    return this.userUsername;
  }

  /**
   * 设置图书信息对象的用户名的值。
   *
   * @param userUsername 
   *            用户名的值
   */
  public final void setUserUsername(java.lang.String userUsername) {
    this.userUsername = userUsername;
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
   * 判断当前图书信息对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.id != null ) { return false; }
    if(this.bookIdentifier != null ) { return false; }
    if(this.bookName != null ) { return false; }
    if(this.bookNum != null ) { return false; }
    if(this.bookDesc != null ) { return false; }
    if(this.borrow != null ) { return false; }
    if(this.userId != null ) { return false; }
    return true;
  }

  /**
   * 检查图书信息对象与目标图书信息对象的逻辑版本是否一致。
   *
   * @param entity
   *            要对比的图书信息对象。
   * @return true代表两个对象的版本一致，false代表两个对象的版本不一致
   */
  public boolean checkVersion(Book entity){
    if (this == entity) return true;
    if (entity == null || getClass() != entity.getClass()) return false;
    return true;
  }

  /**
   * 将当前图书信息对象当中的非空属性，逐一克隆到目标图书信息当中。
   *
   * @param entity
   *            将被克隆到的目标图书信息对象。
   */
  public void cloneThis(Book entity ) {
    if (this.id != null && this.id.trim().length() > 0) 
      entity.id = this.id;
    if (this.bookIdentifier != null && this.bookIdentifier.trim().length() > 0) 
      entity.bookIdentifier = this.bookIdentifier;
    if (this.bookName != null && this.bookName.trim().length() > 0) 
      entity.bookName = this.bookName;
    if (this.bookNum != null && this.bookNum.trim().length() > 0) 
      entity.bookNum = this.bookNum;
    if (this.bookDesc != null && this.bookDesc.trim().length() > 0) 
      entity.bookDesc = this.bookDesc;
    if (this.borrow != null && this.borrow.trim().length() > 0) 
      entity.borrow = this.borrow;
    if (this.userId != null && this.userId.trim().length() > 0) 
      entity.userId = this.userId;
  }

  /**
   * 将当前图书信息对象当中的非空属性，逐一克隆到到目标图书信息对象集合当中。
   *
   * @param entities
   *            将被克隆到的目标图书信息对象集合。
   */
  public void cloneThisToCollection(java.util.Collection<Book> entities ) {
    for(Book entity : entities) {
      cloneThis(entity);
    }
  }

  /**
   * 将当前图书信息对象的主键的值设置为null。
   */
  public void clearPrimaryKeyValue() {
    this.id = null;
  }
}