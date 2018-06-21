CREATE TABLE tblusers ( username VARCHAR(255) PRIMARY KEY NOT NULL, password VARCHAR(255) NOT NULL, userfirstname VARCHAR(255) NOT NULL, userlastname VARCHAR(255) NOT NULL, userage INTEGER NOT NULL, usercontactnumber VARCHAR(255), useremail VARCHAR(255), role VARCHAR(255) NOT NULL, dateregistered DATETIME DEFAULT CURRENT_TIMESTAMP );

INSERT INTO tblusers ( username, password, userfirstname, userlastname, userage, usercontactnumber, useremail, role ) VALUES ( 'LeggoDave', sha1(md5('dave')), 'Dave', 'Cuaterno', 20, '09367101056', 'dave@gmail.com', 'ADMIN' );

CREATE TABLE tblproducts ( productID INTEGER NOT NULL PRIMARY KEY, productname VARCHAR(255) NOT NULL, productdescription VARCHAR(255) DEFAULT NULL, productpricerate VARCHAR(255) NOT NULL, productprice DECIMAL(10, 2) NOT NULL, productquantity INTEGER NOT NULL, dateadded DATETIME DEFAULT CURRENT_TIMESTAMP, productstatus VARCHAR(255), producttag VARCHAR(255), owner VARCHAR(255) NOT NULL, FOREIGN KEY (owner) REFERENCES tblusers (username) );

CREATE TABLE tblcarts ( cartID INTEGER PRIMARY KEY AUTO_INCREMENT, cartregistrydate DATETIME DEFAULT CURRENT_TIMESTAMP, numberofitems INTEGER NOT NULL );

CREATE TABLE tblorders ( orderid INTEGER AUTO_INCREMENT PRIMARY KEY, orderdate DATETIME DEFAULT CURRENT_TIMESTAMP, username VARCHAR(255), prodID INTEGER, pickupdate DATE NOT NULL, returndate DATE NOT NULL, hoursofusage INTEGER NOT NULL, cartID INTEGER NOT NULL, FOREIGN KEY (prodID) REFERENCES tblproducts(productID), FOREIGN KEY (username) REFERENCES tblusers(username), FOREIGN KEY (cartID) REFERENCES tblcarts(cartID) );

CREATE TABLE tblinvoice ( invoiceID INTEGER PRIMARY KEY AUTO_INCREMENT, cartID INTEGER, invoicedate DATETIME DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (cartID) REFERENCES tblcarts (cartID) );

CREATE TABLE tblratings ( ratingID INTEGER NOT NULL PRIMARY KEY, rating INTEGER NOT NULL, review VARCHAR(255), evaluatorID VARCHAR(255) NOT NULL, ratingtype VARCHAR(255) NOT NULL, evaluatedprodID INTEGER, evaluateduserID VARCHAR(255), vote INTEGER, productratedate DATETIME DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (evaluatedprodID) REFERENCES tblproducts (productID), FOREIGN KEY (evaluatorID) REFERENCES tblusers (username), FOREIGN KEY (evaluateduserID) REFERENCES tblusers (username) );

INSERT INTO tblratings ( ratingID, rating, review, evaluatorID, ratingtype, evaluateduserID, vote ) VALUES ( 1, 5, "Review test 1", 'LeggoDave', 'USER', 'LeggoDave', 10 );