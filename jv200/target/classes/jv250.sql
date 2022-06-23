DROP TABLE Sample10;
CREATE TABLE Sample10 ( /*선생님이 sql키워드 대문자로 적으신거 대소문자 구분없음*/
	no 			INT(11)			DEFAULT NULL, 
	name		VARCHAR(20)		DEFAULT NULL,
	birthday	DATE			DEFAULT NULL,
	address		VARCHAR(40)		DEFAULT NULL
--  테이블제목    데이터타입(글자는''로 처리)
); /*세미콜론해줘야함*/

SELECT * FROM Sample10; /*실행*/

INSERT INTO Sample10 VALUES (1, '유비', '1996-10-25', '대구 중구 반월당'); /*넣는거*/
INSERT INTO Sample10 VALUES (2, '관우', '1986-02-10', '대구 달서구 용산동');
INSERT INTO Sample10 VALUES (3, '징비', '2000-09-24', '대구 중구 반월당');

CREATE TABLE Customer (
	cid			BIGINT			PRIMARY KEY	AUTO_INCREMENT,	/*cid => 통상적으로 id로 통일함*/
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL,
	phone		VARCHAR(14)		NOT NULL,
	customerId	VARCHAR(16)		NOT NULL,
	passwd		VARCHAR(16)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL    DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001; /*초기 셋팅값 지정해즘*/

SELECT * FROM Customer;
INSERT INTO Customer (name, ssm, phone, customerId, passwd) 
VALUES ('유비', '901213-1234567','010-2323-2323','java','1111'),
VALUES ('관우', '970234-2822442','010-1234-1234','java02','3333');
INSERT INTO Customer (name, ssm, phone, customerId, passwd) 
VALUES ('장비', '920481-1528452','010-5789-4567','jsp','1111');

UPDATE Customer SET ssm='901212-1234567', phone='010-3434-4444' WHERE cid=1001; /*WHERE=>조건*/

DELETE FROM Customer WHERE cid=1003; /*항상 조건이 중요!*/



CREATE TABLE Account(
	aid				BIGINT		PRIMARY KEY AUTO_INCREMENT,
	accountNum		VARCHAR(11)	NOT NULL,		/*111-11-1111*/
	balance			DOUBLE		NOT NULL 		DEFAULT 0.0,
	interertRete	DOUBLE		NOT NULL		DEFAULT 0.0,       /*NULL => 값이 없다.(이 처리도 데이터가 없진 않음)*/
	overdraft		DOUBLE		NOT NULL		DEFAULT 0.0,
	accountType		CHAR(1)		NOT NULL 		DEFAULT	'S',
	customerId		BIGINT		NOT NULL,
	regDate			TIMESTAMP	NOT NULL		DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT	Account_customerId_FK/*안 적으면 db가 알아서 CONSTRAINT 테이블을 만들어서 따로 이름을 만들어 주는게 좋음*/	FOREIGN KEY (customerId) REFERENCES Customer(cid)
	 	/*           아이디			    customerId랑 Customer (cid)랑 같아야 한다   포링키로 지정해줬으니까*/
)AUTO_INCREMENT = 3001;

SELECT	* FROM Account;

INSERT INTO	Account (accountNum,balance,interertRete,overdraft,customerId)  /*customerId 앞에 만든 테이블을 연결시키는 거라 존재하는 키를 값으로 줘야함*/
VALUES('301-11-2548',200.0,1.2,10000.0,1002);
INSERT INTO	Account (accountNum,balance,interertRete,overdraft,customerId)  /*customerId 앞에 만든 테이블을 연결시키는 거라 존재하는 키를 값으로 줘야함*/
VALUES('301-22-5687',6000.0,1.4,10000.0,1001);
INSERT INTO	Account (accountNum,balance,interertRete,overdraft,customerId) 
VALUES('301-33-4822',6000.0,1.1,3000.0,1002),
('301-44-4555',200.0,1.0,10000.0,1001),
('301-55-1388',4000.0,0.0,0.0,1001);
DROP TABLE Account;

/*교집합 부분*/
SELECT * FROM Account , Customer WHERE Account.customerId = Customer.cid AND Customer.ssm= '901212-1234567';
SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid;
WHERE c.ssm = '901212-1234567';





