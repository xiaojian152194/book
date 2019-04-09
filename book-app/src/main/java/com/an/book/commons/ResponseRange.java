/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.commons;

import java.io.Serializable;

public final class ResponseRange<T extends Serializable> implements Serializable {

  private static final long serialVersionUID = 1L;

  private int code = 200;
  private boolean successResponse = true;
  private String message = "ok";
  private String requestId;
  private boolean isPageRange = false;
  private java.util.Collection<T> datas;
  private java.util.Collection<T> children;
  private Long totalCount = 0l;
  private Long pageCount = null;
  private Long pageSize = null;
  private Long pageNumber = null;
  private Long firstReslut = null;
  

  public final void setException(Exception e) {
    successResponse = false;
    code = 500;
    message = e.getMessage();
  }

  public final boolean isPageRange() {
    return isPageRange;
  }
  
  public final int getCode() {
    return code;
  }

  public final void setCode(int code) {
    this.code = code;
  }

  public final boolean isSuccessResponse() {
    return successResponse;
  }

  public final void setSuccessResponse(boolean successResponse) {
    this.successResponse = successResponse;
  }

  public final String getMessage() {
    return message;
  }

  public final void setMessage(String message) {
    this.message = message;
  }

  public final String getRequestId() {
    return requestId;
  }

  public final void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public final java.util.Collection<T> getDatas() {
    return datas;
  }

  public final void setDatas(java.util.Collection<T> datas) {
    this.datas = datas;
  }

  public final java.util.Collection<T> getChildren() {
    return children;
  }

  public final Long getTotalCount() {
    return totalCount;
  }

  public final void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
  }

  public final Long getPageCount() {
    return pageCount;
  }

  public final void setPageCount(Long pageCount) {
    this.pageCount = pageCount;
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

  public final Long getFirstReslut() {
    return firstReslut;
  }

  public final void setFirstReslut(Long firstReslut) {
    this.firstReslut = firstReslut;
  }

  public final void setPageRange(boolean isPageRange) {
    this.isPageRange = isPageRange;
  }

  public final void setData(PageRange<T> pageRange) {
    this.datas = pageRange.getDatas();
    this.isPageRange = true;
    this.datas = pageRange.getDatas();
    this.totalCount = pageRange.getTotalCount();
    this.pageCount = pageRange.getPageCount();
    this.pageNumber = pageRange.getPageNumber();
    this.firstReslut = pageRange.getFirstReslut();
  }

  public final void setData(java.util.Collection<T> datas) {
    this.totalCount = (long) datas.size();
    this.datas = datas;
  }

  public final void setChildren(java.util.Collection<T> datas) {
    this.totalCount = (long) datas.size();
    this.children = datas;
  }

  public final void setData(T data) {
    totalCount = 1l;
    datas = new java.util.ArrayList<T>();
    datas.add(data);
  }

}