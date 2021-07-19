create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table `class`(
class_id int auto_increment primary key not null,
class_name varchar(60) not null,
start_date date not null,
`status` bit);

create table student(
student_id int auto_increment primary key not null,
student_name varchar(30) not null,
address varchar(50),
phone varchar(20),
`status` bit,
class_id int not null,
foreign key (class_id) references `class`(class_id));

create table `subject`(
sub_id int auto_increment primary key not null,
sub_name varchar(30) not null,
credit tinyint not null default 1 check (credit >= 1),
`status` bit default 1);

create table mark(
mark_id int auto_increment primary key not null,
sub_id int unique key not null,
student_id int unique key not null,
mark float default 0 check (mark between 0 and 100),
exam_time tinyint default 1,
foreign key (sub_id) references `subject`(sub_id),
foreign key (student_id) references student(student_id));

select * from student;