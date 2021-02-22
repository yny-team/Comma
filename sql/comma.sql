CREATE table commer( --사용자 정보 저장 테이블 
user_no NUMBER(11,0) PRIMARY KEY,
user_id VARCHAR2(16) NOT NULL, --사용자 아이디
user_name VARCHAR2(20) NOT NULL, -- 사용자 이름
user_password CHAR(60) NOT NULL, --사용자 패스워드
user_email VARCHAR2(30) NOT NULL, -- 사용자 이메일
user_intro VARCHAR2(500) NULL,--사용자 소개글
user_profile VARCHAR2(200) NULL -- 사용자 프로필이미지 경로
);
DROP TABLE commer PURGE;

CREATE SEQUENCE commer_seq;
DROP SEQUENCE commer_seq;

INSERT INTO commer VALUES(commer_seq.nextval, 'asdf1234', '홍길동', 'password', 'asdf1234@gmail.com',0,0);
INSERT INTO commer VALUES(commer_seq.nextval, 'zxcv1234', '홍길동', 'password', 'zxcv1234@gmail.com',0,0);
COMMIT