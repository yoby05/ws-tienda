DROP TABLE IF EXISTS Product CASCADE;
DROP TABLE IF EXISTS Rate CASCADE;
DROP TABLE IF EXISTS Brand CASCADE;
DROP TABLE IF EXISTS Prices CASCADE;

create table Product (
    id BIGINT not null auto_increment,
    name VARCHAR(100),
    description VARCHAR(250),
    primary key (id)
);

create table Brand (
    id BIGINT not null auto_increment,
    name VARCHAR(100),
    description VARCHAR(250),
    primary key (id)
);

create table Rate (
    id BIGINT not null auto_increment,
    name VARCHAR(100),
    description VARCHAR(250),
    primary key (id)
);

create table Prices (
    id BIGINT not null auto_increment,
	id_brand BIGINT not null,
	id_product BIGINT not null,
	id_rate BIGINT not null,
	priority INTEGER,
	price DOUBLE PRECISION,
	start_date TIMESTAMP,
	end_date TIMESTAMP,
	currency VARCHAR(10),
	primary key (id),
	foreign key (id_brand) references Brand(id),
	foreign key (id_product) references Product(id),
	foreign key (id_rate) references Rate(id)
);

-- Product
insert into Product (id,name,description) values(35455,'CAMISA','CAMISA DE OCASION VERANO');

--Rate
insert into Rate (id,name,description) values(1,'TARIFA 1','IMP 10%');
insert into Rate (id,name,description) values(2,'TARIFA 2','IMP 20%');
insert into Rate (id,name,description) values(3,'TARIFA 3','IMP 30%');
insert into Rate (id,name,description) values(4,'TARIFA 4','IMP 40%');

--Group
insert into Brand (id,name,description) values(1,'ZARA','ZARA COMPANY');

--PRICES
insert into Prices(id,id_brand,id_product,id_rate,priority,price,start_date,end_date,currency) values(1,1,35455,1,0,35.50,'2020-06-14 00:00:00','2020-12-31 23:59:59','EUR');
insert into Prices(id,id_brand,id_product,id_rate,priority,price,start_date,end_date,currency) values(2,1,35455,2,1,25.45,'2020-06-14 15:00:00','2020-06-14 18:30:00','EUR');
insert into Prices(id,id_brand,id_product,id_rate,priority,price,start_date,end_date,currency) values(3,1,35455,3,1,30.50,'2020-06-15 00:00:00','2020-06-15 11:00:00','EUR');
insert into Prices(id,id_brand,id_product,id_rate,priority,price,start_date,end_date,currency) values(4,1,35455,4,1,38.95,'2020-06-15 16:00:00','2020-12-31 23:59:59','EUR');
