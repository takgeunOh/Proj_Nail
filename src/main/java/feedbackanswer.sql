drop table feedbackanswer;
create table feedbackanswer (
	num number primary key,
	boardnum number not null,
	author varchar2(50) not null,
	answer varchar2(3000) not null
);

drop sequence feedbackanswer_seq;
create sequence feedbackanswer_seq;

commit