/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.entity;


/**
 * 图书图片信息的实体类，关联的表名为BOOK_BOOK_IMAGE。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public class BookImage implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String id; // 图书图片ID

  protected java.lang.String bookName; // 图书名

  protected java.lang.String bookRealName; // 存储的真实图书名称

  protected java.lang.String bookPath; // 图片在服务器中的真实路径

  protected java.lang.Long uploadTime; // 图片上传时间

  protected java.lang.String uploadIp; // 图片上传的IP地址

  protected java.lang.String bookId; // 所属图书ID

  // 虚拟列
  protected java.lang.String bookBookName; // 图书名

  /**
   * 返回图书图片信息对象的图书图片ID的值。
   * @return 图书图片信息对象的图书图片ID的值
   */
  public final java.lang.String getId() {
    return this.id;
  }

  /**
   * 设置图书图片信息对象的图书图片ID的值。
   *
   * @param id 
   *            图书图片ID的值
   */
  public final void setId(java.lang.String id) {
    this.id = id;
  }

  /**
   * 返回图书图片信息对象的图书名的值。
   * @return 图书图片信息对象的图书名的值
   */
  public final java.lang.String getBookName() {
    return this.bookName;
  }

  /**
   * 设置图书图片信息对象的图书名的值。
   *
   * @param bookName 
   *            图书名的值
   */
  public final void setBookName(java.lang.String bookName) {
    this.bookName = bookName;
  }

  /**
   * 返回图书图片信息对象的存储的真实图书名称的值。
   * @return 图书图片信息对象的存储的真实图书名称的值
   */
  public final java.lang.String getBookRealName() {
    return this.bookRealName;
  }

  /**
   * 设置图书图片信息对象的存储的真实图书名称的值。
   *
   * @param bookRealName 
   *            存储的真实图书名称的值
   */
  public final void setBookRealName(java.lang.String bookRealName) {
    this.bookRealName = bookRealName;
  }

  /**
   * 返回图书图片信息对象的图片在服务器中的真实路径的值。
   * @return 图书图片信息对象的图片在服务器中的真实路径的值
   */
  public final java.lang.String getBookPath() {
    return this.bookPath;
  }

  /**
   * 设置图书图片信息对象的图片在服务器中的真实路径的值。
   *
   * @param bookPath 
   *            图片在服务器中的真实路径的值
   */
  public final void setBookPath(java.lang.String bookPath) {
    this.bookPath = bookPath;
  }

  /**
   * 返回图书图片信息对象的图片上传时间的值。
   * @return 图书图片信息对象的图片上传时间的值
   */
  public final java.lang.Long getUploadTime() {
    return this.uploadTime;
  }

  /**
   * 设置图书图片信息对象的图片上传时间的值。
   *
   * @param uploadTime 
   *            图片上传时间的值
   */
  public final void setUploadTime(java.lang.Long uploadTime) {
    this.uploadTime = uploadTime;
  }

  /**
   * 返回图书图片信息对象的图片上传的IP地址的值。
   * @return 图书图片信息对象的图片上传的IP地址的值
   */
  public final java.lang.String getUploadIp() {
    return this.uploadIp;
  }

  /**
   * 设置图书图片信息对象的图片上传的IP地址的值。
   *
   * @param uploadIp 
   *            图片上传的IP地址的值
   */
  public final void setUploadIp(java.lang.String uploadIp) {
    this.uploadIp = uploadIp;
  }

  /**
   * 返回图书图片信息对象的所属图书ID的值。
   * @return 图书图片信息对象的所属图书ID的值
   */
  public final java.lang.String getBookId() {
    return this.bookId;
  }

  /**
   * 设置图书图片信息对象的所属图书ID的值。
   *
   * @param bookId 
   *            所属图书ID的值
   */
  public final void setBookId(java.lang.String bookId) {
    this.bookId = bookId;
  }

  /**
   * 返回图书图片信息对象的图书名的值。
   * @return 图书图片信息对象的图书名的值
   */
  public final java.lang.String getBookBookName() {
    return this.bookBookName;
  }

  /**
   * 设置图书图片信息对象的图书名的值。
   *
   * @param bookBookName 
   *            图书名的值
   */
  public final void setBookBookName(java.lang.String bookBookName) {
    this.bookBookName = bookBookName;
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
   * 判断当前图书图片信息对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.id != null ) { return false; }
    if(this.bookName != null ) { return false; }
    if(this.bookRealName != null ) { return false; }
    if(this.bookPath != null ) { return false; }
    if(this.uploadTime != null ) { return false; }
    if(this.uploadIp != null ) { return false; }
    if(this.bookId != null ) { return false; }
    return true;
  }

  /**
   * 检查图书图片信息对象与目标图书图片信息对象的逻辑版本是否一致。
   *
   * @param entity
   *            要对比的图书图片信息对象。
   * @return true代表两个对象的版本一致，false代表两个对象的版本不一致
   */
  public boolean checkVersion(BookImage entity){
    if (this == entity) return true;
    if (entity == null || getClass() != entity.getClass()) return false;
    return true;
  }

  /**
   * 将当前图书图片信息对象当中的非空属性，逐一克隆到目标图书图片信息当中。
   *
   * @param entity
   *            将被克隆到的目标图书图片信息对象。
   */
  public void cloneThis(BookImage entity ) {
    if (this.id != null && this.id.trim().length() > 0) 
      entity.id = this.id;
    if (this.bookName != null && this.bookName.trim().length() > 0) 
      entity.bookName = this.bookName;
    if (this.bookRealName != null && this.bookRealName.trim().length() > 0) 
      entity.bookRealName = this.bookRealName;
    if (this.bookPath != null && this.bookPath.trim().length() > 0) 
      entity.bookPath = this.bookPath;
    if (this.uploadTime != null) 
      entity.uploadTime = this.uploadTime;
    if (this.uploadIp != null && this.uploadIp.trim().length() > 0) 
      entity.uploadIp = this.uploadIp;
    if (this.bookId != null && this.bookId.trim().length() > 0) 
      entity.bookId = this.bookId;
  }

  /**
   * 将当前图书图片信息对象当中的非空属性，逐一克隆到到目标图书图片信息对象集合当中。
   *
   * @param entities
   *            将被克隆到的目标图书图片信息对象集合。
   */
  public void cloneThisToCollection(java.util.Collection<BookImage> entities ) {
    for(BookImage entity : entities) {
      cloneThis(entity);
    }
  }

  /**
   * 将当前图书图片信息对象的主键的值设置为null。
   */
  public void clearPrimaryKeyValue() {
    this.id = null;
  }
}