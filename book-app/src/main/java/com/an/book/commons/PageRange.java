/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.commons;

import java.io.Serializable;

public final class PageRange<T extends Serializable> implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long totalCount = 0l;
  private Long pageCount = 0l;
  private Long pageSize;
  private Long pageNumber;
  private Long firstReslut;

  private java.util.Collection<T> datas;

  public PageRange() {
    super();
  }

  public PageRange(PageSerachParameters page) {
    this();
    this.pageNumber = page.getPageNumber();
    this.pageSize = page.getPageSize();
    this.firstReslut = page.getFirstReslut();
  }

  public final void setPageRange(PageRange<?> pageRange) {
    this.totalCount = pageRange.getTotalCount();
    this.pageCount = pageRange.getPageCount();
    this.pageSize = pageRange.getPageSize();
    this.pageNumber = pageRange.getPageNumber();
    this.firstReslut = pageRange.getFirstReslut();
  }

  public final Long getTotalCount() {
    return totalCount;
  }

  public final void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
  }

  public final Long getPageSize() {
    return pageSize;
  }

  public final void setPageSize(Long pageSize) {
    this.pageSize = pageSize;
  }

  public final Long getPageNumber() {
    return pageNumber;
  }

  public final void setPageNumber(Long pageNumber) {
    this.pageNumber = pageNumber;
  }

  public final java.util.Collection<T> getDatas() {
    return datas;
  }

  public final void setDatas(java.util.Collection<T> datas) {
    this.datas = datas;
  }

  public final Long getFirstReslut() {
    return firstReslut;
  }

  public final void setFirstReslut(Long firstReslut) {
    this.firstReslut = firstReslut;
  }

  public final Long getPageCount() {
    if (pageCount == 0) {
      return (totalCount % pageSize == 0) ? totalCount / pageSize : (totalCount / pageSize) + 1;
    }
    return pageCount;
  }

  public final void setPageCount(Long pageCount) {
    this.pageCount = pageCount;
  }
}