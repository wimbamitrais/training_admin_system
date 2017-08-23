----Insert 25 dummy employee data-------
----------------------------------------
INSERT INTO TB_Employee VALUES ('Wimba');
INSERT INTO TB_Employee VALUES ('Taufik');
INSERT INTO TB_Employee VALUES ('Inez');
INSERT INTO TB_Employee VALUES ('Yuliawan');
INSERT INTO TB_Employee VALUES ('Sopyan');
INSERT INTO TB_Employee VALUES ('Daniel');
INSERT INTO TB_Employee VALUES ('Wisesa');
INSERT INTO TB_Employee VALUES ('Deny');
INSERT INTO TB_Employee VALUES ('Bili');
INSERT INTO TB_Employee VALUES ('Ibnu');
INSERT INTO TB_Employee VALUES ('Agra');
INSERT INTO TB_Employee VALUES ('Andrian');
INSERT INTO TB_Employee VALUES ('Syafaat');
INSERT INTO TB_Employee VALUES ('Mulyana');
INSERT INTO TB_Employee VALUES ('Prayogi');
INSERT INTO TB_Employee VALUES ('Andre');
INSERT INTO TB_Employee VALUES ('Sule');
INSERT INTO TB_Employee VALUES ('Bima');
INSERT INTO TB_Employee VALUES ('Wolverine');
INSERT INTO TB_Employee VALUES ('Spiderman');
INSERT INTO TB_Employee VALUES ('Thausand Sunny');
INSERT INTO TB_Employee VALUES ('Thor');
INSERT INTO TB_Employee VALUES ('Nunung');
INSERT INTO TB_Employee VALUES ('Robert');
INSERT INTO TB_Employee VALUES ('Agung');

Select * from TB_Employee


-------- Delete dummy employee data ---------
---------------------------------------------
Delete from TB_Employee;
DBCC checkident (TB_Employee, reseed, 1001);


----- Create a new table (Employee Grade) -----
-----------------------------------------------
IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[Employee_Grade]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [Employee_Grade]
GO
/* Create Tables */
CREATE TABLE [Employee_Grade]
(
	[Employee_Grade_ID] int NOT NULL IDENTITY (1000, 1),
	[Name] varchar(50) NULL
)
GO
/* Create Primary Keys, Indexes, Uniques, Checks */
ALTER TABLE [Employee_Grade] 
 ADD CONSTRAINT [PK_Table1]
	PRIMARY KEY CLUSTERED ([Employee_Grade_ID] ASC)
GO

------- Insert 4 employee grade data --------
---------------------------------------------
INSERT INTO Employee_Grade VALUES ('JP');
INSERT INTO Employee_Grade VALUES ('PG');
INSERT INTO Employee_Grade VALUES ('AP');
INSERT INTO Employee_Grade VALUES ('AN');

select * from Employee_Grade;

Delete from TB_Employee;
DBCC checkident (TB_Employee, reseed, 1001);




