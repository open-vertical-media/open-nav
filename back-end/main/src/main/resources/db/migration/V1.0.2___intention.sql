create table `nav_intention_partner`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null,
    `name`         varchar(25) not null,
    `telephone`         varchar(25) not null,
    `quota`        int(8) default 0
);
create table `nav_intention_plant`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null,
    `path`         varchar(50) not null,
    `partner_id`   int(11) not null,
    `sort_index`   float(5, 2
)
    );
create table `nav_intention_quota`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null,
    `type`         varchar(10) not null,
    `number`       int(11) not null,
    `partner_id`   int(11) not null
);
create table `nav_intention_record`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp    not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null,
    `path`         varchar(100)  not null,
    `name`         varchar(11)  not null,
    `telephone`    varchar(18)  not null,
    `message`      varchar(200) not null,
    `status`       varchar(200) not null,
    `partner_id`   int(11) null
);
create table `nav_intention_request`
(
    `id`            int(11) primary key auto_increment,
    `gmt_create`    timestamp   not null default current_timestamp,
    `gmt_modified`  timestamp null,
    `is_delete`     int(1) default 0 not null,
    `partner_id`    int(11) not null,
    `relation_type` varchar(10) not null,
    `relation_id`   int(11) not null
);
