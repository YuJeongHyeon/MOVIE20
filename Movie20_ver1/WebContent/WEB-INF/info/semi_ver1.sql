
--------- CREATE Table Query ---------------------------

---- member Table ���� -----------------
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

---- review Table ���� -----------------
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

---- movie Table ���� -----------------
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
---- notice Table ���� -----------------
CREATE TABLE semi_notice(
	nNo                  NUMBER PRIMARY KEY ,
	title                 VARCHAR2(100)  NOT NULL ,
	content             CLOB  NOT NULL ,
	regdate               DATE  NOT NULL ,
	hits                  NUMBER  DEFAULT 0 ,
	id                    VARCHAR2(100)  NOT NULL,
	CONSTRAINT semi_notice_id_fk FOREIGN KEY(id) REFERENCES semi_member(id)
);
SELECT * FROM semi_notice;
DROP TABLE semi_notice;

DROP sequence semi_notice_seq;
CREATE sequence semi_notice_seq nocache;

--E N D ----- CREATE Table Query   -----------------------


-- Member �߰� ---
insert into semi_member(id, name, password, nick, address, birth, tel, favoriteGenre, authority) 
values('java', '�����', '1234', '����', '��ź', '1989.01.07', '017', '�θǽ�', '�Ϲ�'); 

insert into semi_member(id, name, password, nick, address, birth, tel, favoriteGenre, authority) 
values('jquery', '�Ѽ���', '3456', '����', '������', '1994.01.01', '016', '�׼�', '�Ϲ�'); 

insert into semi_member(id, name, password, nick, address, birth, tel, favoriteGenre, authority) 
values('a', '������', '6', '�Ĵ�', '��ž', '1990.01.02', '012', '����', '������'); 

select * from semi_member;

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



-- Movie List �߰� ---
insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval, 'Ÿ��Ÿ��', '1998.02.20', '���������� ��ī������, ����Ʈ ������', '���ӽ� ī�޷�', '���', 
'1912�� �ϴ뼭���� ������ �ٴ幰 �ӿ��� ��� ���� ���� �ҷȴ� Ÿ��Ÿ�� ȣ�� Ž���鿡 ���� ���� �߰ߵǸ鼭 �������� ������ �ִ� ������� ���丮�� ���� �˷����� �ȴ�. 
 17���� ������ ��ȸ ������ ������ �ϴ� �̱� ����� ����(����Ʈ ������)�� �米���� �������� ����� ���ϴ� ��ӴϿ� �������� ��� ���� ��ȥ�ڿ� �Բ� �̱����� ���ϴ� Ÿ��Ÿ�� ȣ 1��ǿ� �¼��Ѵ�. �谡 ����ϱ� �� �ε��� ���������� �������� �� ���� Ÿ��Ÿ��ȣ�� 3��� Ƽ���� ���� ������ ȭ�� ��(���������� ��ī������) ���� �ƽ��ƽ��ϰ� �迡 �¼��Ѵ�. 
 ù ���� 1����� ����� ���� ���� ���ǿ��� �쿬�� �ٴٷ� ���� ������ �ϴ� ��� �߰��ϰ� ��ġ �ִ� �𺯰� �ൿ���� �׳��� ������ ���Ѵ�. �� ����� ���� 1����� ����Ļ翡 �ʴ�ް� �ǰ� ���ο��� ������ �ڽŵ��� �߰��Ѵ�. ���� �׵��� ������ ����� �ƹ��� ������� ���ߴ� Ÿ��Ÿ��ȣ ħ������ ���� ���� �� ������ ������ �θǽ��� �ȴ�.', 
 '195��', 'no', 23, '15' ,'Ÿ��Ÿ��.jpg' ,'a');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, grade, picture, id) 
values(semi_movie_seq.nextval, '�ƹ�Ÿ', '2009.12.17', '�� ������, �� ���ٳ�, �ð�� ����', '���ӽ� ī�޷�', '�׼�', 
'����� �̷�, ������ ������ �� ������ �ذ��ϱ� ���� �ӳ��� �༺ �ǵ��󿡼� ��ü �ڿ��� ä���ϱ� �����Ѵ�.
������ �ǵ����� ������ ���� ���� ���� �ڿ� ȹ�濡 ������� �ް� �� �η��� �ǵ����� ������ ������(Na��vi)���� ������ �ΰ��� �ǽ��� ����,
���� ������ ������ ���ο� ����ü ���ƹ�Ÿ���� ź����Ű�� ���α׷��� �����Ѵ�.
����, �Ϲݽ��� ����� ���� �غ���� ������ũ ����(�� ����ư)���� ���ƹ�Ÿ ���α׷����� ������ ���� ���� �޾� �ǵ��� ��ġ�� �ΰ� �ֵ� ������ ���Ѵ�.
�� ������ �ڽ��� ���ƹ�Ÿ���� ���� �����Ӱ� ���� �� �ְ� �� ������ũ���� �ڿ� ä���� �������� ������(Na��vi)���� ������ ħ���϶�� �ӹ��� �ο� �޴´�.
�ӹ� ���� �� ������(Na��vi)���� ������ ������Ƽ��(�� ���ٳ�)���� ���� ������ũ���� �׳�� �Բ� ��ä�ο� ������ �����ϸ鼭 ������Ƽ������ ����ϰ� �ǰ�,
������(Na��vi)����� �ϳ��� �Ǿ��. ������ ���� �ʾ� �� ������ ����� ���� ���� ��Ը� ������ ���۵Ǹ鼭 ������ũ���� ������ ����뿡 ������ �Ǵµ���.
�༺ �ǵ���� ������ ���� �� ���� ����! �� ��� ����� �տ� �� ����ũ�� ������?', '162��	', 'no', '12' ,'�ƹ�Ÿ.jpg' ,'a');

insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, grade, picture, id) 
values(semi_movie_seq.nextval, 'ĳ��', '2016 .02.04', '����Ʈ �����, ��� ����, ī�� æ�鷯', '��� ������', '�θǽ�', 
'1950��� ����, ����ư ��ȭ�� ������ �׷���(��� ����)�� �մ����� ã�ƿ� ĳ��(����Ʈ �����)�� 
 ó�� ���� �������� �ź��� �� ���� ���� ������ ������. 
 �ϳ����� ���� �ΰ� ��ȥ �Ҽ� ���� ĳ�Ѱ� ������� ����ģ���� ������ Ȯ���� ���� �׷���, 
 ������ ��Ȳ�� ���� ��ŭ ������ �� ���� ���ο��� ������� ������ ȥ�� �ӿ��� ���� Ȯ���ϰ� �ȴ�. 
 �λ��� ��������, �׸��� ó������ ã�ƿ� ��¥ ���������', '118��', 'no', '19', 'ĳ��.jpg' ,'a');

 insert into semi_movie(mNo, title, playdate, character, director, genre, summary, runtime, viewingcheck, hits, grade, picture, id) 
values(semi_movie_seq.nextval, '��ũ����Ʈ', '2008.08.06', 'ũ������ ����, ���� ����', 'ũ�������� ���', '�׼�', '����� ��� ��Ʈ�� VS ���� �� ��Ŀ
����� �� ������ ������ ���۵ȴ�!
���Ƿο� ���� �˻� ���Ϻ� ��Ʈ��, ���� ��硯 ����� �Բ� ���� ���� ������ ��ġ��
 ���˿� ���з� ����� ���ø� ���ѳ����� ����Ʈ�ǡ�
 
 �׷��� ��� ��, ��Ƴ��� ���� �߹���ġ�� ���� ������ ��Ʈ���� �����ϱ� ����
 ���� �Ǵ� ����Ŀ���� ������̰�
 ��ü�� �� �� ���� ��Ŀ�� ���忡 ���� ��ü�� ���� ȥ�� ������ �������.
 
 �ޱ�� ��Ʈ���� ���� ���� ������ �巯�� ��Ŀ��
 �װ� �ùε� �տ� ��ü�� ���� ������ ���� ���ο� ������� ���̰ڴ� �����ϰ�
 ��Ʈ���� ��� �־��� �Ǵ� ��Ŀ�� ���� ���� �ڽ��� ��� ���� ������ ������ ����� �غ��Ѵ�.', '152��', 'no', 10, '15', '��ũ����Ʈ.jpg' ,'a');


 
-- review �߰�


 
 
 select* from semi_movie;
 
 
 select title, picture from semi_movie order by hits desc;
   

 SELECT hits, picture
 FROM (select row_number() over(order by mNo desc) as rnum, hits, picture from semi_movie) semi_movie
 WHERE rnum between 1 and 5
 ORDER BY hits DESC


