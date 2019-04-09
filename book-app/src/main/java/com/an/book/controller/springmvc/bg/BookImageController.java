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
import com.an.book.commons.FileOperateUtils;
import com.an.book.commons.PageRange;
import com.an.book.commons.PageSerachParameters;
import com.an.book.commons.ResponseRange;
import com.an.book.entity.Book;
import com.an.book.entity.BookImage;
import com.an.book.exception.BookException;
import com.an.book.pojo.search.BookImageSearch;
import com.an.book.service.IBookService;

/**
 * 该类是图书图片信息控制器。
 *
 * @author xiaojianzzz@163.com
 * @version  1.0.0-RELEASE 
 */
@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "/book/book_image" })
public class BookImageController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(BookImageController.class);

  @javax.annotation.Resource(name = "com.an.book.BookService")
  private IBookService bookService;


  @RequestMapping(value = { "single" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<BookImage> save(CommonParameters commonParameters, @RequestBody BookImage bookImage) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImageController.save ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookImage is : " + bookImage);
    }
    ResponseRange<BookImage> responseRange = new ResponseRange<>();
    try {
      if (bookImage == null || bookImage.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookImage不能为空。");
      }
      bookService.saveBookImage(bookImage);
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
  public ResponseRange<BookImage> batchSave(CommonParameters commonParameters, @RequestBody List<BookImage> bookImages) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImageController.batchSave ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookImages is : " + bookImages);
    }
    ResponseRange<BookImage> responseRange = new ResponseRange<>();
    try {
      if (bookImages == null || bookImages.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookImages不能为空。");
      }
      bookService.batchSaveBookImage(bookImages);
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
  public ResponseRange<BookImage> update(CommonParameters commonParameters, @RequestBody BookImage bookImage) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImageController.update ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookImage is : " + bookImage);
    }
    ResponseRange<BookImage> responseRange = new ResponseRange<>();
    try {
      if (bookImage == null || bookImage.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookImage不能为空。");
      }
      bookService.updateBookImage(bookImage);
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
  public ResponseRange<BookImage> batchUpdate(CommonParameters commonParameters, @RequestBody List<BookImage> bookImages) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImageController.batchUpdate ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookImages is : " + bookImages);
    }
    ResponseRange<BookImage> responseRange = new ResponseRange<>();
    try {
      if (bookImages == null || bookImages.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookImages不能为空。");
      }
      bookService.batchUpdateBookImage(bookImages);
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
  public ResponseRange<BookImage> remove(CommonParameters commonParameters, @RequestBody BookImage bookImage) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImageController.remove ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookImage is : " + bookImage);
    }
    ResponseRange<BookImage> responseRange = new ResponseRange<>();
    try {
      if (bookImage == null || bookImage.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("bookImage不能为空。");
      }
      bookService.removeBookImage(bookImage);
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
  public ResponseRange<BookImage> batchRemove(CommonParameters commonParameters, @RequestBody List<BookImage> bookImages) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImageController.batchRemove ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookImages is : " + bookImages);
    }
    ResponseRange<BookImage> responseRange = new ResponseRange<>();
    try {
      if (bookImages == null || bookImages.isEmpty()) {
        throw new java.lang.IllegalArgumentException("bookImages不能为空。");
      }
      bookService.batchRemoveBookImage(bookImages);
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
  public ResponseRange<BookImage> getByPrimaryKey(CommonParameters commonParameters, @PathVariable java.lang.String id) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImageController.getByPrimaryKey ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter id is : " + id);
    }
    ResponseRange<BookImage> responseRange = new ResponseRange<>();
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      responseRange.setData(bookService.getBookImageByPrimaryKey(id));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "book_image/{id}" }, method = { RequestMethod.GET })
  @ResponseBody
  public ResponseRange<BookImage> getByBookId(CommonParameters commonParameters, @PathVariable java.lang.String id) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookimageController.getByBookId ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter id is : " + id);
    }
    ResponseRange<BookImage> responseRange = new ResponseRange<>();
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      BookImageSearch bookimageSearch = new BookImageSearch();
      bookimageSearch.setBookId(id);
      responseRange.setData(bookService.searchBookImage(bookimageSearch));
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
  public ResponseRange<BookImage> get(CommonParameters commonParameters, BookImageSearch bookImageSearch) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImageController.get ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookImageSearch is : " + bookImageSearch);
    }
    ResponseRange<BookImage> responseRange = new ResponseRange<>();
    try {
      if (bookImageSearch == null || bookImageSearch.selfIsNull()) {
        if (commonParameters.isPageSerach()) {
          responseRange.setData(bookService.paginationGetAllBookImage(commonParameters.getPageSerachParameters()));
        } else {
          responseRange.setData(bookService.getAllBookImage());
        }
      } else {
        if (commonParameters.isPageSerach()) {
          responseRange.setData(bookService.paginationSearchBookImage(bookImageSearch, commonParameters.getPageSerachParameters()));
        } else {
          responseRange.setData(bookService.searchBookImage(bookImageSearch));
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
  public ResponseRange<BookImage> batchImport(CommonParameters commonParameters, BookImage bookImage, @RequestParam CommonsMultipartFile importFile) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImageController.batchImport ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookImage is : " + bookImage);
      log.debug("parameter importFile is : " + importFile);
    }
    ResponseRange<BookImage> responseRange = new ResponseRange<>();
    try {
      java.io.InputStream inputXML = new java.io.BufferedInputStream(getClass().getResourceAsStream("/template/read/BookImage.xml"));
      org.jxls.reader.XLSReader mainReader = org.jxls.reader.ReaderBuilder.buildFromXML(inputXML);
      java.io.InputStream inputXLS = new java.io.BufferedInputStream(importFile.getInputStream());
      java.util.List<BookImage> bookImageList = new java.util.LinkedList<>();
      java.util.Map<String, Object> beans = new java.util.HashMap<>();
      beans.put("bookImageList", bookImageList);
      org.jxls.reader.XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
      if (readStatus.isStatusOK()) {
        if (bookImage != null && !bookImage.selfIsNull()) {
          bookImage.cloneThisToCollection(bookImageList);
        }
        bookService.batchSaveBookImage(bookImageList);
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
  public org.springframework.http.ResponseEntity<byte[]> export(CommonParameters commonParameters, BookImageSearch bookImageSearch) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call BookImageController.export ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter bookImageSearch is : " + bookImageSearch);
    }
    org.springframework.http.ResponseEntity<byte[]> response = null;
    try {
      List<PageRange<BookImage>> pageRangeList = new java.util.LinkedList<>();
      List<String> sheetNames = new java.util.LinkedList<>();
      if (bookImageSearch == null || bookImageSearch.selfIsNull()) {
        PageSerachParameters page = new PageSerachParameters();
        page.setPageSize(60000l);
        long pageIndex = 1;
        PageRange<BookImage> pageRange = null;
        do {
          page.setPageNumber(pageIndex);
          pageRange = bookService.paginationGetAllBookImage(page);
          pageRangeList.add(pageRange);
          sheetNames.add("第" + pageIndex + "页");
          pageIndex++;
        } while (pageRange.getPageCount() >= pageIndex);
      } else {
        PageSerachParameters page = new PageSerachParameters();
        page.setPageSize(60000l);
        long pageIndex = 1;
        PageRange<BookImage> pageRange = null;
        do {
          page.setPageNumber(pageIndex);
          pageRange = bookService.paginationSearchBookImage(bookImageSearch, commonParameters.getPageSerachParameters());
          pageRangeList.add(pageRange);
          sheetNames.add("第" + pageIndex + "页");
          pageIndex++;
        } while (pageRange.getPageCount() >= pageIndex);
      }
      java.io.InputStream is = this.getClass().getResourceAsStream("/template/write/BookImage.xls");
      org.jxls.common.Context context = new org.jxls.common.Context();
      context.putVar("pageRangeSet", pageRangeList);
      context.putVar("sheetNames", sheetNames);
      java.io.ByteArrayOutputStream os = new java.io.ByteArrayOutputStream();
      org.jxls.util.JxlsHelper.getInstance().processTemplate(is,os, context);
      org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
      byte[] by= os.toByteArray(); 
      headers.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM);
      headers.setContentDispositionFormData("attachment",java.net.URLEncoder.encode("图书图片信息.xls", "UTF-8"));
      headers.setContentLength(by.length);
      response= new org.springframework.http.ResponseEntity<byte[]>(by, headers, org.springframework.http.HttpStatus.OK);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
    }
    return response;
  }

  @RequestMapping(value = { "upload" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<String> uploadBookImage(HttpServletRequest request, CommonParameters commonParameters, @RequestParam(value = "bookimg", required = false) CommonsMultipartFile bookimg, String bookId) {
    ResponseRange<String> responseRange = new ResponseRange<>();
    try {
      if (bookimg == null || bookimg.getSize() == 0) {
        throw new BookException("上传图书图片不能为空！");
      }
      Book book = new Book();
      book = bookService.getBookByPrimaryKey(bookId);
      String str = null;
      if (bookimg.getFileItem().getName() != null) {
        int leng = bookimg.getFileItem().getName().length();
        str = bookimg.getFileItem().getName().substring(bookimg.getFileItem().getName().lastIndexOf("."), leng);
      }
      BookImage bookImage = new BookImage();
      bookImage.setUploadIp(request.getRemoteAddr());
      bookImage = FileOperateUtils.uploadBookImage(bookimg, bookImage, book, str);
      bookImage.setBookId(bookId);
      bookService.saveBookImage(bookImage);
      responseRange.setData("上传成功！！");
    } catch (Exception e) {
      responseRange.setException(e);
    }
    return responseRange;
  }
}
