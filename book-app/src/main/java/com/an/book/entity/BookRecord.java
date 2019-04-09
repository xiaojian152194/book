/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.entity;


/**
 * 图书借阅记录的实体类，关联的表名为BOOK_BOOK_RECORD。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public class BookRecord implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String id; // 图书借阅记录ID

  protected java.lang.String bookName; // 借阅图书名

  protected java.lang.String bookNum; // 借阅图书数量

  protected java.lang.Long borrowDate; // 图书借出时间

  protected java.lang.Long backDate; // 图书归还时间

  protected java.lang.String userId; // 所属用户ID

  // 虚拟列
  protected java.lang.String userUsername; // 用户名

  /**
   * 返回图书借阅记录对象的图书借阅记录ID的值。
   * @return 图书借阅记录对象的图书借阅记录ID的值
   */
  public final java.lang.String getId() {
    return this.id;
  }

  /**
   * 设置图书借阅记录对象的图书借阅记录ID的值。
   *
   * @param id 
   *            图书借阅记录ID的值
   */
  public final void setId(java.lang.String id) {
    this.id = id;
  }

  /**
   * 返回图书借阅记录对象的借阅图书名的值。
   * @return 图书借阅记录对象的借阅图书名的值
   */
  public final java.lang.String getBookName() {
    return this.bookName;
  }

  /**
   * 设置图书借阅记录对象的借阅图书名的值。
   *
   * @param bookName 
   *            借阅图书名的值
   */
  public final void setBookName(java.lang.String bookName) {
    this.bookName = bookName;
  }

  /**
   * 返回图书借阅记录对象的借阅图书数量的值。
   * @return 图书借阅记录对象的借阅图书数量的值
   */
  public final java.lang.String getBookNum() {
    return this.bookNum;
  }

  /**
   * 设置图书借阅记录对象的借阅图书数量的值。
   *
   * @param bookNum 
   *            借阅图书数量的值
   */
  public final void setBookNum(java.lang.String bookNum) {
    this.bookNum = bookNum;
  }

  /**
   * 返回图书借阅记录对象的图书借出时间的值。
   * @return 图书借阅记录对象的图书借出时间的值
   */
  public final java.lang.Long getBorrowDate() {
    return this.borrowDate;
  }

  /**
   * 设置图书借阅记录对象的图书借出时间的值。
   *
   * @param borrowDate 
   *            图书借出时间的值
   */
  public final void setBorrowDate(java.lang.Long borrowDate) {
    this.borrowDate = borrowDate;
  }

  /**
   * 返回图书借阅记录对象的图书归还时间的值。
   * @return 图书借阅记录对象的图书归还时间的值
   */
  public final java.lang.Long getBackDate() {
    return this.backDate;
  }

  /**
   * 设置图书借阅记录对象的图书归还时间的值。
   *
   * @param backDate 
   *            图书归还时间的值
   */
  public final void setBackDate(java.lang.Long backDate) {
    this.backDate = backDate;
  }

  /**
   * 返回图书借阅记录对象的所属用户ID的值。
   * @return 图书借阅记录对象的所属用户ID的值
   */
  public final java.lang.String getUserId() {
    return this.userId;
  }

  /**
   * 设置图书借阅记录对象的所属用户ID的值。
   *
   * @param userId 
   *            所属用户ID的值
   */
  public final void setUserId(java.lang.String userId) {
    this.userId = userId;
  }

  /**
   * 返回图书借阅记录对象的用户名的值。
   * @return 图书借阅记录对象的用户名的值
   */
  public final java.lang.String getUserUsername() {
    return this.userUsername;
  }

  /**
   * 设置图书借阅记录对象的用户名的值。
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
   * 判断当前图书借阅记录对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.id != null ) { return false; }
    if(this.bookName != null ) { return false; }
    if(this.bookNum != null ) { return false; }
    if(this.borrowDate != null ) { return false; }
    if(this.backDate != null ) { return false; }
    if(this.userId != null ) { return false; }
    return true;
  }

  /**
   * 检查图书借阅记录对象与目标图书借阅记录对象的逻辑版本是否一致。
   *
   * @param entity
   *            要对比的图书借阅记录对象。
   * @return true代表两个对象的版本一致，false代表两个对象的版本不一致
   */
  public boolean checkVersion(BookRecord entity){
    if (this == entity) return true;
    if (entity == null || getClass() != entity.getClass()) return false;
    return true;
  }

  /**
   * 将当前图书借阅记录对象当中的非空属性，逐一克隆到目标图书借阅记录当中。
   *
   * @param entity
   *            将被克隆到的目标图书借阅记录对象。
   */
  public void cloneThis(BookRecord entity ) {
    if (this.id != null && this.id.trim().length() > 0) 
      entity.id = this.id;
    if (this.bookName != null && this.bookName.trim().length() > 0) 
      entity.bookName = this.bookName;
    if (this.bookNum != null && this.bookNum.trim().length() > 0) 
      entity.bookNum = this.bookNum;
    if (this.borrowDate != null) 
      entity.borrowDate = this.borrowDate;
    if (this.backDate != null) 
      entity.backDate = this.backDate;
    if (this.userId != null && this.userId.trim().length() > 0) 
      entity.userId = this.userId;
  }

  /**
   * 将当前图书借阅记录对象当中的非空属性，逐一克隆到到目标图书借阅记录对象集合当中。
   *
   * @param entities
   *            将被克隆到的目标图书借阅记录对象集合。
   */
  public void cloneThisToCollection(java.util.Collection<BookRecord> entities ) {
    for(BookRecord entity : entities) {
      cloneThis(entity);
    }
  }

  /**
   * 将当前图书借阅记录对象的主键的值设置为null。
   */
  public void clearPrimaryKeyValue() {
    this.id = null;
  }
}