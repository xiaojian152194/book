/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.exception;


/**
 * 异常类。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
public class BookException extends Exception {

  private static final long serialVersionUID = 1L;

  public BookException() {
    super();
  }

  public BookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public BookException(String message, Throwable cause) {
    super(message, cause);
  }

  public BookException(String message) {
    super(message);
  }

  public BookException(Throwable cause) {
    super(cause);
  }

  public BookException getException() {
    return null;
  }
}