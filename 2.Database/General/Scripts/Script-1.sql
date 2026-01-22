--  employees라는 데이터베이스 선택 
use employees;

select emp_no, first_name from employees;
select * from employees;

-- Q1.실습
select emp_no, birth_date from employees;
select hire_date from employees;
select emp_no, from_date, to_date from dept_manager;
select * from departments;

insert into employees
values(1,
		'2000-01-01',
		'jaeseop',
		'kim',
		'M',
		now());

select *from employees;







