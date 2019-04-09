/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.pojo.search;

import java.io.Serializable;
import com.an.book.entity.Book;

/**
 * 图书信息的查询条件类。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public final class BookSearch implements Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String bookIdentifier; // eq图书编号的参数值

  protected java.lang.String bookName; // eq图书名的参数值

  protected java.lang.String bookNum; // eq图书数量的参数值

  protected java.lang.String bookDesc; // eq图书简介的参数值

  protected java.lang.String borrow; // eq是否允许借出的参数值

  protected java.lang.String userId; // eq所属用户ID的参数值

  protected java.lang.String likeBookName; // like图书名的参数值

  /**
   * 返回图书信息对象的eq图书编号的参数值的值。
   * @return 图书信息对象的eq图书编号的参数值的值
   */
  public final java.lang.String getBookIdentifier() {
    return this.bookIdentifier;
  }

  /**
   * 设置图书信息对象的eq图书编号的参数值的值。
   *
   * @param bookIdentifier 
   *            eq图书编号的参数值的值
   */
  public final void setBookIdentifier(java.lang.String bookIdentifier) {
    this.bookIdentifier = bookIdentifier;
  }
    
  /**
   * 返回图书信息对象的eq图书名的参数值的值。
   * @return 图书信息对象的eq图书名的参数值的值
   */
  public final java.lang.String getBookName() {
    return this.bookName;
  }

  /**
   * 设置图书信息对象的eq图书名的参数值的值。
   *
   * @param bookName 
   *            eq图书名的参数值的值
   */
  public final void setBookName(java.lang.String bookName) {
    this.bookName = bookName;
  }
    
  /**
   * 返回图书信息对象的eq图书数量的参数值的值。
   * @return 图书信息对象的eq图书数量的参数值的值
   */
  public final java.lang.String getBookNum() {
    return this.bookNum;
  }

  /**
   * 设置图书信息对象的eq图书数量的参数值的值。
   *
   * @param bookNum 
   *            eq图书数量的参数值的值
   */
  public final void setBookNum(java.lang.String bookNum) {
    this.bookNum = bookNum;
  }
    
  /**
   * 返回图书信息对象的eq图书简介的参数值的值。
   * @return 图书信息对象的eq图书简介的参数值的值
   */
  public final java.lang.String getBookDesc() {
    return this.bookDesc;
  }

  /**
   * 设置图书信息对象的eq图书简介的参数值的值。
   *
   * @param bookDesc 
   *            eq图书简介的参数值的值
   */
  public final void setBookDesc(java.lang.String bookDesc) {
    this.bookDesc = bookDesc;
  }
    
  /**
   * 返回图书信息对象的eq是否允许借出的参数值的值。
   * @return 图书信息对象的eq是否允许借出的参数值的值
   */
  public final java.lang.String getBorrow() {
    return this.borrow;
  }

  /**
   * 设置图书信息对象的eq是否允许借出的参数值的值。
   *
   * @param borrow 
   *            eq是否允许借出的参数值的值
   */
  public final void setBorrow(java.lang.String borrow) {
    this.borrow = borrow;
  }
    
  /**
   * 返回图书信息对象的eq所属用户ID的参数值的值。
   * @return 图书信息对象的eq所属用户ID的参数值的值
   */
  public final java.lang.String getUserId() {
    return this.userId;
  }

  /**
   * 设置图书信息对象的eq所属用户ID的参数值的值。
   *
   * @param userId 
   *            eq所属用户ID的参数值的值
   */
  public final void setUserId(java.lang.String userId) {
    this.userId = userId;
  }
    
  /**
   * 返回图书信息对象的like图书名的参数值的值。
   * @return 图书信息对象的like图书名的参数值的值
   */
  public final java.lang.String getLikeBookName() {
    return this.likeBookName;
  }

  /**
   * 设置图书信息对象的like图书名的参数值的值。
   *
   * @param likeBookName 
   *            like图书名的参数值的值
   */
  public final void setLikeBookName(java.lang.String likeBookName) {
    this.likeBookName = likeBookName;
  }
    

  /**
   * 判断当前图书信息对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.bookIdentifier != null ) { return false; }
    if(this.bookName != null ) { return false; }
    if(this.bookNum != null ) { return false; }
    if(this.bookDesc != null ) { return false; }
    if(this.borrow != null ) { return false; }
    if(this.userId != null ) { return false; }
    if(this.likeBookName != null ) { return false; }
    return true;
  }

  @Override
  public String toString() {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }

  public void setEntity(Book entity) {
    this.bookIdentifier = entity.getBookIdentifier();
    this.bookName = entity.getBookName();
    this.bookNum = entity.getBookNum();
    this.bookDesc = entity.getBookDesc();
    this.borrow = entity.getBorrow();
    this.userId = entity.getUserId();
  }
}