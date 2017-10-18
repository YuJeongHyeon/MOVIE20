
--------- CREATE Table Query ---------------------------

---- member Table 관련 -----------------
CREATE TABLE semi_member(
	id                  VARCHAR2(100)  PRIMARY KEY ,
	name                  VARCHAR2(100)  NOT NULL ,
	password              VARCHAR2(100)  NOT NULL ,
	nick                  VARCHAR2(100)  NOT NULL ,
	address               VARCHAR2(100)  NOT NULL ,
	birth                 DATE  NOT NULL ,
	tel                   VARCHAR2(100)  NOT NULL ,
	favoriteGenre         VARCHAR2(100)  NOT NULL ,
	authority             VARCHAR2(100)  NOT NULL 
);

SELECT * FROM semi_member;
DROP TABLE semi_member;

---- movie Table 관련 -----------------
CREATE TABLE semi_movie(
	mNo                  NUMBER  PRIMARY KEY ,
	title                 VARCHAR2(100)  NOT NULL ,
	playdate              DATE  NOT NULL ,
	character             VARCHAR2(100)  NOT NULL ,
	director              VARCHAR2(100)  NOT NULL ,
	genre                 VARCHAR2(100)  NOT NULL ,
	summary               CLOB  NOT NULL ,
	runtime               VARCHAR2(100)  NOT NULL ,
	viewingcheck          VARCHAR2(100)  NOT NULL ,
	hits                  NUMBER DEFAULT 0,
	grade                 NUMBER  NOT NULL ,
	picture 			VARCHAR2(100) NOT NULL ,
	id                    VARCHAR2(100)  NOT NULL,
	CONSTRAINT semi_movie_id_fk FOREIGN KEY(id) REFERENCES semi_member(id)
);

SELECT * FROM semi_movie;
DROP TABLE semi_movie;

DROP sequence semi_movie_seq;
CREATE sequence semi_movie_seq nocache;
---- notice Table 관련 -----------------
CREATE TABLE semi_notice(
	nNo                  NUMBER PRIMARY KEY ,
	title                 VARCHAR2(100)  NOT NULL ,
	content             CLOB  NOT NULL ,
	regdate               DATE  NOT NULL ,
	hits                  NUMBER  DEFAULT 0 ,
	important			VARCHAR2(100)  NOT NULL,
	id                    VARCHAR2(100)  NOT NULL,
	CONSTRAINT semi_notice_id_fk FOREIGN KEY(id) REFERENCES semi_member(id)
);
SELECT * FROM semi_notice;
DROP TABLE semi_notice;

DROP sequence semi_notice_seq;
CREATE sequence semi_notice_seq nocache;
---- review Table 관련 -----------------
CREATE TABLE semi_review(
	rNo                  NUMBER  PRIMARY KEY ,
	content            CLOB NOT NULL ,
	regdate               DATE  NOT NULL ,
	title                 VARCHAR2(100)  NOT NULL ,
	hits                  NUMBER  DEFAULT 0 ,
	mNo                   NUMBER   NOT NULL ,
	CONSTRAINT semi_review_m_no_fk FOREIGN KEY(mNo) REFERENCES semi_movie(mNo),
	id                    VARCHAR2(100)  NOT NULL,
	CONSTRAINT semi_review_id_fk FOREIGN KEY(id) REFERENCES semi_member(id) 
);

SELECT * FROM semi_review;
DROP TABLE semi_review;

DROP sequence semi_review_seq;
CREATE sequence semi_review_seq nocache;

insert into semi_review(rno,title,content,regdate,mno,id) 
values(semi_review_seq.nextval,'바보 배승찬2','바보래요!!!',sysdate,2,'jquery')



---- score Table 관련 -----------------
CREATE TABLE semi_score
(
	id                    VARCHAR2(100)  ,
	mNo                  NUMBER  ,
	score                 NUMBER  default -1 ,
	PRIMARY KEY(id, mNo),
    FOREIGN KEY(id) REFERENCES semi_member(id),
    FOREIGN KEY(mNo) REFERENCES semi_movie(mNo)
);

SELECT * FROM semi_score;
DROP TABLE semi_score;

---- semi_seat Table 관련 -----------------
CREATE TABLE semi_seat
(
	meetingDate           VARCHAR2(100) NOT NULL,
	FOREIGN KEY(meetingDate) REFERENCES semi_meeting(meetingDate),
	seatNum               VARCHAR2(100) default '0',
	id                    VARCHAR2(100)  ,
	FOREIGN KEY(id) REFERENCES semi_member(id)
);
SELECT * FROM semi_seat;
DROP TABLE semi_seat;

--DROP sequence semi_seat_seq;
--CREATE sequence semi_seat_seq nocache;
--------meeting table 관련----------------
CREATE TABLE semi_meeting
(
	meetingDate           VARCHAR2(100)  primary key ,
	mNo                  NUMBER not null  ,
	FOREIGN KEY(mNo) REFERENCES semi_movie(mNo),
	location 	varchar2(100) default '미정'
);

SELECT * FROM semi_meeting;
DROP TABLE semi_meeting;
---- comment Table 관련 -----------------

CREATE TABLE semi_comment
(
	cNo                  NUMBER  primary key ,
	content               VARCHAR2(100) NOT NULL ,
	writeTime             DATE NOT NULL ,
	id                    VARCHAR2(100)  NOT NULL ,
	FOREIGN KEY(id) REFERENCES semi_member(id),
	rNo                  NUMBER  NOT NULL ,
	FOREIGN KEY(rNo) REFERENCES semi_review(rNo)
);
SELECT * FROM semi_comment;
DROP TABLE semi_comment;

DROP sequence semi_comment_seq;
CREATE sequence semi_comment_seq nocache;

--E N D ----- CREATE Table Query   -----------------------


-- Member 추가 ---
insert into semi_member(id, name, password, nick, address, birth, tel, favoriteGenre, authority) 
values('java7', '배승찬7', '1234', '배찬', '동탄', '1989.01.07', '017', '로맨스', '일반'); 

insert into semi_member(id, name, password, nick, address, birth, tel, favoriteGenre, authority) 
values('jquery', '한송희', '3456', '송히', '남양주', '1994.01.01', '016', '액션', '일반'); 

insert into semi_member(id, name, password, nick, address, birth, tel, favoriteGenre, authority) 
values('a', '진영훈', '6', '후니', '야탑', '1990.01.02', '012', '공포', '관리자'); 

select * from semi_member;





-- Movie List 추가 ---
insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'타이타닉', '1998.02.20', '레오나르도 디카프리오, 케이트 윈슬렛', '제임스 카메론', '19', 
'1912년 북대서양의 차가운 바닷물 속에서 당대 꿈의 배라고 불렸던 타이타닉 호가 탐사대들에 의해 세상에 발견되면서 오랫동안 감춰져 있던 비극적인 스토리가 세상에 알려지게 된다. 
 17세기 엄격한 사회 질서에 숨막혀 하는 미국 상류층 로즈(케이트 윈슬렛)는 사교계의 굴레에서 벗어나지 못하는 어머니와 권위적인 재벌 귀족 약혼자와 함께 미국으로 향하는 타이타닉 호 1등실에 승선한다. 배가 출발하기 전 부두의 선술집에서 도박으로 운 좋게 타이타닉호의 3등실 티켓을 얻은 가난한 화가 잭(레오나르도 디카프리오) 역시 아슬아슬하게 배에 승선한다. 
 첫 눈에 1등실의 로즈에게 반한 잭은 갑판에서 우연히 바다로 몸을 던지려 하는 로즈를 발견하고 재치 있는 언변과 행동으로 그녀의 생명을 구한다. 이 사건을 계기로 1등실의 저녁식사에 초대받게 되고 서로에게 끌리는 자신들을 발견한다. 이후 그들의 금지된 사랑은 아무도 상상하지 못했던 타이타닉호 침몰조차 갈라 놓을 수 없었던 세기의 로맨스가 된다.', 
 '195분', 'no', 23, '15' ,'타이타닉.jpg' ,'a');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, grade, picture, id) 
values(semi_movie_seq.nextval, '아바타', '2009.12.17', '샘 워싱턴, 조 샐다나, 시고니 위버', '제임스 카메론', '액션', 
'가까운 미래, 지구는 에너지 고갈 문제를 해결하기 위해 머나먼 행성 판도라에서 대체 자원을 채굴하기 시작한다.
하지만 판도라의 독성을 지닌 대기로 인해 자원 획득에 어려움을 겪게 된 인류는 판도라의 토착민 ‘나비(Na’vi)’의 외형에 인간의 의식을 주입,
원격 조종이 가능한 새로운 생명체 ‘아바타’를 탄생시키는 프로그램을 개발한다.
한편, 하반신이 마비된 전직 해병대원 ‘제이크 설리(샘 워딩튼)’는 ‘아바타 프로그램’에 참가할 것을 제안 받아 판도라에 위치한 인간 주둔 기지로 향한다.
그 곳에서 자신의 ‘아바타’를 통해 자유롭게 걸을 수 있게 된 ‘제이크’는 자원 채굴을 막으려는 ‘나비(Na’vi)’의 무리에 침투하라는 임무를 부여 받는다.
임무 수행 중 ‘나비(Na’vi)’의 여전사 ‘네이티리(조 샐다나)’를 만난 ‘제이크’는 그녀와 함께 다채로운 모험을 경험하면서 ‘네이티리’를 사랑하게 되고,
‘나비(Na’vi)’들과 하나가 되어간다. 하지만 머지 않아 전 우주의 운명을 결정 짓는 대규모 전투가 시작되면서 ‘제이크’는 최후의 시험대에 오르게 되는데….
행성 판도라와 지구의 피할 수 없는 전쟁! 이 모든 운명을 손에 쥔 제이크의 선택은?', '162분	', 'no', '12' ,'아바타.jpg' ,'a');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, grade, picture, id) 
values(semi_movie_seq.nextval, '캐롤', '2016 .02.04', '케이트 블란쳇, 루니 마라, 카일 챈들러', '토드 헤인즈', '로맨스', 
'1950년대 뉴욕, 맨해튼 백화점 점원인 테레즈(루니 마라)와 손님으로 찾아온 캐롤(케이트 블란쳇)은 
 처음 만난 순간부터 거부할 수 없는 강한 끌림을 느낀다. 
 하나뿐인 딸을 두고 이혼 소송 중인 캐롤과 헌신적인 남자친구가 있지만 확신이 없던 테레즈, 
 각자의 상황을 잊을 만큼 통제할 수 없이 서로에게 빠져드는 감정의 혼란 속에서 둘은 확신하게 된다. 
 인생의 마지막에, 그리고 처음으로 찾아온 진짜 사랑임을…', '118분', 'no', '19', '캐롤.jpg' ,'a');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'다크나이트', '2008.08.06', '크리스찬 베일, 히스 레저', '크리스토퍼 놀란', '액션', '어둠의 기사 배트맨 VS 절대 악 조커
운명을 건 최후의 결전이 시작된다!
정의로운 지방 검사 ‘하비 덴트’, ‘짐 고든’ 반장과 함께 범죄 소탕 작전을 펼치며
 범죄와 부패로 들끓는 고담시를 지켜나가는 ‘배트맨’
 
 그러던 어느 날, 살아남기 위해 발버둥치던 범죄 조직은 배트맨을 제거하기 위해
 광기어린 악당 ‘조커’를 끌어들이고
 정체를 알 수 없는 조커의 등장에 고담시 전체가 깊은 혼돈 속으로 빠져든다.
 
 급기야 배트맨을 향한 강한 집착을 드러낸 조커는
 그가 시민들 앞에 정체를 밝힐 때까지 매일 새로운 사람들을 죽이겠다 선포하고
 배트맨은 사상 최악의 악당 조커를 막기 위해 자신의 모든 것을 내던진 마지막 대결을 준비한다.', '152분', 'no', 10, '15','다크나이트.jpg' ,'a');


 
-- review 추가


select count(*) from SEMI_MOVIE where title like '%타%'; 
 
 
 select* from semi_movie;
 delete from SEMI_MOVIE;
 
 select title, picture from semi_movie order by hits desc;
   

 SELECT hits, picture
 FROM (select row_number() over(order by mNo desc) as rnum, hits, picture from semi_movie) semi_movie
 WHERE rnum between 1 and 5
 ORDER BY hits DESC

select rNo,content,regdate,title,hits,mNo,id from semi_review where mNo=2 and rNo between 1 and 1



insert into SEMI_NOTICE(nNo,title,content,regdate,id)
values(SEMI_NOTICE_seq.nextval,'123','123',sysdate,'a');


select nNo,regdate,id
from SEMI_NOTICE where nNo=SEMI_NOTICE_seq.currval ;


insert into SEMI_NOTICE(nNo,title,content,regdate,id)
values(SEMI_NOTICE_seq.nextval,'123','123',sysdate,'a'); 

select nNo,regdate,id from SEMI_NOTICE where nNo=SEMI_NOTICE_seq.currval

select count(*) FROM semi_member WHERE id='sdf'


select * 
from( 
SELECT	row_number() over(order by mNo desc) as rnum, 
mNo, title, to_char(playdate,'YYYY.MM.DD') as playdate, character, director, genre, runtime, viewingcheck, grade, picture  
FROM semi_movie 
where title like '%다%'
) 
where rnum between 1 and 4
order by mNo desc

select count(*) from SEMI_MOVIE where title like '%아%'
----------------------------------------
-- 1017 2244 광태 쿼리 -------
insert into SEMI_MEETING(meetingDate, mNo,location) 
values('2017-10-31',3,'고릴라 볼링장');
--seat Num추가
insert into SEMI_SEAT(seatNum) values(25);
select seatNum, id from SEMI_SEAT

-- meeting list info 쿼리
select me.meetingDate, me.location, mv.mNo, mv.title, mv.runtime, mv.picture 
FROM SEMI_MEETING me, SEMI_MOVIE mv 
WHERE me.mNo = mv.mNo;

<<<<<<< HEAD
SELECT * FROM tab;
select * from semi_meeting
-- 좌석 등록
select * from semi_seat
insert into semi_seat(meetingdate,seatNum,id) 
values('2017-10-30','4','java')
=======
select mno,title from SEMI_MOVIE
>>>>>>> branch 'master' of https://github.com/YuJeongHyeon/MOVIE20.git

<<<<<<< HEAD
update semi_seat set seatNum = '10' 
WHERE meetingdate = '2017-10-30' and id = 'java'
-- meeting data 조회
select seatNum from semi_seat WHERE meetingDate = '2017-10-30' and id='java'
------- end 광태 쿼리----------------
select count(*) from semi_notice
=======
insert into semi_review(rno,title,content,regdate,mno,id) 
values(semi_review_seq.nextval,'바보 배승찬2','바보래요!!!',sysdate,6,'jquery')

insert into SEMI_COMMENT(cno,content,writetime,id,rno)
values(semi_comment_seq.nextval,'코코멘트',sysdate,'jquery',30)

update semi_comment set content='코파는 승차니' where cNo=4

insert into semi_comment(cno,content,writetime,id,rno)
values(semi_review_seq.nextval,'앙 승쨩찡',sysdate,'a',6)

select count(*) from semi_review where mno=2

select * from(select row_number() over(order by rNo desc)
as rnum,rNo,content,regdate,title,hits,mno,id
from semi_review where mno=2)		
where mno=2 and rnum between 1 and 5
ORDER BY rNo DESC
>>>>>>> branch 'master' of https://github.com/YuJeongHyeon/MOVIE20.git
