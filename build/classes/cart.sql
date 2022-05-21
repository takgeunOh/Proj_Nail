drop table cartlist;

create table cartlist(
	cartnum number primary key,
	movienum number default 0,
	dramanum number default 0,
	title varchar2(100) not null,
	content varchar2(1000) not null,
	productprice number not null,

	constraint fk_movienum foreign key(movienum)
	references movietable(movienum) on delete cascade
);

drop sequence cartlist_seq;
create sequence cartlist_seq;

commit