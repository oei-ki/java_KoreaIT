CREATE TABLE Customer1 (
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	name		VARCHAR(10)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT=1001;

DELETE FROM Account1;
DROP TABLE Account1;

CREATE TABLE Account1 (
	aid				BIGINT		PRIMARY KEY AUTO_INCREMENT,
	accType			CHAR(1)		NOT NULL,
	balance			DOUBLE		NOT NULL,
	interestRate	DOUBLE		NOT NULL,
	overdraftAmount	DOUBLE		NOT NULL,
	customerId		BIGINT		NOT NULL,
	regDate			TIMESTAMP   NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 3001;

SELECT * FROM Customer1;
SELECT * FROM Account1;

INSERT INTO Customer1 (name, ssn) VALUES ('James Bond','900101-1234567');

INSERT INTO Account1 (accType, balance, interestRate,overdraftAmount, customerId)
VALUES ('C',2000.2,0.03,0.0,1001);

ALTER TABLE Customer1 MODIFY name VARCHAR(12) NULL;
UPDATE Customer1 Set name='Jason Vourne' WHERE cid=1001;
DELETE FROM Customer1 WHERE cid =1001;

SELECT * FROM Account1 WHERE accType='';
SELECT * FROM Account1 WHERE balance='';

CREATE TABLE Users (
	uid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	userId			VARCHAR(16)		NOT NULL,
	passwd			VARCHAR(16)		NOT NULL,
	userName		VARCHAR(5)		NOT NULL,
	ssn				VARCHAR(14)		NOT NULL,
	email			VARCHAR(30)		NOT NULL,
	addr			VARCHAR(50)		NOT NULL,
	regDate			TIMESTAMP   NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 0001;

SELECT * FROM Users;