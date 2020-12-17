CREATE DATABASE C1909I1_JDA
GO
USE C1909I1_JDA
GO
CREATE TABLE Category(
	id int primary key identity(1,1) not null,
	name nvarchar(255) unique not null,
	status bit
)
GO
CREATE TABLE Product(
	id varchar(10) primary key,
	name nvarchar(255),
	price float,
	categoryid int foreign key references Category(id),
	status bit
)
GO