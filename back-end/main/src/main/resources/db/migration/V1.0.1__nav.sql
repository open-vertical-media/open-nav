create table `nav_aggregation_category`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null
);
create table `nav_aggregation_feed`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null
);
create table `nav_aggregation_tag`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null
);
create table `nav_item_article`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null,
    `medium`       json,
    `content`      json,
    `seo`          json
);
create table `nav_item_link`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null
);
create table `nav_item_site`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null
);
create table `nav_page_cms`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null
);
create table `nav_page_component`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null,
    `name`         varchar(20) not null,
    `slotNames`    json
);
create table `nav_page_template`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null,
    `seo`         varchar(20) not null,
    `items`    json
);