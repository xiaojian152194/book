package com.an.book.commons;

/**
 * 工具类(图书图片上传工具类)
 * 
 * @author yuzhongjian
 * @version : 0.0.1
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.an.book.entity.Book;
import com.an.book.entity.BookImage;

public class FileOperateUtils {

  // public static Music uploadMusic(CommonsMultipartFile music) throws
  // IOException {
  // Music music1 = new Music();
  //
  // if (music.getSize() >= 1024) {
  // music1.setMusicSize(String.valueOf(music.getSize() / 1024) + "KB");
  // }
  // if (music.getSize() >= 1024 * 1024) {
  // music1.setMusicSize(String.valueOf(music.getSize() / (1024 * 1024)) + "MB");
  // }
  // if (music.getSize() >= 1024 * 1024 * 1024) {
  // music1.setMusicSize(String.valueOf(music.getSize() / (1024 * 1024 * 1024)) +
  // "GB");
  // }
  //
  // InputStream is = music.getInputStream();// 获取文件输入流
  // OutputStream os = null;
  // try {
  // // 获取文件名称
  // String musicName = music.getOriginalFilename();
  // music1.setMusicName(musicName);
  // // 写入本地磁盘
  // byte[] bs = new byte[1024]; // 创建文件缓冲区
  // int len; // 每次读取的字节数
  // final String path = System.getProperty("user.home") + "/music-data/files"; //
  // 创建服务器存储目录
  // SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); // 日期格式
  // File musicPath = new File(path, format.format(new Date())); // 以日期为名创建目录
  // music1.setMusicPath(musicPath.getPath());
  // if (!musicPath.exists()) { // 如果目录不存在 则创建
  // musicPath.mkdirs();
  // }
  // String musicRealName = new Date().getTime() + "_" + musicName; //
  // 创建文件在服务器中的实际名称
  // music1.setUploadTime(new Date().getTime());
  // music1.setMusicRealName(musicRealName);
  // File newMusic = new File(musicPath, musicRealName);
  // if (newMusic.exists()) {
  // newMusic.delete();
  // }
  // newMusic.createNewFile();
  // os = new FileOutputStream(newMusic); // 创建刚产生的文件的输出流
  //
  // while ((len = is.read(bs)) != -1) {
  // os.write(bs, 0, len);
  // }
  //
  // } catch (MusicException e) {
  //
  // } catch (Exception e) {
  //
  // } finally {
  // is.close(); // 关闭输入流
  // os.close(); // 关闭输出流
  // }
  // return music1;
  // }

  public static BookImage uploadBookImage(CommonsMultipartFile bookimg, BookImage bookimage, Book book, String str) throws IOException {
    InputStream is = bookimg.getInputStream();// 获取文件输入流
    OutputStream os = null;
    try {
      // 获取文件名称
      String bookName = book.getBookName();
      bookimage.setBookName(bookName + str);
      // 写入本地磁盘
      byte[] bs = new byte[1024]; // 创建文件缓冲区
      int len; // 每次读取的字节数
      final String path = System.getProperty("user.home") + "/bookimg"; // 创建服务器存储目录
//      SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); // 日期格式
      File bookPath = new File(path); // 以日期为名创建目录
      bookimage.setBookPath(bookPath.getPath());
      if (!bookPath.exists()) { // 如果目录不存在 则创建
        bookPath.mkdirs();
      }
      String bookimageRealName = new Date().getTime() + "_" + bookName + str; // 创建文件在服务器中的实际名称
      bookimage.setUploadTime(new Date().getTime());
      bookimage.setBookRealName(bookimageRealName);
      File newBookimg = new File(bookPath, bookimageRealName);
      if (newBookimg.exists()) {
        newBookimg.delete();
      }
      newBookimg.createNewFile();
      os = new FileOutputStream(newBookimg); // 创建刚产生的文件的输出流
      while ((len = is.read(bs)) != -1) {
        os.write(bs, 0, len);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      is.close(); // 关闭输入流
      os.close(); // 关闭输出流
    }
    return bookimage;
  }
}
