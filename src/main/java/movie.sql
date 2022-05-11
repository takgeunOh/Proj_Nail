drop table movietable;

create table movietable(
movieNum Number Not null,
movieGenre varchar(20),
movieTitle varchar(30),
movieContent varchar(500),
movieDirector varchar(20),
movieYear number,
moviePrice varchar(10),
movieCountry varchar(10),
movieCompany varchar(20),
movieLikeCnt number,
movieHide number,
movieAge number
);

drop sequence movietable_seq;
create sequence movietable_seq;

insert into movietable values (
	movietable_seq.nextval, '장르', '제목', '줄거리줄거리가나다라', '감독', 2022, 5000, '국적','회사', 0, 0, 0
);

insert into movietable values (
	movietable_seq.nextval, '장르', '제목2', '줄거리줄거리가나다라2', '감독2', 2022, 5000, '국적2','회사2', 0, 0, 0
);