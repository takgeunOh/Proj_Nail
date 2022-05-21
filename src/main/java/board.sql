drop table movieboard;

create table movieboard (
	boardNum number primary key,
	boardEmail varchar2(100) not null,
	boardAuthor VARCHAR2(50) not null,
	boardtitle VARCHAR2(100) not null,
	boardcontent VARCHAR2(3000) not null,
	boardregidate date default sysdate,
	boardviewcnt number default 0 not null,
	boardlikecnt number not null,
	boardreproot  NUMBER(4),
    boardrepstep  NUMBER(4),
    boardrepindent NUMBER(4)
);

alter table movieboard add(boardvideoname varchar2(50));

drop sequence movieboard_seq;
create sequence movieboard_seq;

drop table feedbackboard;
create table feedbackboard (
	num number primary key,
	author VARCHAR2(50) not null,
	querytype varchar2(150) not null,
	title VARCHAR2(100) not null,
	content VARCHAR2(3000) not null,
	regidate date default sysdate,
	viewcnt number default 0 not null,
	answercheck number default 1 not null
);

drop sequence feedback_seq;
create sequence feedback_seq
	MINVALUE 1
	MAXVALUE 3
	CYCLE
	CACHE 2;

drop sequence feedbackboard_seq;
create sequence feedbackboard_seq;

commit