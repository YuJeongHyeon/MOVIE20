
--------- CREATE Table Query ---------------------------

---- member Table 包访 -----------------
CREATE TABLE semi_member
(
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

---- review Table 包访 -----------------
CREATE TABLE semi_review
(
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

---- movie Table 包访 -----------------
CREATE TABLE semi_movie
(
	mNo                  NUMBER  PRIMARY KEY ,
	title                 VARCHAR2(100)  NOT NULL ,
	playdate              DATE  NOT NULL ,
	character             VARCHAR2(100)  NOT NULL ,
	director              VARCHAR2(100)  NOT NULL ,
	genre                 VARCHAR2(100)  NOT NULL ,
	summary               CLOB  NOT NULL ,
	runtime               VARCHAR2(100)  NOT NULL ,
	viewingcheck          VARCHAR2(100)  NOT NULL ,
	hits                  NUMBER  DEFAULT 0 ,
	grade                 NUMBER  NOT NULL ,
	picture 			VARCHAR2(100) NOT NULL ,
	id                    VARCHAR2(100)  NOT NULL,
	CONSTRAINT semi_movie_id_fk FOREIGN KEY(id) REFERENCES semi_member(id)
);
SELECT * FROM semi_movie;
DROP TABLE semi_movie;

DROP sequence semi_movie_seq;
CREATE sequence semi_movie_seq nocache;
---- notice Table 包访 -----------------
CREATE TABLE semi_notice
(
	nNo                  NUMBER PRIMARY KEY ,
	title                 VARCHAR2(100)  NOT NULL ,
	content             CLOB  NOT NULL ,
	regdate               DATE  NOT NULL ,
	hits                  NUMBER   DEFAULT 0 ,
	id                    VARCHAR2(100)  NOT NULL,
	CONSTRAINT semi_notice_id_fk FOREIGN KEY(id) REFERENCES semi_member(id)
);
SELECT * FROM semi_notice;
DROP TABLE semi_notice;

DROP sequence semi_notice_seq;
CREATE sequence semi_notice_seq nocache;

--E N D ----- CREATE Table Query   -----------------------








