create table `nav_advert_page`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1)             default 0 not null
);
create table `nav_advert_schedule`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp    not null default current_timestamp,
    `gmt_modified` timestamp    null,
    `is_delete`    int(1)                default 0 not null,
    `url`          varchar(500) not null,
    `block_key`     varchar(255) null,
    `block_index`   varchar(20) null,
    `title`        varchar(255) null,
    `img_url`       varchar(255) null,
    `link_url`      varchar(500) null,
    `description`  varchar(500) null,
    `icon`         varchar(255) null,
    `time`         varchar(255) null
);