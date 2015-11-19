SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS ACL_ENTRY;
DROP TABLE IF EXISTS ACL_SID;
DROP TABLE IF EXISTS ORDERITEM;
DROP TABLE IF EXISTS OREDR_STATUS;
DROP TABLE IF EXISTS ORDER;
DROP TABLE IF EXISTS FIELD_PROFESSIONAL;
DROP TABLE IF EXISTS SEC_ROLE;
DROP TABLE IF EXISTS SEC_USER_ROLE;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS RECORD_METADATA;
DROP TABLE IF EXISTS SERVICE_PROVIDER;
DROP TABLE IF EXISTS SERVICE_AGGREGATOR;
DROP TABLE IF EXISTS SEC_USER;
DROP TABLE IF EXISTS ADDRESS;
DROP TABLE IF EXISTS CUSTOMER;
DROP TABLE IF EXISTS METADATA;
DROP TABLE IF EXISTS OBJECT_TYPE;
DROP TABLE IF EXISTS OBJECT_IDENTITY;
DROP TABLE IF EXISTS Offers;
DROP TABLE IF EXISTS REGION;
DROP TABLE IF EXISTS SERVICE_TYPE;




/* Create Tables */

CREATE TABLE ACL_ENTRY
(
	ACL_ENRTY_ID bigint NOT NULL,
	ACL_SID_ID bigint,
	OBJECT_IDENTITY_ID bigint,
	PRIMARY KEY (ACL_ENRTY_ID)
);


CREATE TABLE ACL_SID
(
	ACL_SID_ID bigint NOT NULL,
	USER_ID ,
	PRIMARY KEY (ACL_SID_ID)
);


CREATE TABLE ADDRESS
(
	ADDRESS_ID  NOT NULL,
	LINE1 ,
	LINE2 ,
	CITY ,
	STATE ,
	COUNTRY ,
	PINCODE  NOT NULL,
	PRIMARY KEY (ADDRESS_ID)
);


CREATE TABLE CUSTOMER
(
	CUSTOMER_ID  NOT NULL,
	PHONE_NO ,
	NAME ,
	EMAIL ,
	PRIMARY KEY (CUSTOMER_ID)
);


CREATE TABLE FIELD_PROFESSIONAL
(
	Field_Professional_ID  NOT NULL,
	USER_ID  NOT NULL,
	Service_Provider_ID  NOT NULL,
	Service_Aggregator_ID  NOT NULL,
	ADDRESS_ID  NOT NULL,
	PRIMARY KEY (Field_Professional_ID)
);


CREATE TABLE METADATA
(
	EXTENSION_ID bigint(100) NOT NULL,
	COLUMN_LABEL varchar(100) NOT NULL,
	COLUMN_TYPE ,
	PRIMARY KEY (EXTENSION_ID)
);


CREATE TABLE OBJECT_IDENTITY
(
	OBJECT_IDENTIRY_ID bigint NOT NULL,
	OBJECT_TYPE_ID bigint,
	OBJECT_IDENTITY varchar(200),
	PRIMARY KEY (OBJECT_IDENTIRY_ID)
);


CREATE TABLE OBJECT_TYPE
(
	OBJECT_TYPE_ID bigint NOT NULL,
	OBJECT_NAME varchar(100),
	PRIMARY KEY (OBJECT_TYPE_ID)
);


CREATE TABLE Offers
(
	PRODUCT_ID bigint(100) NOT NULL,
	Offer varchar(100)
);


CREATE TABLE ORDER
(
	ORDER_ID  NOT NULL,
	CUSTOMER_ID  NOT NULL,
	Field_Professional_ID  NOT NULL,
	Service_Aggregator_ID  NOT NULL,
	Service_Provider_ID  NOT NULL,
	PRIMARY KEY (ORDER_ID)
);


CREATE TABLE ORDERITEM
(
	ID  NOT NULL,
	PRODUCT_ID bigint(100) NOT NULL,
	ORDER_ID  NOT NULL,
	QUANTITY ,
	PRIMARY KEY (ID)
);


CREATE TABLE OREDR_STATUS
(
	STATUS ,
	ORDER_ID  NOT NULL
);


CREATE TABLE PRODUCT
(
	PRODUCT_ID bigint(100) NOT NULL,
	NAME ,
	DESCRIPTION ,
	Service_Aggregator_ID  NOT NULL,
	PRIMARY KEY (PRODUCT_ID)
);


CREATE TABLE RECORD_METADATA
(
	RECORD_ID  NOT NULL,
	EXTENSION_ID bigint(100) NOT NULL,
	VALUE varchar(500) NOT NULL
);


CREATE TABLE REGION
(
	REGION_ID  NOT NULL,
	REGION_NAME ,
	START_PINCODE bigint,
	END_PINCODE bigint,
	PRIMARY KEY (REGION_ID)
);


CREATE TABLE SEC_ROLE
(
	ROLE_ID  NOT NULL,
	Role ,
	-- Primary Key
	ID  NOT NULL COMMENT 'Primary Key',
	PRIMARY KEY (ROLE_ID)
);


CREATE TABLE SEC_USER
(
	USER_ID  NOT NULL,
	Name ,
	Email ,
	Phone ,
	Password ,
	ADDRESS_ID  NOT NULL,
	PRIMARY KEY (USER_ID)
);


CREATE TABLE SEC_USER_ROLE
(
	-- Primary Key
	ID  NOT NULL COMMENT 'Primary Key',
	role_id ,
	USER_ID  NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE SERVICE_AGGREGATOR
(
	Service_Aggregator_ID  NOT NULL,
	Name ,
	Phone ,
	Email ,
	Service_Type_ID  NOT NULL,
	USER_ID  NOT NULL,
	ADDRESS_ID  NOT NULL,
	RECORD_ID bigint(100) NOT NULL,
	PRIMARY KEY (Service_Aggregator_ID)
);


CREATE TABLE SERVICE_PROVIDER
(
	Service_Provider_ID  NOT NULL,
	Name ,
	Phone ,
	Email ,
	Service_Aggregator_ID  NOT NULL,
	ADDRESS_ID  NOT NULL,
	REGION_ID  NOT NULL,
	PRIMARY KEY (Service_Provider_ID)
);


CREATE TABLE SERVICE_TYPE
(
	Service_Type_ID  NOT NULL,
	Service_Type ,
	PRIMARY KEY (Service_Type_ID)
);



/* Create Foreign Keys */

ALTER TABLE ACL_ENTRY
	ADD FOREIGN KEY (ACL_SID_ID)
	REFERENCES ACL_SID (ACL_SID_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE FIELD_PROFESSIONAL
	ADD FOREIGN KEY (ADDRESS_ID)
	REFERENCES ADDRESS (ADDRESS_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE SEC_USER
	ADD FOREIGN KEY (ADDRESS_ID)
	REFERENCES ADDRESS (ADDRESS_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE SERVICE_AGGREGATOR
	ADD FOREIGN KEY (ADDRESS_ID)
	REFERENCES ADDRESS (ADDRESS_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE SERVICE_PROVIDER
	ADD FOREIGN KEY (ADDRESS_ID)
	REFERENCES ADDRESS (ADDRESS_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ORDER
	ADD FOREIGN KEY (CUSTOMER_ID)
	REFERENCES CUSTOMER (CUSTOMER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ORDER
	ADD FOREIGN KEY (Field_Professional_ID)
	REFERENCES FIELD_PROFESSIONAL (Field_Professional_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE RECORD_METADATA
	ADD FOREIGN KEY (EXTENSION_ID)
	REFERENCES METADATA (EXTENSION_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ACL_ENTRY
	ADD FOREIGN KEY (OBJECT_IDENTITY_ID)
	REFERENCES OBJECT_IDENTITY (OBJECT_IDENTIRY_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE OBJECT_TYPE
	ADD FOREIGN KEY (OBJECT_TYPE_ID)
	REFERENCES OBJECT_IDENTITY (OBJECT_IDENTIRY_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ORDERITEM
	ADD FOREIGN KEY (ORDER_ID)
	REFERENCES ORDER (ORDER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE OREDR_STATUS
	ADD FOREIGN KEY (ORDER_ID)
	REFERENCES ORDER (ORDER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ORDERITEM
	ADD FOREIGN KEY (PRODUCT_ID)
	REFERENCES PRODUCT (PRODUCT_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE SERVICE_PROVIDER
	ADD FOREIGN KEY (REGION_ID)
	REFERENCES REGION (REGION_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ACL_SID
	ADD FOREIGN KEY (USER_ID)
	REFERENCES SEC_USER (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE FIELD_PROFESSIONAL
	ADD FOREIGN KEY (USER_ID)
	REFERENCES SEC_USER (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE SEC_USER_ROLE
	ADD FOREIGN KEY (USER_ID)
	REFERENCES SEC_USER (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE SERVICE_AGGREGATOR
	ADD FOREIGN KEY (USER_ID)
	REFERENCES SEC_USER (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE SEC_ROLE
	ADD FOREIGN KEY (ID)
	REFERENCES SEC_USER_ROLE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE FIELD_PROFESSIONAL
	ADD FOREIGN KEY (Service_Aggregator_ID)
	REFERENCES SERVICE_AGGREGATOR (Service_Aggregator_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ORDER
	ADD FOREIGN KEY (Service_Aggregator_ID)
	REFERENCES SERVICE_AGGREGATOR (Service_Aggregator_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE PRODUCT
	ADD FOREIGN KEY (Service_Aggregator_ID)
	REFERENCES SERVICE_AGGREGATOR (Service_Aggregator_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE RECORD_METADATA
	ADD FOREIGN KEY (RECORD_ID)
	REFERENCES SERVICE_AGGREGATOR (Service_Aggregator_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE SERVICE_PROVIDER
	ADD FOREIGN KEY (Service_Aggregator_ID)
	REFERENCES SERVICE_AGGREGATOR (Service_Aggregator_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE FIELD_PROFESSIONAL
	ADD FOREIGN KEY (Service_Provider_ID)
	REFERENCES SERVICE_PROVIDER (Service_Provider_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ORDER
	ADD FOREIGN KEY (Service_Provider_ID)
	REFERENCES SERVICE_PROVIDER (Service_Provider_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE SERVICE_AGGREGATOR
	ADD FOREIGN KEY (Service_Type_ID)
	REFERENCES SERVICE_TYPE (Service_Type_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


