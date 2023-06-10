create table `nav_auth_account`
(
    `id`           int(11) primary key auto_increment,
    `gmt_create`   timestamp   not null default current_timestamp,
    `gmt_modified` timestamp null,
    `is_delete`    int(1) default 0 not null,
    `name`         varchar(25) not null,
    `password`     varchar(25) not null,
    `powers`       json
);