CREATE TABLE tblusers ( username VARCHAR(20) PRIMARY KEY NOT NULL, password VARCHAR(255) NOT NULL, userfirstname VARCHAR(20) NOT NULL, userlastname VARCHAR(20) NOT NULL, userage INTEGER NOT NULL, usercontactnumber VARCHAR(20), useremail VARCHAR(20), role VARCHAR(20) NOT NULL, dateregistered DATETIME DEFAULT CURRENT_TIMESTAMP );

INSERT INTO tblusers ( username, password, userfirstname, userlastname, userage, usercontactnumber, useremail, role ) VALUES ( 'LeggoDave', sha1(md5('dave')), 'Dave', 'Cuaterno', 20, '09367101056', 'dave@gmail.com', 'ADMIN' );

CREATE TABLE tblproducts ( productID INTEGER NOT NULL PRIMARY KEY, productname VARCHAR(20) NOT NULL, productdescription VARCHAR(255) DEFAULT NULL, productpricerate VARCHAR(20) NOT NULL, productprice DECIMAL(10, 2) NOT NULL, productquantity INTEGER NOT NULL, dateadded DATETIME DEFAULT CURRENT_TIMESTAMP, productstatus VARCHAR(20), producttag VARCHAR(20), owner VARCHAR(20) NOT NULL, FOREIGN KEY (owner) REFERENCES tblusers (username) );

INSERT INTO tblproducts ( productID, productname, productdescription, productpricerate, productprice, productquantity, productstatus, producttag, owner ) VALUES ( 1, 'Product 1', 'First product test', 'Per Hour', 100.00, 3, 'Available', 'test', 'LeggoDave' );

CREATE TABLE tbltransactions ( transactionID INTEGER PRIMARY KEY, transactiondate DATETIME DEFAULT CURRENT_TIMESTAMP, username VARCHAR(20) NOT NULL, prodID INTEGER NOT NULL, pickupdate DATE NOT NULL, returndate DATE NOT NULL, hoursofusage INTEGER NOT NULL, FOREIGN KEY (prodID) REFERENCES tblproducts(productID), FOREIGN KEY (username) REFERENCES tblusers(username) );

INSERT INTO tbltransactions ( transactionID, quantityofproducts, prodID, pickupdate, returndate ) VALUES ( 4019, 2, 1, '2018/06/19', '2018/06/20', 24 ) ;

CREATE TABLE tblratings ( ratingID INTEGER NOT NULL PRIMARY KEY, rating INTEGER NOT NULL, review VARCHAR(50), evaluatorID VARCHAR(20) NOT NULL, ratingtype VARCHAR(20) NOT NULL, evaluatedprodID INTEGER, evaluateduserID VARCHAR(20), vote INTEGER, productratedate DATETIME DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (evaluatedprodID) REFERENCES tblproducts (productID), FOREIGN KEY (evaluatorID) REFERENCES tblusers (username), FOREIGN KEY (evaluateduserID) REFERENCES tblusers (username) );