/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.commons;

import java.io.Serializable;

public final class AuthorizedContext implements Serializable {

  private static final long serialVersionUID = 1L;

  public static String getSignature() {
    return "Anonymous";
  }
}