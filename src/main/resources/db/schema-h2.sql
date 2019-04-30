DROP TABLE IF EXISTS user;

create table `user`(
  `id`         bigint not null comment '主键ID',
  `username`  varchar(100) NULL DEFAULT NULL COMMENT '姓名',
  `email`  varchar(100) NULL DEFAULT NULL COMMENT '邮箱',
  `mobile_phone_number`  varchar(20),
  `password`  varchar(100),
  `salt`       varchar(10),
  `create_date` timestamp default 0,
  `status`    varchar(50),
  `deleted`   bool,
  `admin`     bool,
  PRIMARY KEY (`id`)
);