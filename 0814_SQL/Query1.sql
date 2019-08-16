create database TestDB;

use testdb;
-- 데이터 타입의 종류 3가지 : 문자형, 숫자형, 날짜형 
create table sample(id int, title char(100), contentsample varchar(1000));

show databases;
show tables;
desc sample;

insert into sample(id, title, content) values(1, 'title1', 'content1');
insert into sample(id, title, content) values(2, 'title2', 'content2');
insert into sample(id, title, content) values(3, 'title3', 'content3');

select id, title, content from sample;

update sample set title ='kwangju' where id =3;

delete from sample where id=2;

drop table sample;