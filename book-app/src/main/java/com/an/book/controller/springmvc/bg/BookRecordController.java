/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.an.book.controller.springmvc.bg;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.an.book.commons.CommonParameters;
import com.an.book.commons.Contants;
import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.commons.ResponseRange;
import com.an.book.entity.Book;
import com.an.book.entity.BookRecord;
import com.an.book.entity.User;
import com.an.book.exception.BookException;
import com.an.book.pojo.search.BookRecordSearch;
import com.an.book.service.IBookService;

/**
 * 该类是图书借阅记录控制器。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "/book/book_record" })
public class BookRecordController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(BookRecordController.class);

  @javax.annotation.Resource(name = "com.an.book.BookService")
  private IBookService bookService;


  @RequestMapping(value = { "single" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<BookRecord> save(CommonParameters commonParameters, @RequestBody BookRecord bookRecord, String bookId, HttpServletRequest request) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordController.save ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookRecord is : " + bookRecord);
    }
    ResponseRange<BookRecord> responseRange = new ResponseRange<>();
    try {
      if (bookRecord == null || bookRecord.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
      }
      Book book = new Book();
      book = bookService.getBookByPrimaryKey(bookId);
      if(book.getBorrow().equals(Contants.YesOrTrue)) {
        throw new BookException("此书已被管理员锁定，无法借阅！！");
      }
//      if(bookRecord.getBookNum().compareTo(bookId))
      bookRecord.setBorrowDate(System.currentTimeMillis());
      User user = new User();
      user = (User)request.getSession().getAttribute(Contants.LOGIN_PROVE_FG);
      bookRecord.setUserId(user.getId());
      bookService.saveBookRecord(bookRecord);
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
  public ResponseRange<BookRecord> batchSave(CommonParameters commonParameters, @RequestBody List<BookRecord> bookRecords) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordController.batchSave ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookRecords is : " + bookRecords);
    }
    ResponseRange<BookRecord> responseRange = new ResponseRange<>();
    try {
      if (bookRecords == null || bookRecords.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookRecords不能为空。");
      }
      bookService.batchSaveBookRecord(bookRecords);
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
  public ResponseRange<BookRecord> update(CommonParameters commonParameters, @RequestBody BookRecord bookRecord) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordController.update ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookRecord is : " + bookRecord);
    }
    ResponseRange<BookRecord> responseRange = new ResponseRange<>();
    try {
      if (bookRecord == null || bookRecord.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
      }
      bookRecord.setBackDate(System.currentTimeMillis());
      bookService.updateBookRecord(bookRecord);
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
  public ResponseRange<BookRecord> batchUpdate(CommonParameters commonParameters, @RequestBody List<BookRecord> bookRecords) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordController.batchUpdate ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookRecords is : " + bookRecords);
    }
    ResponseRange<BookRecord> responseRange = new ResponseRange<>();
    try {
      if (bookRecords == null || bookRecords.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookRecords不能为空。");
      }
      bookService.batchUpdateBookRecord(bookRecords);
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
  public ResponseRange<BookRecord> remove(CommonParameters commonParameters, @RequestBody BookRecord bookRecord) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordController.remove ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookRecord is : " + bookRecord);
    }
    ResponseRange<BookRecord> responseRange = new ResponseRange<>();
    try {
      if (bookRecord == null || bookRecord.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookRecord不能为空。");
      }
      bookService.removeBookRecord(bookRecord);
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
  public ResponseRange<BookRecord> batchRemove(CommonParameters commonParameters, @RequestBody List<BookRecord> bookRecords) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordController.batchRemove ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookRecords is : " + bookRecords);
    }
    ResponseRange<BookRecord> responseRange = new ResponseRange<>();
    try {
      if (bookRecords == null || bookRecords.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookRecords不能为空。");
      }
      bookService.batchRemoveBookRecord(bookRecords);
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
  public ResponseRange<BookRecord> getByPrimaryKey(CommonParameters commonParameters, @PathVariable java.lang.String id) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordController.getByPrimaryKey ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter id is : " + id);
    }
    ResponseRange<BookRecord> responseRange = new ResponseRange<>();
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      responseRange.setData(bookService.getBookRecordByPrimaryKey(id));
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
  public ResponseRange<BookRecord> get(CommonParameters commonParameters, BookRecordSearch bookRecordSearch) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordController.get ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookRecordSearch is : " + bookRecordSearch);
    }
    ResponseRange<BookRecord> responseRange = new ResponseRange<>();
    try {
      if (bookRecordSearch == null || bookRecordSearch.selfIsNull()) {
        if (commonParameters.isPageSerach()) {
          responseRange.setData(bookService.paginationGetAllBookRecord(commonParameters.getPageSerachParameters()));
        } else {
          responseRange.setData(bookService.getAllBookRecord());
        }
      } else {
        if (commonParameters.isPageSerach()) {
          responseRange.setData(bookService.paginationSearchBookRecord(bookRecordSearch, commonParameters.getPageSerachParameters()));
        } else {
          responseRange.setData(bookService.searchBookRecord(bookRecordSearch));
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
  public ResponseRange<BookRecord> batchImport(CommonParameters commonParameters, BookRecord bookRecord, @RequestParam CommonsMultipartFile importFile) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordController.batchImport ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookRecord is : " + bookRecord);
      log.debug("parameter importFile is : " + importFile);
    }
    ResponseRange<BookRecord> responseRange = new ResponseRange<>();
    try {
      java.io.InputStream inputXML = new java.io.BufferedInputStream(getClass().getResourceAsStream("/template/read/BookRecord.xml"));
      org.jxls.reader.XLSReader mainReader = org.jxls.reader.ReaderBuilder.buildFromXML(inputXML);
      java.io.InputStream inputXLS = new java.io.BufferedInputStream(importFile.getInputStream());
      java.util.List<BookRecord> bookRecordList = new java.util.LinkedList<>();
      java.util.Map<String, Object> beans = new java.util.HashMap<>();
      beans.put("bookRecordList", bookRecordList);
      org.jxls.reader.XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
      if (readStatus.isStatusOK()) {
        if (bookRecord != null && !bookRecord.selfIsNull()) {
          bookRecord.cloneThisToCollection(bookRecordList);
        }
        bookService.batchSaveBookRecord(bookRecordList);
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
  public org.springframework.http.ResponseEntity<byte[]> export(CommonParameters commonParameters, BookRecordSearch bookRecordSearch) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookRecordController.export ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookRecordSearch is : " + bookRecordSearch);
    }
    org.springframework.http.ResponseEntity<byte[]> response = null;
    try {
      List<PageRange<BookRecord>> pageRangeList = new java.util.LinkedList<>();
      List<String> sheetNames = new java.util.LinkedList<>();
      if (bookRecordSearch == null || bookRecordSearch.selfIsNull()) {
        PageSerachParameters page = new PageSerachParameters();
        page.setPageSize(60000l);
        long pageIndex = 1;
        PageRange<BookRecord> pageRange = null;
        do {
          page.setPageNumber(pageIndex);
          pageRange = bookService.paginationGetAllBookRecord(page);
          pageRangeList.add(pageRange);
          sheetNames.add("第" + pageIndex + "页");
          pageIndex++;
        } while (pageRange.getPageCount() >= pageIndex);
      } else {
        PageSerachParameters page = new PageSerachParameters();
        page.setPageSize(60000l);
        long pageIndex = 1;
        PageRange<BookRecord> pageRange = null;
        do {
          page.setPageNumber(pageIndex);
          pageRange = bookService.paginationSearchBookRecord(bookRecordSearch, commonParameters.getPageSerachParameters());
          pageRangeList.add(pageRange);
          sheetNames.add("第" + pageIndex + "页");
          pageIndex++;
        } while (pageRange.getPageCount() >= pageIndex);
      }
      java.io.InputStream is = this.getClass().getResourceAsStream("/template/write/BookRecord.xls");
      org.jxls.common.Context context = new org.jxls.common.Context();
      context.putVar("pageRangeSet", pageRangeList);
      context.putVar("sheetNames", sheetNames);
      java.io.ByteArrayOutputStream os = new java.io.ByteArrayOutputStream();
      org.jxls.util.JxlsHelper.getInstance().processTemplate(is,os, context);
      org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
      byte[] by= os.toByteArray(); 
      headers.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM);
      headers.setContentDispositionFormData("attachment",java.net.URLEncoder.encode("图书借阅记录.xls", "UTF-8"));
      headers.setContentLength(by.length);
      response= new org.springframework.http.ResponseEntity<byte[]>(by, headers, org.springframework.http.HttpStatus.OK);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
    }
    return response;
  }

}
