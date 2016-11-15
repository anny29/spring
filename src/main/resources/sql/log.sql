create table log (
	log_id INT NOT NULL AUTO_INCREMENT,
    info varchar(500) NOT NULL,
    sttm date,
	primary key(log_id)
);

select * from log;

insert into log (info, sttm) values (null, '2016-11-14 16:32:30');