create table `nav_spider_site`
(
    `id`               int(11) primary key auto_increment,
    `gmt_create`       timestamp   not null default current_timestamp,
    `gmt_modified`     timestamp   null,
    `is_delete`        int(1)             default 0 not null,
    `domain`           varchar(500)        not null,
    `title`            varchar(500)        null,
    `count`            int      default 0,
    `status`           varchar(500)            null
);
create table `nav_spider_page`
(
    `id`               int(11) primary key auto_increment,
    `gmt_create`       timestamp   not null default current_timestamp,
    `gmt_modified`     timestamp   null,
    `is_delete`        int(1)             default 0 not null,
    `site_id`          int                not null,
    `url`              varchar(500)        not null,
    `title`            varchar(500)        null,
    `keywords`         varchar(500)        null,
    `description`      varchar(500)        null,
    `status`           varchar(500)            null
);
create table `nav_spider_link`
(
    `id`               int(11) primary key auto_increment,
    `gmt_create`       timestamp   not null default current_timestamp,
    `gmt_modified`     timestamp   null,
    `is_delete`        int(1)             default 0 not null,
    `name`             varchar(500)        null,
    `from_site_id`     int                not null,
    `to_site_id`       int                not null,
    `from_site_url`    varchar(500)        null,
    `to_site_url`      varchar(500)        null
);
create table `nav_task_item`
(
    `id`               int(11) primary key auto_increment,
    `gmt_create`       timestamp   not null default current_timestamp,
    `gmt_modified`     timestamp   null,
    `is_delete`        int(1)   default 0 not null,
    `param`            varchar(800) not null,
    `type`             varchar(500) not null,
    `item_group`       int(1)   default 0 not null,
    `status`           varchar(500) not null,
    `item_from`        varchar(500) not null
);