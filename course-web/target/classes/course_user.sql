drop database if exists `test_platform`;
create database `test_platform` default character  set utf8;
use test_platform;
drop table if exists `course_user`;
create table `course_user`(
                              `id` bigint(20) not null AUTO_INCREMENT,
                              `username` varchar(50) not null default '',
                              `password` varchar(64) not null default '',
                              `nick_name` varchar(50) not null default '',
                              `user_email` varchar(100) not null default '',
                              `user_phone` varchar(100) not null default '',
                              `user_activation_key` varchar(60) not null default '',
                              `user_status` int(11) not null default '0',
                              `create_time` datetime default null,
                              `update_time` datetime default null,
                              primary key (`id`)
) engine =InnoDb
  default charset = utf8;