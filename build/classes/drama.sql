drop table dramatable;

create table dramatable(
dramaNum Number default 0 primary key,
dramaGenre varchar(50),
dramaTitle varchar(100),
dramaContent varchar(100),
dramaDirector varchar(40),
dramaYear varchar(20),
dramaPrice number,
dramaCountry varchar(50),
dramaCompany varchar(50),
dramaLikeCnt number,
dramaHide number,
dramaAge number
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
commit