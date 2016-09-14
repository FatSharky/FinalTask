-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: db_hr_system
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education` (
  `id_education` int(11) NOT NULL AUTO_INCREMENT,
  `institution` varchar(45) NOT NULL,
  `faculty` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  `education` enum('not specified','university incomplete','higher','master','PhD','secondary','technical school','PhD candidate') NOT NULL,
  `course` smallint(1) DEFAULT NULL,
  `grad_year` smallint(4) NOT NULL,
  `postgraduate` enum('not assigned','assigned','to be assigned') NOT NULL,
  `id_resume` int(11) NOT NULL,
  PRIMARY KEY (`id_education`),
  KEY `resume_education_idx` (`id_resume`),
  CONSTRAINT `resume_education` FOREIGN KEY (`id_resume`) REFERENCES `resume` (`id_resume`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (1,'БНТУ','ФИТР','ПОИТ','university incomplete',5,2016,'not assigned',4),(2,'БГЭУ','ИСИТ','СИТР','university incomplete',2,2019,'not assigned',4),(3,'БНТУ','ФИТР','ПОИТ','PhD',0,2016,'not assigned',14),(5,'BRUI','dsadsa','sad','not specified',0,2038,'not assigned',19),(6,'BRUI','dsadsa','sad','not specified',0,2038,'not assigned',11),(7,'BNTU','FITR','POIT','master',0,2016,'assigned',20),(8,'BNTU','а','а','not specified',0,2016,'not assigned',11),(12,'БНТУ','ФИТР','ПОВТ','PhD',0,2016,'not assigned',28),(13,'dsa','asd','sda','not specified',0,2014,'not assigned',11);
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview`
--

DROP TABLE IF EXISTS `interview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interview` (
  `id_interview` int(11) NOT NULL AUTO_INCREMENT,
  `type` enum('techical','preliminary') NOT NULL,
  `date_begin` datetime NOT NULL,
  `pass` enum('pass','not pass') DEFAULT NULL,
  `id_verify` int(11) NOT NULL,
  PRIMARY KEY (`id_interview`),
  KEY `verify_interview_idx` (`id_verify`),
  CONSTRAINT `verify_interview` FOREIGN KEY (`id_verify`) REFERENCES `verify` (`id_verify`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview`
--

LOCK TABLES `interview` WRITE;
/*!40000 ALTER TABLE `interview` DISABLE KEYS */;
INSERT INTO `interview` VALUES (16,'preliminary','2016-03-02 00:00:00',NULL,18);
/*!40000 ALTER TABLE `interview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview_mark`
--

DROP TABLE IF EXISTS `interview_mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interview_mark` (
  `id_mark` int(11) NOT NULL AUTO_INCREMENT,
  `skill` varchar(45) NOT NULL,
  `mark` enum('novice','intermediate','advanced','expert') NOT NULL,
  `id_interview` int(11) NOT NULL,
  PRIMARY KEY (`id_mark`),
  KEY `interview_mark_idx` (`id_interview`),
  CONSTRAINT `interview_mark` FOREIGN KEY (`id_interview`) REFERENCES `interview` (`id_interview`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview_mark`
--

LOCK TABLES `interview_mark` WRITE;
/*!40000 ALTER TABLE `interview_mark` DISABLE KEYS */;
/*!40000 ALTER TABLE `interview_mark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `langs`
--

DROP TABLE IF EXISTS `langs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `langs` (
  `lang` char(2) NOT NULL,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY (`lang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `langs`
--

LOCK TABLES `langs` WRITE;
/*!40000 ALTER TABLE `langs` DISABLE KEYS */;
INSERT INTO `langs` VALUES ('EN','English'),('RU','Russian');
/*!40000 ALTER TABLE `langs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resume` (
  `id_resume` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `publish_date` date NOT NULL,
  `military` enum('not specified','fit','not fit','military department','not bound') NOT NULL,
  `active` enum('active','non active') DEFAULT 'non active',
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id_resume`),
  KEY `user_resume_idx` (`email`),
  CONSTRAINT `user_resume` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (4,'Java june','2016-01-02','not fit','non active','vladbypinsk@gmail.ru'),(5,'C# специалист','2016-02-02','not bound','non active','zhenabyVitebsk@mail.ru'),(6,'Разнорабочий','2016-02-01','not fit','non active','vladbypinsk@gmail.ru'),(11,'Лучший','2016-08-29','not specified','non active','sharkybypinsk@mail.ru'),(14,'Первый','2016-08-29','not specified','non active','sharkybypinsk@mail.ru'),(18,'Знаю все','2016-08-31','military department','non active','zakazka@mail.ru'),(19,'Я то что вам нужно','2016-09-01','not specified','non active','ba@mail.ru'),(20,'Resume','2016-09-07','not specified','non active','vanobypinsk@mail.ru'),(28,'Я лучший','2016-09-12','not specified','non active','sadas@mail.ru'),(29,'I am the best','2016-09-12','not specified','non active','sharkybypinsk@mail.ru'),(30,'best','2016-09-12','not specified','non active','pennypinsk@mail.ru');
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resumelanguage`
--

DROP TABLE IF EXISTS `resumelanguage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resumelanguage` (
  `id_language` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `raiting` enum('not specified','A1','A1 plus','A2','A2 plus','B1','B1 plus','B2','B2 plus','C1','C1 plus','C2','Native speaker') NOT NULL,
  `id_resume` int(11) NOT NULL,
  PRIMARY KEY (`id_language`),
  KEY `resume_resumelaguage_idx` (`id_resume`),
  CONSTRAINT `resume_resumelaguage` FOREIGN KEY (`id_resume`) REFERENCES `resume` (`id_resume`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumelanguage`
--

LOCK TABLES `resumelanguage` WRITE;
/*!40000 ALTER TABLE `resumelanguage` DISABLE KEYS */;
INSERT INTO `resumelanguage` VALUES (4,'qwe','not specified',14),(5,'English','B2 plus',19),(18,'English','not specified',11),(19,'English','A1',11),(32,'English','not specified',28);
/*!40000 ALTER TABLE `resumelanguage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `id_skill` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `raiting` enum('novice','intermediate','advanced','expert') NOT NULL,
  `id_resume` int(11) NOT NULL,
  PRIMARY KEY (`id_skill`),
  KEY `resume_skill_idx` (`id_resume`),
  CONSTRAINT `resume_skill` FOREIGN KEY (`id_resume`) REFERENCES `resume` (`id_resume`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,'C#','novice',4),(6,'qweeqw','advanced',14),(7,'eqwewqe','novice',14),(8,'Kamni','advanced',19),(9,'Sera','advanced',19),(10,'Fasdas','advanced',11),(11,'Fassaddas','novice',11),(12,'Fsadasdas','expert',11);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teducation`
--

DROP TABLE IF EXISTS `teducation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teducation` (
  `id_education` int(11) NOT NULL,
  `lang` char(2) NOT NULL,
  `institution` varchar(45) NOT NULL,
  `faculty` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  PRIMARY KEY (`id_education`,`lang`),
  KEY `langs_teducation` (`lang`),
  CONSTRAINT `education_teducation` FOREIGN KEY (`id_education`) REFERENCES `education` (`id_education`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `langs_teducation` FOREIGN KEY (`lang`) REFERENCES `langs` (`lang`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teducation`
--

LOCK TABLES `teducation` WRITE;
/*!40000 ALTER TABLE `teducation` DISABLE KEYS */;
INSERT INTO `teducation` VALUES (1,'EN','BNTU','FITR','POVT');
/*!40000 ALTER TABLE `teducation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tresume`
--

DROP TABLE IF EXISTS `tresume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tresume` (
  `id_resume` int(11) NOT NULL,
  `lang` char(2) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_resume`,`lang`),
  KEY `langs_tresume` (`lang`),
  CONSTRAINT `langs_tresume` FOREIGN KEY (`lang`) REFERENCES `langs` (`lang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `resume_tresume` FOREIGN KEY (`id_resume`) REFERENCES `resume` (`id_resume`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tresume`
--

LOCK TABLES `tresume` WRITE;
/*!40000 ALTER TABLE `tresume` DISABLE KEYS */;
/*!40000 ALTER TABLE `tresume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tresumelanguage`
--

DROP TABLE IF EXISTS `tresumelanguage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tresumelanguage` (
  `id_language` int(11) NOT NULL,
  `lang` char(2) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_language`,`lang`),
  KEY `langs_tresumelaguage` (`lang`),
  CONSTRAINT `langs_tresumelaguage` FOREIGN KEY (`lang`) REFERENCES `langs` (`lang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `resumelaguage_tresumelanguage` FOREIGN KEY (`id_language`) REFERENCES `resumelanguage` (`id_language`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tresumelanguage`
--

LOCK TABLES `tresumelanguage` WRITE;
/*!40000 ALTER TABLE `tresumelanguage` DISABLE KEYS */;
/*!40000 ALTER TABLE `tresumelanguage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tskill`
--

DROP TABLE IF EXISTS `tskill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tskill` (
  `id_skill` int(11) NOT NULL,
  `lang` char(2) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_skill`,`lang`),
  KEY `langs_tskill` (`lang`),
  CONSTRAINT `langs_tskill` FOREIGN KEY (`lang`) REFERENCES `langs` (`lang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `skill_tskill` FOREIGN KEY (`id_skill`) REFERENCES `skill` (`id_skill`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tskill`
--

LOCK TABLES `tskill` WRITE;
/*!40000 ALTER TABLE `tskill` DISABLE KEYS */;
INSERT INTO `tskill` VALUES (1,'EN','Сишка');
/*!40000 ALTER TABLE `tskill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuser`
--

DROP TABLE IF EXISTS `tuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tuser` (
  `email` varchar(45) NOT NULL,
  `lang` char(2) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `secondname` varchar(45) NOT NULL,
  PRIMARY KEY (`email`,`lang`),
  KEY `langs_tuser` (`lang`),
  CONSTRAINT `langs_tuser` FOREIGN KEY (`lang`) REFERENCES `langs` (`lang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_tuser` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuser`
--

LOCK TABLES `tuser` WRITE;
/*!40000 ALTER TABLE `tuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `tuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tvacancy`
--

DROP TABLE IF EXISTS `tvacancy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tvacancy` (
  `id_vacancy` int(11) NOT NULL,
  `lang` char(2) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `duties` text NOT NULL,
  `conditions` text NOT NULL,
  PRIMARY KEY (`id_vacancy`,`lang`),
  KEY `langs_tvacancy` (`lang`),
  CONSTRAINT `langs_tvacancy` FOREIGN KEY (`lang`) REFERENCES `langs` (`lang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vacancy_tvacancy` FOREIGN KEY (`id_vacancy`) REFERENCES `vacancy` (`id_vacancy`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tvacancy`
--

LOCK TABLES `tvacancy` WRITE;
/*!40000 ALTER TABLE `tvacancy` DISABLE KEYS */;
INSERT INTO `tvacancy` VALUES (55,'EN','International transport specialist','Transport company APS - the market leader in the field of international road transport, welcomes the manager on international transportation with no experience!','Higher education (preferably Linguistic University, Belarusian State University - Faculty of International Relations, Belarusian State Economic University), consider the candidates enrolled in the last year, with the possibility of distribution (with the possibility to work full-time);\r\nKnowledge of a foreign language at the level of free communication (German or English) - always;\r\nUnderstanding the process of organization of transport and freight forwarding.\r\nWe consider candidates with no work experience.','Special training for employees without experience in international transportation;\r\nTraining in sales techniques;\r\nInternships in the main departments of the company;\r\nIndividual curator at the training period (3 months);\r\nPossibility of professional development!\r\nHigh pay-for-performance.'),(56,'EN','Business development manager (лесозаготовка)','An enterprise with foreign investments invites to his team Manager of Business Development.\r\nField of activity: production of timber and fuel wood chips, export.','-Search of new directions of development, access to new markets, finding new customers.\r\n-podderzhanie and developing relationships with existing clients.\r\n-komandirovki and meetings in forestries of Belarus.\r\n-zarubezhnye trip, meeting with company management, reporting on the results of the work.\r\n-also desirable to have experience in document management, accounting.','- Obligatory English language skills to communicate with investors, frequent trips to Europe\r\n-vysshee education (technical), welcomed the additional economic education\r\n-Experience Production Director or Manager of Business Development in the same sector (forestry and others.)'),(57,'EN','Sales Manager (Sales Specialist)','Ltd. \"Nanotech\" - the leading contract manufacturer of electronics, professional supplier of printed circuit boards and related materials on the market of the Republic of Belarus, the work experience in the industry - 10 years, due to the growth of the company is looking for sales managers.','salary: salary + 600% of sales (over the past three months, the average monthly salary was 2519 Belarusian rubles on hand.);\r\ntraining range and sales skills at the expense of the company;\r\nWork in the office at the address: Minsk, ul. Grizzly;\r\nfull employment;\r\na five-day working week from 9.00 to 18.00, lunch from 13.00 to 14.00;\r\npaid leave of 25 calendar days;\r\nyoung, energetic, cheerful staff;\r\ncareer prospects.','active sales of goods and services of the company;\r\nWork with existing customer base;\r\ntime between a new customer base.\r\nMandatory requirements:\r\nhigher technical education: BSUIR (PCF EDF FEITH), Belarusian National Technical University (PSF, FITR), Baku State University (Faculty of Radio Physics and Department of Physics), MSHRC;\r\nzeal and positive attitude to life;\r\ninterest in achieving results;\r\ninitiative.\r\n'),(58,'EN','Engineer (Master) Repair equipment','Chain stores 5 Element invites engineering work (master) for the repair of equipment','warranty and post-television and audio / video equipment;\r\nability to work on the technical sites, support sites (manufacturers of household appliances);\r\norder spare parts;\r\ntroubleshooting;\r\nfor simple, medium and complex repairs (component, module level);\r\ncompilation, quality assurance statement acts, acts of work performed;\r\ncarrying out maintenance.','Work in a stable, forward-looking company;\r\nplace of work - ul.Harkovskaya;\r\nsocial package - official employment, timely stable, wages, paid leave and sick leave;\r\nprofessional and talented team, enthusiastic about their work.');
/*!40000 ALTER TABLE `tvacancy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tworkplace`
--

DROP TABLE IF EXISTS `tworkplace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tworkplace` (
  `id_workplace` int(11) NOT NULL,
  `lang` char(2) NOT NULL,
  `company_name` varchar(45) NOT NULL,
  `position` varchar(45) NOT NULL,
  PRIMARY KEY (`id_workplace`,`lang`),
  KEY `langs_tworkplace` (`lang`),
  CONSTRAINT `langs_tworkplace` FOREIGN KEY (`lang`) REFERENCES `langs` (`lang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `workplace_tworkplace` FOREIGN KEY (`id_workplace`) REFERENCES `workplace` (`id_workplace`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tworkplace`
--

LOCK TABLES `tworkplace` WRITE;
/*!40000 ALTER TABLE `tworkplace` DISABLE KEYS */;
INSERT INTO `tworkplace` VALUES (1,'EN','BNTU','prepod');
/*!40000 ALTER TABLE `tworkplace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `secondname` varchar(45) NOT NULL,
  `photo` longtext,
  `skype` varchar(45) NOT NULL,
  `contact_phone` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  `role` enum('applicant','hr') DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('ba@mail.ru','58ddca387bfab5ca47879b5c656634af','dasdsa','sdadas','asddas',NULL,'asds',4345674,'1992-05-02','applicant'),('bakads@mail.ru','58ddca387bfab5ca47879b5c656634af','asd','asd','sad',NULL,'asd',5458748,'2013-02-01','applicant'),('bakas@mail.ru','58ddca387bfab5ca47879b5c656634af','asd','asd','sad',NULL,'asd',5458748,'2013-02-01','applicant'),('disko@mail.ru','58ddca387bfab5ca47879b5c656634af','sadsa','sdasad','asd',NULL,'dsa',5458748,'1945-02-04','applicant'),('juba@mail.ru','58ddca387bfab5ca47879b5c656634af','Самуил','Валерий','Вадимович',NULL,'javaTheBest',5459754,'1993-02-03','hr'),('jubik@mail.ru','58ddca387bfab5ca47879b5c656634af','Панова','Елена','Владимировна',NULL,'blabla',5356783,'1992-02-05','hr'),('pennypinsk@mail.ru','58ddca387bfab5ca47879b5c656634af','Пеньков','Вадим','Петрович',NULL,'vadVad',5458748,'1994-02-05','applicant'),('sachka@mail.ru','58ddca387bfab5ca47879b5c656634af','das','ads','sad',NULL,'asd',5458748,'2013-02-01','applicant'),('sadas@mail.ru','58ddca387bfab5ca47879b5c656634af','Гапеенко','Владислав','Витальевич',NULL,'blwble',5458748,'1993-02-05','applicant'),('sharkybypinsk@mail.ru','423f3eab4e1b9435e9df0dd04aef6039','Праников','Вадимовн','Петрович',NULL,'sharkShark',5458748,'1994-05-02','applicant'),('shashkagatus@mail.ru','d701fde59d74f76803087b6632186caf','Микульский','Александр','Сергеевич',NULL,'konik',4444122,'1994-02-02','applicant'),('sussum@mail.ru','58ddca387bfab5ca47879b5c656634af','Гапеенко','Владислав','Витальевич',NULL,'vladvlad',5458748,'1994-05-02','hr'),('vanobypinsk@mail.ru','58ddca387bfab5ca47879b5c656634af','Кришталь','Иван','Васильевич',NULL,'vnao',3234567,'1994-01-02','applicant'),('vla@mail.ru','58ddca387bfab5ca47879b5c656634af','saddsa','dsadsa','dassda',NULL,'adass',4545555,'1993-02-24','applicant'),('vlabis@mail.ru','58ddca387bfab5ca47879b5c656634af','sadsda','dsasd','asddas',NULL,'sadsad',4354562,'1993-02-05','applicant'),('vladas@mail.ru','58ddca387bfab5ca47879b5c656634af','asdsad','saddsa','asdsda',NULL,'saddsa',4554543,'1993-05-24','applicant'),('vladasbypinsk@mail.ru','58ddca387bfab5ca47879b5c656634af','Сашко','Наталья','Петровна',NULL,'sachko',4556789,'1994-05-02','hr'),('vladbyminsk@mail.ru','58ddca387bfab5ca47879b5c656634af','Шаренко','Александра','Александровна',NULL,'alalais',3456789,'1994-05-02','hr'),('vladbypinsk@gmail.ru','vlad214248','Гапеенко','Владислав','Витальевич',NULL,'vladbypinsk',5458748,'1994-02-05','applicant'),('vladddos@mail.ru','58ddca387bfab5ca47879b5c656634af','Vlad','ads','ads',NULL,'ads',5458748,'1993-02-02','applicant'),('vladislavbypinsk@mail.ru','423f3eab4e1b9435e9df0dd04aef6039','Гапеенко','Виталий','Васильевич',NULL,'vkasdas',5458748,'1994-05-02',NULL),('vladosbypinsk@mail.ru','58ddca387bfab5ca47879b5c656634af','Антоненко','Вадим','Петрович',NULL,'antonAndton',5457876,'1994-05-02','hr'),('zaba@mail.ru','58ddca387bfab5ca47879b5c656634af','Zaka','zaka','zaka',NULL,'Zaka',4345678,'1945-02-02','applicant'),('zakazaka@mail.ru','58ddca387bfab5ca47879b5c656634af','Gapaas','Gapas','sada',NULL,'sad',2345678,'1993-02-03','applicant'),('zakazka@mail.ru','58ddca387bfab5ca47879b5c656634af','Gapaas','Gapas','sada',NULL,'sad',2345678,'1993-02-03','applicant'),('zhenabyVitebsk@mail.ru','asdsa','Демченко','Евгения','Петровна',NULL,'demdem',4556789,'1993-01-02','applicant');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacancy`
--

DROP TABLE IF EXISTS `vacancy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacancy` (
  `id_vacancy` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `salary` int(11) NOT NULL,
  `currency` enum('rub','dolar') NOT NULL,
  `publish_date` date DEFAULT NULL,
  `description` text NOT NULL,
  `duties` text NOT NULL,
  `conditions` text NOT NULL,
  `employment_type` enum('full time','part time','contractual') NOT NULL,
  `active` enum('active','non active') DEFAULT 'non active',
  `hot` enum('hot','non hot') DEFAULT 'non hot',
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id_vacancy`),
  KEY `user_vacancy_idx` (`email`),
  CONSTRAINT `user_vacancy` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacancy`
--

LOCK TABLES `vacancy` WRITE;
/*!40000 ALTER TABLE `vacancy` DISABLE KEYS */;
INSERT INTO `vacancy` VALUES (23,'Web-разработчик (Senior PHP, frontend/backend)',1200,'dolar','2016-09-09','Подбираем опытного web-разработчика в команду разработки и сопровождения собственных продуктов: Торгового портала Shop.by и Платформы интернет-магазинов beSeller.by.\r\nИщем активного, ответственного инженера-универсала,\r\nимеющего потребности в команде и потоке сложных задач,\r\nаккуратного и настойчивого в реализации идей.','backend и frontend на PHP5, включая MVC (например Yii), SQL-базы данных\r\nDevOps Linux (LAMP)\r\nfrontend (HTML5, CSS3, JavaScript, адаптивная вёрстка, bootstrap, Ajax/REST)\r\nопыт решения архитектурных задач, оптимизации высокой нагрузки, рефакторинга web-сервисов\r\nумение и желание работать с чужим кодом\r\nобщий опыт web-разработки более 3-х лет\r\nжелателен опыт разработки с Git и виртуализацией (Citrix, VMware)','backend и frontend на PHP5, включая MVC (например Yii), SQL-базы данных\r\nDevOps Linux (LAMP)\r\nfrontend (HTML5, CSS3, JavaScript, адаптивная вёрстка, bootstrap, Ajax/REST)\r\nопыт решения архитектурных задач, оптимизации высокой нагрузки, рефакторинга web-сервисов\r\nумение и желание работать с чужим кодом\r\nобщий опыт web-разработки более 3-х лет\r\nжелателен опыт разработки с Git и виртуализацией (Citrix, VMware)','full time','active','hot','vladosbypinsk@mail.ru'),(24,'Junior PHP-разработчик',200,'dolar','2016-09-09','Минский офис международной компании, разрабатывающей игровое ПО приглашает на постоянную работу начинающего программиста PHP. Мы предлагаем работу в развивающемся, динамическом проекте, где вы сможете получить новые знания и вырасти как специалист работая в команде опытных разработчиков.','Сплоченный и профессиональный коллектив\r\nОфициальное оформление\r\nОплачиваемый отпуск 28 дней\r\nПолностью оплачиваемые больничные\r\nУровень заработной платы обсуждаем индивидуально с успешным кандидатом\r\nРегулярный пересмотр зарплаты\r\nЗащищенная от инфляции зарплата\r\nПрофессиональный рост приветствуется и вознаграждается\r\nБольшой офис в бизнес-центре \"Порт\", ст.м. Уручье\r\nКорпоративные мероприятия\r\nЧеткая и понятная постановка задач\r\nЭффективный менеджмент, отсутствие бюрократии, оптимальные процессы, комфортные условия работы\r\nБольшой и постоянно развивающийся проект','Сплоченный и профессиональный коллектив\r\nОфициальное оформление\r\nОплачиваемый отпуск 28 дней\r\nПолностью оплачиваемые больничные\r\nУровень заработной платы обсуждаем индивидуально с успешным кандидатом\r\nРегулярный пересмотр зарплаты\r\nЗащищенная от инфляции зарплата\r\nПрофессиональный рост приветствуется и вознаграждается\r\nБольшой офис в бизнес-центре \"Порт\", ст.м. Уручье\r\nКорпоративные мероприятия\r\nЧеткая и понятная постановка задач\r\nЭффективный менеджмент, отсутствие бюрократии, оптимальные процессы, комфортные условия работы\r\nБольшой и постоянно развивающийся проект','full time','active','non hot','vladosbypinsk@mail.ru'),(25,'JavaScript (Front-End) Developer',400,'dolar','2016-09-09','В дружный отдел Front-End команды Altoros требуется Middle\\Senior JavaScript разработчик.\r\nБудем рады принять человека с опытом и знаниями в указанных ниже областях.','Работа в квалифицированной команде;\r\nНа старте возможна командировка в Европу;\r\nВнутреннее и внешнее обучение, профессиональный рост;\r\nРабота с различными фреймворками;\r\nДостойная оплата труда;\r\nВнутрикорпоративное обучение английскому языку (для легкого общения с заказчиками и не только);\r\nКомната для отдыха, тренажер, массажный кабинет, просторная кухня (фрукты, печеньки и другие вкусности);\r\nГибкий рабочий график;\r\nКомпенсация групповых и индивидуальных занятий спортом;\r\nУникальная система лояльности для сотрудников компании;\r\nРегулярные внутренние, внешние мероприятия и многое другое.','Работа в квалифицированной команде;\r\nНа старте возможна командировка в Европу;\r\nВнутреннее и внешнее обучение, профессиональный рост;\r\nРабота с различными фреймворками;\r\nДостойная оплата труда;\r\nВнутрикорпоративное обучение английскому языку (для легкого общения с заказчиками и не только);\r\nКомната для отдыха, тренажер, массажный кабинет, просторная кухня (фрукты, печеньки и другие вкусности);\r\nГибкий рабочий график;\r\nКомпенсация групповых и индивидуальных занятий спортом;\r\nУникальная система лояльности для сотрудников компании;\r\nРегулярные внутренние, внешние мероприятия и многое другое.','full time','active','hot','vladosbypinsk@mail.ru'),(51,'Специалист по международным перевозкам',5000,'rub','2016-09-11','Международная группа компаний TELS – логистический оператор с многолетним успешным опытом международных грузоперевозок, приглашает в свою команду специалиста по организации международных перевозок.','1) Поиск новых транспортных компаний, работа с существующей базой.\r\n3) Оформление транспортных заказов, ведение перевозки.\r\n5) Проставление контрольных точек перевозки, регистрация места дислокации транспорта.\r\n6) Информирование о ходе перевозки Заказчиков.\r\n','1) Высшее образование.\r\n2) Свободное владение офисными программами.\r\n3) Внимательность, усидчивость, аккуратность в работе.\r\n4) Готовность работать с большими объемами информации.\r\n5) Знание польского языка - обязательно!','full time','active','hot','vladasbypinsk@mail.ru'),(52,'Специалист по транспортной логистике',400,'rub','2016-09-11','Ищем специалиста по транспортной логистике','1) организация и контроль оперативной деятельности службы логистики (складская, транспортная);\r\nорганизация доставок/заборов грузов по Минску и РБ собственным и наемным транспортом;\r\n2) организация международных грузоперевозок собственным транспортом;\r\n3) расширение клиентской базы в транспортно-экспедиционной организации (согласование сроков, условий, стоимости фрахта, прочих условий,);','1) работа в динамично развивающейся компании, в молодом дружном коллективе;\r\n2) полная занятость (работа в офисе- 8.45-17.15, пн-пт.);\r\n3) достойная заработная плата (оклад +премиальные);\r\n4) возможность профессионального и личностного развития, а также карьерного роста.','full time','active','hot','vladasbypinsk@mail.ru'),(53,'Начальник отдела приемки товара',5000,'rub','2016-09-11','Компания \"ЭРНИС\" - лидер белорусского рынка с 25-летним опытом в области торговли строительными и отделочными материалами - расширяет торговую сеть и открывает гипермаркет \"МАТЕРИК\" в г.Гродно.','Руководить работой отдела приемки товара, контролировать выполнение должностных обязанностей сотрудниками отдела.\r\nУчаствовать в проведении инвентаризаций.\r\nПроводить работы по повышению квалификации работников, адаптации новых сотрудников.\r\nОбеспечивать работников отдела приемки товара необходимым инвентарем, упаковочными материалами, спецодеждой\r\nСогласовывать графики поставок товара в магазин по количеству транспорта и временному ресурсу.\r\nОрганизовывать разгрузку автотранспорта, приемку товаров по количеству и качеству, распределять нагрузку между кладовщиками.\r\nВзаимодействовать с товарными секциями, отделами магазина по вопросам товародвижения.\r\nВзаимодействовать с представителями поставщиков при возникновении спорных ситуаций в процессе приемки и возврата товара.','Высшее или среднее специальное образование.\r\nОпыт работы в складской логистике не менее 3 лет,\r\nОпыт руководства персоналом,\r\nУверенный ПК-пользователь','full time','active','non hot','vladasbypinsk@mail.ru'),(54,'Начальник склада нефтепродуктов',4000,'rub','2016-09-11','ИООО \"РН-Запад\" входит в группу компаний «РОСНЕФТЬ». Штат сотрудников в РБ составляет более 700 человек. Основной деятельностью компании в Беларуси является: нефтепереработка и реализация нефтепродуктов.','Руководство работой склада нефтепродуктов;\r\nПрием, хранение и отпуск нефтепродуктов;\r\nОбеспечение бесперебойной работы оборудования, организация своевременного ремонта и технического обслуживания оборудования, зданий и сооружений;\r\nОбеспечение административно-хозяйственной деятельности СНП;\r\nКоординация работы персонала;\r\nОрганизация и проведение проверки знаний и периодического инструктажа персонала по вопросам охраны труда, пожарной безопасности и правилам технической эксплуатации нефтебаз;\r\nВедение всей необходимой технической документации.','Работа в крупной, динамичной нефтяной компании;\r\nОфициальное оформление, стабильная заработная плата (2 раза в месяц);\r\nРасширенный социальный пакет, а также дополнительное страхование 24 часа в сутки;\r\nКорпоративная мобильная связь;\r\nПремирование по итогам работы.','full time','active','non hot','vladasbypinsk@mail.ru'),(55,'Специалист по международным перевозкам',500,'rub','2016-09-11','Транспортная компания APS - лидер на рынке в области международных перевозок автомобильным транспортом, приглашает менеджера по международным перевозкам без опыта!','Высшее образование (предпочтительно МГЛУ, БГУ – ФМО, БГЭУ), рассматриваем кандидатов обучающихся на последнем курсе, с возможностью распределения (с возможностью работать на полную ставку);\r\nЗнание иностранного языка на уровне свободного общения (немецкий или английский языки) - обязательно;\r\nПонимание процесса организации перевозок, экспедирования грузов.\r\nРассматриваем кандидатов без опыта работы.','Специальное обучение для сотрудников без опыта работы в сфере международных грузоперевозок;\r\nОбучение технологиям продаж;\r\nСтажировки в основных отделах компании;\r\nИндивидуальный куратор на период обучения (до 3 месяцев);\r\nВозможность профессионального развития!\r\nВысокая оплата труда по результатам работы.','full time','active','hot','vladasbypinsk@mail.ru'),(56,'Менеджера по развитию бизнеса (лесозаготовка)',200,'rub','2016-09-12','Предприятие с иностранными инвестициями приглашает в свою команду Менеджера по развитию бизнеса.\r\nНаправление деятельности:лесозаготовка и производство топливной щепы, экспорт.','-поиск новых направлений развития, выход на новые рынки, поиск новых клиентов.\r\n-поддержание и развитие отношений с уже существующими клиентами.\r\n-командировки и проведение встреч в лесхозах РБ.\r\n-зарубежные командировки, встречи с руководством компании, отчетность по итогам работы.\r\n-также желательно иметь опыт в документообороте, бухгалтерии.','- обязательно владение английским языком для общения с инвесторами, частые командировки по Европе\r\n-высшее образование( техническое), приветствуется дополнительное экономическое образование\r\n-опыт Директором по производству или Менеджером по развитию бизнеса в аналогичной отрасли (лесозаготовка и др.)','full time','active','hot','juba@mail.ru'),(57,'Менеджер по продажам (специалист по продажам)',2519,'rub','2016-09-12','ООО \"Нанотех\" – ведущий контрактный производитель электроники, профессиональный поставщик печатных плат и сопутствующих материалов на рынке Республики Беларусь, стаж работы в отрасли – 10 лет, в связи с ростом компании ищет МЕНЕДЖЕРА ПО ПРОДАЖАМ.','заработная плата: оклад 600 + % от продаж (за последние три месяца средняя ежемесячная заработная плата составила 2519 бел. рублей на руки);\r\nобучение ассортименту и навыкам продаж за счёт компании;\r\nработа в офисе по адресу: г. Минск, ул. Седых;\r\nполная занятость;\r\nпятидневная рабочая неделя с 9.00 до 18.00, обед с 13.00 до 14.00;\r\nоплачиваемый отпуск 25 календарных дней;\r\nмолодой, энергичный, весёлый коллектив;\r\nперспективы карьерного роста.','заработная плата: оклад 600 + % от продаж (за последние три месяца средняя ежемесячная заработная плата составила 2519 бел. рублей на руки);\r\nобучение ассортименту и навыкам продаж за счёт компании;\r\nработа в офисе по адресу: г. Минск, ул. Седых;\r\nполная занятость;\r\nпятидневная рабочая неделя с 9.00 до 18.00, обед с 13.00 до 14.00;\r\nоплачиваемый отпуск 25 календарных дней;\r\nмолодой, энергичный, весёлый коллектив;\r\nперспективы карьерного роста.','full time','active','non hot','juba@mail.ru'),(58,'Инженер (мастер) по ремонту техники',510,'rub','2016-09-12','Сеть магазинов 5 Элемент приглашает на работу инженера (мастера) по ремонту техники','гарантийное и послегарантийное обслуживание телевизионной и аудио/видео техники;\r\nумение работать на технических сайтах, сайтах технической поддержки ( производителей бытовой техники);\r\nзаказ запасных частей;\r\nвыявление неисправностей;\r\nвыполнение простых, средних и сложных ремонтов (компонентном, модульном уровне);\r\nсоставление, выписка актов проверки качества, актов выполненных работ;\r\nпроведение технического обслуживания.','знание бытовой, телевизионной, аудио/видео техники;\r\nопыт работы в сервисной службе;\r\nнавыки ремонта и обслуживания оборудования.','full time','active','non hot','juba@mail.ru'),(59,'Мастер цеха пекарня',400,'rub','2016-09-12','Торговая сеть \"Соседи\" приглашает на работу МАСТЕРА ЦЕХА ПЕКАРНИ','Управление персоналом на смене.\r\nКонтроль качества и технологии производства продукции.\r\nИзготовление хлебобулочных изделий.','Работа в крупной и развивающейся компании.\r\nБонусная карта сотрудника \"Купилка\".\r\nПрофессиональный и карьерный рост.\r\nДостойная и своевременная оплата труда (оклад + премия)\r\nВакансия открыта в гипермаркете по адресу Долгиновский тр., 178 (ТЦ ALL)\r\nГрафик 3/3 (дневные и ночные смены)','full time','active','non hot','juba@mail.ru'),(60,'Инженер по ремонту и эксплуатации оборудования',1000,'rub','2016-09-12','Единственный в своем сегменте в Республике Беларусь – производитель Черной осетровой икры и рыбной продукции класса Люкс приглашает на высокооплачиваемую работу инженера по ремонту и эксплуатации оборудования.','Разработка графика ППР и ТОР;\r\nВыполнение работ согласно графика ППР и ТОиР оборудования участка;\r\nЕжедневный осмотр оборудования;\r\nРемонт оборудования;\r\nЗакупка запчастей и материалов производства;\r\nОтветственный за электро и тепло-хозяйство;\r\nАкты, списание материалов и запчастей .','Работа в стабильной компании;\r\nОфициальное трудоустройство;\r\nСоциальный пакет;\r\nСвоевременная выплата заработной платы;\r\nКомпенсация топливных расходов;\r\nЗаработная плата высокая, окончательный уровень заработной платы по итогам собеседования.\r\nГрафик работы: пятидневка с 9.00 до 18.00 (обеденный перерыв 1 час);','full time','active','non hot','juba@mail.ru'),(61,'Ведущий экономист (консультант) Центра государстве',700,'rub','2016-09-12','Национальное агентство инвестиций и приватизации является государственной организацией по привлечению прямых иностранных инвестиций в Республику Беларусь.\r\nОткрываем вакансию для опытного и талантливого экономиста, желающего практически применять свои знания в сфере международных экономических отношений','осуществление оценки финансовой и социально-экономической эффективности проектов государственно-частного партнерства (ГЧП);\r\nосуществление предварительной проверки проекта и комплексный анализ проекта ГЧП в соответствии с установленными требованиями и методиками;\r\nучастие в работе Центра ГЧП по разработке методических и методологических документов, иных аналитических материалов;\r\nвзаимодействие с республиканскими и местными органами управления, иными заинтересованными органами/организациями по вопросам подготовки проектов ГЧП на всех его этапах (в том числе подготовки технических заданий для экспертов, разработки конкурсной документации и т.д.);\r\nвзаимодействие с международными консультантами при подготовке и экспертизе проектов ГЧП;\r\nконсультирование заинтересованных лиц по вопросам реализации ГЧП в Республике Беларусь;\r\nподготовка материалов и презентаций для потенциальных инвесторов, в том числе на английском языке.','высшее (экономика/финансы). Преимущество специалистам, владеющим экономико-математическим моделированием;\r\nопыт работы в области оценки (разработки) инвестиционных проектов не менее 2 лет;\r\nвладение английским языком на уровне не ниже upper intermediatе (деловые переговоры, работа с документами) - требование обязательное!;\r\nопытный пользователь ПК: Excel, Word, Power Point на уровне продвинутого пользователя. Приветствуются навыки работы в графических программах (Adobe Illustrator);\r\nхорошие аналитические навыки, инициативность, ориентированность «на результат»;\r\nстрессоустойчивость, готовность к интенсивной работе и самостоятельность (способность к самоорганизации труда);\r\nбыстрая обучаемость и стремление к саморазвитию.','full time','active','non hot','jubik@mail.ru');
/*!40000 ALTER TABLE `vacancy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verify`
--

DROP TABLE IF EXISTS `verify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `verify` (
  `id_verify` int(11) NOT NULL AUTO_INCREMENT,
  `id_vacancy` int(11) NOT NULL,
  `id_resume` int(11) NOT NULL,
  `pass` enum('pass','not pass','unknown') DEFAULT 'unknown',
  PRIMARY KEY (`id_verify`),
  KEY `resume_verify_idx` (`id_resume`),
  KEY `vacancy_verify_idx` (`id_vacancy`),
  CONSTRAINT `resume_verify` FOREIGN KEY (`id_resume`) REFERENCES `resume` (`id_resume`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vacancy_verify` FOREIGN KEY (`id_vacancy`) REFERENCES `vacancy` (`id_vacancy`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verify`
--

LOCK TABLES `verify` WRITE;
/*!40000 ALTER TABLE `verify` DISABLE KEYS */;
INSERT INTO `verify` VALUES (10,23,11,'unknown'),(16,55,18,'unknown'),(17,55,19,'unknown'),(18,55,20,'pass'),(19,55,28,'unknown'),(20,55,29,'pass'),(21,55,30,'not pass'),(22,55,11,'pass'),(23,55,14,'not pass');
/*!40000 ALTER TABLE `verify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workplace`
--

DROP TABLE IF EXISTS `workplace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workplace` (
  `id_workplace` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) NOT NULL,
  `position` varchar(45) NOT NULL,
  `date_begin` date NOT NULL,
  `date_end` date NOT NULL,
  `id_resume` int(11) NOT NULL,
  PRIMARY KEY (`id_workplace`),
  KEY `resume_workplace_idx` (`id_resume`),
  CONSTRAINT `resume_workplace` FOREIGN KEY (`id_resume`) REFERENCES `resume` (`id_resume`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workplace`
--

LOCK TABLES `workplace` WRITE;
/*!40000 ALTER TABLE `workplace` DISABLE KEYS */;
INSERT INTO `workplace` VALUES (1,'БНТУ','препод','2014-02-01','2016-01-02',4),(4,'Besto','GLAVA','1994-02-05','1997-02-06',19);
/*!40000 ALTER TABLE `workplace` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-12 21:50:19
