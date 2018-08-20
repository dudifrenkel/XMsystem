--
-- Dumping data for table `examinee`
--
USE `xmdb`;

# LOCK TABLES `examinee` WRITE;
# /*!40000 ALTER TABLE `examinee` DISABLE KEYS */;

INSERT INTO `examinee` (`id`, `birth_date`, `first_name`, `last_name`, `sex`, `curr_tester_id`) VALUES
	('305111222', '11/01/2000', 'Ron', 'Levi', 'M', '999'),
	('305222333', '12/02/2010', 'Eli', 'Cohen', 'M', '999'),
	('305333444', '13/01/2010', 'Rinat', 'Levi', 'F', '999'),
	('305444555', '14/01/2000', 'Adi', 'Bar', 'M', '999');

INSERT INTO `xmdb`.`question` (`id`, `body`) VALUES
	('1', 'מה צבע השמיים?'),
	('2', 'מי היה ראש הממשלה הראשון של ישראל?'),
	('3', '1+1= ?');

INSERT INTO `xmdb`.`answer` (`id`, `content`, `is_true`, `question_id`) VALUES
	('1', 'כחול', True, '1'),
	('2', 'ירוק', FALSE, '1'),
	('3', 'אדום', FALSE, '1'),
	('4', 'ורוד', FALSE, '1'),

	('5', 'דוד בן-גוריון', True, '2'),
	('6', 'משה פרץ', FALSE, '2'),
	('7', 'שימעון פרס', FALSE, '2'),
	('8', 'רני רהב', FALSE, '2'),

	('9', '2', True, '3'),
	('10', '1', FALSE, '3'),
	('11', '3', FALSE, '3'),
	('12', '4', FALSE, '3');

INSERT INTO `xmdb`.`tester` (`id`) VALUES
	('999');

INSERT INTO `xmdb`.`test` (`id`, `description`) VALUES ('1', 'מבחן לדוגמה');

INSERT INTO `xmdb`.`questionnaire` (`id`, `duration_min`) VALUES ('1', '30');
