
drop database web_quan_ly_dh

create database web_quan_ly_dh

use web_quan_ly_dh


create table users(
	users_id		int primary key identity(1,1),
	username		varchar(30),
	password		varchar(30),
	name			nvarchar(30),
	birthday		date,
	addrezz			nvarchar(50),
	email			varchar(30) unique,
	phone_number	varchar(30) unique,
	role			int,
	faculty_id		int,
	is_deleted		bit default 0
)

update users set name = 'cc', birthday = '2003-02-23', addrezz = 'b', 
                email = 'ab@gmail.com', phone_number = '00003123416', faculty_id = 6 where users_id = 27


select*from users

ALTER TABLE users ALTER COLUMN username VARCHAR(30);
ALTER TABLE users ADD CONSTRAINT UC_username UNIQUE (username);

select users_id, name, birthday, addrezz, email, phone_number
from users u 
where u.role = 1 and is_deleted = 0


select users_id, name, birthday, addrezz, email, phone_number, c.class_name
from users u 
right join student_class sc on u.users_id = sc.student_id
join class c on sc.class_id = c.class_id
where u.role = 1 and is_deleted = 0

select*
from users u 
left join student_class sc on u.users_id = sc.student_id
join class c on sc.class_id = c.class_id
where u.role = 1 and is_deleted = 0

select*from users where role=1

select users_id, name, birthday, 
                addrezz, email, phone_number, faculty_id from 
               users where is_deleted = 0 and users_id = 1

create table student_class(
	student_id		int unique,
	class_id		int,
	primary key(student_id,class_id)
)

insert into student_class
values	(1,1),
		(3,2),
		(5,2),
		(7,3),
		(9,1),
		(11,10),
		(13,4)

		

select u.users_id, u.name, u.birthday, u.addrezz, u.email, u.phone_number
from student_class sc
join users u on sc.student_id = u.users_id
join class c on sc.class_id = c.class_id
where c.class_id = 1




create table lecturer_class(
	lecturer_id		int,
	class_id		int,
	primary key(lecturer_id,class_id)
)

insert into lecturer_class 
values	(2,1),
		(4,2),
		(6,3),
		(8,4),
		(6,5),
		(10,6),
		(12,7),
		(14,8),
		(4,9),
		(18,10)


		--select idclass name class lecturer name
select  c.class_id,c.class_name,u.users_id from lecturer_class lc join class c
on lc.class_id=c.class_id join users u
on lc.lecturer_id=u.users_id
where c.faculty_id=1

select*from class

select*from faculty

select * from faculty

create table faculty(
	faculty_id		int primary key identity(1,1),
	faculty_name	nvarchar(30)
)

create table subjects(
	subject_id		int primary key identity(1,1),
	subject_name	nvarchar(30),
	describe		nvarchar(max),
	credit_hour		int,
	faculty_id		int,
	is_deleted		bit default 0
)

update subjects set subject_name = 'hd', describe = 'a', 
                 credit_hour = 2, faculty_id = 6 where subject_id = 12

create table class(
	class_id		int primary key identity(1,1),
	class_name		varchar(30),
	faculty_id		int
)


create table classroom(
	classroom_id	int primary key identity(1,1),
	classroom_name	varchar(20)
)

create table schedule(
	schedule_id		int primary key identity(1,1),
	subject_id		int,
	lecturer_id		int,
	classroom_id	int,
	start_time		datetime,
	 end_time		datetime
)

SELECT 
    u.name AS lecturer_name,
    cr.classroom_name,
    s.subject_name,
    sch.start_time,
    sch.end_time
FROM 
    schedule sch
JOIN 
    users u ON sch.lecturer_id = u.users_id
JOIN 
    classroom cr ON sch.classroom_id = cr.classroom_id
JOIN 
    subjects s ON sch.subject_id = s.subject_id;



create table enrollment(
	enrollment_id	int primary key identity(1,1),
	student_id		int,
	subject_id		int,
	semester_id		int
)

create table grades(
	grade_id		int primary key identity(1,1),
	student_id		int,
	subject_id		int,
	grade1			decimal,
	grade2			decimal,
	grade3			decimal,
	semester_id		int,
	academic_year	int
)
alter table grades add is_deleted bit default 0 

UPDATE grades
SET is_deleted = 0;

select*from grades

select sb.subject_id, sb.subject_name, sb.credit_hour, g.grade1, g.grade2, g.grade3, s.semester_name
from grades g
join semester s on g.semester_id = s.semester_id
join subjects sb on g.subject_id = sb.subject_id
join users u on g.student_id = u.users_id
where u.users_id = 1 and s.semester_id = 3

create table semester(
	 semester_id	int primary key identity(1,1),
     semester_name	nvarchar(20)
)

create table subjects_grades(
	student_id		int,
	grade_id		int,
	primary key(student_id,grade_id)
)

create table student_subjects(
	student_id		int,
	subject_id		int,
	primary key(student_id,subject_id)
)

create table subjects_schedule(
	subject_id		int,
	schedule_id		int,
	primary key(subject_id,schedule_id)
)


--users
alter table users
ADD CONSTRAINT FK_users_faculty FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id)

select*from users

--subjects
ALTER TABLE subjects
ADD CONSTRAINT FK_subjects_faculty FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id);

--class
ALTER TABLE class
ADD CONSTRAINT FK_class_faculty FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id)


--schedule
ALTER TABLE schedule
ADD CONSTRAINT FK_schedule_subject FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)

ALTER TABLE schedule
ADD CONSTRAINT FK_schedule_lecturer FOREIGN KEY (lecturer_id) REFERENCES users(users_id)


ALTER TABLE schedule
ADD CONSTRAINT FK_schedule_classroom FOREIGN KEY (classroom_id) REFERENCES classroom(classroom_id)

--enrollment
ALTER TABLE enrollment
ADD CONSTRAINT FK_enrollment_student FOREIGN KEY (student_id) REFERENCES users(users_id);

ALTER TABLE enrollment
ADD CONSTRAINT FK_enrollment_subject FOREIGN KEY (subject_id) REFERENCES subjects(subject_id);

ALTER TABLE enrollment
ADD CONSTRAINT FK_enrollment_semester FOREIGN KEY (semester_id) REFERENCES semester(semester_id);

--grades
ALTER TABLE grades
ADD CONSTRAINT FK_grades_student FOREIGN KEY (student_id) REFERENCES users(users_id);

ALTER TABLE grades
ADD CONSTRAINT FK_grades_subject FOREIGN KEY (subject_id) REFERENCES subjects(subject_id);

ALTER TABLE grades
ADD CONSTRAINT FK_grades_semester FOREIGN KEY (semester_id) REFERENCES semester(semester_id);

alter table grades
drop constraint FK_grades_subject

alter table grades
drop constraint FK_grades_student

alter table grades
drop constraint FK_grades_semester

drop table grades

--subjects_grades
ALTER TABLE subjects_grades
ADD CONSTRAINT FK_subjects_grades_student FOREIGN KEY (student_id) REFERENCES users(users_id);

ALTER TABLE subjects_grades
ADD CONSTRAINT FK_subjects_grades_grade FOREIGN KEY (grade_id) REFERENCES grades(grade_id);

alter table subjects_grades
drop constraint FK_subjects_grades_grade



--student_subjects
ALTER TABLE student_subjects
ADD CONSTRAINT FK_student_subjects_student FOREIGN KEY (student_id) REFERENCES users(users_id);

ALTER TABLE student_subjects
ADD CONSTRAINT FK_student_subjects_subject FOREIGN KEY (subject_id) REFERENCES subjects(subject_id);

--subjects_schedule
ALTER TABLE subjects_schedule
ADD CONSTRAINT FK_subjects_schedule_subject FOREIGN KEY (subject_id) REFERENCES subjects(subject_id);

ALTER TABLE subjects_schedule
ADD CONSTRAINT FK_subjects_schedule_schedule FOREIGN KEY (schedule_id) REFERENCES schedule(schedule_id);

--sutdent_class
alter table student_class
add constraint FK_student_class_users foreign key (student_id) references users(users_id)

alter table student_class
add constraint FK_student_class_class foreign key (class_id) references class(class_id)


alter table student_class drop constraint FK_student_class_users

alter table student_class drop constraint FK_student_class_class

drop table student_class

--lecturer_class

alter table lecturer_class
add constraint FK_lecturer_class_users foreign key (lecturer_id) references users(users_id)

alter table lecturer_class drop constraint FK_lecturer_class_users

alter table lecturer_class drop constraint FK_lecturer_class_class

drop table lecturer_class

alter table lecturer_class
add constraint FK_lecturer_class_class foreign key (class_id) references class(class_id)


select * from faculty
--insert faculty
INSERT INTO faculty (faculty_name)
VALUES
    ('Faculty A'),
    ('Faculty B'),
    ('Faculty C'),
    ('Faculty D'),
    ('Faculty E'),
    ('Faculty F');


--insert class

drop table class

select * from class
INSERT INTO class (class_name, faculty_id)
VALUES
    ('Class A1', 1),
    ('Class A2', 1),
    ('Class B1', 2),
    ('Class B2', 2),
    ('Class C1', 3),
    ('Class C2', 3),
    ('Class D1', 4),
    ('Class D2', 4),
    ('Class E1', 5),
    ('Class E2', 5)


	select * from users


	drop table users

	--insert users
INSERT INTO users (username, password, name, birthday, addrezz, email, phone_number, role, faculty_id, class_id)
VALUES
    ('user1', 'password1', 'User One', '2000-01-01', 'Address One', 'user1@example.com', '123456789', 1, 1, 2),
    ('user2', 'password2', 'User Two', '1999-02-02', 'Address Two', 'user2@example.com', '987654321', 2, 2, 4),
    ('user3', 'password3', 'User Three', '1998-03-03', 'Address Three', 'user3@example.com', '456789123', 1, 3, 6),
    ('user4', 'password4', 'User Four', '1997-04-04', 'Address Four', 'user4@example.com', '654123789', 2, 4, 5),
    ('user5', 'password5', 'User Five', '1996-05-05', 'Address Five', 'user5@example.com', '321789456', 1, 5, 3),
    ('user6', 'password6', 'User Six', '1995-06-06', 'Address Six', 'user6@example.com', '111111111', 2, 2, 1),
    ('user7', 'password7', 'User Seven', '1994-07-07', 'Address Seven', 'user7@example.com', '222222222', 1, 1, 4),
    ('user8', 'password8', 'User Eight', '1993-08-08', 'Address Eight', 'user8@example.com', '333333333', 2, 3, 2),
    ('user9', 'password9', 'User Nine', '1992-09-09', 'Address Nine', 'user9@example.com', '444444444', 1, 4, 5),
    ('user10', 'password10', 'User Ten', '1991-10-10', 'Address Ten', 'user10@example.com', '555555555', 2, 5, 6),
    ('user11', 'password11', 'User Eleven', '1990-11-11', 'Address Eleven', 'user11@example.com', '666666666', 1, 3, 3),
    ('user12', 'password12', 'User Twelve', '1989-12-12', 'Address Twelve', 'user12@example.com', '777777777', 2, 2, 4),
    ('user13', 'password13', 'User Thirteen', '1988-01-01', 'Address Thirteen', 'user13@example.com', '888888888', 1, 1, 1),
    ('user14', 'password14', 'User Fourteen', '1987-02-02', 'Address Fourteen', 'user14@example.com', '999999999', 2, 4, 2),
    ('user15', 'password15', 'User Fifteen', '1986-03-03', 'Address Fifteen', 'user15@example.com', '101010101', 1, 5, 3),
    ('user16', 'password16', 'User Sixteen', '1985-04-04', 'Address Sixteen', 'user16@example.com', '11112222333', 2, 3, 4),
    ('user17', 'password17', 'User Seventeen', '1984-05-05', 'Address Seventeen', 'user17@example.com', '44443333222', 1, 2, 5),
    ('user18', 'password18', 'User Eighteen', '1983-06-06', 'Address Eighteen', 'user18@example.com', '11119999888', 2, 1, 6),
    ('user19', 'password19', 'User Nineteen', '1982-07-07', 'Address Nineteen', 'user19@example.com', '00009999888', 1, 3, 1);

 --admin
INSERT INTO users (username, password, name, birthday, addrezz, email, phone_number, role, faculty_id, class_id)
VALUES
    ('admin', 'adminpassword', 'Admin', '1980-01-01', 'Admin Address', 'admin@example.com', '9999999999', 3, 1, 2);


--subject
INSERT INTO subjects (subject_name, describe, credit_hour, faculty_id)
VALUES
    ('Subject A', 'Description for Subject A', 3, 1),
    ('Subject B', 'Description for Subject B', 4, 2),
    ('Subject C', 'Description for Subject C', 3, 3),
    ('Subject D', 'Description for Subject D', 2, 1),
    ('Subject E', 'Description for Subject E', 3, 2),
    ('Subject F', 'Description for Subject F', 4, 3),
    ('Subject G', 'Description for Subject G', 3, 1),
    ('Subject H', 'Description for Subject H', 2, 2),
    ('Subject I', 'Description for Subject I', 3, 3),
    ('Subject J', 'Description for Subject J', 4, 1);


--classroom

INSERT INTO classroom (classroom_name)
VALUES
    ('Classroom 101'),
    ('Classroom 102'),
    ('Classroom 103'),
    ('Classroom 104'),
    ('Classroom 105'),
    ('Classroom 106'),
    ('Classroom 107'),
    ('Classroom 108'),
    ('Classroom 109'),
    ('Classroom 110');


	--schedule
	INSERT INTO schedule (subject_id, lecturer_id, classroom_id, start_time, end_time)
VALUES
    (1, 1, 1, '07/10/2024 08:00:00', '07/10/2024 10:00:00'),
    (2, 2, 2, '07/11/2024 09:00:00', '07/11/2024 11:00:00'),
    (3, 3, 3, '07/12/2024 10:00:00', '07/12/2024 12:00:00'),
    (4, 1, 4, '07/13/2024 11:00:00', '07/13/2024 13:00:00'),
    (5, 2, 5, '07/14/2024 12:00:00', '07/14/2024 14:00:00'),
    (6, 3, 6, '07/15/2024 13:00:00', '07/15/2024 15:00:00'),
    (7, 1, 7, '07/16/2024 14:00:00', '07/16/2024 16:00:00'),
    (8, 2, 8, '07/17/2024 15:00:00', '07/17/2024 17:00:00'),
    (9, 3, 9, '07/18/2024 16:00:00', '07/18/2024 18:00:00'),
    (10, 1, 10, '07/19/2024 17:00:00', '07/19/2024 19:00:00');


	--semester
	INSERT INTO semester (semester_name)
VALUES
    ('Học kỳ 1'),
    ('Học kỳ 2'),
    ('Học kỳ 3');



	--enrollment
	INSERT INTO enrollment (student_id, subject_id, semester_id)
VALUES
    (1, 1, 1),
    (2, 2, 1),
    (3, 3, 2),
    (4, 4, 2),
    (5, 5, 3),
    (6, 6, 3),
    (7, 7, 1),
    (8, 8, 2),
    (9, 9, 3),
    (10, 10, 1);



	--grade

	INSERT INTO grades (student_id, subject_id, grade1, semester_id, academic_year)
VALUES
    (1, 1, 8.5, 1, 2023),
    (2, 2, 7.9, 1, 2023),
    (3, 3, 6.5, 2, 2023),
    (4, 4, 9.2, 2, 2023),
    (5, 5, 7.1, 3, 2023),
    (6, 6, 8.3, 3, 2023),
    (7, 7, 6.8, 1, 2023),
    (8, 8, 9.0, 2, 2023),
    (9, 9, 8.7, 3, 2023),
    (10, 10, 7.5, 1, 2023),
    (1, 2, 8.0, 1, 2024),
    (2, 3, 7.7, 1, 2024),
    (3, 4, 9.5, 2, 2024),
    (4, 5, 6.9, 2, 2024),
    (5, 6, 8.1, 3, 2024),
    (6, 7, 7.2, 3, 2024),
    (7, 8, 9.3, 1, 2024),
    (8, 9, 8.8, 2, 2024),
    (9, 10, 7.4, 3, 2024),
    (10, 1, 8.2, 1, 2024);



INSERT INTO grades (student_id, subject_id, grade1, semester_id, academic_year)
VALUES
    (1, 6, 8.5, 2, 2023),
    (1, 2, 7.9, 3, 2023)

--select class idclass nameclass lecturer-name 

select u.class_id, c.class_name, u.name from class c join users u on c.class_id=u.class_id where u.role = 2

select * from users where role=2

select * from class