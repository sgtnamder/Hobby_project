drop table if exists race CASCADE;
drop table if exists driver CASCADE;

create table race
(
	`id` integer AUTO_INCREMENT PRIMARY KEY,
	`name` varchar(255),
	`date` varchar(255),
	`time` varchar(255)
);

create table driver
(
	`id`integer AUTO_INCREMENT PRIMARY KEY,
    `name`varchar(255),
    `team_name`varchar(255) ,
    `points`integer ,
    `driver_num`integer,
    `time`varchar(255) ,
    `position`integer ,
    `race_id`integer       
    );