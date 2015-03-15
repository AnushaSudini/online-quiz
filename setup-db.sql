
use `troika_dba`;


#
# Drop any old tables
#

DROP TABLE IF EXISTS `users_roles`, `roles`, `users`;


#
# Create the tables
#

CREATE TABLE `users` (
    `user_name` VARCHAR(20) NOT NULL PRIMARY KEY,
    `password` VARCHAR(30) NOT NULL
);

CREATE TABLE `roles` (
    `role_name` VARCHAR(20) NOT NULL PRIMARY KEY
);

CREATE TABLE `users_roles` (
    `user_name` VARCHAR(20) NOT NULL,
    `role_name` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`user_name` , `role_name`),
    FOREIGN KEY (`user_name`)
        REFERENCES `users` (`user_name`),
    FOREIGN KEY (`role_name`)
        REFERENCES `roles` (`role_name`)
);


#
# Insert test data in the tables
#

# The Roles (Quizemon Trainer and Quiz Master)

INSERT INTO `roles` (`role_name`) VALUES ('trainer');
INSERT INTO `roles` (`role_name`) VALUES ('master');

# The Quizemon Trainers

INSERT INTO `users` (`user_name`, `password`) VALUES ('rray', 'yay1SOFT!');
INSERT INTO `users_roles` (`user_name`, `role_name`) VALUES ('rray', 'trainer');

INSERT INTO `users` (`user_name`, `password`) VALUES ('sshankar', 'yay1SOFT!');
INSERT INTO `users_roles` (`user_name`, `role_name`) VALUES ('sshankar', 'trainer');

INSERT INTO `users` (`user_name`, `password`) VALUES ('ttrey', 'yay1SOFT!');
INSERT INTO `users_roles` (`user_name`, `role_name`) VALUES ('ttrey', 'trainer');

INSERT INTO `users` (`user_name`, `password`) VALUES ('uupton', 'yay1SOFT!');
INSERT INTO `users_roles` (`user_name`, `role_name`) VALUES ('uupton', 'trainer');

# The Quiz Masters

INSERT INTO `users` (`user_name`, `password`) VALUES ('aallen', 'yay1SOFT!');
INSERT INTO `users_roles` (`user_name`, `role_name`) VALUES ('aallen', 'master');

INSERT INTO `users` (`user_name`, `password`) VALUES ('bbess', 'yay1SOFT!');
INSERT INTO `users_roles` (`user_name`, `role_name`) VALUES ('bbess', 'master');


#
# Dump the contents of each table
#

SELECT 
    *
FROM
    `users`;

SELECT 
    *
FROM
    `roles`;

SELECT 
    *
FROM
    `users_roles`;
    
    
#trade db
CREATE TABLE `trade` (
`trade_id` INT( 11 ) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`user_name` VARCHAR(20) NOT NULL,
FOREIGN KEY (`user_name`)
        REFERENCES `users` (`user_name`)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `propose` (
`propose_id` INT( 11 ) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`user_name` VARCHAR(20) NOT NULL,
`trade_id` INT( 11 ) NOT NULL,
FOREIGN KEY (`user_name`)
        REFERENCES `users` (`user_name`)
        ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`trade_id`)
        REFERENCES `trade` (`trade_id`)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `trade_info` (
`trade_id` INT( 11 ) NOT NULL,
`quizemon_name` VARCHAR( 20 ) NOT NULL,
PRIMARY KEY (`trade_id`,`quizemon_name`),
FOREIGN KEY (`trade_id`)
        REFERENCES `trade` (`trade_id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`quizemon_name`)
	    REFERENCES `quizemon` (`name`)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `propose_info` (
`propose_id` INT( 11 ) NOT NULL,
`quizemon_name` VARCHAR( 20 ) NOT NULL,
FOREIGN KEY (`propose_id`)
        REFERENCES `propose` (`propose_id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`quizemon_name`)
	    REFERENCES `quizemon` (`name`)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `user_coin` (
`user_name` VARCHAR(20) NOT NULL,
`coin` INT( 11 ) NOT NULL,
FOREIGN KEY (`user_name`)
	REFERENCES `users` (`user_name`)
	        ON DELETE CASCADE ON UPDATE CASCADE
); 

CREATE TABLE `user_quizemon` (
`user_name` VARCHAR(20) NOT NULL,
`quizemon` VARCHAR( 20 ) NOT NULL,
FOREIGN KEY (`user_name`)
	REFERENCES `users` (`user_name`)
	        ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`quizemon`)
	REFERENCES `quizemon` (`name`)
	        ON DELETE CASCADE ON UPDATE CASCADE
); 

INSERT INTO `trade` (`trade_id`, `user_name`) VALUES ('10','rray');
INSERT INTO `propose` (`user_name`, `trade_id`) VALUES ('sshankar','10');
DELETE FROM `users` where user_name = 'rray';
DELETE FROM `users` where user_name = 'sshankar';
select * from trade;
select * from propose;


# test data for trade and propose part
DELETE FROM `user_quizemon`;
DELETE FROM `propose`;
DELETE FROM `trade`;

INSERT INTO `user_quizemon` VALUES ("rray", "Tails");
INSERT INTO `user_quizemon` VALUES ("rray", "Donnie");
INSERT INTO `user_quizemon` VALUES ("rray", "Leo");
INSERT INTO `user_quizemon` VALUES ("uupton", "Mikey");
INSERT INTO `user_quizemon` VALUES ("uupton", "Battle Cat");
INSERT INTO `user_quizemon` VALUES ("uupton", "Battle Cat");


INSERT INTO `trade` (`trade_id`, `user_name`) VALUES ("10", "rray");
INSERT INTO `trade` (`trade_id`, `user_name`) VALUES ("11", "rray");

INSERT INTO `trade_info` (`trade_id`, `quizemon_name`) VALUES ("10", "Tails");
INSERT INTO `trade_info` (`trade_id`, `quizemon_name`) VALUES ("11", "Donnie");
INSERT INTO `trade_info` (`trade_id`, `quizemon_name`) VALUES ("11", "Leo");

INSERT INTO `propose` VALUES ("1", "uupton", "10");
INSERT INTO `propose` VALUES ("2", "uupton", "11");

INSERT INTO `propose_info` (`propose_id`, `quizemon_name`) VALUES("1", "Battle Cat");
INSERT INTO `propose_info` (`propose_id`, `quizemon_name`) VALUES("2", "Mikey");
INSERT INTO `propose_info` (`propose_id`, `quizemon_name`) VALUES("2", "Battle Cat");
