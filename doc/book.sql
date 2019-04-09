-- create by yuzhongjian<xiaojianzzz1521@163.com> at 2019/03/12 20:22
-- name   : Book
-- author : yuzhongjian<xiaojianzzz1521@163.com>
-- desc   : 图书租赁系统
CREATE DATABASE book DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use book;

/*==============================================================*/
  --  用户      BOOK_USER   --
/*==============================================================*/
drop table if exists BOOK_USER;
create table BOOK_USER(

  ID                                char(36)                      character set utf8 collate utf8_bin     not null comment '账号ID',
  USERNAME                          varchar(32)                   character set utf8 collate utf8_bin     not null comment '用户名',
  PASSWORD                          char(32)                      character set utf8 collate utf8_bin     not null comment '密码',
  HAVE_AUTHORITY                    char(1)                       character set utf8 collate utf8_bin     not null comment '是否为管理员',
  CREATE_DATE                       bigint                                                                not null comment '创建时间',
primary key(ID)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '用户';
/*==============================================================*/
  --  图书信息      BOOK_BOOK   --
/*==============================================================*/
drop table if exists BOOK_BOOK;
create table BOOK_BOOK(

  ID                                char(36)                      character set utf8 collate utf8_bin    not null comment '图书ID',
  BOOK_IDENTIFIER                   varchar(128)                  character set utf8 collate utf8_bin    not null comment '图书编号',
  BOOK_NAME                         varchar(128)                  character set utf8 collate utf8_bin    not null comment '图书名',
  BOOK_NUM                          varchar(128)                  character set utf8 collate utf8_bin    not null comment '图书数量',
  BOOK_DESC                         text                          character set utf8 collate utf8_bin    not null comment '图书简介',
  BORROW                            char(1)                       character set utf8 collate utf8_bin    not null comment '是否允许借出',
  USER_ID                           char(36)                      character set utf8 collate utf8_bin    not null comment '所属用户ID',

primary key(ID) 
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '图书信息';
alter table BOOK_BOOK add constraint FK_BOOK_BOOK_USER_ID foreign key (USER_ID) references BOOK_USER(ID);
/*==============================================================*/
  --  图书图片      BOOK_BOOK_IMAGE   --
/*==============================================================*/
drop table if exists BOOK_BOOK_IMAGE;
create table BOOK_BOOK_IMAGE(

  ID                                char(36)                      character set utf8 collate utf8_bin    not null comment '图书图片ID',
  BOOK_NAME                         varchar(128)                  character set utf8 collate utf8_bin    not null comment '图书名',
  BOOK_REAL_NAME                    varchar(128)                  character set utf8 collate utf8_bin    not null comment '存储的真实图书名称',
  BOOK_PATH                         varchar(255)                  character set utf8 collate utf8_bin    not null comment '图片在服务器中的真实路径',
  UPLOAD_TIME                       bigint                                                               not null comment '图片上传时间',
  UPLOAD_IP                         varchar(16)                   character set utf8 collate utf8_bin    not null comment '图片上传的IP地址',
  BOOK_ID                           char(36)                      character set utf8 collate utf8_bin    not null comment '所属图书ID',

primary key(ID) 
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '图书图片信息';
alter table BOOK_BOOK_IMAGE add constraint FK_BOOK_BOOK_IMAGE_BOOK_ID foreign key (BOOK_ID) references BOOK_BOOK(ID);
/*==============================================================*/
  --  图书借阅记录      BOOK_BOOK_RECORD   --
/*==============================================================*/
drop table if exists BOOK_BOOK_RECORD;
create table BOOK_BOOK_RECORD(

  ID                                char(36)                      character set utf8 collate utf8_bin    not null comment '图书借阅记录ID',
  BOOK_NAME                         varchar(128)                  character set utf8 collate utf8_bin    not null comment '借阅图书名',
  BOOK_NUM                          varchar(128)                  character set utf8 collate utf8_bin    not null comment '借阅图书数量',
  BORROW_DATE                       bigint                                                               not null comment '图书借出时间',
  BACK_DATE                         bigint                                                                   null comment '图书归还时间',
  USER_ID                           char(36)                      character set utf8 collate utf8_bin    not null comment '所属用户ID',

primary key(ID) 
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '图书借阅记录';
alter table BOOK_BOOK_RECORD add constraint FK_BOOK_BOOK_RECORD_USER_ID foreign key (USER_ID) references BOOK_USER(ID);