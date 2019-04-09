/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.pojo.search;

import java.io.Serializable;
import com.an.book.entity.BookImage;

/**
 * 图书图片信息的查询条件类。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public final class BookImageSearch implements Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String bookName; // eq图书名的参数值

  protected java.lang.String bookRealName; // eq存储的真实图书名称的参数值

  protected java.lang.String bookPath; // eq图片在服务器中的真实路径的参数值

  protected java.lang.Long uploadTime; // eq图片上传时间的参数值

  protected java.lang.String uploadIp; // eq图片上传的IP地址的参数值

  protected java.lang.String bookId; // eq所属图书ID的参数值

  /**
   * 返回图书图片信息对象的eq图书名的参数值的值。
   * @return 图书图片信息对象的eq图书名的参数值的值
   */
  public final java.lang.String getBookName() {
    return this.bookName;
  }

  /**
   * 设置图书图片信息对象的eq图书名的参数值的值。
   *
   * @param bookName 
   *            eq图书名的参数值的值
   */
  public final void setBookName(java.lang.String bookName) {
    this.bookName = bookName;
  }
    
  /**
   * 返回图书图片信息对象的eq存储的真实图书名称的参数值的值。
   * @return 图书图片信息对象的eq存储的真实图书名称的参数值的值
   */
  public final java.lang.String getBookRealName() {
    return this.bookRealName;
  }

  /**
   * 设置图书图片信息对象的eq存储的真实图书名称的参数值的值。
   *
   * @param bookRealName 
   *            eq存储的真实图书名称的参数值的值
   */
  public final void setBookRealName(java.lang.String bookRealName) {
    this.bookRealName = bookRealName;
  }
    
  /**
   * 返回图书图片信息对象的eq图片在服务器中的真实路径的参数值的值。
   * @return 图书图片信息对象的eq图片在服务器中的真实路径的参数值的值
   */
  public final java.lang.String getBookPath() {
    return this.bookPath;
  }

  /**
   * 设置图书图片信息对象的eq图片在服务器中的真实路径的参数值的值。
   *
   * @param bookPath 
   *            eq图片在服务器中的真实路径的参数值的值
   */
  public final void setBookPath(java.lang.String bookPath) {
    this.bookPath = bookPath;
  }
    
  /**
   * 返回图书图片信息对象的eq图片上传时间的参数值的值。
   * @return 图书图片信息对象的eq图片上传时间的参数值的值
   */
  public final java.lang.Long getUploadTime() {
    return this.uploadTime;
  }

  /**
   * 设置图书图片信息对象的eq图片上传时间的参数值的值。
   *
   * @param uploadTime 
   *            eq图片上传时间的参数值的值
   */
  public final void setUploadTime(java.lang.Long uploadTime) {
    this.uploadTime = uploadTime;
  }
    
  /**
   * 返回图书图片信息对象的eq图片上传的IP地址的参数值的值。
   * @return 图书图片信息对象的eq图片上传的IP地址的参数值的值
   */
  public final java.lang.String getUploadIp() {
    return this.uploadIp;
  }

  /**
   * 设置图书图片信息对象的eq图片上传的IP地址的参数值的值。
   *
   * @param uploadIp 
   *            eq图片上传的IP地址的参数值的值
   */
  public final void setUploadIp(java.lang.String uploadIp) {
    this.uploadIp = uploadIp;
  }
    
  /**
   * 返回图书图片信息对象的eq所属图书ID的参数值的值。
   * @return 图书图片信息对象的eq所属图书ID的参数值的值
   */
  public final java.lang.String getBookId() {
    return this.bookId;
  }

  /**
   * 设置图书图片信息对象的eq所属图书ID的参数值的值。
   *
   * @param bookId 
   *            eq所属图书ID的参数值的值
   */
  public final void setBookId(java.lang.String bookId) {
    this.bookId = bookId;
  }
    

  /**
   * 判断当前图书图片信息对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.bookName != null ) { return false; }
    if(this.bookRealName != null ) { return false; }
    if(this.bookPath != null ) { return false; }
    if(this.uploadTime != null ) { return false; }
    if(this.uploadIp != null ) { return false; }
    if(this.bookId != null ) { return false; }
    return true;
  }

  @Override
  public String toString() {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }

  public void setEntity(BookImage entity) {
    this.bookName = entity.getBookName();
    this.bookRealName = entity.getBookRealName();
    this.bookPath = entity.getBookPath();
    this.uploadTime = entity.getUploadTime();
    this.uploadIp = entity.getUploadIp();
    this.bookId = entity.getBookId();
  }
}