create table member (
	userNum number primary key,
	userName varchar2(50) not null,
	userEmail varchar2(100) not null,
	userPhone varchar2(30) not null,
	userPassword varchar2(70) not null,
	userRegidate date default sysdate not null,
	usertype number not null
);

create sequence member_seq;