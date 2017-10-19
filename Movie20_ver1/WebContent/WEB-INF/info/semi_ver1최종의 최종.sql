
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

insert into semi_member(id, name, password, nick, address, birth, tel, favoriteGenre, authority) 
values('admin', '관리자0', 'admin0', '관리자0', '종로', '1990.01.01', '0100100000', '로맨스', '관리자'); 

select * from semi_member;








 --------
  insert into semi_movie(mNo, title, playdate, character, director, genre,
summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'공포의 묘지', '1989.10.27','데일일 미드키프, 프레드 그윈','메리 램버트','공포', 
' ',
'115분', 'no', 129, '19' ,'심령의 공포.jpg' ,'admin');
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


SELECT * FROM tab;
select * from semi_meeting
-- 좌석 등록
select * from semi_seat
insert into semi_seat(meetingdate,seatNum,id) 
values('2017-10-30','4','java')

-- 좌석 업데이트
update semi_seat set seatNum = '10' 
WHERE meetingdate = '2017-10-30' and id = 'java'

--좌석 예약 취소
delete semi_seat WHERE id='a' and meetingDate = '2017-10-31' and seatNum = 6;
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
values(semi_review_seq.nextval,'a앙 승쨩찡a',sysdate,'jquery',1)

select count(*) from semi_review where mno=2

select * from(select row_number() over(order by rNo desc)
as rnum,rNo,content,regdate,title,hits,mno,id
from semi_review where mno=2)		
where mno=2 and rnum between 1 and 5
ORDER BY rNo DESC

--------------------------------------------------------------------------------------
----------------------------------- MOVIE LIST INSERT -------------------------------
-------------------------------------------------------------------------------------
-- Movie List 추가 ---
select * from semi_movie
delete from semi_movie;
--공포
insert into semi_movie(mNo, title, playdate, character, director, genre,
summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'공포', '2010.10.10','후지이미나, 카쿠 토모히로','타카하시 히로시', '공포', 
'뇌과학자, 에츠코와 유키오 부부는 전쟁 전 만주에서 촬영된 뇌실험의 모습이 담긴 필름을 보게 된다. 피험자들은 무언가를 응시하고 있다. 그 순간 스크린에 거대한 흰 빛이 나타나고 에츠코와 유키오, 우연히 방에 들어 온 어린 딸 미유키는 빛에 눈을 빼앗긴다. 17년 후, 집단 자살을 시도한 미유키는 에츠코가 경영하는 병원의 격리 병동에서 깨어난다. 필름을 본 후로 비합법적인 뇌수술을 시행하고 있었던 에츠코. 미유키는 에츠코 몰래 격리 병동을 탈출하고 사라진 미유키를 찾던 동생 카오리는 미유키가 자살 시도를 했던 폐가에서 딴사람과 같이 변해 버린 미유키와 만난다. 에츠코는 미유키를 다시 격리 병동으로 데려가고 그들에게 상상을 초월하는 공포가 방문한다. J호러의 산파라고 불린 다카하시 히로시가 전개하는 공포의 수사학에 관한 고찰.', 
 '94분', 'no', 199, '15' ,'공포.jpg' ,'admin');

 insert into semi_movie(mNo, title, playdate, character, director, genre,
summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'심령의 공포', '1990.06.16','바바라 허쉬, 론 실버','시드니J. 퓨리', '공포', 
'두 번의 결혼에 실패한 카알라(Carla Moran: 바바라 허쉬 분)는 세 아이와 함께 LA에 살고 있다. 낮에는 일을 하고 밤에는 더 나은 직장을 얻기 위해 야간 비서학교에서 타이핑을 배운다. 어느 날 늦게 집에 온 카알라는 눈에 보이지 않는 실체로부터 폭행을 당한다. 두번재의 폭행시도가 있던 날 밤엔 아이들을 데리고 가까스로 친구의 집으로 피신해 화를 면한다. 그후로도 보이지 않는 실체는 계속 그녀를 괴롭힌다. 출근길 실체 때문에 교통사고를 낸 카알라는 정신과의사인 스나이더만(Phil Sneiderman: 론 실버 분)의 치료를 받는다. 심령학을 믿지 않는 그는 문제의 원인을 카알라의 성적 피해의식에 의한 자각증상으로 간주한다. 그러나 책방에서 만난 심령심리학자 쿨리 박사(Dr. Cooley: 재클린 스미스 분) 일행은 카알라에게 일어난 초자연적인 현상에 관심을 갖고 관찰하던 중 실체의 존재를 과학적 실험으로 확인한다. 이들은 실체를 고립시킨 후 제거하기 위해 헬리움용액을 사용하는 위험하고도 규모가 큰 실험을 계속한다.',
'115분', 'no', 129, '19' ,'심령의 공포.jpg' ,'admin');

 insert into semi_movie(mNo, title, playdate, character, director, genre,
summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'공포의 묘지', '1989.10.27','데일일 미드키프, 프레드 그윈','메리 램버트','공포', 
'거대한 트럭들만이 무서운 속도로 지나 다니는 한적한 도로변. 이 외딴 곳에 루이스(Louis Creed: 데일 미드키프 분) 일가가 이사오면서부터 공포는 시작된다. 짐을 풀기도 전에 딸 앨리(Ellie Creed: 브라이즈 버달 분)는 집 앞 그네에서 떨어지고, 아들 게이지(Gage Creed: 미코 휴스 분)는 트럭에 치일 뻔하며, 집 앞에는 이상한 분위기의 어디로 통하는지 알 수 없는 작은 오솔길이 있다. 주위의 건물이라고는 애완동물 묘지의 관리인인 크렌들씨((Jud Crandall: 프레드 그윈 분)가 거주하고 있는 관리소 뿐이다. 고양이가 죽자 루이스는 크렌들과 함께 인디언의 묘지에 묻게 된다. 그런데 다음날 고양이가 살아 돌아온다. 하지만 고양이는 전과는 다른 행동을 하는데. ',
'100분', 'no', 109, '19' ,'공포의 묘지.jpg' ,'admin');

insert into semi_movie(mNo, title, playdate, character, director, genre,
summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'공포의 계단', '1993.07.10','브랜던던 퀸틴 애덤스, 에버렛 맥길','웨스 크레이븐','공포', 
' 암으로 투병중인 어머니, 그리고 임신한 누나와 함께 살고 있는 흑인 빈민가 소년 포인덱스터는 어느날 그의 집에 집세 체납을 사유로 한 퇴거 명령서가 날아들자 금화가 가득하다는 건물주의 집을 털기로 작정한다. 그러나 사스 점검원을 가장한 누나친구 리로이와 함께 몰래 침입한 그곳에서 포인덱스터는 계단밑에서 들려오는 지하인간들의 아우성을 듣게 되는데, 그들은 악인은 보지도 듣지도 말하지도 말라는 양부모의 말을 어긴 입양아들로 혀나 팔,다리가 절단된 채 암흑의 세계에서 사육되고 있었다. 공포심에 휩싸인 포인덱스터와 리로이는 탈출을 시도하지만 곧 사태를 눈치챈 집주인의 공격으로 죽음의 위기에 처하고.',
'95분', 'no',129, '19' ,'공포의 계단.jpg' ,'admin');

 insert into semi_movie(mNo, title, playdate, character, director, genre,
summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'쏘우-데스 머신', '2009.09.08','크레이그 맥마혼','크레이그 맥마혼','공포', 
' 결혼을 앞둔 커플 케이드와 제스는 사막에 위치한 폐 공장으로 오게 된다. 그곳은 과거 처참한 살인 사건이 일어났던 곳으로 두 사람을 기다리고 있던 것은 상상을 뛰어넘는 공포였다. ‘수수께끼의 남자’에게 납치된 제스는 공포의 고문 기계에 갇혀 고통을 당한다. 그 자가 케이드에게 요구하는 것은 제스를 구하려면 케이드 자신을 살인 기계로 개조해 찾아오는 사람들을 계속 죽이라는 것이었다. 이렇게 해서 악마의 게임은 시작되는데... 공장을 찾아오는 사람들을 차례차례 피의 희생물로 만드는 케이드, 조금씩 육체를 고문당하며 죽음에 다가가는 제스, 과연 이 지옥에 끝은 있는 것인가...',
'80분', 'no', 123, '19' ,'쏘우-데스 머신.jpg' ,'admin');

  insert into semi_movie(mNo, title, playdate, character, director, genre,
summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'오펀-천사의 비밀', '2009.08.10','베라 파미가, 피터 사스가드','자움 콜렛 세라','공포', 
' "쉿! 비밀을 지켜주세요.
유산으로 세 번째 아이를 잃고 고통 받던 케이트(베라 파미가)와 존(피터 사스가드)은 정상적인 일상을 되찾기 위해 입양을 결심하고 고아원을 찾는다. 거기서 부부는 또래보다 차분하고 영민한 아이 에스터(이사벨 펄먼)의 신비한 느낌에 이끌려 새 가족으로 받아들이고 큰 아들 대니얼(지미 베넷)과 어린 딸 맥스(아리아나 엔지니어)까지 다섯 식구의 행복한 삶을 꿈꾼다.
  하지만 에스터는 외모와 달리 천사 같은 아이가 아니었다. 에스터가 가족이 된 이후부터 아이들은 뭔가 숨기는 듯 두려워하고 에스터의 오래된 성경책 속에서 정체 모를 사진들을 발견한 케이트는 이상한 기운을 느낀다. 어느 날, 에스터를 괴롭혔던 같은 반 친구가 놀이터에서 떨어지는 사고를 당하고 에스터가 범인으로 지목된다. 한편 입양을 주선한 고아원의 원장수녀가 에스터가 수상하다며 찾아왔다가 실종된 후 처참한 모습으로 숨진 채 발견된다.
  에스터를 둘러싼 의문의 사고는 계속되고 대니얼과 맥스까지 위험에 처하게 되자 케이트는 이 아이의 정체에 대한 의문을 품게 된다. 마침내 에스터의 과거를 쫓던 케이트는 생각지도 못했던 충격적인 진실을 알게 되고, 누구도 상상할 수 없는 에스터의 치명적인 비밀은 이제 서서히 가족들을 조여오기 시작하는데…"',
'123분', 'no', 349, '19' ,'오펀-천사의 비밀.jpg' ,'admin'); 

 insert into semi_movie(mNo, title, playdate, character, director, genre,
summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'컨저링', '2013.12.01','베베라 파미가, 패트릭 윌슨','제임스 완','공포', 
'"믿을 수 없겠지만… 이것은 실화다!
1971년 로드 아일랜드, 해리스빌. 페론 가족은 꿈에 그리던 새 집으로 이사를 간다. 물론 1863년에 그 집에서 일어난 끔찍한 살인 사건을 전혀 몰랐다. 또한 그 이후에 일어난 많은 무서운 사건에 대해서도 알지 못했다. 이 가족은 그 집에서 겪은 일이 너무 무서워서 한 마디라도 외부에 언급하는 것을 거절했었다. 지금까지는… " ',
'112분', 'no', 129, '19' ,'컨저링.jpg' ,'admin');

 insert into semi_movie(mNo, title, playdate, character, director, genre,
summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'셔터', '2005.06.30','아난다 에에버링엄, 나타위라눗 통미','팍품 웡품','공포', 
'귀신 찍는 공포의 순간 | 셔터를 누르는 순간, 귀신이 살아난다 | 신화를 창조하는 사람들 | 지금 세계엔, 귀신사진들이 찍히고 있다! | 당신은 지금 <셔터> 충격 미스테리의 현장을 목격하고 있습니다!
25살의 사진작가 턴과 그의 여자친구 제인. 대학동창의 결혼식에 다녀오던 길에 한 여자를 차로 치고 만다. 두려움에 뺑소니를 치고 마는 그들... 다음날, 턴은 자신이 찍은 사진 속에서 형체를 구분하기 어려운 무언가를 발견하기 시작한다. 
 두려움의 원인을 찾아 결국 사고 현장을 다시 찾게 되는 그들. 그러나 그 도로 위에선 어떤 사건 사고도 보고된 바 없다! 점점 더 혼란과 공포 속으로 빠져드는 턴과 제인. 뿐만 아니라 턴의 대학동창들은 하나 둘 의문의 자살을 시작하는데...
  턴과 제인은 의문의 사진들이 찍힌 현장을 찾아 다시 셔터를 누르기 시작한다. 그리고 사진 속 그것이 그들에게 무언가를 말하려 한다는 것을 깨닫게 된다! 그들은 언제나 당신 옆에 있다... 당신이 원하건 원하지 않건 그들은 바로 당신 곁에 서서 당신에게 무언가를 말하고 있다!!! ',
'96분', 'no', 349, '15' ,'셔터.jpg' ,'admin');
-----------------------------공 포 끝


------------------------------로맨스 시작
insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id)  
values(semi_movie_seq.nextval,'라라랜드', '2016.12.07', '라이언고슬링,엠마스톤', '데이미언셔젤', '로맨스', '황홀한 사랑, 순수한 희망, 격렬한 열정… 
이 곳에서 모든 감정이 폭발한다!
꿈을 꾸는 사람들을 위한 별들의 도시 ‘라라랜드’.
 재즈 피아니스트 ‘세바스찬’(라이언 고슬링)과 배우 지망생 ‘미아’(엠마 스톤),
 인생에서 가장 빛나는 순간 만난 두 사람은
 미완성인 서로의 무대를 만들어가기 시작한다.', 
 '127분', 'no', 990, '12','라라랜드.jpg' ,'admin');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id)  
values(semi_movie_seq.nextval,'이터널 선샤인', '2015.11.05', '짐캐리,케이트윈슬렛', '미셸 공드리', '로맨스', '사랑은 그렇게 다시 기억된다..
조엘은 아픈 기억만을 지워준다는 라쿠나사를 찾아가 헤어진 연인 클레멘타인의 기억을 지우기로 결심한다. 
기억이 사라져 갈수록 조엘은 사랑이 시작되던 순간, 행복한 기억들, 가슴 속에 각인된 추억들을 지우기 싫어지기만 하는데... 
당신을 지우면 이 아픔도 사라질까요? 사랑은 그렇게 다시 기억된다.',
'107분', 'no', 760, '15','이터널 선샤인.jpg' ,'admin');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id)  
values(semi_movie_seq.nextval,'말할수 없는 비밀', '2015.05.07', '주걸륜,계륜미', '주걸륜', '로맨스', '나는 너를 사랑해!너도 나를 사랑하니?
 예술학교로 전학 온 상륜(주걸륜)은 아버지의 영향을 받아 피아노에 천부적인 소질을 보인다. 학교를 둘러보던 중, 신비스러운 피아노 연주가 흘러나오는 옛 음악실을 발견하게 되고,
 그곳에서 샤오위(계륜미)를 만난다. 그들은 아름다운 피아노 선율처럼 즐거운 시간을 보내고, 둘 사이에는 애틋한 마음이 싹튼다.
 그러나 상륜이 샤오위를 더 알고 싶어할 때마다 그녀는 비밀이라고 일관하며 의미심장한 미소만 짓는다. 그러던 어느 날, 샤오위는 상륜이 같은 반 여학생 칭요와 뽀뽀하는 모습을 보게 되고, 그의 곁에서 사라지는데…',
'101분', 'no', 650, '12','말할수 없는 비밀.jpg' ,'admin');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id)  
values(semi_movie_seq.nextval,'이프 온리', '2009.01.20', '제니퍼러브휴이트,폴니콜스', '길정거', '로맨스', '사랑을 꿈꾸는 로맨티스트 그녀와 성공을 꿈꾸는 워커홀릭 그. 바이올린을 전공하는 사랑스런 로맨티스트 사만다(제니퍼 러브 휴잇)와 자신의 일에만 몰두하는 성공한 젊은 비즈니스 맨 이안(폴 니콜스). 
둘은 서로를 사랑하지만 사만다는 일만 생각하고 자신은 자신은 뒷전인 이안의 모습에 마음이 아프고, 이안은 자신을 이해해주지 못하는 사만다가 답답하다.
  사만다에겐 졸업연주회, 이안에겐 투자설명회. 오늘은 두 사람 모두에게 중요한 하루이다. 그녀는 그를 위해 선물과 아침식사를 준비하지만, 오늘이 그녀의 졸업연주회 날이라는 것 조차 잊고 있던 그를 보며 사만다는 서운함을 감추지 못한다.
  출근길.. 옷에 쏟은 커피 때문에 집으로 돌아온 사만다는 이안이 중요한 파일을 두고 갔음을 알고 급히 설명회 장소로 향한다. 하지만 그 파일은 단순한 복사본. 갑작스런 그녀의 출현으로 설명회를 망쳤다고 생각한 이안은 사만다의 전화조차 받지 않는다.
  사만다의 졸업 연주회에 가는 길.. 이안은 그녀가 있음을 감사하고 계산 없이 사랑하라 는 택시기사의 충고를 들으며 문득 그녀의 소중함을 깨닫는다. 하지만 졸업연주회가 끝나고 식사를 하던 두 사람은 그 동안의 쌓인 감정들 때문에 말다툼을 하고, 레스토랑에서 뛰쳐나와 혼자 택시를 타고 가던 사만다는 이안이 보는 앞에서 교통사고로 목숨을 잃는다. 
그녀에게 사랑한다는 말 한마디 제대로 해주지 못했던 이안은 그녀의 죽음을 인정할 수 없는데...
  다음 날 아침.. 눈을 뜬 그는 믿지 못할 상황과 마주한다. 자신의 곁에는 그녀가 있고, 그녀가 떠나간 어제가 다시 반복되고 있는 것! 이안은 어제의 일들이 단순한 꿈이길 바라며 그녀의 운명을 바꾸려 노력한다.
 하지만 어제와 같은 일들이 계속 반복되는 것을 보며 그는 정해진 운명을 바꿀 수 없음을 깨닫는다. 이안에게 다시 주어진 사만다와의 마지막 하루. 이제 그녀를 사랑할 수 있는 시간은 단 하루뿐! 그는 마지막으로 그녀에게 자신의 모든 사랑을 담은 최고의 하루를 선물하기로 하는데...',
'96분', 'no', 770, '15','이프 온리.jpg' ,'admin');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id)  
values(semi_movie_seq.nextval,'지금 만나러 갑니다', '2005.03.25', '다케우치유코,나카무라 시오', '도이노부히로', '로맨스', '처음부터 다시 사랑하기 위해... (지금, 만나러 갑니다) | 비의 계절에 찾아온 6주간의 기적
1년 후 비의 계절에 돌아온다.는 약속을 남기고 먼저 세상을 떠난 아내에겐 초등학교 1학년에 다니는 아들과 그 아들을 챙겨야하는 어설픈 아빠가 있다. 그리고 비오는 어느 날, 늘 놀러 가던 숲에서 산보를 하던 아빠와 아이 앞에 아내가 거짓말처럼 다시 나타난다.
 하지만 그녀는 생전의 모든 기억을 잃은 상태다. 그리고 두 사람은 자연스럽게 두번째의 사랑을 맺어가고 아이 역시 두번째의 엄마를 만나게 된 사실에 너무나 큰 기쁨을 느낀다. 하지만 그 여인은 자신이 기억하지 못하는 약속을 남겼다. 비의 계절이 끝나는 6주뒤에 떠난다는 것을.',
'118분', 'no', 650, '12','지금 만나러 갑니다.jpg' ,'admin');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id)  
values(semi_movie_seq.nextval,'비포 선라이즈', '1996.04.07', '에단호크,줄리델피', '리처드링클레이터', '로맨스', '파리로 돌아가는 셀린과 비엔나로 향하는 제시.
 기차 안에서 우연히 만난 그들은 짧은 시간에 서로에게 빠져든다.
 나와 함께 비엔나에 내려요
 그림 같은 도시와 꿈같은 대화 속에서 발견한 
 서로를 향한 강한 이끌림은 풋풋한 사랑으로 물들어 간다. 
 밤새도록 계속된 그들의 사랑 이야기 끝에
 해가 떠오르기 시작하고 그들은 헤어져야만 하는데…
  단 하루, 사랑에 빠지기 충분한 시간
 낭만적인 로맨스가 다시 피어오른다.',
'100분', 'no', 400, '15','비포 선라이즈.jpg' ,'admin');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id)  
values(semi_movie_seq.nextval,'비포 선셋', '2004.10.22', '에단호크,줄리델피', '리처드링클레이터', '로맨스', 
'오랜만이야, 사랑!
비엔나에서의 꿈같은 하루, 6개월 후의 어긋난 약속…
 그리고 9년이 지난 오늘, 파리에서 다시 마주한 제시와 셀린느.
 서로 같지만 다른 기억을 간직해 온 두 사람 사이에 묘한 기류가 감돈다.
 “그날 당신이 내 모든 것을 가져가 버린 것 같아”
 그렇게 그 간의 진심을 서로에게 털어놓는 사이,
 
 해는 저물고, 또다시 헤어짐의 순간이 다가오는데…
 
 처음보다 짙은 그들의 두 번째 사랑,
 우리는 반드시 지금을 기억하게 될 거야.
',
'79분', 'no', 450, '15','비포 선셋.jpg' ,'admin');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id)  
values(semi_movie_seq.nextval,'비포 미드나잇', '2013.05.22', '에단호크,줄리델피', '리처드링클레이터', '로맨스', 
'오랜만이야, 사랑!
비엔나에서의 꿈같은 하루, 6개월 후의 어긋난 약속…
 그리고 9년이 지난 오늘, 파리에서 다시 마주한 제시와 셀린느.
 서로 같지만 다른 기억을 간직해 온 두 사람 사이에 묘한 기류가 감돈다.
 “그날 당신이 내 모든 것을 가져가 버린 것 같아”
 그렇게 그 간의 진심을 서로에게 털어놓는 사이,
 
 해는 저물고, 또다시 헤어짐의 순간이 다가오는데…
 
 처음보다 짙은 그들의 두 번째 사랑,
 우리는 반드시 지금을 기억하게 될 거야.
',
'108분', 'no', 320, '19','비포 미드나잇.jpg' ,'admin');
--------------------------------------로맨스 끝
-------------------------------------승찬이형 시작
insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'타이타닉', '1998.02.20', '레오나르도 디카프리오, 케이트 윈슬렛', '제임스 카메론', '19', 
'1912년 북대서양의 차가운 바닷물 속에서 당대 꿈의 배라고 불렸던 타이타닉 호가 탐사대들에 의해 세상에 발견되면서 오랫동안 감춰져 있던 비극적인 스토리가 세상에 알려지게 된다. 
 17세기 엄격한 사회 질서에 숨막혀 하는 미국 상류층 로즈(케이트 윈슬렛)는 사교계의 굴레에서 벗어나지 못하는 어머니와 권위적인 재벌 귀족 약혼자와 함께 미국으로 향하는 타이타닉 호 1등실에 승선한다. 배가 출발하기 전 부두의 선술집에서 도박으로 운 좋게 타이타닉호의 3등실 티켓을 얻은 가난한 화가 잭(레오나르도 디카프리오) 역시 아슬아슬하게 배에 승선한다. 
 첫 눈에 1등실의 로즈에게 반한 잭은 갑판에서 우연히 바다로 몸을 던지려 하는 로즈를 발견하고 재치 있는 언변과 행동으로 그녀의 생명을 구한다. 이 사건을 계기로 1등실의 저녁식사에 초대받게 되고 서로에게 끌리는 자신들을 발견한다. 이후 그들의 금지된 사랑은 아무도 상상하지 못했던 타이타닉호 침몰조차 갈라 놓을 수 없었던 세기의 로맨스가 된다.', 
 '195분', 'no', 23, '15' ,'타이타닉.jpg' ,'admin');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, grade, picture, id) 
values(semi_movie_seq.nextval, '아바타', '2009.12.17', '샘 워싱턴, 조 샐다나, 시고니 위버', '제임스 카메론', '액션', 
'가까운 미래, 지구는 에너지 고갈 문제를 해결하기 위해 머나먼 행성 판도라에서 대체 자원을 채굴하기 시작한다.
하지만 판도라의 독성을 지닌 대기로 인해 자원 획득에 어려움을 겪게 된 인류는 판도라의 토착민 ‘나비(Na’vi)’의 외형에 인간의 의식을 주입,
원격 조종이 가능한 새로운 생명체 ‘아바타’를 탄생시키는 프로그램을 개발한다.
한편, 하반신이 마비된 전직 해병대원 ‘제이크 설리(샘 워딩튼)’는 ‘아바타 프로그램’에 참가할 것을 제안 받아 판도라에 위치한 인간 주둔 기지로 향한다.
그 곳에서 자신의 ‘아바타’를 통해 자유롭게 걸을 수 있게 된 ‘제이크’는 자원 채굴을 막으려는 ‘나비(Na’vi)’의 무리에 침투하라는 임무를 부여 받는다.
임무 수행 중 ‘나비(Na’vi)’의 여전사 ‘네이티리(조 샐다나)’를 만난 ‘제이크’는 그녀와 함께 다채로운 모험을 경험하면서 ‘네이티리’를 사랑하게 되고,
‘나비(Na’vi)’들과 하나가 되어간다. 하지만 머지 않아 전 우주의 운명을 결정 짓는 대규모 전투가 시작되면서 ‘제이크’는 최후의 시험대에 오르게 되는데….
행성 판도라와 지구의 피할 수 없는 전쟁! 이 모든 운명을 손에 쥔 제이크의 선택은?', '162분	', 'no', '12' ,'아바타.jpg' ,'admin');


insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, grade, picture, id) 
values(semi_movie_seq.nextval, '캐롤', '2016 .02.04', '케이트 블란쳇, 루니 마라, 카일 챈들러', '토드 헤인즈', '로맨스', 
'1950년대 뉴욕, 맨해튼 백화점 점원인 테레즈(루니 마라)와 손님으로 찾아온 캐롤(케이트 블란쳇)은 
 처음 만난 순간부터 거부할 수 없는 강한 끌림을 느낀다. 
 하나뿐인 딸을 두고 이혼 소송 중인 캐롤과 헌신적인 남자친구가 있지만 확신이 없던 테레즈, 
 각자의 상황을 잊을 만큼 통제할 수 없이 서로에게 빠져드는 감정의 혼란 속에서 둘은 확신하게 된다. 
 인생의 마지막에, 그리고 처음으로 찾아온 진짜 사랑임을…', '118분', 'no', '19', '캐롤.jpg' ,'admin');

 
 
 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'니키타', '1990.06.30', '장 르노, 안느 파릴로드, 장 위그 앙글라드', '뤽 베송', '액션', 
'뒷골목의 불량 소녀 니키타는 정체가 분명치 않은 비밀 정보기관에서 전문 킬러로 양성된다. 
엄청난 트레이닝으로 인간 병기가 되어 버린 니키타는 이제 조세핀이라는 이름으로 바뀌어 도시에 던져진다. 
임무가 주어지면 때로는 조직과 함께, 때로는 홀홀단신으로 양손에 대형 매그넘 권총을 들고 뛰어 들어가 용서 없는 숙청을 감행한다. 
그러나 니키타에게 연인이 생기면서 자신의 처지에 방황하며 죄의식을 느낀다. 하지만 조직은 그녀의 변화에 대비해 또 하나의 임무를 하달한다. 
그것은 바로 적성국 대사관에 침입하여 비밀서류를 사진으로 찍어 오는 일.. 니키타는 그 최후의 임무를 수행하기 위해 양손에 무기를 드는데…', '117분', 'no', 10, '15','니키타.jpg' ,'admin');


 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'아토믹 블론드', '2017.10.13', '샤를리즈 테론, 제임스 맥어보이', '데이빗 레이치', '19', 
'냉전시대 스파이 전쟁의 주무대가 된 베를린, MI6의 요원을 살해하고 핵폭탄급 정보를 담고 있는 전 세계 스파이 명단을 훔쳐 달아난 이중 스파이를 잡기 위해 MI6 최고의 요원 ‘로레인’이 급파된다. 
각국의 스파이들은 명단을 차지하기 위해 혈안이 되고, 로레인 역시 동독과 서독을 오가며 미션을 수행한다. 
하지만 생각지도 못한 음모로 인해 정체가 밝혀져 목숨까지 위협받게 되고, 마침내 베를린 장벽이 무너지기 하루 전날 결전의 밤을 맞이하는데... 
 누구도 믿을 수 없는 상황, 미션을 완수할 수 있을 것인가!', '114분 ', 'yes', 102, '19','아토믹 블론드.jpg' ,'admin');
 
 
 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'한나', '2011.04.14', '시얼샤 로넌, 에릭 바나, 케이트 블란쳇', '조 라이트', '로맨스', 
'강인한 체력, 치명적인 살인기술, 완벽한 전략! 열여섯 살 소녀 한나(시얼샤 로넌)는 전직 CIA출신 아버지 에릭(에릭 바나)에 의해 완벽한 살인 병기로 키워진다. 
극비리에 진행시킨 위험한 임무가 시작된 순간 에릭과 헤어지게 되고, 급기야 정보기관에 납치당한다. 
조직의 비밀기지에서 치명적인 기술로 탈출을 시도하는 한나. 이제 그녀는 탄생의 비밀과 그 배후의 거대조직의 음모와 직면하게 되는데.. 
지금 그녀의 복수가 시작된다!', '110분 ', 'no', 91, '15','한나.jpg' ,'admin');
 
 
 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'센트럴 인텔리전스', '2017.03.15', '드웨인 존슨, 케빈 하트, 에이미 라이언', '로슨 마샬 터버', '19', 
'1950년대 뉴욕, 맨해튼 백화점 점원인 테레즈(루니 마라)와 손님으로 찾아온 캐롤(케이트 블란쳇)은 
 처음 만난 순간부터 거부할 수 없는 강한 끌림을 느낀다. 
 하나뿐인 딸을 두고 이혼 소송 중인 캐롤과 헌신적인 남자친구가 있지만 확신이 없던 테레즈, 
 각자의 상황을 잊을 만큼 통제할 수 없이 서로에게 빠져드는 감정의 혼란 속에서 둘은 확신하게 된다. 
 인생의 마지막에, 그리고 처음으로 찾아온 진짜 사랑임을…', '118분 ', 'no', 191, '19','센트럴 인텔리전스.jpg' ,'admin');
--------------------------------------승찬이형 끝
----------------------------코믹 시작
insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'브루스 올마이티', '2003 .07.11', '짐 캐리, 모건 프리먼, 제니퍼 내이스톤', '톰 새디악', '코미디', 
'<매트릭스 2>를 누른 전지전능한 코미디 블록버스터 | 3일간 8,700만불의 흥행을 창조! 일주일간 신이 된 브루스, 나머지 4일간 무엇을 창조했을까... 
브루스는 뉴욕, 버펄로 지방 방송국의 뉴스 리포터. 재미있고 소박한 이웃들 얘기를 단골로 맡아 재미있는 입담으로 사람들을 즐겁게 해주지만 정작 자신은 자신에게 주어지는 별 볼일 없는 취재거리가 늘 불만이다. 
곧 은퇴할 앵커의 후임이나, 적어도 극적인 사건의 현장을 전하는 게 그의 꿈. 자신의 모습에 대해 하나부터 열까지 모두 불만인 그는 쉴새 없이 신에게 불만을 쏟아놓는다. 
유아원을 운영하는 브루스의 여자친구 그레이스(제니퍼 애니스톤)는 반대로, 자신의 삶에 만족하고, 늘 툴툴거리기만 하는 브루스를 변함없이 받아주고 사랑한다. 브루스의 꿈이 월터 크론카이트 같은 대 앵커가 되는 것이라면, 
그레이스는 매일매일 작은 일로 세상에 도움을 주려는 소박하고 따뜻한 마음을 가지고 있다. 그러던 어느 날 브루스에게 기회가 찾아온다. 나이아가라 폭포의 유명한 "Maid of the Mist (안개 속의 처녀)"호의 23주년 기념일 취재를 맡게 된 것. 
하지만 방송 직전, 브루스는 공석으로 알고 있던 앵커 자리가 그와 늘 으르렁거리는 왕재수 라이벌에게 돌아갔다는 것을 알게 되자, 수 백만 시청자 앞에서 정신없이 욕을 퍼붓는다. 방송국에서 쫓겨난 건 불 보듯 뻔한 일.
하지만 바로 그날 설상가상으로 브루스는 건달들에게 몰매를 맞고, 차가 엉망이 되고, 재수 없어도 오부지게 없는 일들만 반복된다. 화가 나 폭발하기 일보직전엔 브루스는 하늘을 향해 삿대질을 해대며, 자신의 불행은 신 탓이라며 원망한다. 
이때 삐삐가 울리고 번호 하나가 찍힌다. 몇 번을 무시한 끝에 그 정체 모를 번호에 전화를 걸게 된 브루스는 "Omni Presents 사"라는 이상한 낡은 건물로 향하게 되고, 거기서 정체불명의 청소부(모건 프리먼)을 만난다. 
그런데 그 청소부는 놀랍게도 브루스에게 자신이 신이라고 소개한다. 브루스의 원망에 응답해 모습을 나타낸 신은, 이 열 잘 받는 전직 리포터에게 자신의 전지전능한 힘을 주고, 얼마나 더 나은 세상을 만들 수 있는지 보자고 한다. 
이게 꿈인가 생신가, 자신의 능력을 시험해본 브루스는 자신에게 주어진 힘이 악몽도 환상도 아님을 알게 되고, 무엇이든 마음대로 할 수 있는 전능한 존재가 됐음을 알게 된다. 이제 브루스 놀란은 우주에서 가장 강력한 망나니가 되고, 
마음대로 손가락을 휘둘러대기 시작한다. 과연 브루스는 자신에게 가장 소중한 것을 찾아낼 수 있을 것인가.', '100분', 'no', 157, '12','브루스 올마이티.jpg' ,'admin');



 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'지랄발광 17세', '2017 .06.28', '헤헤일리 스테인펠드, 블레이크 제너, 헤일리 루 리차드슨', '켈리 프레몬', '코미디', 
'17세 네이딘, 어느 날 갑자기 깨닫다!

자식보다 본인 인생이 더 중요한 엄마, 공부 잘하고 잘 생기고 인기 많은 엄마아들, 
 이런 엄마아들과 눈 맞은 10년 넘은 베프, 내 존재조차 모르는 짝사랑남, 
 고민을 상담해도 전혀 도움도, 위로도 안되는 돌직구 선생님까지, 내 주변은 무식하고 이기적인 인간들 투성이다. 
 그보다 더 끔찍한 사실은 지금 이 얼굴로 평생을 살아야 한다는 것…  망했다… 이번 생은 완전히 망했다!', '102분', 'no', 222, '15','지랄발광 17세.jpg' ,'admin');


 
 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'세얼간이', '2011 .08.18', '아미르 칸, 마드하반, 셔먼조쉬', '라지쿠마르 히라니', '코미디', 
'알 이즈 웰’을 외치던 유쾌한 세 남자가 돌아왔다!천재들만 간다는 일류 명문대 ICE, 성적과 취업만을 강요하는 학교를 발칵 뒤집어 놓은 대단한 녀석 란초! 
아버지가 정해준 꿈, 공학자가 되기 위해 정작 본인이 좋아하는 일은 포기하고 공부만하는 파파보이 파르한! 
찢어지게 가난한 집, 병든 아버지와 식구들을 책임지기 위해 무조건 대기업에 취직해야만 하는 라주! 
친구의 이름으로 뭉친 세 얼간이! 삐딱한 천재들의 진정한 꿈을 찾기 위한 세상 뒤집기 한판이 시작된다!', '171분', 'no', 393, '12','세얼간이.jpg' ,'admin');
 
 
 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'트루먼 쇼', '1998 .10.24', '짐 캐리, 에드 해리스, 로라 리니', '피터 위어', '코미디', 
'트루먼 버뱅크(Truman Burbank: 짐 캐리 분)는 평범한 샐러리맨이다. 적어도 그가 아는 한은 그렇다. 
그는 메릴(Meryl Burbank/Hannah Gill: 로라 린니 분)이란 여인과 결혼했고 보험회사에서 근무하며 어린 시절 아빠(Kirk Burbank: 브라이언 디레이트 분)가 익사하는 것을 보고 물에 대한 공포증이 있는 남자다. 
그런데 어느 날 그는 익사한 것으로 알던 아버지를 길에서 만나고 알 수 없는 사람에 의해 아빠가 끌려가는 것을 보면서 자신의 생활이 뭔가 평범치 못하다는 것을 확신하게 된다. 
  그는 하루 24시간 생방송 되는 트루먼 쇼의 주인공이다. 전 세계의 시청자들이 그의 탄생부터 30이 가까운 지금까지 일거수 일투족을 TV를 통해 보고 있다. 그는 만인의 스타지만 정작 본인은 짐작도 못하고 있다. 
그의 주변 인물은 모두 배우이고 사는 곳 또한 스튜디오이지만 그는 실비아(Lauren Garland/Sylvia: 나타샤 맥엘혼 분)를 만날 때까지 전혀 알지 못한다. 
대학 때 이상형의 여인 실비아와 만난 트루먼은 그 여인으로부터 모든게 트루먼을 위해 만들어진 가짜란 얘기를 듣는데 그 여인이 피지섬으로 간다는 얘길 듣고 늦게나마 그 여인을 찾아 떠나기로 결심한다. 
아내와 함께 떠나려는 시도를 하지만 번번히 실패하면서 가족, 친구 조차 믿을 수 없다는 것을 깨닫게 되고 혼자서 고향을 빠져나가려는 시도를 한다.', '103분', 'no', 444, '15','트루먼 쇼.jpg' ,'admin');


 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'엽기적인 그녀', '2001 .07.27', '전지현, 차태현, 김인묵', '곽재용', '코미디', 
'전지현+차태현의 절라유쾌 사랑이야기 그녀와의 무서운 데이트가 시작된다! 2001년 여름, 온몸이 뽀사지도록 즐거워집니다!

전반전. 그녀와 저는 같은 문으로 함께 인천행 지하철을 타게 되씀미다. 취해서 비틀거리지만 안는다면 정말 매력저기고 갠차는 아가씨여쪄... 푸하하핫! 진짜 특이하다! 저는 그녀가 술에 취해서 배를 기대고 서있는 모습이 귀여워서 힐끔거리며 그녀를 계속 지켜보아씀미다. 그런데 몸을 미세하게 부르르 떨던 그녀가 왠지 불안해 보이더니만 마침내 우웨에엑~~~ 우웨엑~~ 좌르르르르~~~ 네, 그러씀미다! 그녀가 앞에 앉아 이떤 대머리 아저씨 머리 위에 순식간에 일을 친 거시여씀미다!! 순간 지하철안은 아수라장이 되고 절라 재미는 상황이었져. 진짜 일은 거기서부터 터지고야 말아씀미다. 오바이트를 시원하게 하던 그녀가 게슴치레한 눈빛으로 저를 보며 이러는 검미다! 자기야!~ 어어억~ 우욱~ 자기~ 웩~! 쿵... 이 여자 좋은 느낌이 듬니다. 원래 그러치안은데 실연의 아픔이 너무나 큰 것 가씀미다. 괜히 불쌍한 마음이 듬미다. 제 마음 어디에선가 싸늘한 바람이 부는 것도 가씀미다. 그래, 이 여자의 아픔을 한번 치료해보자!! 강물 깊이가 궁금하면 가차업시 물 속으로 떠밀어버리는 여자! 그러나 정신업시 허우적대는 저를 위해서 물 속으로 뛰어들쭐도 아는 여자... 그녀의 생일, 얼렁뚱땅 너머가면 살해할찌도 모를 여자! 그러나 일촉즉발 인질로 잡혀있던 나를 목숨걸고 구해주며 기막힌 감동을 먹일쭐도 아는 여자!
후반전. 요즘은 그녀가 참 많이 우씀미다. 해맑게 웃는 그녀를 보고 있으면 제 마음도 한 없이 행복해짐미다. 지금까지 제가 힘이 되어주었는지 자신이 업씀미다. 제가 그녀를 감싸준것도 그녀에게 보여준 것도 또 그녀를 치료한 적도 없는 것 가씀미다. 이제 그녀 곁을 떠날 때가 점점 가까워지는 것을 느낌미다. 그리고 오늘 타임캡슐에 서로의 마음을 담고 타이머를 2년 후에 맞춰씀미다. 이 캡슐이 열리는 날! 서로의 마음을 확인할 껌미다. 그렇게 그녀는 헤어지자는 말을 대신했슴미다.
연장전. 오늘 헤어지고 내일 만나는 것처럼 우리는 지금 헤어지고 분명히 다시 만날 것임미다. 다만 오늘과 내일처럼 가까운 시간이 아닐 뿐... 믿슴미다.', '122분', 'no', 374, '15','엽기적인 그녀.jpg' ,'admin');


 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'언터처블', '2012 .03.22', '프랑수아 클루제, 오마 사이, 앤 르 니', '올리비에르 나카체, 에릭 토레다노', '코미디', 
'상위 1% 귀족남과 하위 1% 무일푼이 만났다.

2주간의 내기로 시작된 상상초월 특별한 동거 스토리 
 하루 24시간 내내 돌봐주는 손길이 없으면 아무 것도 할 수 없는 전신불구의 상위 1% 백만장자 필립(프랑수아 클루제). 
어느 날 우연히, 가진 것이라곤 건강한 신체가 전부인 하위 1% 무일푼 백수 드리스(오마 사이)를 만나게 된 그는 거침없이 자유로운 성격의 드리스에게 호기심을 느껴 특별한 내기를 제안한다. 
바로 2주 동안 필립의 손발이 되어 한시도 떨어지지 않고 자신을 간호하며 버틸 수 있는지 시험해보겠다는 것. 참을성이라곤 눈꼽 만큼도 찾아 볼 수 없던 드리스는 오기가 발동해 엉겁결에 내기를 수락한다. 이렇게, 전혀 어울릴 것 같지 않던 극과 극, 두 남자의 예측불허 기막힌 동거가 시작 되는데…',
'112분', 'no', 277, '12','언터처블.jpg' ,'admin');


 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'라따뚜이', '2007 .07.25', '패튼 오스왈트, 루 로마노, 브라이언 데니히', '브래드 버드', '코미디', 
'파리에서 날아온 니모를 찾아서 & 인크레더블 제작진의 달콤한 상상

절대미각, 빠른 손놀림, 끓어 넘치는 열정의 소유자 레미. 프랑스 최고의 요리사를 꿈꾸는 그에게 단 한가지 약점이 있었으니, 바로 주방 퇴치대상 1호인 생쥐라는 것! 그러던 어느 날, 하수구에서 길을 잃은 레미는 운명처럼 파리의 별 다섯개짜리 최고급 레스토랑에 떨어진다. 그러나 생쥐의 신분으로 주방이란 그저 그림의 떡. 보글거리는 수프, 둑닥둑닥 도마소리, 향긋한 허브 내음에 식욕이 아닌 요리욕이 북받친 레미의 작은 심장은 콩닥콩닥 뛰기 시작하는데!
  쥐면 쥐답게 쓰레기나 먹고 살라는 가족들의 핀잔에도 굴하지 않고 끝내 주방으로 들어가는 레미. 깜깜한 어둠 속에서 요리에 열중하다 재능 없는 견습생 ‘링귀니’에게 ‘딱’ 걸리고 만다. 하지만 해고위기에 처해있던 링귀니는 레미의 재능을 한눈에 알아보고 의기투합을 제안하는데. 과연 궁지에 몰린 둘은 환상적인 요리 실력을 발휘할 수 있을 것인가? 레니와 링귀니의 좌충우돌 공생공사 프로젝트가 아름다운 파리를 배경으로 이제 곧 펼쳐진다!',
'112분', 'no', 404, '0','라따뚜이.jpg' ,'admin');


 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'파리의 밤이 열리면', '2017 .06.22', '에두아르 바에르, 사브리나 와자니, 오드리', '에두아르 바에르', '코미디', 
'걷고 마시고 떠들다 보면 파리의 밤에 취한다!

친화력 갑(甲), 주종불문 알코올 러버, 파리 극장 운영주 루이지는 
 직원들의 파업으로 내일 있을 연극 첫 공연의 막을 올리지 못할 위기에 처한다. 
 그에게 주어진 시간은 단 하룻밤뿐! 
 직원들에게 밀린 월급을 줄 돈과 연극 무대에 오를 원숭이를 찾아나서는 여름 밤의 모험이 시작된다. 
 그러나 예상치 못한 만남들이 루이지를 기다리고 있는데...',
'97분', 'no', 303, '12','파리의 밤이 열리면.jpg' ,'admin');
-----------------------------코믹 끝

-----------------------액션 시작------------------
 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'범죄도시',   '2017.10.03',   '마동석,윤계상',   '강윤성',   '액션','오늘 밤, 다 쓸어버린다! 2004년 서울…하얼빈에서 넘어와 단숨에 기존 조직들을 장악하고
가장 강력한 세력인 춘식이파 보스 황사장(조재윤 분)까지 위협하며 도시 일대의 최강자로 급부상한 신흥범죄조직의 악랄한 보스 장첸(윤계상 분).
대한민국을 뒤흔든 ‘장첸(윤계상 분)’ 일당을 잡기 위해 오직 주먹 한방으로 도시의 평화를 유지해 온 괴물형사 마석도(마동석 분)와 
인간미 넘치는 든든한 리더 전일만(최귀화 분) 반장이 이끄는 강력반은 나쁜 놈들을 한방에 쓸어버릴 끝.짱.나.는. 작전을 세우는데…
통쾌하고! 화끈하고! 살벌하게! 나쁜 놈들 때려잡는 강력반 형사들의 조폭소탕작전이 시작된다!'
 ,'121분','yes',864,'19','범죄도시.jpg','admin'
);

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'킹스맨 골든서클','2017.09.27','콜린린 퍼스, 줄리안 무어,태런 에저튼','배승찬','액션','
"킹스맨 본부의 파괴! 더 강력해진 범죄조직 골든서클의 등장! 철저하게 비밀에 둘러싸인 채 세상을 안전하게 지키는 임무를 수행해온 독자적인 국제 정보 조직 킹스맨. 
그러나 어느 날 국제적 범죄조직 골든 서클에 의해 킹스맨 본부가 무참히 파괴된다. 에그시(태런 에저튼)와 멀린(마크 스트롱)은 
킹스맨 ‘최후의 날’ 규약에 따라 발견된 위스키 병에서 ‘미국 켄터키’라는 키워드를 얻게 되고, 그 곳에서 형제 조직인 스테이츠맨의 존재를 알게 된다. 
전 세계를 장악하기 위해 위협적인 비지니스를 추진 중인 골든 서클과 수장 포피(줄리안 무어). 이들의 계획을 막기 위한 킹스맨과 스테이츠맨의 작전이 시작된다.
','141분','yes',12332,'19','킹스맨 골든서클.jpg','admin');

 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'007 골드핑거',   '2015.11.06',   '숀 코네리',   '가이 해밀톤',
'액션','영국 국적의 골드핑거(Auric Goldfinger: 거트 프로브 분)는 정식 금매매업자이며 국제 보석상이다. 그가 보유하고 있는 영국의 상당량의 금을 외국으로 반출시킨다는 정보는 있으나 증거가 없는 영국 은행에서는 007(James Bond: 숀 코넬리 분)에게 증거를 찾도록 M(M: 버나드 리 분)을 통해 임무를 내린다. 명령을 받은 007은 그에게 접근하여 두번의 골탕과 금전적 손실을 입히나 그 대가로 매스터슨(Jill Masterson: 셜리 엣톤 분 / Tilly Masterson: 타니아 말렛 분) 자매가 죽음을 당한다. 제네바까지 쫓아간 007은 골드핑거의 고급승용차인 롤스로이스 팬텀 3의 보디를 금으로 만들어 밀수한다는 사실을 알아낸다. 허나 그 와중에 007은 잡히게 되고 레이저의 위협도 받게 되는데.
','112분','no',121,'19',   '007골든핑거.jpg',   'admin'
);

 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'글래디에이터','2000.06.03','러셀 크로우,호아킨 피닉스,코니 닐슨',
'리들리 스콧','액션','느낄 수 있는가, 이 거대한 스펙터클의 전율을... !
{절정기의 로마제국은 그 영토가 광대하여 아프리카 사막에서 잉글랜드 북쪽까지 걸쳐 있었다. 그 당시 세계는 그 총인구의 1/4이 로마 황제의 지배 하에 있었다. 때는 서기 180년, 마르커스 아우렐리우스(Marcus Aurelius) 황제의 12년에 걸친 게르마니아(Germania) 정벌이 거의 마무리되던 무렵이었다. 마지막 하나 남은 적의 요새만 함락하면 이제 로마 제국은 평화가 온다.}
평화로운 5현제 시대가 막바지에 이른 서기 180년 로마. 어두운 삼림. 수백명의 부대가 숨을 죽이고 서 있다. 마치 폭풍전야와 같이. 장군의 신호가 울리고 거대한 함성소리와 함께 하늘에는 불화살, 불타는 점토 항아리가 난무하고, 땅위는 수많은 병사들의 피로 물든다. 철인(哲人) 황제 마르쿠스 아우렐리우스(Marcus Aurelius: 리차드 해리스 분)가 아들처럼 친애하는 장군 막시무스(General Maximus: 러셀 크로우 분)는 다뉴브 강가 전투에서 대승한다.
죽을 날이 머지않은 황제 마르쿠스 아우렐리우스는 막시무스를 총애하여, 아들이 아닌 그에게 왕위를 넘겨주기로 한다. 그러나 황제의 아들 코모두스는 이에 질투와 분노를 느껴 급기야 황제를 살해한다. 왕좌를 이어받은 코모두스는 막시무스와 그의 가족을 죽이라고 명령한다. 가족을 모두 잃고 혼자 겨우 살아남게 된 막시무스는 노예로 전락하고, 투기장의 검투사로 매일 훈련을 받는다. 그에게 남은 건 오로지 새로 즉위한 황제 코모두스에 대한 복수 뿐. 검투사로서 매 경기마다 승리로 이끌면서 살아남자 그의 명성과 인기는 날로 높아간다.
로마로 돌아온 그는 아내와 아들을 죽인 코모두스에 대한 복수를 다짐한다. 그러던 어느날, 오래전 사랑했던 황제의 누이 루실라(Lucilla: 코니 닐슨 분)를 다시 만나게 된다. 어느 새 민중의 영웅이 된 막시무스. 코모두스는 그가 아직 살아있음을 알고 분노하지만 민중이 두려워 그를 죽이지 못한다. 드디어 막시무스는 예전의 부하들과 은밀히 만나 사랑하는 아내와 아들, 존경하던 황제를 살해한 난폭한 황제 코모두스에 대한 복수를 결의한다. 아직도 막시무스를 사랑하고 있는 루실라는 동생 코모두스를 배신하고 막시무스의 반란을 도우려 하는데.
','154분','no',2312,'15','글래디에이터.jpg','admin'
);

 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'다크나이트',   '2008.08.06','크리스찬 베일, 히스 레저','크리스토퍼 놀란'
,'액션','"어둠의 기사 배트맨 VS 절대 악 조커
운명을 건 최후의 결전이 시작된다! 정의로운 지방 검사 ‘하비 덴트’, ‘짐 고든’ 반장과 함께 범죄 소탕 작전을 펼치며
범죄와 부패로 들끓는 고담시를 지켜나가는 ‘배트맨’그러던 어느 날, 살아남기 위해 발버둥치던 범죄 조직은 배트맨을 제거하기 위해
광기어린 악당 ‘조커’를 끌어들이고정체를 알 수 없는 조커의 등장에 고담시 전체가 깊은 혼돈 속으로 빠져든다.
급기야 배트맨을 향한 강한 집착을 드러낸 조커는그가 시민들 앞에 정체를 밝힐 때까지 매일 새로운 사람들을 죽이겠다 선포하고
배트맨은 사상 최악의 악당 조커를 막기 위해 자신의 모든 것을 내던진 마지막 대결을 준비한다."
','152분','no',4536,'15','다크나이트.jpg','admin'
);

 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'취권2','1994.02.05','성룡','유가량','액션',
'"그가 취하면 온 세상이 비틀거린다!
청나라 말의 어느 겨울, 광동성 광주에서 멀리 북경까지 약재를 구하러 떠났던 보지림의 황기영(적룡 분)과 아들 황비홍(성룡 분)은 인삼을 국진사 짐 속에 넣어 세관을 피한다. 황비홍은 진사 짐속의 인삼을 다시 훔치러 갔는데 마침 다른 사람이 그 짐 속에서 물건을 꺼내 본다. 이때 경찰이 지나가자 인삼을 그 사람에게 밀어넣고 밖으로 나온다. 황비홍은 취권으로 도둑과 대결한다. 도둑은 도망가고 황비홍은 기차에 오른다. 경찰은 진사의 짐을 찾기 위해 기차를 조사한다. 황비홍은 수색당하면 세금을 내지 않은 것을 들키므로 긴장한다.
그러던 중 장소사(유덕화 분)의 도움으로 일이 마무리된다. 보지림으로 돌아와 약상자를 보니 옥쇄가 들어 있었다. 황비홍은 인삼을 찾던 중 무술지도자인 찬을 알게 된다. 이자는 취권을 쓸모없는 권법이라 여긴다. 이럴 쯤 진사의 짐을 훔치던 기란자가 인삼을 안고 취권하는 자를 찾아오나 황비홍은 만나지 못하고 찬을 만난다. 기는 찬 밑에서 무술을 배운다. 후에 알고보니 가야말로 만청 최후의 무술인이었다. 국가의 보물인 옥쇄를 찾으러 나섰던 것이다.
기와 황은 옥쇄를 찾던 중에 기는 무술관 앞에서 죽고 황, 찬 둘이 옥쇄를 찾으러 간다. 찬은 황에게 다시 취권을 연습하길 권한다. 예전에 취하면 잔다는 이야기를 들은 황은 하지 않으려 한다. 이에 흥분한 찬은 폭포에 뛰어들고 황이 구해낸다. 다시 옥쇄를 훔치는 것을 시도하고 결국은 성공한다."
','100분','no',6356,'15','취권2.jpg','admin'
);

 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'다이하드','1988.09.24','브루스 윌리스','존 맥티어난','액션',
'"고독한 승부는 시작되었다! | 그가 홀로 있을 때, 그의 아내는 인질이었다! | 죽일 수 있을 때 망설이면, 내가 죽는다! | 위대한 브루스 윌리스 결코 죽지 않는다! | 40 Stories Of Sheer Adventure!
크리스마스를 보내기 위해 아내와 자식이 있는 로스엔젤레스로 날아온 뉴욕 경찰 존 맥크레인(브루스 윌리스 분). 그가 아내 홀리(보니 델리아 분)의 직장이 있는 나카토이 빌딩으로 찾아 갔을 때, 사무실에서는 크리스마스 파티가 한창이다. 그러나 파티가 한창 무르익을 무렵, 한스 그루버(Hans Gruber: 알란 릭맨 분)가 이끄는 일단의 테러리스트들이 침입, 사장을 비롯한 파티 참석자 30여 명을 인질로 삼고 건물 금고에 소장하고 있는 돈과 보물을 손에 넣으려 한다.
최첨단 하이테크에 의해 관리되던 34층짜리 나카토미 빌딩은 통채로 테러리스트들의 수중으로 넘어가 폐쇄되고 고층 빌딩은 살벌한 생존 게임의 전쟁터로 변해 가공할 병기가 복도를 휘젖는다. 긴급 출동한 경찰과 FBI는 혼자 고군분투하는 존을 무시한 채 멋대로 무리한 작전을 수행한다. 뿐만 아니라 출세욕에 눈이 먼 TV 리포터는 앞뒤없이 카메라를 들이대어 맥클레인을 궁지로 몰아 넣는다. 다만 말단 흑인 경찰관 포웰 경사(레지날드 볼존슨 분)만이 그의 눈과 귀가 되어 줄 뿐이다. 맥클레인은 초인적인 힘을 발휘하여 최첨단 장비로 무장된 12명의 테러리스트들을 한명씩 처치해 간다."
','131분','no',   6324,'15','다이하드.jpg','admin'
); 

 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval,'소림축구','2002.05.14','주성치,자오웨이','주성치','액션',
'"전세계를 폭소로 뒤흔든 절대무공의 드림팀이 온다!!!
절룩거리는 다리로 이제 퇴물취급 받는 왕년의 스타 플레이어 명봉(오맹달 분). 축구 코치가 되고 싶어도 어느 구단에서조차 그를 받아주지 않는다. 소림사에서 무공을 익혔던 씽씽(주성치 분)은 사부가 죽자 하릴없이 빈둥빈둥 가난한 백수로 지내며 만두가게 처녀 아매(조미 분)를 흠모하는게 유일한 낙. 거리에서 우연히 씽씽의 요상한 다리 힘을 발견한 명봉은 씽씽에게 축구단을 결성하자고 제안하는데.
일단은 정예 멤버를 모으는게 가장 급선무, 씽씽은 소림사에서 함께 무예를 다졌던 동료들을 차례차례 찾아간다. 그러나 날렵했던 무사들은 온데 간데 없고, 외모비관론자, 뚱땡이, 박봉의 청소부, 방콕론자, 돈벌레 등으로 모두 변해 있었다. 이들의 공통점은 하나같이 다 삶의 의욕을 잃어버렸다는 점! 이들은 씽씽의 제안을 처음엔 거절했었지만 나중엔 차례차례 씽씽을 다시 찾아오게 되는데.
일명 ‘소림축구단’. 이들은 길거리 축구에서부터 시작해서 프로 축구단과 겨룰 만큼의 실력으로 급성장한다. 하지만 명봉과 왕년의 라이벌 관계였던 강웅(사현 분)이 축구협회 위원장이라, ‘무협축구단’의 목표인 ‘전국축구대회 우승’은 갈 수록 첩첩산중이 되가는데."
','87분','no',132,'15','소림축구.jpg','admin'
); 
------------------------------------액션 끝
