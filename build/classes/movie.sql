drop table movietable;

create table movietable(
movieNum Number default 0 primary key,
movieGenre varchar(50),
movieTitle varchar(100),
movieContent varchar(1000),
movieDirector varchar(40),
movieYear varchar(20),
moviePrice number,
movieCountry varchar(50),
movieCompany varchar(50),
movieLikeCnt number,
movieHide number,
movieAge number
);

drop sequence movietable_seq;
create sequence movietable_seq;

insert into movietable values (
   movietable_seq.nextval, '액션', '어벤져스 엔드게임', '클린트는 딸에게 활을 쏘는 법을 가르쳐 주며 가족들과 단란한 시간을 보내고 있다. 그런데 점심을 먹으려고 화살을 챙기고 뒤를 돌아본 순간 가족들은 온데간데 없어졌고 그들이 있던 자리에는 먼지만 휘날리고 있다. 홀로 애타게 가족들의 이름을 부르짖는 클린트를 뒤로하며 마블 스튜디오의 프로덕션 로고가 등장한다.', '가나다', '2019', 5000, '미국','마블', 0, 0, 0
);

insert into movietable values (
   movietable_seq.nextval, '역사', '덩케르크', '잔교, 바다, 하늘에서 각각 토미 일행, 문스톤 호, 파리어가 됭케르크에 머물렀던 일주일, 하루, 한 시간이 시간 순서에 상관없이 교차 진행되어 뒤섞인다.', '놀란', '2017', 5000, '미국','워너브라더스 픽처스', 0, 0, 12
);

insert into movietable values (
   movietable_seq.nextval, '액션', '범죄도시2', '“느낌 오지? 이 놈 잡아야 하는 거”

가리봉동 소탕작전 후 4년 뒤,
금천서 강력반은 베트남으로 도주한 용의자를 인도받아 오라는 미션을 받는다.

괴물형사 ‘마석도’(마동석)와 ‘전일만’(최귀화) 반장은 현지 용의자에게서 수상함을 느끼고,
그의 뒤에 무자비한 악행을 벌이는 ‘강해상’(손석구)이 있음을 알게 된다.

‘마석도’와 금천서 강력반은 한국과 베트남을 오가며
 역대급 범죄를 저지르는 ‘강해상’을 본격적으로 쫓기 시작하는데...

나쁜 놈들 잡는 데 국경 없다!
통쾌하고 화끈한 범죄 소탕 작전이 다시 펼쳐진다! ', '이상용', '2022', 3000, '한국','㈜에이비오엔터테인먼트', 0, 0, 0
);

insert into movietable values (
   movietable_seq.nextval, '액션, 애니메이션', '배드 가이즈', '드림웍스 최초의 범죄오락액션 블록버스터!
어디 착한 짓 좀 해볼까?

작전 설계부터 금고 해제, 해킹, 액션, 위장까지 
완벽한 팀플레이를 펼치는 자타공인 최고의 나쁜 녀석들이 한순간의 실수로 체포된다. 

하지만 그들도 착해질 수 있다는 ‘마멀레이드 박사’의 주장으로
나쁜 녀석들은 바른 생활 갓생 프로젝트에 투입되고, 
이들은 다시 한번 자유의 몸을 위해 태어나 처음으로 바른 생활에 도전하게 되는데… 

나쁜 녀석들의 사상 초유 바른 생활 갓생 프로젝트가 시작된다!', '피에르 페리펠', '2022', 6000, '미국','유니버셜 픽처스', 0, 0, 0
);

commit