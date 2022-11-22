create table if not exists samples (
  `id` bigint unsigned not null auto_increment comment 'ID',
  `content` varchar(256) not null comment '内容',
  `created_at` datetime not null default current_timestamp comment '作成日時',
  `updated_at` datetime not null default current_timestamp on update current_timestamp comment '更新日時',
  primary key (`id`)
) comment 'サンプルテーブル';