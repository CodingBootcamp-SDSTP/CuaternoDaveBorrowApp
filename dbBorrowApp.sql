CREATE TABLE tblusers ( username VARCHAR(20) PRIMARY KEY NOT NULL, password VARCHAR(255) NOT NULL, userfirstname VARCHAR(20) NOT NULL, userlastname VARCHAR(20) NOT NULL, userage INTEGER NOT NULL, usercontactnumber VARCHAR(20), useremail VARCHAR(20), role VARCHAR(20) NOT NULL, dateregistered DATETIME DEFAULT CURRENT_TIMESTAMP );

CREATE TABLE tblproducts ( productID INTEGER NOT NULL PRIMARY KEY, productname VARCHAR(20) NOT NULL, productdescription VARCHAR(255) DEFAULT NULL, productpricerate VARCHAR(20) NOT NULL, productprice DECIMAL(10, 2) NOT NULL, productquantity INTEGER NOT NULL, dateadded DATETIME DEFAULT CURRENT_TIMESTAMP, productstatus VARCHAR(20), producttag VARCHAR(20), owner VARCHAR(20) NOT NULL, FOREIGN KEY (owner) REFERENCES tblusers (username) );

CREATE TABLE tbltransactions ( transactionID INTEGER PRIMARY KEY, transactiondate DATETIME DEFAULT CURRENT_TIMESTAMP, quantityofproducts INTEGER NOT NULL, prodID INTEGER, pickupdate DATE NOT NULL, returndate DATE NOT NULL, FOREIGN KEY (prodID) REFERENCES tblproducts(productID) );

CREATE TABLE tbluserratings ( ratingID INTEGER NOT NULL PRIMARY KEY, rating INTEGER NOT NULL, review VARCHAR(50), userID VARCHAR(20), userratedate DATETIME DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (userID) REFERENCES tblusers (username) );

CREATE TABLE tblproductsrating ( ratingID INTEGER NOT NULL PRIMARY KEY, rating INTEGER NOT NULL, review VARCHAR(50), prodID INTEGER, productratedate DATETIME DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (prodID) REFERENCES tblproducts (productID) );