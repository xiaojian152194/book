/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.controller.springmvc.bg;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.an.book.commons.CommonParameters;
import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.commons.ResponseRange;
import com.an.book.entity.Book;
import com.an.book.pojo.search.BookSearch;
import com.an.book.service.IBookService;

/**
 * 该类是图书信息控制器。
 *
 * @author xiaojianzzz@163.com
 * @version 1.0.0-RELEASE
 */
@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "/book/book" })
public class BookController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(BookController.class);

  @javax.annotation.Resource(name = "com.an.book.BookService")
  private IBookService bookService;

  @RequestMapping(value = { "single" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<Book> save(CommonParameters commonParameters, @RequestBody Book book) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookController.save ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter book is : " + book);
    }
    ResponseRange<Book> responseRange = new ResponseRange<>();
    try {
      if (book == null || book.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("book不能为空。");
      }
      bookService.saveBook(book);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<Book> batchSave(CommonParameters commonParameters, @RequestBody List<Book> books) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookController.batchSave ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter books is : " + books);
    }
    ResponseRange<Book> responseRange = new ResponseRange<>();
    try {
      if (books == null || books.isEmpty()) {
        throw new java.lang.IllegalArgumentException("books不能为空。");
      }
      bookService.batchSaveBook(books);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "single" }, method = { RequestMethod.PUT })
  @ResponseBody
  public ResponseRange<Book> update(CommonParameters commonParameters, @RequestBody Book book) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookController.update ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter book is : " + book);
    }
    ResponseRange<Book> responseRange = new ResponseRange<>();
    try {
      if (book == null || book.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("book不能为空。");
      }
      bookService.updateBook(book);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.PUT })
  @ResponseBody
  public ResponseRange<Book> batchUpdate(CommonParameters commonParameters, @RequestBody List<Book> books) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookController.batchUpdate ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter books is : " + books);
    }
    ResponseRange<Book> responseRange = new ResponseRange<>();
    try {
      if (books == null || books.isEmpty()) {
        throw new java.lang.IllegalArgumentException("books不能为空。");
      }
      bookService.batchUpdateBook(books);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "single" }, method = { RequestMethod.DELETE })
  @ResponseBody
  public ResponseRange<Book> remove(CommonParameters commonParameters, @RequestBody Book book) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookController.remove ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter book is : " + book);
    }
    ResponseRange<Book> responseRange = new ResponseRange<>();
    try {
      if (book == null || book.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("book不能为空。");
      }
      bookService.removeBook(book);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.DELETE })
  @ResponseBody
  public ResponseRange<Book> batchRemove(CommonParameters commonParameters, @RequestBody List<Book> books) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookController.batchRemove ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter books is : " + books);
    }
    ResponseRange<Book> responseRange = new ResponseRange<>();
    try {
      if (books == null || books.isEmpty()) {
        throw new java.lang.IllegalArgumentException("books不能为空。");
      }
      bookService.batchRemoveBook(books);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "/{id}" }, method = { RequestMethod.GET })
  @ResponseBody
  public ResponseRange<Book> getByPrimaryKey(CommonParameters commonParameters, @PathVariable java.lang.String id) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookController.getByPrimaryKey ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter id is : " + id);
    }
    ResponseRange<Book> responseRange = new ResponseRange<>();
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      responseRange.setData(bookService.getBookByPrimaryKey(id));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.GET })
  @ResponseBody
  public ResponseRange<Book> get(CommonParameters commonParameters, BookSearch bookSearch) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookController.get ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookSearch is : " + bookSearch);
    }
    ResponseRange<Book> responseRange = new ResponseRange<>();
    try {
      if (bookSearch == null || bookSearch.selfIsNull()) {
        if (commonParameters.isPageSerach()) {
          responseRange.setData(bookService.paginationGetAllBook(commonParameters.getPageSerachParameters()));
        } else {
          responseRange.setData(bookService.getAllBook());
        }
      } else {
        if (commonParameters.isPageSerach()) {
          responseRange.setData(bookService.paginationSearchBook(bookSearch, commonParameters.getPageSerachParameters()));
        } else {
          responseRange.setData(bookService.searchBook(bookSearch));
        }
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "import" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<Book> batchImport(CommonParameters commonParameters, Book book, @RequestParam CommonsMultipartFile importFile) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookController.batchImport ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter book is : " + book);
      log.debug("parameter importFile is : " + importFile);
    }
    ResponseRange<Book> responseRange = new ResponseRange<>();
    try {
      java.io.InputStream inputXML = new java.io.BufferedInputStream(getClass().getResourceAsStream("/template/read/Book.xml"));
      org.jxls.reader.XLSReader mainReader = org.jxls.reader.ReaderBuilder.buildFromXML(inputXML);
      java.io.InputStream inputXLS = new java.io.BufferedInputStream(importFile.getInputStream());
      java.util.List<Book> bookList = new java.util.LinkedList<>();
      java.util.Map<String, Object> beans = new java.util.HashMap<>();
      beans.put("bookList", bookList);
      org.jxls.reader.XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
      if (readStatus.isStatusOK()) {
        if (book != null && !book.selfIsNull()) {
          book.cloneThisToCollection(bookList);
        }
        bookService.batchSaveBook(bookList);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "export" }, method = { RequestMethod.GET })
  @ResponseBody
  public org.springframework.http.ResponseEntity<byte[]> export(CommonParameters commonParameters, BookSearch bookSearch) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookController.export ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookSearch is : " + bookSearch);
    }
    org.springframework.http.ResponseEntity<byte[]> response = null;
    try {
      List<PageRange<Book>> pageRangeList = new java.util.LinkedList<>();
      List<String> sheetNames = new java.util.LinkedList<>();
      if (bookSearch == null || bookSearch.selfIsNull()) {
        PageSerachParameters page = new PageSerachParameters();
        page.setPageSize(60000l);
        long pageIndex = 1;
        PageRange<Book> pageRange = null;
        do {
          page.setPageNumber(pageIndex);
          pageRange = bookService.paginationGetAllBook(page);
          pageRangeList.add(pageRange);
          sheetNames.add("第" + pageIndex + "页");
          pageIndex++;
        } while (pageRange.getPageCount() >= pageIndex);
      } else {
        PageSerachParameters page = new PageSerachParameters();
        page.setPageSize(60000l);
        long pageIndex = 1;
        PageRange<Book> pageRange = null;
        do {
          page.setPageNumber(pageIndex);
          pageRange = bookService.paginationSearchBook(bookSearch, commonParameters.getPageSerachParameters());
          pageRangeList.add(pageRange);
          sheetNames.add("第" + pageIndex + "页");
          pageIndex++;
        } while (pageRange.getPageCount() >= pageIndex);
      }
      java.io.InputStream is = this.getClass().getResourceAsStream("/template/write/Book.xls");
      org.jxls.common.Context context = new org.jxls.common.Context();
      context.putVar("pageRangeSet", pageRangeList);
      context.putVar("sheetNames", sheetNames);
      java.io.ByteArrayOutputStream os = new java.io.ByteArrayOutputStream();
      org.jxls.util.JxlsHelper.getInstance().processTemplate(is, os, context);
      org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
      byte[] by = os.toByteArray();
      headers.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM);
      headers.setContentDispositionFormData("attachment", java.net.URLEncoder.encode("图书信息.xls", "UTF-8"));
      headers.setContentLength(by.length);
      response = new org.springframework.http.ResponseEntity<byte[]>(by, headers, org.springframework.http.HttpStatus.OK);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
    }
    return response;
  }

}
