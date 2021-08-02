-- 테이블 삭제
DROP TABLE RESERVATION;   
DROP TABLE STOREREG;
--시퀀스 삭제
DROP SEQUENCE STORERES_SEQ;		--예약 테이블 
DROP SEQUENCE STOREREG_SEQ;		-- 가게 테이블

-- 가게 테이블
CREATE TABLE STOREREG
(
    STORENO NUMBER PRIMARY KEY,
    STORENAME VARCHAR2(32) NOT NULL,
    STORECONTENT VARCHAR2(300) NOT NULL,
    STORETABLE NUMBER NOT NULL UNIQUE,
    STORETEL VARCHAR2(32) NOT NULL,
    STOREADDR1 VARCHAR2(64) NOT NULL,
    STOREADDR2 VARCHAR2(64) NOT NULL,
    STOREADDR3 VARCHAR2(64),
    STORETIME VARCHAR2(32) NOT NULL,
    STORESNS VARCHAR2(100),
    STORECATEGORY VARCHAR2(32),
    STOREMENU VARCHAR2(200),
  	ORIGINFILENAME VARCHAR2(256),
    SAVEFILENAME VARCHAR2(40),  -- 파일명 32바이트, 확장자 8바이트
    STOREHIT NUMBER,
    STATUS NUMBER,
    OWNERNO NUMBER,
    CONSTRAINT FK_STOREREG_OWNER FOREIGN KEY (OWNERNO) REFERENCES OWNER(OWNERNO)
);

-- 예약 테이블
CREATE TABLE RESERVATION
(
	RESNO NUMBER PRIMARY KEY,		-- 예약번호
	STORENO NUMBER,					-- 가게번호(외래키)
	MEMBERNO NUMBER,				-- 회원번호(외래키)
	RESDATE VARCHAR2(10) NOT NULL,	-- 예약한 해당 날짜
	RESHOURS VARCHAR2(20),			-- 예약 시간
	RESPEOPLE VARCHAR2(10),			-- 예약 인원
	RESNOTE VARCHAR2(4000),			-- 예약 요청사항
	RESPOSTDATE DATE				-- 예약한 날짜
);

INSERT INTO RESERVATION VALUES(STORERES_SEQ.NEXTVAL, '1', '1', '2021-08-08', '10시-11시', '2명', '요청사항입니다.', SYSDATE)

-- 외래키 삭제 
ALTER TABLE RESERVATION DROP CONSTRAINT FK_RESERVATION_STORENO; -- 가게 번호
ALTER TABLE RESERVATION DROP CONSTRAINT FK_RESERVATION_MEMBERNO;	-- 회원 번호 

-- 외래키 생성 
ALTER TABLE RESERVATION ADD CONSTRAINT FK_RESERVATION_STORENO FOREIGN KEY (STORENO) REFERENCES STOREREG(STORENO); -- 가게번호
ALTER TABLE RESERVATION ADD CONSTRAINT FK_RESERVATION_MEMBERNO FOREIGN KEY (MEMBERNO) REFERENCES MEMBER(MEMBERNO) -- 회원번호



-- 시퀀스 생성 
CREATE SEQUENCE STORERES_SEQ INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;
CREATE SEQUENCE STOREREG_SEQ INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;


-- 예약 테이블 데이터 삽입 / 확인 
INSERT INTO RESERVATION VALUES(STORERES_SEQ.NEXTVAL, 1, '2020-08-08', '10시', '3명', '요청사항입니다.', SYSDATE);
SELECT * FROM RESERVATION;

SELECT * FROM MEMBER;


-- 가게등록 테이블 데이터 확인 
SELECT * FROM STOREREG;

SELECT * FROM STOREREG ORDER BY STOREHIT DESC;
SELECT * FROM STOREREG ORDER BY STORENO ASC;
		


