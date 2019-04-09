/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.pojo.search;

import java.io.Serializable;
import com.an.book.entity.BookRecord;

/**
 * 图书借阅记录的查询条件类。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public final class BookRecordSearch implements Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String bookName; // eq借阅图书名的参数值

  protected java.lang.String bookNum; // eq借阅图书数量的参数值

  protected java.lang.Long borrowDate; // eq图书借出时间的参数值

  protected java.lang.Long backDate; // eq图书归还时间的参数值

  protected java.lang.String userId; // eq所属用户ID的参数值

  /**
   * 返回图书借阅记录对象的eq借阅图书名的参数值的值。
   * @return 图书借阅记录对象的eq借阅图书名的参数值的值
   */
  public final java.lang.String getBookName() {
    return this.bookName;
  }

  /**
   * 设置图书借阅记录对象的eq借阅图书名的参数值的值。
   *
   * @param bookName 
   *            eq借阅图书名的参数值的值
   */
  public final void setBookName(java.lang.String bookName) {
    this.bookName = bookName;
  }
    
  /**
   * 返回图书借阅记录对象的eq借阅图书数量的参数值的值。
   * @return 图书借阅记录对象的eq借阅图书数量的参数值的值
   */
  public final java.lang.String getBookNum() {
    return this.bookNum;
  }

  /**
   * 设置图书借阅记录对象的eq借阅图书数量的参数值的值。
   *
   * @param bookNum 
   *            eq借阅图书数量的参数值的值
   */
  public final void setBookNum(java.lang.String bookNum) {
    this.bookNum = bookNum;
  }
    
  /**
   * 返回图书借阅记录对象的eq图书借出时间的参数值的值。
   * @return 图书借阅记录对象的eq图书借出时间的参数值的值
   */
  public final java.lang.Long getBorrowDate() {
    return this.borrowDate;
  }

  /**
   * 设置图书借阅记录对象的eq图书借出时间的参数值的值。
   *
   * @param borrowDate 
   *            eq图书借出时间的参数值的值
   */
  public final void setBorrowDate(java.lang.Long borrowDate) {
    this.borrowDate = borrowDate;
  }
    
  /**
   * 返回图书借阅记录对象的eq图书归还时间的参数值的值。
   * @return 图书借阅记录对象的eq图书归还时间的参数值的值
   */
  public final java.lang.Long getBackDate() {
    return this.backDate;
  }

  /**
   * 设置图书借阅记录对象的eq图书归还时间的参数值的值。
   *
   * @param backDate 
   *            eq图书归还时间的参数值的值
   */
  public final void setBackDate(java.lang.Long backDate) {
    this.backDate = backDate;
  }
    
  /**
   * 返回图书借阅记录对象的eq所属用户ID的参数值的值。
   * @return 图书借阅记录对象的eq所属用户ID的参数值的值
   */
  public final java.lang.String getUserId() {
    return this.userId;
  }

  /**
   * 设置图书借阅记录对象的eq所属用户ID的参数值的值。
   *
   * @param userId 
   *            eq所属用户ID的参数值的值
   */
  public final void setUserId(java.lang.String userId) {
    this.userId = userId;
  }
    

  /**
   * 判断当前图书借阅记录对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.bookName != null ) { return false; }
    if(this.bookNum != null ) { return false; }
    if(this.borrowDate != null ) { return false; }
    if(this.backDate != null ) { return false; }
    if(this.userId != null ) { return false; }
    return true;
  }

  @Override
  public String toString() {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }

  public void setEntity(BookRecord entity) {
    this.bookName = entity.getBookName();
    this.bookNum = entity.getBookNum();
    this.borrowDate = entity.getBorrowDate();
    this.backDate = entity.getBackDate();
    this.userId = entity.getUserId();
  }
}