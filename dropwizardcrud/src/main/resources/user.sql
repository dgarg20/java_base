CREATE TABLE user(
`id` bigint primary key not null auto_increment,
`name` VARCHAR(255) NOT NULL,
`e_mail` varchar(255) NOT NULL ,
`phone_number` varchar(13) NOT NULL ,
`sex` varchar (10) NOT NULL,
`age` number(2) NOT NULL,
`created_at` DATE NOT NULL,
`updated_at` Date NOT NULL
)ENGINE=InnoDB AUTO_INCREMENT=3381 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;