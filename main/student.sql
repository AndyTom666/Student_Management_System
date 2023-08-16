use web_student;
CREATE TABLE student(
 stuid VARCHAR(50) NOT NULL PRIMARY KEY  ,
 stuname  VARCHAR(50) NOT NULL,
 pwd  VARCHAR(50) NOT NULL,
 professionid varchar(50) NOT NULL,
 role int DEFAULT 1,
 date varchar(50) NOT NULL,
 sex int NOT NULL,
 idnum varchar(20) NOT NULL,
 totalscore int NOT NULL,
 photo varchar(100),
 note varchar(100)
 );
CREATE TABLE profession(
 professionid VARCHAR(50) NOT NULL PRIMARY KEY,
 professionname VARCHAR(40) NOT NULL
 );
 CREATE TABLE stumarkinfo(
 markid varchar(50) NOT NULL PRIMARY KEY  ,
 stuid varchar(50) NOT NULL,
 courseid varchar(50) Not NULL,
 basescore double NOT NULL,
 testscore double NOT NULL,
 finalscore double NOT NULL,
 adddate varchar(50) NOT NULL,
 note varchar(100)
 );
 CREATE TABLE teacher(
 teacherid VARCHAR(50) NOT NULL PRIMARY KEY,
 teachername VARCHAR(40) NOT NULL,
 pwd  VARCHAR(50) NOT NULL,
 professionid VARCHAR(50) NOT NULL,
 role int DEFAULT 2
 );
 CREATE TABLE course (
    courseid VARCHAR(50) NOT NULL PRIMARY KEY,
    coursename VARCHAR(40) NOT NULL,
    professionid VARCHAR(50) NOT NULL,
    ratio Double NOT NULL,
    credit int DEFAULT 0
);
  CREATE TABLE login(
 stuid VARCHAR(50) NOT NULL PRIMARY KEY,
 pwd VARCHAR(40) NOT NULL,
 role int DEFAULT 1,
 stustate int default 0
 );