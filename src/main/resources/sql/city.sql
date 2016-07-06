--create database anny_test default charset utf8;
use anny_test;

/**
create table city (
	city_name varchar(20) not null,
    province_name varchar(20),
	primary key(city_name)
);
**/
insert into city values ('武汉', '湖北');
insert into city values ('宜昌', '湖北');

select * from city;
