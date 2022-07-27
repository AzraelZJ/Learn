drop table if exists mms_growth_change_history;

drop table if exists mms_integration_change_history;

drop table if exists mms_member;

drop table if exists mms_member_collect_spu;

drop table if exists mms_member_collect_subject;

drop table if exists mms_member_level;

drop table if exists mms_member_login_log;

drop table if exists mms_member_receive_address;

drop table if exists mms_member_statistics_info;

/*==============================================================*/
/* Table: mms_growth_change_history                             */
/*==============================================================*/
create table mms_growth_change_history
(
   id                   bigint not null auto_increment comment 'id',
   member_id            bigint comment 'member_id',
   create_time          datetime comment '创建时间',
   change_count         int comment '改变的值（正负计数）',
   note                 varchar(0) comment '备注',
   source_type          tinyint comment '积分来源：[0: 购物; 1: 管理员修改]',
   creator              bigint comment '记录创建者',
   create_date          date comment '记录创建时间',
   update_date          date comment '记录修改时间',
   primary key (id)
);

alter table mms_growth_change_history comment '成长值变化历史记录';

/*==============================================================*/
/* Table: mms_integration_change_history                        */
/*==============================================================*/
create table mms_integration_change_history
(
   id                   bigint not null auto_increment comment 'id',
   member_id            bigint comment 'member_id',
   create_time          datetime comment '创建时间',
   change_count         int comment '变化的值',
   note                 varchar(255) comment '备注',
   source_type          tinyint comment '来源：[0: 购物; 1: 管理员修改; 2: 活动]',
   creator              bigint comment '记录创建者',
   create_date          date comment '记录创建时间',
   update_date          date comment '记录修改时间',
   primary key (id)
);

alter table mms_integration_change_history comment '积分变化历史记录';

/*==============================================================*/
/* Table: mms_member                                            */
/*==============================================================*/
create table mms_member
(
   id                   bigint not null auto_increment comment 'id',
   level_id             bigint comment '会员等级id',
   username             char(64) comment '用户名',
   password             varchar(64) comment '密码',
   nickname             varchar(64) comment '昵称',
   mobile               varchar(20) comment '手机号码',
   email                varchar(64) comment '邮箱',
   header               varchar(500) comment '头像',
   gender               tinyint comment '性别',
   birth                date comment '生日',
   city                 varchar(500) comment '所在城市',
   job                  varchar(255) comment '职业',
   sign                 varchar(255) comment '个性签名',
   source_type          tinyint comment '用户来源',
   integration          int comment '积分',
   growth               int comment '成长值',
   status               tinyint comment '启用状态',
   create_time          datetime comment '注册时间',
   creator              bigint comment '记录创建者',
   create_date          date comment '记录创建时间',
   update_date          date comment '记录修改时间',
   primary key (id)
);

alter table mms_member comment '会员';

/*==============================================================*/
/* Table: mms_member_collect_spu                                */
/*==============================================================*/
create table mms_member_collect_spu
(
   id                   bigint not null comment 'id',
   member_id            bigint comment '会员id',
   spu_id               bigint comment 'spu_id',
   spu_name             varchar(500) comment 'spu名字',
   spu_img              varchar(500) comment 'spu图片',
   create_time          datetime comment '创建时间',
   creator              bigint comment '记录创建者',
   create_date          date comment '记录创建时间',
   update_date          date comment '记录修改时间',
   primary key (id)
);

alter table mms_member_collect_spu comment '会员收藏的商品';

/*==============================================================*/
/* Table: mms_member_collect_subject                            */
/*==============================================================*/
create table mms_member_collect_subject
(
   id                   bigint not null auto_increment comment 'id',
   subject_id           bigint comment 'subject_id',
   subject_name         varchar(255) comment 'subject名字',
   subject_img          varchar(500) comment 'subject图片',
   subject_url         varchar(500) comment '活动url',
   creator              bigint comment '记录创建者',
   create_date          date comment '记录创建时间',
   update_date          date comment '记录修改时间',
   primary key (id)
);

alter table mms_member_collect_subject comment '会员收藏的专题活动';

/*==============================================================*/
/* Table: mms_member_level                                      */
/*==============================================================*/
create table mms_member_level
(
   id                   bigint not null auto_increment comment 'id',
   name                 varchar(100) comment '等级名称',
   growth_point         int comment '等级需要的成长值',
   default_status       tinyint comment '是否为默认等级：[0: 不是; 1:  是]',
   free_freight_point   decimal(18,4) comment '免运费标准',
   comment_growth_point int comment '每次评价获取的成长值',
   privilege_free_freight tinyint comment '是否有免邮特权',
   privilege_member_price tinyint comment '是否有会员价格特权',
   privilege_birthday  tinyint comment '是否有生日特权',
   note                 varchar(255) comment '备注',
   creator              bigint comment '记录创建者',
   create_date          date comment '记录创建时间',
   update_date          date comment '记录修改时间',
   primary key (id)
);

alter table mms_member_level comment '会员等级';

/*==============================================================*/
/* Table: mms_member_login_log                                  */
/*==============================================================*/
create table mms_member_login_log
(
   id                   bigint not null auto_increment comment 'id',
   member_id            bigint comment '会员id',
   create_time          datetime comment '创建时间',
   ip                   varchar(64) comment 'ip地址',
   city                 varchar(64) comment '城市',
   login_type           tinyint(1) comment '登录类型：[1: web; 2: App]',
   creator              bigint comment '记录创建者',
   create_date          date comment '记录创建时间',
   update_date          date comment '记录修改时间',
   primary key (id)
);

alter table mms_member_login_log comment '会员登录记录';

/*==============================================================*/
/* Table: mms_member_receive_address                            */
/*==============================================================*/
create table mms_member_receive_address
(
   id                   bigint not null auto_increment comment 'id',
   member_id            bigint comment '会员id',
   name                 varchar(255) comment '收货人姓名',
   phone                varchar(64) comment '电话',
   post_code            varchar(64) comment '邮政编码',
   province             varchar(100) comment '省份/直辖市',
   city                 varchar(100) comment '城市',
   region               varchar(100) comment '区',
   detail_address       varchar(255) comment '详细地址（街道）',
   areacode             varchar(15) comment '省市区代码',
   default_status       tinyint(1) comment '是否默认',
   creator              bigint comment '记录创建者',
   create_date          date comment '记录创建时间',
   update_date          date comment '记录修改时间',
   primary key (id)
);

alter table mms_member_receive_address comment '会员收货地址';

/*==============================================================*/
/* Table: mms_member_statistics_info                            */
/*==============================================================*/
create table mms_member_statistics_info
(
   id                   bigint not null auto_increment comment 'id',
   member_id            bigint comment '会员id',
   consume_amount       decimal(18,4) comment '累计消费金额',
   coupon_amount        decimal(18,4) comment '累计优惠金额',
   order_count          int comment '订单数量',
   coupon_count         int comment '优惠券数量',
   comment_count        int comment '评价数',
   return_order_count   int comment '退货数量',
   login_count          int comment '登录次数',
   attend_count         int comment '关注数量',
   fans_count           int comment '粉丝数量',
   collect_product_count int comment '收藏的商品数量',
   collect_subject_count int comment '收藏的专题活动数量',
   collect_comment_count int comment '收藏的评论数量',
   invite_friend_count  int comment '邀请的朋友数量',
   creator              bigint comment '记录创建者',
   create_date          date comment '记录创建时间',
   update_date          date comment '记录修改时间',
   primary key (id)
);

alter table mms_member_statistics_info comment '会员统计信息';
