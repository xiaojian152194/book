/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.commons;

import java.io.Serializable;

/**
* 分页参数类
*
* @author pangzhigang
*
*/
public final class PageSerachParameters implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long firstReslut;
  private Long pageNumber;
  private Long pageSize;

  public final Long getFirstReslut() {
    if (pageNumber == null || pageNumber <= 1) {
      return firstReslut != null ? firstReslut : 0;
    } else {
      return pageSize * (pageNumber - 1);
    }
  }

  public final void setFirstReslut(Long firstReslut) {
    this.firstReslut = firstReslut;
  }

  public final Long getPageNumber() {
    return pageNumber;
  }

  public final void setPageNumber(Long pageNumber) {
    this.pageNumber = pageNumber;
  }

  public final Long getPageSize() {
    return pageSize;
  }

  public final void setPageSize(Long pageSize) {
    this.pageSize = pageSize;
  }

}