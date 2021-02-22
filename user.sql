CREATE TABLE TBL_USER (
   user_no NUMBER(11, 0),
   user_id VARCHAR2(16) NOT NULL,
   user_email VARCHAR2(30) NOT NULL, 
   user_name VARCHAR2(20) NOT NULL,
   user_password CHAR(60) NOT NULL,
   user_intro VARCHAR2(500),
   user_profile VARCHAR2(200),  
   user_create_dt DATE DEFAULT sysdate NOT NULL,
   user_authority VARCHAR2(11) DEFAULT 'ROLE_USER' NOT NULL,
   user_enabled CHAR(1) DEFAULT '1' NOT NULL,
   CONSTRAINT USER_NO_PK PRIMARY KEY(user_no),
   CONSTRAINT USER_ID_UK UNIQUE(user_id),
   CONSTRAINT USER_EMAIL_UK UNIQUE(user_email)
);
drop table TBL_USER;

drop SEQUENCE USER_NO_SEQ;
CREATE SEQUENCE USER_NO_SEQ;

CREATE TABLE TBL_TIMELINE (
   time_no NUMBER(11, 0),
   user_no NUMBER(11, 0),
   time_title VARCHAR2(255) NOT NULL,
   time_content VARCHAR2(4000) NOT NULL,
   time_view_count NUMBER DEFAULT 0 NOT NULL,
   time_like_count NUMBER DEFAULT 0 NOT NULL,
   time_create_dt DATE DEFAULT sysdate NOT NULL,
   time_open_scope CHAR(1) DEFAULT 'A' NOT NULL,
   CONSTRAINT TIME_NO_PK PRIMARY KEY(time_no),
   CONSTRAINT USER_NO_FK FOREIGN KEY(user_no)
   REFERENCES TBL_USER(user_no)
)

CREATE SEQUENCE TIME_NO_SEQ;