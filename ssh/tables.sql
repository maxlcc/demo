CREATE TABLE `person` (
  `id` int(11) not null auto_increment,
  `address` varchar(255) DEFAULT NULL,
  `idCard` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 create table `student`(
    `id` int(11) not null auto_increment,
    `stu_name` varchar(16) not null,
    `age` int(11) default null,
    `gender` int (11) default null,
    `address` varchar(128) default null,
    primary key(`id`)
)
    