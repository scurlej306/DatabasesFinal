create database techcompany;
use techcompany;
CREATE TABLE back_inventory (
  iid int(11) NOT NULL,
  name varchar(100) DEFAULT NULL,
  quantity int(11) DEFAULT NULL,
  unit_price decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (iid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE front_inventory (
  iid int(11) NOT NULL,
  name varchar(100) DEFAULT NULL,
  quantity int(11) DEFAULT NULL,
  unit_price decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (iid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE employee (
  eid int(11) NOT NULL,
  first_name varchar(15) DEFAULT NULL,
  last_name varchar(15) DEFAULT NULL,
  store_num smallint(6) DEFAULT NULL,
  PRIMARY KEY (eid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE customer (
  cid int(11) NOT NULL,
  first_name varchar(30) DEFAULT NULL,
  last_name varchar(30) DEFAULT NULL,
  street varchar(50) DEFAULT NULL,
  city varchar(20) DEFAULT NULL,
  state varchar(2) DEFAULT NULL,
  zip varchar(10) DEFAULT NULL,
  phone varchar(20) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  PRIMARY KEY (cid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE sales (
  sid int(11) NOT NULL,
  cid int(11) NOT NULL,
  iid int(11) NOT NULL,
  date date NOT NULL,
  quantity_sold int(11) DEFAULT NULL,
  sale_total decimal(15,2) DEFAULT NULL,
  eid int(11) DEFAULT NULL,
  PRIMARY KEY (cid,iid,date),
  KEY iid (iid),
  KEY eid (eid),
  CONSTRAINT sales_ibfk_1 FOREIGN KEY (cid) REFERENCES customer (cid),
  CONSTRAINT sales_ibfk_2 FOREIGN KEY (iid) REFERENCES front_inventory (iid),
  CONSTRAINT sales_ibfk_3 FOREIGN KEY (eid) REFERENCES employee (eid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
