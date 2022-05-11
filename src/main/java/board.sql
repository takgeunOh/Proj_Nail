drop table movieboard;

create table movieboard (
	boardNum number primary key,
	boardAuthor VARCHAR2(20) not null,
	boardTitle VARCHAR2(40) not null,
	boardContent VARCHAR2(3000) not null,
	boardPassword VARCHAR2(20) not null,
	boardRegidate date default sysdate,
	boardViewCnt number default 0 not null,
	boardLikeCnt number not null,
	boardRepRoot  NUMBER(4),
    boardRepStep  NUMBER(4),
    boardRepIndent NUMBER(4)
);

drop sequence movieboard_seq;
create sequence movieboard_seq;

insert into movieboard values (
	movieboard_seq.nextval, 'takgeun', '더미데이터1', '더미데이터1더미데이터1더미데이터1더미데이터1', '1234', sysdate, 0, 0, 0, 0, 0
);
	
insert into movieboard values (
	movieboard_seq.nextval, 'takgeun2', '더미데이터2', '더미데이터2더미데이터2더미데이터2더미데이터2', '1234', sysdate, 0, 0, 0, 0, 0
);

insert into movieboard values (
	movieboard_seq.nextval, 'takgeun3', '더미데이터3', '더미데이터3더미데이터3더미데이터3더미데이터3', '1234', sysdate, 0, 0, 0, 0, 0
);

insert into movieboard values (
	movieboard_seq.nextval, 'takgeun4', '더미데이터4', '더미데이터4더미데이터4더미데이터4더미데이터4', '1234', sysdate, 0, 0, 0, 0, 0
);


create table feedbackboard (
	num number primary key,
	author VARCHAR2(20) not null,
	title VARCHAR2(40) not null,
	content VARCHAR2(3000) not null,
	password VARCHAR2(20) not null,
	regidate date default sysdate,
	viewcnt number default 0 not null,
	repauthor VARCHAR2(20) not null,
	repcontent VARCHAR2(3000)
);

create sequence feedback_seq;

insert into feedbackboard values (
	feedback_seq.nextval, 'takgeun1', '더미데이터제목1', '더미데이터내용1', '1234', sysdate, 0, '상담원원', '더미데이터 답변1'
);

insert into feedbackboard values (
	feedback_seq.nextval, 'takgeun2', '더미데이터제목2', '더미데이터내용2', '1234', sysdate, 0, '상담원투', '더미데이터 답변2'
);


