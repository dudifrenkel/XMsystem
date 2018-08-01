CREATE DATABASE IF NOT EXISTS `xmdb`;
USE `xmdb`;

-- Table structure for table `examinee`
--
DROP TABLE IF EXISTS `examinee`;
CREATE TABLE `examinee` (
  `id` INT UNSIGNED NOT NULL UNIQUE auto_increment,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
--   `birth_date` date DEFAULT NULL,
--   `sex` ENUM('M', 'F') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Table structure for table `questions`

DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` INT UNSIGNED NOT NULL UNIQUE,
  `headline` text DEFAULT NULL,
  `answer` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- -- Table structure for table `answers`
--
-- DROP TABLE IF EXISTS `answers`;
-- CREATE TABLE `answers` (
--   `id` INT UNSIGNED NOT NULL UNIQUE ,
--   `question_id`  INT UNSIGNED NOT NULL,
--   `headline` text DEFAULT NULL,
--   `content` text DEFAULT NULL,
--   `is_correct` tinyint(1) NOT NULL default 0,
--   PRIMARY KEY (`id`,`question_id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
--
--
-- -- Table structure for table `response`
--
-- DROP TABLE IF EXISTS `response`;
-- CREATE TABLE `response` (
--   `examinee_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
--   `question_id` INT UNSIGNED NOT NULL ,
--   `headline` text DEFAULT NULL,
--   `answer_id` int(11),
--   PRIMARY KEY (`examinee_id`,`question_id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
--
-- -- Table structure for table `Questionnaire`
--
-- DROP TABLE IF EXISTS `Questionnaire`;
-- CREATE TABLE `Questionnaire` (
--   `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
--   `duration_min` int(2) NOT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
--
--
-- -- Table structure for table `question_questionnaire`
--
-- DROP TABLE IF EXISTS `question_questionnaire`;
-- CREATE TABLE `question_questionnaire` (
--   `question_id` INT UNSIGNED NOT NULL,
--   `questionnaire_id` INT UNSIGNED NOT NULL,
--   PRIMARY KEY (`question_id`,`questionnaire_id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
--
-- -- Table structure for table `questionnaire_test`
--
-- DROP TABLE IF EXISTS `questionnaire_test`;
-- CREATE TABLE `questionnaire_test` (
--   `test_id` INT UNSIGNED NOT NULL,
--   `questionnaire_id` INT UNSIGNED NOT NULL,
--   PRIMARY KEY (`test_id`,`questionnaire_id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
--
--
-- -- Table structure for table `test`
--
-- DROP TABLE IF EXISTS `test`;
-- CREATE TABLE `test` (
--   `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
