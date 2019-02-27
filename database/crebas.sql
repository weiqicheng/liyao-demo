/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/2/22 16:11:58                           */
/*==============================================================*/


drop table if exists sys_dict;

drop table if exists sys_menu;

drop table if exists sys_role;

drop table if exists sys_role_menu;

drop table if exists sys_user;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: sys_dict                                              */
/*==============================================================*/
create table sys_dict
(
   id                   int not null comment '主键',
   name                 varchar(100) comment '字典名称',
   type_code            varchar(100) comment '字典类型编码',
   pid                  int comment '字典父级id',
   "order"              int comment '排序',
   is_delete            char(1) comment '是否删除',
   is_available         char(1) comment '是否可用',
   create_by            varchar(30) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(30) comment '更新人',
   update_date          datetime comment '更新时间',
   primary key (id)
);

alter table sys_dict comment '字典表';

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   id                   int not null comment '主键',
   name                 varchar(30) comment '菜单名称',
   url                  varchar(200) comment '菜单url',
   type                 char(1) comment '菜单类型：应用、菜单、模块',
   pid                  int comment '父级菜单id',
   "order"              int comment '排序',
   is_available         char(1) comment '是否可用',
   create_by            varchar(30) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(30) comment '更新人',
   update_date          datetime comment '更新时间',
   is_delete            char(1) comment '是否删除',
   primary key (id)
);

alter table sys_menu comment '菜单表';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   int not null comment '主键',
   name                 varchar(30) comment '角色名称',
   is_available         char(1) comment '是否可用',
   "describe"           varchar(200) comment '角色描述',
   create_by            varchar(30) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(30) comment '更新人',
   update_date          datetime comment '更新时间',
   is_delete            char(1) comment '是否删除',
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu
(
   id                   int not null comment '主键',
   role_id              int comment '角色id',
   menu_id              int comment '菜单id',
   is_delete            char(1) comment '是否删除',
   create_by            varchar(30) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(30) comment '更新人',
   update_date          datetime comment '更新时间',
   primary key (id)
);

alter table sys_role_menu comment '角色菜单分配表';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   int not null comment '主键',
   true_name            varchar(30) comment '用户真实姓名',
   phone                int comment '手机号',
   login_name           varchar(30) comment '登录用户名',
   email                varchar(30) comment '邮箱',
   password             varchar(50) comment '密码',
   is_available         char(1) comment '是否可用',
   is_delete            char(1) comment '是否删除',
   create_by            varchar(30) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(30) comment '更新人',
   update_date          datetime comment '更新时间',
   primary key (id)
);

alter table sys_user comment '用户表';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   id                   int not null comment '主键',
   user_id              int comment '用户id',
   role_id              int comment '角色id',
   is_default           char(1) comment '是否是默认的角色',
   is_available         char(1) comment '是否可用',
   is_delete            char(1) comment '是否删除',
   create_by            varchar(30) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(30) comment '更新人',
   update_date          datetime comment '更新时间',
   primary key (id)
);

alter table sys_user_role comment '用户角色表';

