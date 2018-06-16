DROP TABLE tbl_reservees;
DROP TABLE tbl_reservations;
DROP TABLE tbl_equipments;
DROP TABLE tbl_status;
DROP TABLE tbl_rate;


CREATE TABLE tbl_reservees ( reservee_ID INTEGER PRIMARY KEY NOT NULL, rsrv_firstname VARCHAR(255) NOT NULL, rsrv_lastname VARCHAR(255) NOT NULL, rsrv_contact_num INTEGER NOT NULL );

CREATE TABLE tbl_status ( status_ID VARCHAR(255) PRIMARY KEY NOT NULL, status_desc VARCHAR(255) NOT NULL );

CREATE TABLE tbl_rate ( rate_ID VARCHAR(255) PRIMARY KEY NOT NULL, rate_desc VARCHAR(255) NOT NULL );

CREATE TABLE tbl_equipments ( eq_ID INTEGER PRIMARY KEY NOT NULL, eq_name VARCHAR(255) NOT NULL, date_registered INTEGER NOT NULL, res_rate VARCHAR(255), status VARCHAR(255), FOREIGN KEY (res_rate) REFERENCES tbl_rate (rate_ID), FOREIGN KEY (status) REFERENCES tbl_status (status_ID) );

CREATE TABLE tbl_reservations ( res_ID INTEGER PRIMARY KEY NOT NULL, eq_ID INTEGER, date_reserved INTEGER NOT NULL, pick_up_date INTEGER NOT NULL, return_data INTEGER NOT NULL, res_desc VARCHAR(255), FOREIGN KEY (eq_ID) REFERENCES tbl_equipments (eq_ID) );

INSERT INTO tbl_status ( status_ID, status_desc ) VALUES ( 'Available', 'Item is ready to be reserved and in good condition to be used.' );
INSERT INTO tbl_status ( status_ID, status_desc ) VALUES ( 'Reserved', 'Item is already reserved.' );
INSERT INTO tbl_status ( status_ID, status_desc ) VALUES ( 'Under Maintenance', 'Item is currently being repaired.' );
INSERT INTO tbl_rate ( rate_ID, rate_desc ) VALUES ( 'PER HOUR', 'Price of this item is based on hours of usage');
INSERT INTO tbl_rate ( rate_ID, rate_desc ) VALUES ( 'PER DAY', 'Price of this item is based on days of usage');