/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.commons;

import java.io.Serializable;

public final class CommonParameters implements Serializable {

  private static final long serialVersionUID = 1L;

  private String _dc;

  private String verifyCode;

  private String action;
  private String statusValue;

  private Long page;
  private Long limit;
  private Long start;

  private String data;

  public boolean isPageSerach() {
    if ((start != null && start >= 0) && (limit != null && limit > 0)) {
      return true;
    }
    if ((page != null && page > 0) && (limit == null || limit > 0)) {
      return true;
    }
    return false;
  }

  public PageSerachParameters getPageSerachParameters() {
    PageSerachParameters page = new PageSerachParameters();
    page.setFirstReslut(this.getStart() == null ? 0 : this.getStart());
    page.setPageNumber(this.getPage() == null ? 1 : this.getPage());
    page.setPageSize(this.getLimit() == null ? 25 : this.getLimit());
    return page;
  }

  public final String get_dc() {
    return _dc;
  }

  public final void set_dc(String _dc) {
    this._dc = _dc;
  }

  public final String getVerifyCode() {
    return verifyCode;
  }

  public final void setVerifyCode(String verifyCode) {
    this.verifyCode = verifyCode;
  }

  public final String getAction() {
    return action;
  }

  public final void setAction(String action) {
    this.action = action;
  }

  public final String getStatusValue() {
    return statusValue;
  }

  public final void setStatusValue(String statusValue) {
    this.statusValue = statusValue;
  }

  public final Boolean getBooleanStatusValue() {
    if (this.statusValue == null || this.statusValue.trim().length() < 1) {
      return null;
    } else {
      return Boolean.valueOf(this.statusValue);
    }
  }
  
  public final Long getPage() {
    return page;
  }

  public final void setPage(Long page) {
    this.page = page;
  }

  public final Long getLimit() {
    return limit;
  }

  public final void setLimit(Long limit) {
    this.limit = limit;
  }

  public final Long getStart() {
    return start;
  }

  public final void setStart(Long start) {
    this.start = start;
  }

  public final String getData() {
    return data;
  }

  public final void setData(String data) {
    this.data = data;
  }
}