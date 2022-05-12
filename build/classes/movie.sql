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
	movietable_seq.nextval, '액션', '어벤져스 엔드게임', '줄거리줄거리가나다라', '가나다', 2019, 5000, '미국','마블', 0, 0, 0
);

insert into movietable values (
	movietable_seq.nextval, '역사', '덩케르크', '줄거리줄거리가나다라2', '놀란', 2017, 5000, '미국','회사2', 0, 0, 12
);

insert into movietable values (
	movietable_seq.nextval, '장르3', '제목3', '줄거리줄거리가나다라asdf', '감독3', 1992, 3000, '국적4','회사7', 0, 0, 0
);

insert into movietable values (
	movietable_seq.nextval, '장르5', '제목4', '줄거리나다라asdf', '감독', 1984, 3000, '국적2','회사3', 0, 0, 0
);