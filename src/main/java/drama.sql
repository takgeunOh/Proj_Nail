drop table dramatable;

create table dramatable(
dramaNum Number Not NUll,
dramaGenre varchar(20) Not NUll,
dramaTitle varchar(30) Not NUll,
dramaContent varchar(500) Not NUll,
dramaDirector varchar(20) Not NUll,
dramaYear number Not NUll,
dramaPrice varchar(10) Not NUll,
dramaCountry varchar(10) Not NUll,
dramaCompany varchar(20) Not NUll,
dramaLikeCnt number Not NUll,
dramaHide number Not NUll,
dramaAge number Not NUll
);

drop sequence dramatable_seq;
create sequence dramatable_seq;

insert into dramatable values (
	dramatable_seq.nextval, '액션', '드라마', '가나다라줄거리', '김', 2019, 5000, '미국','회사', 0, 0, 0
);
insert into dramatable values (
	dramatable_seq.nextval, '코미디', '드라마2', '가줄거리', '아무나', 2015, 5000, '미국','회사', 0, 0, 0
);
insert into dramatable values (
	dramatable_seq.nextval, '수사', '드라마3', '가나다라마바줄거리', '김기믹ㅁ', 2009, 5000, '미국','회사', 0, 0, 0
);
insert into dramatable values (
	dramatable_seq.nextval, '스포츠', '드라마4', '가나다라마바줄거리', '모름', 2010, 5000, '미국','회사', 0, 0, 0
);