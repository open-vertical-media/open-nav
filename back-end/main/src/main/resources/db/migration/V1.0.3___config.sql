create table `nav_config_property`
(
    `id`               int(11) primary key auto_increment,
    `gmt_create`       timestamp   not null default current_timestamp,
    `gmt_modified`     timestamp   null,
    `is_delete`        int(1)               default 0 not null,
    `property_key`     varchar(25) not null,
    `property_value`   json        not null,
    `property_version` varchar(25)          default 0
);